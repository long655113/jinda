package org.trustel.service.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.trustel.service.ServiceException;
import org.trustel.service.common.IORTransform;
import org.trustel.service.form.IPageQueryForm;
import org.trustel.service.sql.a.ICondition;
import org.trustel.service.sql.a.IField;
import org.trustel.service.sql.a.IModifiableQuery;
import org.trustel.service.sql.a.IQuery;

import com.trustel.common.ItemPage;

public interface IJdbcService {
	/**
	 * ��ȡ��¼����
	 * 
	 * @param SQL
	 * @return ����
	 */
	public long _getRecordCount(String SQL) throws ServiceException;

	/**
	 * ��ȡ��¼����
	 * 
	 * @param SQL
	 * @param values
	 *            �ο�Condition����
	 * @return ��¼��
	 */
	public long _getRecordCount(String SQL, List<ICondition> values)
			throws ServiceException;

	public List<?> _query(IORTransform transform, IQuery query)
			throws ServiceException;

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
			int maxRows) throws ServiceException;

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
			IPageQueryForm form) throws ServiceException;

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
			List<ICondition> values) throws ServiceException;

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
			List<ICondition> values, int skipSize) throws ServiceException;

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
	 */

	public List<?> _query(IORTransform transform, String SQL,
			List<ICondition> values, int skipSize, int maxRows)
			throws ServiceException;

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
			throws ServiceException;

	/**
	 * 
	 * @param maxRows
	 *            JDBC��ѯ��󷵻ؼ�¼����
	 */
	public void setMaxRows(int maxRows);

	public ExecuteResult _call(String callSQL, ICallableStatementSetter setter,
			ICallableStatementGetter getter) throws ServiceException;

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
	public ExecuteResult _execute(String SQL) throws ServiceException;

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
			throws ServiceException;

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
	public long _update(List<IModifiableQuery> queries) throws ServiceException;

	public long _update(IModifiableQuery query) throws ServiceException;

	/**
	 * 
	 * @param name
	 *            �������
	 * @param minValue
	 *            ��Сֵ
	 * @param maxValue
	 *            ���ֵ
	 * @return ��һ�����
	 */
	public long _getNextCode(String name, int minValue, long maxValue)
			throws ServiceException;
	
	/**
	 * ��ѯ���ⲿ����
	 * 
	 * @param SQL sql���
	 * @param paramMap sql����
	 * @throws SQLException
	 */
	public List<Map<String,Object>> query(String SQL, Map<String,Object> paramMap)throws Exception;
	
	
	/**
	 * ��ѯ���ⲿ����2
	 * 
	 * @param SQL sql���
	 * @param paramMap sql����
	 * @throws SQLException
	 */
	public List<Object> queryObject(String SQL, Map<String,Object> paramMap,Class<?> c)throws Exception;
	
	public int getRecordCount_(String sql,Map<String,Object> paramMap);
	
	public Connection getCurrentConnection();

}
