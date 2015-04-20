package org.trustel.service.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.trustel.service.ServiceException;
import org.trustel.service.common.IORTransform;
import org.trustel.service.form.IPageQueryForm;
import org.trustel.service.sql.a.DefaultColumn;
import org.trustel.service.sql.a.IColumn;
import org.trustel.service.sql.a.ICondition;
import org.trustel.service.sql.a.IField;
import org.trustel.service.sql.a.IModifiableQuery;
import org.trustel.service.sql.a.IQuery;
import org.trustel.util.SimpleHashMap;

import com.trustel.common.ItemPage;

public class JdbcService implements IJdbcService {

	private Connection conn;

	protected final Log logger = LogFactory.getLog(getClass());

	private int maxRows = 100000;

	// private Object[] field2Array(List<Field> values) {
	// Object[] items = new Object[values.size()];
	// for (int i = 0; i < items.length; i++) {
	// items[i] = values.get(i).getValue();
	// }
	// return items;
	// }

	/**
	 * ִ�д洢����
	 * 
	 * @param callSQL
	 * @param inputs
	 * @param outputs
	 * @throws SQLException
	 */
	public ExecuteResult _call(String callSQL, ICallableStatementSetter setter,
			ICallableStatementGetter getter) throws ServiceException {
		CallableStatement cs = null;
		ExecuteResult ret = new ExecuteResult();
		try {
			cs = conn.prepareCall(callSQL);
			if (setter != null)
				setter.setParameterValues(cs);

			ret.ret = cs.execute();
			getter.readOutParameter(cs);
			ret.updateCount = cs.getUpdateCount();
			ResultSet rs = cs.getResultSet();
			try {
				ret.sets = resultSet2List(rs, getter, 0);
			} finally {
				closeResultSet(rs);
			}
			return ret;

		} catch (Exception e) {
			logger.error("_call-->" + e.getMessage());
			logger.error("  " + callSQL);
			throw new ServiceException(e.getMessage(), e);

		} finally {
			closeStatement(cs);
		}

	}

