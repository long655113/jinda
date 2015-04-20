package com.trustel.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * 
 * ��ṹ��ȡ��
 * <p>
 * <li> �û���ѡ����ʵ��������ʱ�ṩ���ݿ����ӻ����ڵ���ʱ�ṩ���ݿ�����
 * <li> ȡ���ݿ����Ϣʵ�ֹ��̣�
 * <li> 1. ����getInstance()����һ����������Ƕ��ʹ�ã������ʼ������ʱ�ṩ���ݿ����ӣ�������ڵ��þ��巽��ʱ�ṩ���ݿ�����
 * <li> 2. ����getTableTypesȡ��֧�ֵı���������(TABLE��VIEW��SYNONYM��)�������ȷ�����ͣ���ʡ�Դ˲����ں���������ֱ�����볣��
 * <li> 3. ����getSchames()��ȡ�����е�schema���ƣ������֪schema���ƿ�ʡ�Դ˲�
 * <li> 4. ����getTableNamesByTypeȡ���ض�schema�µ����ݿ������
 * <li> 5. ����getTableByName()����getColumnsByTable()ȡ�����ݿ���ֶ���Ϣ
 */
public class Reader {
	/**
	 * ��
	 */
	public static final String TABLE = "TABLE";

	/**
	 * ��ͼ
	 */
	public static final String VIEW = "VIEW";

	/**
	 * ͬ���
	 */
	public static final String SYNONYM = "SYNONYM";

	/**
	 * ���ݿ�����
	 * <p>
	 * <li> �û����ڴ�����ʵ��ʱ�ṩ���ݿ����ӣ�����÷���ʱ�������ṩ���ݿ����ӣ�
	 * <li> �û�Ҳ���ڴ���ʵ��ʱ���ṩ���ݿ����ӣ�����÷���ʱ�����ṩ���ݿ�����
	 */
	private Connection conn;

	public static Reader getInstance() throws RuntimeException {
		return new Reader();
	}

	public static Reader getInstance(Connection conn) throws RuntimeException {
		Reader reader = null;

		if (conn == null)
			throw new RuntimeException("connection is null");

		reader = new Reader(conn);

		return reader;
	}

	private Reader() {

	}

	private Reader(Connection conn) {
		this.conn = conn;
	}

	/**
	 * ȡ���ݿ�schema
	 * 
	 * @return schema���б�
	 * @throws RuntimeException
	 */
	public List<String> getSchemas() throws RuntimeException {
		return getSchemas(conn);
	}

