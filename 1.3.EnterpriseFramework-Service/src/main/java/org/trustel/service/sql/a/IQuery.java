package org.trustel.service.sql.a;

import java.util.List;

public interface IQuery {
	/**
	 * 
	 * @return delete from tablename where
	 */
	public String getDeleteSQL();

	/**
	 * ���ز�ѯ��䣨��ͳ������䣩(hibernate:from XX)
	 */
	public String getHQL();

	/**
	 * ���ز�ѯ��䣨��ͳ������䣩
	 * 
	 * @param *
	 * @return ���� select fieldlist from tablename where .... �ޱ���ʱ���� where
	 *         ֮����������
	 */
	public String getSQL();

	/**
	 * 
	 * @param fieldlist
	 * @return ���� select fieldlist from tablename where .... �ޱ���ʱ���� where
	 *         ֮����������
	 */
	public String getSQL(String fieldlist);

	/**
	 * 
	 * @return ����select count(*) from tableName where���
	 */
	public String getTotalSQL();

	/**
	 * 
	 * @return ���ز�ѯ����
	 */
	public List<ICondition> getValues();

	/**
	 * 
	 * @return ���ز�ѯ��where֮������ݣ�������where)
	 */
	public String getWhere();
}