	protected void closeResultSet(ResultSet rs) throws ServiceException {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				logger.error("closeResultSet-->" + e.getMessage());
				throw new ServiceException(e.getMessage(), e);
			}
		}
	}

	// private Object[] cond2Array(List<Condition> values) {
	// Object[] items = new Object[values.size()];
	// for (int i = 0; i < items.length; i++) {
	// items[i] = values.get(i).getValue();
	// }
	// return items;
	// }

	protected void closeStatement(Statement stmt) throws ServiceException {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				logger.error("closeStatement-->" + e.getMessage());
				throw new ServiceException(e.getMessage(), e);
			}
		}
	}

	private int[] _execute(final List<IModifiableQuery> queries)
			throws SQLException {
		if (queries == null || queries.size() == 0)
			return null;
		String SQL = queries.get(0).getPrepareSQL();
		logger.info("execute-->" + SQL);
		int[] ret = null;
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL);
			for (int i = 0; i < queries.size(); i++) {
				prepareStatement(ps, queries.get(i).getValues());
				ps.addBatch();
			}
			ret = ps.executeBatch();
			closeStatement(ps);
			logger.info("execute-->" + ret.toString());
		} finally {
			closeStatement(ps);

		}

		return ret;
	}

	/**
	 * ִ�д�SQL(insert/delete/update/exec /call �޲���)
	 * 
	 * @param sql
	 *            SQL
	 * @param transaction
	 *            �Ƿ��������֧�����
	 * @return Ӱ���¼����
	 * @throws SQLException
	 */
	public ExecuteResult _execute(String SQL) throws ServiceException {
		ExecuteResult ret = new ExecuteResult();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL);
			ret.ret = ps.execute();
			ret.updateCount = ps.getUpdateCount();
		} catch (SQLException e) {
			ret.ret = false;
			logger.error("_execute-->" + e.getMessage());
			logger.error("  " + SQL);
			throw new ServiceException("execute(SQL)-->" + e.getMessage(), e);
		}
		closeStatement(ps);
		return ret;

	}

	/**
	 * ִ�в�ѯ(Insert /delete/update )
	 * 
	 * @param SQL
	 *            �Ƽ�ʹ��UpdateBuilder/InsertBuilder����
	 * @param values
	 *            �Ƽ�ʹ��UpdateBuilder/InsertBuilder����
	 * @return ִ�ж���
	 * @throws SQLException
	 */
	public ExecuteResult _execute(String SQL, final List<IField> values)
			throws ServiceException {
		PreparedStatement ps = null;
		ExecuteResult ret = new ExecuteResult();
		try {
			ps = conn.prepareStatement(SQL);
			prepareStatement(ps, values);
			if (ps.execute()) {
				ret.updateCount = ps.getUpdateCount();
				ret.ret = true;
			}
		} catch (SQLException e) {
			logger.error("_execute-->" + e.getMessage());
			logger.error("  " + SQL);
			throw new ServiceException(e.getMessage(), e);
		}
		return ret;
	}

	private long _executeA(final List<IModifiableQuery> queries)
			throws ServiceException {
		int[] ret = null;
		try {
			ret = _execute(queries);
		} catch (SQLException e) {
			logger.error("_executeA-->" + e.getMessage());
			throw new ServiceException(e.getMessage(), e);
		}
		long r = 0;
		for (int i = 0; i < ret.length; i++)
			r = ret[i] + r;
		return r;
	}

	protected List<IColumn> getColumnInformations(ResultSetMetaData data)
			throws SQLException {
		List<IColumn> arr = new ArrayList<IColumn>();
		for (int i = 1; i <= data.getColumnCount(); i++) {
			IColumn column = new DefaultColumn(data.getColumnName(i),
					data.getColumnType(i), i, data.getColumnLabel(i));
			arr.add(column);
		}
		return arr;
	}

	public int getMaxRows() {
		return maxRows;
	}

	public long _getNextCode(final String name, final int minValue,
			final long maxValue) throws ServiceException {
		// getnextcode ret,name,min,max
		NextCodeGetter nextCode = new NextCodeGetter(minValue);
		_call("{call getnextcode(?,?,?,?) }", new ICallableStatementSetter() {

			public void setParameterValues(CallableStatement cs)
					throws SQLException {
				cs.registerOutParameter(1, Types.BIGINT);
				cs.setString(2, name);
				cs.setInt(3, minValue);
				cs.setLong(4, maxValue);
			}
		}, nextCode);
		return nextCode.getNextCode();
	}

	/**
	 * ��ȡ��¼����
	 * 
	 * @param SQL
	 * @return ����
	 */
	public long _getRecordCount(String SQL) throws ServiceException {
		return _getRecordCount(SQL, new ArrayList<ICondition>());
	}

	/**
	 * ��ȡ��¼����
	 * 
	 * @param SQL
	 * @param values
	 *            �ο�Condition����
	 * @return ��¼��
	 */
	public long _getRecordCount(String SQL, List<ICondition> values)
			throws ServiceException {
		ResultSet rs = null;
		try {
			rs = getResultSet(SQL, values, 1);
		} catch (SQLException e) {
			logger.error("_getRecordCount" + e.getMessage());
			logger.error("  " + SQL);
			throw new ServiceException(e.getMessage(), e);
		}
		int iCount = 0;
		if (rs != null) {
			try {
				if (rs.next())
					iCount = rs.getInt(1);
				rs.getStatement().close();
				rs.close();
				rs = null;
			} catch (Exception e) {
				logger.error("_getRecordCount" + e.getMessage());
				logger.error("  " + SQL);
				throw new ServiceException(e.getMessage(), e);
			}

		}
		return iCount;
	}

	protected ResultSet getResultSet(String SQL, int maxRows)
			throws SQLException {
		ResultSet rs = null;
		Statement st = conn.createStatement();
		if (maxRows >= 0)
			st.setMaxRows(maxRows);
		rs = st.executeQuery(SQL);

		logger.info("DefaultConnection.getDataset with nonvalues");
		logger.info(SQL);
		logger.info("OK!");
		return rs;
	}

	protected ResultSet getResultSet(String SQL, List<ICondition> values,
			int maxRows) throws SQLException {
		if (values == null || values.size() < 1)
			return getResultSet(SQL, maxRows);
		// if (maxresults < maxRows)
		// throw new OverflowException();
		ResultSet rsTemp = null, rsRet = null;
		logger.info("DefaultConnection.getDataset");
		logger.info(SQL);
//		CallableStatement query = null;
		//���myslqһЩ�����ݵ�����
		PreparedStatement query = null;
//		query = conn.prepareCall(SQL);
		query = conn.prepareStatement(SQL);
		if (values != null)
			for (int i = 0; i < values.size(); i++) {
				ICondition value = values.get(i);
				switch (value.getType()) {
				case Types.INTEGER:
					query.setInt(i + 1, ((Integer) value.getValue()).intValue());
					break;
				case Types.SMALLINT:
					query.setShort(i + 1,
							((Integer) value.getValue()).shortValue());
					break;
				case Types.VARCHAR:
				case Types.CHAR:
					query.setString(i + 1, (String) value.getValue());
					break;
				case Types.FLOAT:
					query.setFloat(i + 1,
							((Float) value.getValue()).floatValue());
					break;
				case Types.DECIMAL:
				case Types.DOUBLE:
					query.setDouble(i + 1,
							((Double) value.getValue()).doubleValue());
					break;
				case Types.DATE:
					Date d = (Date) value.getValue();
					java.sql.Date d1 = new java.sql.Date(d.getTime());
					// java.sql.Date s = java.sql.Date.valueOf(DateUtils
					// .format(d, "yyyy-MM-dd HH:mm", ""));
					query.setDate(i + 1, d1);
					break;
				// case Types.l:
				// query.setDate(i, (Date) value.getValue());

				}
			}
		if (maxRows > 0)
			query.setMaxRows(maxRows);
		rsTemp = query.executeQuery();
		rsRet = rsTemp;
		logger.info("OK!");
		return rsRet;
	}

	private void prepareStatement(PreparedStatement ps, List<IField> values)
			throws SQLException {
		for (int j = 1; j <= values.size(); j++) {
			IField item = values.get(j - 1);
			switch (item.getType()) {
			case Types.INTEGER:
				ps.setInt(j, item.toInteger(0));
				break;
			case Types.SMALLINT:
				ps.setShort(j, item.toShort(0));
			case Types.VARCHAR:
			case Types.CHAR:
				ps.setString(j, item.toString());
				break;
			case Types.FLOAT:
				ps.setFloat(j, item.toFloat(0));
				break;
			case Types.DECIMAL:
			case Types.DOUBLE:
				ps.setDouble(j, item.toDouble(0));
			}
		}
	}

	public List<?> _query(IORTransform transform, IQuery query)
			throws ServiceException {
		return _query(transform, query.getHQL(), query.getValues());
	}

	/**
	 * ���ݲ�ѯ������������ת������ѯָ����֮�������
	 * 
	 * @param transform
	 *            ORת����(����-��ϵת����)
	 * @param query
	 *            ��ѯ������
	 * @param skip
	 *            ������¼���� skip>=0
	 * @param maxRows
	 *            ��෵�� ��¼�� ʵ�ʼ�¼��ΪmaxRow-skip
	 * @return ORת��������ָ�������б�
	 * @throws SQLException
	 */
	public List<?> _query(IORTransform transform, IQuery query, int skip,
			int maxRows) throws ServiceException {
		maxRows = maxRows > 0 ? maxRows : getMaxRows();
		maxRows = maxRows > getMaxRows() ? getMaxRows() : maxRows;

		return _query(transform, query.getSQL(), query.getValues(), skip,
				maxRows);
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param transform
	 *            ORת����(����-��ϵת����)
	 * @param query
	 *            ��ѯ������
	 * @param form
	 *            ��ҳ����ģ��
	 * @return ��ҳ����
	 * @throws SQLException
	 */
	public ItemPage _query(IORTransform transform, IQuery query,
			IPageQueryForm form) throws ServiceException {
		long total = _getRecordCount(query.getTotalSQL(), query.getValues());
		return _query(transform, query.getSQL(), query.getValues(), total, form);
	}

	/**
	 * ��ѯ
	 * 
	 * @param transform
	 *            �ο�ORTransform��
	 * @param query
	 *            �ο�CommonQuery����
	 * @param form
	 *            �ο�PageQueryForm����
	 * @return ���ݼ�(ORת�������ض���) ���������maxRows���ò�������
	 */
	public List<?> _query(IORTransform transform, String SQL,
			List<ICondition> values) throws ServiceException {
		return _query(transform, SQL, values, 0, maxRows);

	}

	/**
	 * ��ѯ
	 * 
	 * @param transform
	 *            �ο�ORTransform��
	 * @param query
	 *            �ο�CommonQuery����
	 * @param form
	 *            �ο�PageQueryForm����
	 * @param skipSize
	 *            ����ָ ����������skipSize>=0
	 * @return ���ݼ�(ORת�������ض���) ���������maxRows���ò�������
	 */
	public List<?> _query(IORTransform transform, String SQL,
			List<ICondition> values, int skipSize) throws ServiceException {
		return _query(transform, SQL, values, skipSize, maxRows);
	}

	/**
	 * ��ѯ
	 * 
	 * @param transform
	 *            �ο�ORTransform��
	 * @param query
	 *            �ο�CommonQuery����
	 * @param form
	 *            �ο�PageQueryForm����
	 * @param skipSize
	 *            ����ָ ����������skipSize>=0
	 * @param maxRows
	 *            ��෵��N�м�¼,������skipSizeָ���ļ�¼��
	 * @return ���ݼ�(ORת�������ض���)
	 * @throws SQLException
	 * @throws Exception
	 */
	protected List<?> resultSet2List(ResultSet rs, IORTransform transform,
			int skipSize) throws SQLException {
		List<Object> list = new ArrayList<Object>();
		logger.info("query-->skip record number:" + skipSize);
		if (rs != null) {
			List<IColumn> columns;
			columns = getColumnInformations(rs.getMetaData());

			int index = 0;
			while (rs.next()) {

				if (index >= skipSize)
					list.add(transform.transform(index + 1 - skipSize,
							row2Map(rs, columns)));
				index++;
			}
			logger.info("query-->dataset.size:" + index);
			rs.close();
		}
		return list;
	}

	public List<?> _query(IORTransform transform, String SQL,
			List<ICondition> values, int skipSize, int maxRows)
			throws ServiceException {
		maxRows = maxRows > getMaxRows() ? getMaxRows() : maxRows;

		ResultSet rs = null;
		try {
			rs = getResultSet(SQL, values, maxRows);
		} catch (SQLException e) {
			logger.error("" + e.getMessage());
			throw new ServiceException(e.getMessage(), e);
		} finally {
			// closeResultSet(rs);
		}
		logger.info("query-->skip record number:" + skipSize);
		try {
			return resultSet2List(rs, transform, skipSize);
		} catch (SQLException e) {
			logger.error("" + e.getMessage());
			throw new ServiceException(e.getMessage(), e);
		} finally {
			closeResultSet(rs);
		}
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param transform
	 *            ORת����(����-��ϵת����)
	 * @param SQL
	 *            ��׼SQL��ѯ(SELECT)
	 * @param conditions
	 *            ��ѯ����,ͨ����querybuilder����,����Ϊ��
	 * @param total
	 *            SQL��Ӧ���ݼ���¼��
	 * @param form
	 *            ��ҳ����ģ��
	 * @return ��ҳ��¼/Items��ԱΪORת�������ض���
	 * @throws SQLException
	 */
	public ItemPage _query(IORTransform transform, String SQL,
			List<ICondition> conditions, long total, IPageQueryForm form)
			throws ServiceException {
		int skipSize = form.isExport() ? form.getSkipSize() : (form
				.getPageIndex() - 1) * form.getPageSize();
		int maxRows = form.isExport() ? form.getSkipSize() : form.getPageSize()
				* form.getPageIndex();
		List<?> items = _query(transform, SQL, conditions, skipSize, maxRows);

		return new ItemPage(items, total, form.getPageIndex(),
				form.getPageSize());
	}

	/**
	 * 
	 * @param row
	 *            ��ǰ��
	 * @param columns
	 *            ���ݼ��ֶζ��� �ο�getColumnInformations
	 * @return ������(�����)
	 */
	protected SimpleHashMap row2Map(ResultSet row, List<IColumn> columns) {
		SimpleHashMap map = new SimpleHashMap();
		try {
			for (int i = 0; i < columns.size(); i++) {
				IColumn column = columns.get(i);
				String fieldName = column.getName();
				if (!fieldName.equalsIgnoreCase(column.getAlais()))
					fieldName = column.getAlais();

				switch (column.getType()) {
				case Types.TIMESTAMP:
					map.put(fieldName, row.getTimestamp(fieldName));
					break;
				case Types.DATE:
					map.put(fieldName, row.getTimestamp(fieldName));
					break;
				case Types.NUMERIC:
					map.put(fieldName, row.getDouble(fieldName));
					break;
				case Types.CLOB:
					map.put(fieldName, ClobToString(row.getClob(fieldName)));
					break;
				default:
					map.put(fieldName, row.getObject(fieldName));
				}

			}
		} catch (Exception e) {
			logger.error("row2Event");
			throw new ServiceException(e.getMessage(), e);
		}
		return map;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}

	/**
	 * ��������
	 * 
	 * @param query
	 *            ��ο� ModifiableQuery����
	 * @param transaction
	 *            �Ƿ��������������
	 * @return Ӱ���¼����
	 * @throws SQLException
	 */
	public long _update(List<IModifiableQuery> queries) throws ServiceException {
		return _executeA(queries);
	}

	public long _update(IModifiableQuery query) throws ServiceException {
		ExecuteResult ret = _execute(query.getPrepareSQL(), query.getValues());
		if (ret.ret)
			return ret.updateCount;
		else
			return -1;
	}

	public Connection getCurrentConnection() {
		return conn;
	}
	
	/**
	 * clobת����String
	 * @Description: TODO
	 * @param clob
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public  String ClobToString(Clob clob) throws SQLException, IOException {

		String reString = "";
		if(clob != null){
			Reader is = clob.getCharacterStream();// �õ���
			BufferedReader br = new BufferedReader(is);
			String s = br.readLine();
			StringBuffer sb = new StringBuffer();
			while (s != null) {// ִ��ѭ�����ַ���ȫ��ȡ����ֵ��StringBuffer��StringBufferת��STRING
			sb.append(s);
			s = br.readLine();
			}
			reString = sb.toString();
		}
		
		return reString;
	}
	
	
	/**
	 * sql��ѯ
	 * 
	 * @param SQL sql���
	 * @param paramMap sql����
	 * @throws SQLException
	 */
	protected ResultSet getResultSet_(String SQL,PreparedStatement query, Map<String,Object> paramMap) throws Exception {
		if (null == paramMap){
			return getResultSet_(SQL,query);
		}	
		ResultSet rsTemp = null, rsRet = null;
		logger.info("DefaultConnection.getDataset");
		logger.info(SQL);
		List<String> paramList=sqlParamCompose(SQL);
		SQL=sqlParamCompose1(SQL);
		logger.info(SQL);
		query = conn.prepareStatement(SQL);
		if (null != paramMap){
			for (int j = 0; j < paramList.size(); j++) {
				String key=paramList.get(j);
				String objectTypeName=paramMap.get(key).getClass().getName();
				if(objectTypeName.equalsIgnoreCase("java.lang.Integer")){
					query.setInt(j+1, Integer.valueOf(paramMap.get(key).toString()));
				}else if(objectTypeName.equalsIgnoreCase("java.lang.String")){
					query.setString(j+1, paramMap.get(key).toString());
				}else if(objectTypeName.equalsIgnoreCase("java.lang.Double")){
					query.setDouble(j+1, Double.valueOf(paramMap.get(key).toString()));
				}else if(objectTypeName.equalsIgnoreCase("java.util.Date")){
					Date d=(Date)paramMap.get(key);
					Timestamp t=new Timestamp(d.getTime());
					query.setTimestamp(j+1, t);
				}else{
					query.setObject(j+1, paramMap.get(key));
				}
			}
		}
		rsTemp = query.executeQuery();
		rsRet = rsTemp;
		logger.info("OK!");
		return rsRet;
	}

	/**
	 * sql��ѯ�޲���
	 * 
	 * @param SQL sql���
	 * @throws SQLException
	 */
	protected ResultSet getResultSet_(String SQL,PreparedStatement query) throws SQLException {
		ResultSet rsTemp = null, rsRet = null;
		logger.info("DefaultConnection.getDataset");
		logger.info(SQL);
		query = conn.prepareStatement(SQL);
		rsTemp = query.executeQuery();
		rsRet = rsTemp;
		logger.info("OK!");
		return rsRet;
	}

	/**
	 * sql��ѯ ������˳�����list
	 * 
	 * @param sql sql���
	 * @throws SQLException
	 */
	private List<String> sqlParamCompose(String sql){
		List<String> list=new ArrayList<String>();
		Pattern p=Pattern.compile("#\\w+#");
		Matcher m=p.matcher(sql);
		while(m.find()){
			String param=m.group(0);
			list.add(param.replace("#", ""));
		}
		return list;
	}

	/**
	 * sql����еĲ���ȫ���滻�ɡ�����
	 * 
	 * @param sql sql���
	 * @throws SQLException
	 */
	private String sqlParamCompose1(String sql){
		Pattern p=Pattern.compile("#\\w+#");
		Matcher m=p.matcher(sql);
		while(m.find()){
			String param=m.group(0);
			sql=sql.replace(param, "?");
		}
		return sql;
	}

	/**
	 * �������Ϣ
	 * 
	 * @param data
	 * @throws SQLException
	 */
	protected List<IColumn> getColumnInformations_(ResultSetMetaData data)
			throws SQLException {
		List<IColumn> arr = new ArrayList<IColumn>();
		for (int i = 1; i <= data.getColumnCount(); i++) {
			IColumn column = new DefaultColumn(data.getColumnName(i), data
					.getColumnType(i), i, data.getColumnLabel(i));
			arr.add(column);
		}
		return arr;
	}

	/**
	 * ��װLIST MAP���
	 * 
	 * @param rs 
	 * @param columns 
	 * @throws SQLException
	 */
	private List<Map<String,Object>> obtainMapResult(ResultSet rs,List<IColumn> columns)throws SQLException{
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		while(rs.next()){
			Map<String,Object> map=new HashMap<String, Object>();
			for (int i = 0; i < columns.size(); i++) {
				String columnName=columns.get(i).getAlais();
				if(rs.getObject(columnName)!=null){
					if (rs.getObject(columnName).getClass().getName()
							.equalsIgnoreCase("java.sql.Date")
							|| rs.getObject(columnName).getClass().getName()
									.toLowerCase().contains("timestamp")
							|| rs.getObject(columnName).getClass().getName()
									.toLowerCase().contains("date")){
						map.put(columnName, rs.getTimestamp(columnName));
					}else{
						map.put(columnName, rs.getObject(columnName));
					}
				}else{
					map.put(columnName, rs.getObject(columnName));
				}
				
			}
			list.add(map);
		}
		return list;
	}

	/**
	 * ��װLIST ����ʵ����
	 * 
	 * @param rs 
	 * @param columns 
	 * @throws SQLException
	 */
	private List<Object> obtainObjectResult(ResultSet rs,List<IColumn> columns,Class<?> c)throws Exception{
		List<Object> list=new ArrayList<Object>();
		Method []ms=c.getDeclaredMethods();
		while(rs.next()){
			Object obj=c.newInstance();
			for (int i = 0; i < columns.size(); i++) {
				String columnName=columns.get(i).getAlais();
				for(Method m:ms){
					if(m.getName().contains("set")&&m.getName().replace("set", "").equalsIgnoreCase(columnName)){
						if(null != rs.getObject(columnName)){
							//String typeName=rs.getObject(columnName).getClass().getName();
							String typeName1=m.getParameterTypes()[0].toString().replace("class ", "");
							if(typeName1.equalsIgnoreCase("java.lang.Float")||typeName1.equalsIgnoreCase("float")){
								m.invoke(obj, rs.getFloat(columnName));
							}else if(typeName1.equalsIgnoreCase("java.lang.Double")||typeName1.equalsIgnoreCase("double")){
								m.invoke(obj, rs.getDouble(columnName));
							}else if(typeName1.equalsIgnoreCase("java.lang.String")){
								m.invoke(obj, rs.getString(columnName));
							}else if(typeName1.equalsIgnoreCase("java.lang.Integer")||typeName1.equalsIgnoreCase("int")){
								m.invoke(obj, rs.getInt(columnName));
							}else if(typeName1.equalsIgnoreCase("java.lang.Long")||typeName1.equalsIgnoreCase("long")){
								m.invoke(obj, rs.getLong(columnName));
							}else if(typeName1.equalsIgnoreCase("java.lang.Short")||typeName1.equalsIgnoreCase("short")){
								m.invoke(obj, rs.getShort(columnName));
							}else if(typeName1.equalsIgnoreCase("java.util.Date")){
								m.invoke(obj, rs.getTimestamp(columnName));
							}else if(typeName1.equalsIgnoreCase("java.lang.Byte")||typeName1.equalsIgnoreCase("byte")){
								m.invoke(obj, rs.getByte(columnName));
							}else if(typeName1.equalsIgnoreCase("java.lang.Boolean")||typeName1.equalsIgnoreCase("boolean")){
								m.invoke(obj, rs.getBoolean(columnName));
							}
							break;
						}else{
						}
					}
				}
			}
			list.add(obj);
		}
		return list;
	}

	/**
	 * ��sql�����ĳ�ʼ��
	 * 
	 * @param paramMap sql����
	 */
//	private Map<String,Object> initParamMap(Map<String,Object> paramMap){
//		Map<String,Object> initParamMap=new HashMap<String,Object>();
//		if (paramMap != null) {
//			Iterator<String> it = paramMap.keySet().iterator();
//			while (it.hasNext()) {
//				String key = it.next();
//				String key1 = key.toUpperCase();
//				initParamMap.put(key1, paramMap.get(key));
//			}
//		} else {
//			initParamMap = null;
//		}
//		return initParamMap;
//	}

	/**
	 * ��ѯ���ⲿ����
	 * 
	 * @param SQL sql���
	 * @param paramMap sql����
	 * @throws SQLException
	 */
	public List<Map<String,Object>> query(String SQL, Map<String,Object> paramMap)throws Exception{
			//SQL=SQL.toUpperCase();
			Map<String,Object> initParamMap=paramMap;
			PreparedStatement query=null;
			ResultSet rs=getResultSet_(SQL,query,initParamMap);
			List<IColumn> columns=getColumnInformations_(rs.getMetaData());
			List<Map<String,Object>> list=obtainMapResult(rs,columns);
			closeResultSet(rs);
			closeStatement(query);
			return list;
	}
	
	/**
	 * ��ѯ���ⲿ����2
	 * 
	 * @param SQL sql���
	 * @param paramMap sql����
	 * @throws SQLException
	 */
	public List<Object> queryObject(String SQL, Map<String,Object> paramMap,Class<?> c)throws Exception{
		//SQL=SQL.toUpperCase();
		Map<String,Object> initParamMap=paramMap;
		PreparedStatement query=null;
		ResultSet rs=getResultSet_(SQL,query,initParamMap);
		List<IColumn> columns=getColumnInformations_(rs.getMetaData());
		List<Object> list=obtainObjectResult(rs,columns,c);
		closeResultSet(rs);
		closeStatement(query);
		return list;
	}

	public int getRecordCount_(String sql,Map<String,Object> paramMap){
		int count=0;
		List<Map<String, Object>> resultList=new ArrayList<Map<String, Object>>();
		try {
			resultList = query(sql, paramMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(resultList.size()==1)
			count=Integer.valueOf(resultList.get(0).get("TOTAL").toString());
		return count;
	}

}