	/**
	 * ȡ���ݿ�schema
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @return schema���б�
	 * @throws RuntimeException
	 */
	public List<String> getSchemas(Connection conn) throws RuntimeException {
		List<String> names = new ArrayList<String>();

		if (conn == null)
			throw new RuntimeException("connection is null");

		try {
			DatabaseMetaData metadata = conn.getMetaData();
			ResultSet results = metadata.getSchemas();
			while (results.next()) {
				names.add(results.getString("TABLE_SCHEM"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException: " + e.getMessage()
					+ " at reader.getSchemas");
		}

		return names;
	}

	/**
	 * ȡ���ݿ�֧�ֵ� SQL����
	 * 
	 * @return SQL�������б�
	 * @throws RuntimeException
	 */
	public List<String> getAllTypes() throws RuntimeException {
		return getAllTypes(conn);
	}

	/**
	 * ȡ���ݿ�֧�ֵ� SQL����
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @return SQL�������б�
	 * @throws RuntimeException
	 */
	public List<String> getAllTypes(Connection conn) throws RuntimeException {
		List<String> names = new ArrayList<String>();

		if (conn == null)
			throw new RuntimeException("connection is null");

		try {
			DatabaseMetaData metadata = conn.getMetaData();
			ResultSet results = metadata.getTypeInfo();
			while (results.next()) {
				names.add(results.getString("TYPE_NAME"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException: " + e.getMessage()
					+ " at reader.getAllTypes");
		}

		return names;
	}

	/**
	 * ȡ���ݿ������
	 * 
	 * @return ���������б� (TABLE��VIEW��SYNONYM��)
	 * @throws RuntimeException
	 */
	public List<String> getTableTypes() throws RuntimeException {
		return getTableTypes(conn);
	}

	/**
	 * ȡ���ݿ������
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @return ���������б� (TABLE��VIEW��SYNONYM��)
	 * @throws RuntimeException
	 */
	public List<String> getTableTypes(Connection conn) throws RuntimeException {
		List<String> names = new ArrayList<String>();

		if (conn == null)
			throw new RuntimeException("connection is null");

		try {
			DatabaseMetaData metadata = conn.getMetaData();
			ResultSet results = metadata.getTableTypes();
			while (results.next()) {
				names.add(results.getString("TABLE_TYPE"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException: " + e.getMessage()
					+ " at reader.getCatalogs");
		}

		return names;
	}

	/**
	 * ����schema������ȡ����
	 * 
	 * @param schema
	 *            ���ݿ�schema (Ϊ�ջ���%ʱȡ������schema�µı�)
	 * @param type
	 *            ���� (TABLE��VIEW��SYNONYM�ȣ�Ϊ��ʱȡ�����еı�)
	 * @return �����б�
	 * @throws RuntimeException
	 */
	public List<Table> getTablesByType(String schema, String type)
			throws RuntimeException {
		return getTablesByType(conn, schema, type);
	}

	/**
	 * ����schema������ȡ����
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param schema
	 *            ���ݿ�schema (Ϊ�ջ���%ʱȡ������schema�µı�)
	 * @param type
	 *            ���� (TABLE��VIEW��SYNONYM�ȣ�Ϊ��ʱȡ�����еı�)
	 * @return �����б�
	 * @throws RuntimeException
	 */
	public List<Table> getTablesByType(Connection conn, String schema, String type)
			throws RuntimeException {
		List<Table> tables = new ArrayList<Table>();

		if (conn == null)
			throw new RuntimeException("connection is null");

		try {
			DatabaseMetaData metadata = conn.getMetaData();
			String[] types = type == null ? new String[] {TABLE, VIEW, SYNONYM } : new String[] { type };

			ResultSet results = metadata.getTables(null, schema, "%", types);
			while (results.next()) {
				tables.add(new Table(results.getString("TABLE_SCHEM"), results.getString("TABLE_TYPE"), results.getString("TABLE_NAME")));
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException: " + e.getMessage()
					+ " at reader.getTablesByType");
		}

		return tables;
	}

	/**
	 * �������ݿ����ȡ���ֶ���Ϣ
	 * 
	 * @param schemaName schema����
	 * @param tableName
	 *            ���ݿ����
	 * @return �ֶ���Ϣ�б�
	 * @throws RuntimeException
	 */
	public List<Column> getColumnsByTable(String schemaName, String tableName) throws RuntimeException {
		return getColumnsByTable(conn, schemaName, tableName);
	}

	/**
	 * �������ݿ����ȡ���ֶ���Ϣ
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param schemaName schema����
	 * @param tableName
	 *            ���ݿ����
	 * @return �ֶ���Ϣ�б�
	 * @throws RuntimeException
	 */
	public List<Column> getColumnsByTable(Connection conn, String schemaName, String tableName)
			throws RuntimeException {
		List<Column> columns = new ArrayList<Column>();

		if (conn == null)
			throw new RuntimeException("connection is null");

		try {
			DatabaseMetaData metadata = conn.getMetaData();
			ResultSet results = metadata.getColumns(null, schemaName, tableName, "%");
			while (results.next()) {
				columns.add(new Column(results.getString("COLUMN_NAME"),
						results.getInt("DATA_TYPE"), results
								.getString("TYPE_NAME"), results
								.getInt("COLUMN_SIZE"), results
								.getInt("DECIMAL_DIGITS"), results
								.getInt("NULLABLE"), results
								.getString("COLUMN_DEF"), results
								.getString("REMARKS")));
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException: " + e.getMessage()
					+ " at reader.getColumnsByTable");
		}

		return columns;
	}

}