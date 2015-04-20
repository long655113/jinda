package org.trustel.service.sql.a;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.trustel.common.Utils;


public abstract class AbstractModiableQuery implements IModifiableQuery {
	protected List<IField> items = new ArrayList<IField>();

	protected String tableName;

	/**
	 * ����HQL��䣬Hibernateʹ��
	 * 
	 * @param classType
	 *            O/Rӳ������
	 */
	public AbstractModiableQuery(Class<?> pojo) {
		this.tableName = getClassName(pojo);
	}

	/**
	 * ����SQL��䣬JDBCʹ��
	 * 
	 * @param tableName
	 *            DBMS�������
	 */
	public AbstractModiableQuery(String tableName) {
		this.tableName = tableName;
	}

	private void add(IField item) {
		items.add(item);
	}

	/**
	 * ����һ���ֽ�������´���,�ڷ�Papare�в���ʹ�á�
	 * 
	 * BLOB�ֶ�ʱʹ��
	 * 
	 * @param fieldName
	 *            �ֶ�����O/R��ʾ������
	 * @param value
	 *            �ֶ�ֵ
	 */
	public void addField(String fieldName, byte[] value) {
		add(new DefaultField(fieldName, value));
	}

	/**
	 * �����ֶ�
	 * 
	 * @param fieldName
	 * @param value
	 *            ����ֵ������ת���� ������(GMT+8)ʱ�䣬ȡ��ʱ��ת��
	 */
	public void addField(String fieldName, Date value) {
		add(new DefaultField(fieldName, value));
	}

	public void addField(String fieldName, double value) {
		add(new DefaultField(fieldName, value));
	}

	public void addField(String fieldName, float value) {
		add(new DefaultField(fieldName, value));
	}

	public void addField(String fieldName, int value) {

		add(new DefaultField(fieldName, value));
	}

	public void addField(String fieldName, long value) {
		add(new DefaultField(fieldName, value));
	}

	/**
	 * 
	 * @param fieldName
	 * @param value
	 * @param type
	 *            sql.Types�е�ֵ
	 */
	public void addField(String fieldName, Object value, int type) {
		add(new DefaultField(fieldName, value, type));
	}

	public void addField(String fieldName, String value) {
		add(new DefaultField(fieldName, value, Types.VARCHAR));
	}

	protected synchronized String getClassName(Class<?> pojo) {
		String name = pojo.getName();

		return name.substring(name.lastIndexOf('.') + 1);
	}

	protected Object getExpress(IField field, boolean prepare) {
		if (prepare)
			return "?";

		switch (field.getType()) {
		case Types.INTEGER:
			return field.getValue().toString();
		case Types.BIGINT:
			return field.getValue().toString();
		case Types.VARCHAR:
		case Types.CHAR:
			return "'" + field.getValue() + "'";
		case Types.DATE:
			return "'"
					+ Utils.format((Date) field.getValue(),
							"yyyy-MM-dd HH:mm:ss", "") + "'";

		case Types.TIME:
			return "'" + Utils.format((Date) field.getValue(), "HHmm:ss", "")
					+ "'";
		case Types.TIMESTAMP:
			return "'"
					+ Utils.format((Date) field.getValue(),
							"yyyy-MM-dd HHmm:ss", "") + "'";
		default:
			return field.getValue();

		}
	}

	/**
	 * ��ӦHibernate����HQL,JDBC����SQL
	 * 
	 * ע��byte[]������ֻ��ʹ�ò�����ʽ
	 * 
	 * @param prepare
	 *            true��ʾ����ʹ�ò����Ĳ�ѯ���������в����ϳ��ڲ�ѯ�����
	 * @return
	 */
	protected abstract String getSQL(boolean prepare);

	public String getSQL() {
		return getSQL(false);
	}

	public String getPrepareSQL() {
		return getSQL(true);
	}

	/**
	 * ����ֵ
	 * 
	 * @return
	 */
	public List<IField> getValues() {
		return items;
	}

	public List<ICondition> value2Conditions() {
		List<ICondition> conditions = new ArrayList<ICondition>();
		for (int i = 0; i < items.size(); i++)
			conditions.add(items.get(i));
		return conditions;
	}
}
