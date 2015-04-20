package org.trustel.service.hibernate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.trustel.service.ServiceException;
import org.trustel.service.form.IPageQueryForm;
import org.trustel.service.sql.a.ICondition;
import org.trustel.service.sql.a.IModifiableQuery;
import org.trustel.service.sql.a.IQuery;

import com.trustel.common.ItemPage;

public interface IHibernateService {

	/**
	 * ��ȡ��¼����
	 * 
	 * @param HQL
	 * @return ����
	 */
	public long getRecordCount(String HQL) throws ServiceException;

	/**
	 * ��ȡ��¼����
	 * 
	 * @param HQL
	 *            ��ʹ��QueryBuilder����
	 * @param values
	 *            �ο�Condition���� ��ʹ��QueryBuilder����
	 * @return ��¼��
	 */
	public long getRecordCount(String HQL, List<ICondition> values)
			throws ServiceException;

	public long getRecordCount(IQuery query) throws ServiceException;

	/**
	 * ����IDȡ����
	 * 
	 * @param classType
	 *            ������
	 * @param id
	 * @return
	 */
	public Object getById(Class<?> classType, Serializable id)
			throws ServiceException;

	/**
	 * ��ѯ������ָ�����Ͷ���
	 * 
	 * @param query
	 *            �ο�CommonQuery���� ��ʹ��QueryBuilder����
	 * @param maxrows
	 * @return ����
	 */
	public List<?> query(IQuery query, int maxrows) throws ServiceException;

	/**
	 * ��ѯ������ָ������
	 * 
	 * @param query
	 *            �ο� CommonQuery����
	 * @param form
	 *            ����ģ�ͣ���ο�PageQueryForm����
	 * @return ��ҳ����
	 */
	public ItemPage query(IQuery query, IPageQueryForm form)
			throws ServiceException;

	/**
	 * ��ѯ������ָ������
	 * 
	 * @param query
	 *            �ο� CommonQuery����
	 * @param form
	 *            ����ģ�ͣ���ο�PageQueryForm����
	 * @param recordCount
	 *            query��Ӧ�����ݼ�����
	 * @return ��ҳ����
	 */
	public ItemPage query(IQuery query, IPageQueryForm form, long recordCount)
			throws ServiceException;

	/**
	 * ��ѯ������ָ������
	 * 
	 * @param HQL
	 *            HQL
	 * @param maxrows
	 *            ��෵�ؼ�¼����
	 * @return ��ҳ����
	 */
	public List<?> query(String HQL, int maxrows) throws ServiceException;

	/**
	 * ��ѯ������ָ������
	 * 
	 * @param HQL
	 * @param conditions
	 *            ��ʹ��QueryBuilder����
	 * @param form
	 *            ����ģ�ͣ���ο�PageQueryForm����
	 * @return ����
	 */
	public List<?> query(String HQL, List<ICondition> conditions, int maxrows)
			throws ServiceException;

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param HQL
	 *            �����ݿ�ϵͳ���ݵ�HQL
	 * @param values
	 *            �ο�Condition����
	 * @param form
	 *            �ο�PageQueryForm����
	 * @param recordCount
	 *            HQL��Ӧ���ݼ���¼��
	 * @return ��ҳ���ݼ�
	 */
	public ItemPage query(String HQL, List<ICondition> values,
			IPageQueryForm form, long recordCount) throws ServiceException;

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param HQL
	 * @param form
	 *            �ο�PageQueryForm����
	 * @param recordCount
	 *            HQL��Ӧ���ݼ��ļ�¼��
	 * @return ��ҳ���ݼ���ITEM�д洢����pojoʵ��
	 */
	public ItemPage query(String HQL, IPageQueryForm form, long recordCount)
			throws ServiceException;

	/**
	 * 
	 * ����Query�����SQLɾ������
	 * 
	 * @param query
	 *            �ο�[sql]Query����
	 * @return ɾ����¼����
	 */
	public long delete(IQuery query);

	/**
	 * 
	 * ����SQLɾ������
	 * 
	 * @param sql
	 *            �ο�[sql]Query����
	 * @return ɾ����¼����
	 */
	public long delete(String sql, List<ICondition> values)
			throws ServiceException;

	/**
	 * ��������
	 * 
	 * @param query
	 *            ��ο� ModifiableQuery����
	 * @param transaction
	 *            �Ƿ��������������
	 * @return Ӱ���¼����
	 */
	public long execute(List<IModifiableQuery> queries) throws ServiceException;

	/**
	 * �޸�����
	 * 
	 * @param query
	 *            ��ο� ModifiableQuery���� ������InsertBuilder ��UpdateBuilder
	 * @return Ӱ���¼����
	 */
	public long execute(IModifiableQuery query) throws ServiceException;

	/**
	 * ִ�д�SQL
	 * 
	 * @param sql
	 *            SQL
	 * @return Ӱ���¼����
	 */
	public long execute(String sql, List<ICondition> values)
			throws ServiceException;

	/**
	 * ��������
	 * 
	 * @param query
	 *            ��ο� ModifiableQuery����
	 * @param transaction
	 *            �Ƿ��������������
	 * @return Ӱ���¼����
	 */
	public long insert(List<IModifiableQuery> queries) throws ServiceException;

	/**
	 * ��������
	 * 
	 * @param query
	 *            ��ο� ModifiableQuery����
	 * @return Ӱ���¼����
	 */
	public long insert(IModifiableQuery query) throws ServiceException;

	/**
	 * ��������
	 * 
	 * @param query
	 *            ��ο� ModifiableQuery����
	 * @param transaction
	 *            �Ƿ��������������
	 * @return Ӱ���¼����
	 */
	public long update(List<IModifiableQuery> list) throws ServiceException;

	/**
	 * ����ӳ�����־û�(���浽���ݿ���)
	 * 
	 * @param list
	 *            ����ӳ������б�(DO)(����)
	 */
	public void updateAll(List<?> list) throws ServiceException;

	/**
	 * ����ӳ�����־û�(���浽���ݿ���)(����)
	 * 
	 * @param item
	 *            ����ӳ�����(DO)
	 */
	public void updateObject(Object item) throws ServiceException;

	/**
	 * ����ӳ�����־û�(���浽���ݿ���)(����)
	 * 
	 * @param list
	 *            ����ӳ������б�(DO)
	 */
	public void save(List<?> list) throws ServiceException;

	/**
	 * ����ӳ�����־û�(���浽���ݿ���)(����)
	 * 
	 * @param item
	 *            ����ӳ�����(DO)
	 */
	public Serializable save(Object item) throws ServiceException;

	/**
	 * ��������
	 * 
	 * @param query
	 *            ��ο� ModifiableQuery����
	 * @param transaction
	 *            �Ƿ��������������
	 * @return Ӱ���¼����
	 */
	public long update(IModifiableQuery query) throws ServiceException;
	
	/**
	 * ɾ����������(����)
	 * 
	 * @param item
	 *            ����ӳ�����(DO)
	 */
	public void deleteObject(Object item) throws ServiceException;
	
	/**
	 * ����ɾ������(����)
	 * 
	 * @param items
	 *            ����ӳ�����(DO)
	 */
	public void deleteAll(Collection<?> items) throws ServiceException;

}
