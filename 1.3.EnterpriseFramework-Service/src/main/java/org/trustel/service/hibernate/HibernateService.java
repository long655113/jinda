package org.trustel.service.hibernate;

import java.io.Serializable;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.trustel.service.form.IPageQueryForm;
import org.trustel.service.sql.a.ICondition;
import org.trustel.service.sql.a.IModifiableQuery;
import org.trustel.service.sql.a.IQuery;

import com.trustel.common.ItemPage;

public class HibernateService extends HibernateDaoSupport implements IHibernateService {

	private int maxRows = 100000;

	public int getMaxRows() {
		return maxRows;
	}

	public void setMaxRows(int maxRows) {
		this.maxRows = maxRows;
	}

	protected Query createQuery(String hql) {
		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		return query;
	}

	/**
	 * ͨ��HQL��ѯ��䷵�ز�ѯ����,������һ������²�����ʹ��
	 * 
	 * @param hql
	 * @param values
	 *            org.trustel.hibernate.ConditionValue item
	 * @return
	 */
	protected Query createQuery(String hql, List<ICondition> values) {

		Query query = createQuery(hql);
		if (values != null)
			for (int i = 0; i < values.size(); i++) {
				ICondition value = values.get(i);
				switch (value.getType()) {
				case Types.DATE:
					query.setDate(i, (Date) value.getValue());
					break;
				case Types.TIME:
					query.setTime(i, (Date) value.getValue());
					break;
				case Types.TIMESTAMP:
					query.setTimestamp(i, (Date) value.getValue());
					break;
				default:
					query.setParameter(i, value.getValue());
				}
			}
		return query;

	}

	/**
	 * 
	 * ����Query�����SQLɾ������
	 * 
	 * @param query
	 *            �ο�[sql]Query����
	 * @return ɾ����¼����
	 */
	public long delete(IQuery builder) {
		Query query = createQuery(builder.getDeleteSQL(), builder.getValues());
		return query.executeUpdate();
	}

	/**
	 * 
	 * ����SQLɾ������
	 * 
	 * @param sql
	 *            �ο�[sql]Query����
	 * @param transaction
	 *            �Ƿ�֧������/�Ƿ������������﷨
	 * @return ɾ����¼����
	 */
	public long delete(String sql, List<ICondition> values) {
		Query query = createQuery(sql, values);
		return query.executeUpdate();
	}

	/**
	 * ��������
	 * 
	 * @param query
	 *            ��ο� ModifiableQuery����
	 * @param transaction
	 *            �Ƿ��������������
	 * @return Ӱ���¼����
	 */
	public long execute(List<IModifiableQuery> queries) {
		long ret = 0;
		for (int i = 0; i < queries.size(); i++) {
			IModifiableQuery builder = queries.get(i);
			Query query = createQuery(builder.getPrepareSQL(), builder.value2Conditions());
			ret = ret + query.executeUpdate();
		}
		return ret;
	}

	/**
	 * �޸�����
	 * 
	 * @param query
	 *            ��ο� ModifiableQuery���� ������InsertBuilder ��UpdateBuilder
	 * @return Ӱ���¼����
	 */
	public long execute(IModifiableQuery builder) {
		Query query = createQuery(builder.getPrepareSQL(), builder.value2Conditions());
		return query.executeUpdate();
	}

	/**
	 * ִ�д�SQL
	 * 
	 * @param sql 
	 *            SQL
	 * @param transaction
	 *            �Ƿ��������֧�����
	 * @return Ӱ���¼����
	 */
	public long execute(String sql, List<ICondition> values) {
		Query query = createQuery(sql, values);
		return query.executeUpdate();
	}

	public long getRecordCount(IQuery query) {
		return getRecordCount(query.getTotalSQL(), query.getValues());
	}

	/**
	 * ��ȡ��¼����
	 * 
	 * @param HQL
	 * @return ����
	 */
	public long getRecordCount(String HQL) {
		Object value = getHibernateTemplate().find(HQL).get(0);

		if (value instanceof Long)
			return ((Long) value).longValue();
		else
			return ((Integer) value).intValue();
	}

	/**
	 * ��ȡ��¼����
	 * 
	 * @param HQL
	 *            ��ʹ��QueryBuilder����
	 * @param values
	 *            �ο�Condition���� ��ʹ��QueryBuilder����
	 * @return ��¼��
	 */
	public long getRecordCount(String HQL, List<ICondition> values) {
		Query query = createQuery(HQL, values);
		Object value = query.list().get(0);

		if (value instanceof Long)
			return ((Long) value).longValue();
		else
			return ((Integer) value).intValue();

	}

	/**
	 * ����IDȡ����
	 * 
	 * @param classType
	 * @param id
	 * @return
	 */

	public Object getById(Class<?> classType, Serializable id) {
		return getById(getHibernateTemplate(), classType, id);
	}

	protected Object getById(HibernateTemplate temp, Class<?> classType, Serializable id) {
		return temp.get(classType, id);
	}

	/**
	 * ��������
	 * 
	 * @param query
	 *            ��ο� ModifiableQuery����
	 * @param transaction
	 *            �Ƿ��������������
	 * @return Ӱ���¼����
	 */
	public long insert(List<IModifiableQuery> queries) {
		return execute(queries);
	}

	/**
	 * ��������
	 * 
	 * @param query
	 *            ��ο� ModifiableQuery����
	 * @return Ӱ���¼����
	 */
	public long insert(IModifiableQuery query) {
		return execute(query);
	}

	/**
	 * ��ѯ������ָ�����Ͷ���
	 * 
	 * @param query
	 *            �ο�CommonQuery���� ��ʹ��QueryBuilder����
	 * @param maxrows
	 * @return ����
	 */
	public List<?> query(IQuery query, int maxrows) {
		return query(query.getHQL(), query.getValues(), maxrows);
	}

	/**
	 * ��ѯ������ָ������
	 * 
	 * @param query
	 *            �ο� CommonQuery����
	 * @param form -
	 *            ����ģ�ͣ���ο�PageQueryForm����
	 * @return ��ҳ����
	 */
	public ItemPage query(IQuery query, IPageQueryForm form) {
		long total = getRecordCount(query);
		return query(query, form, total);

	}

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
	public ItemPage query(IQuery query, IPageQueryForm form, long recordCount) {

		return query(query.getHQL(), query.getValues(), form, recordCount);

	}

	/**
	 * ��ѯ������ָ������
	 * 
	 * @param HQL
	 *            HQL
	 * @param maxrows
	 *            ��෵�ؼ�¼����
	 * @return ��ҳ����
	 */
	public List<?> query(String HQL, int maxrows) {
		// Connection conn=
		// DataSourceUtils.getConnection(SessionFactoryUtils.getDataSource(getSessionFactory()));
		// //....
		// DataSourceUtils.releaseConnection(conn,
		// SessionFactoryUtils.getDataSource(getSessionFactory()));
		// 

		return query(HQL, new ArrayList<ICondition>(), maxrows);
	}

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
	public List<?> query(String HQL, List<ICondition> conditions, int maxrows) {
		Query query = createQuery(HQL, conditions);
		if (maxrows > 0)
			query.setMaxResults(maxrows);
		return query.list();
	}

	public List<?> query(String HQL, List<ICondition> values, int skipSize, int pageSize) {
		Query query = createQuery(HQL, values);
		query.setFirstResult(skipSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

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
	public ItemPage query(String HQL, List<ICondition> values, IPageQueryForm form, long recordCount) {
		int first = (form.getPageIndex() - 1) * form.getPageSize();
		int pageSize = form.getPageSize();
		if (form.isExport()) {
			first = form.getSkipSize();
			pageSize = form.getExportSize();
		}
		List<?> list = query(HQL, values, first, pageSize);

		return new ItemPage(list, recordCount, form.getPageIndex(), form.getPageSize());

	}

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
	public ItemPage query(String HQL, IPageQueryForm form, long recordCount) {
		return query(HQL, null, form, recordCount);
	}

	/**
	 * ��������
	 * 
	 * @param query
	 *            ��ο� ModifiableQuery����
	 * @param transaction
	 *            �Ƿ��������������
	 * @return Ӱ���¼����
	 */
	public long update(List<IModifiableQuery> list) {
		return execute(list);
	}

	/**
	 * ��������
	 * 
	 * @param query
	 *            ��ο� ModifiableQuery����
	 * @param transaction
	 *            �Ƿ��������������
	 * @return Ӱ���¼����
	 */
	public long update(IModifiableQuery query) {
		return execute(query);
	}

	public void updateAll(List<?> list) {
		if (list != null)
			for (int i = 0; i < list.size(); i++) {
				updateObject(list.get(i));
			}
	}

	public void updateObject(Object item) {
		getHibernateTemplate().update(item);
	}

	public void save(List<?> list) {
		if (list != null)
			for (int i = 0; i < list.size(); i++) {
				save(list.get(i));
			}

	}

	public Serializable save(Object item) {
		return getHibernateTemplate().save(item);

	}

	public void deleteAll(Collection<?> items) {
		getHibernateTemplate().deleteAll(items);
		
	}

	public void deleteObject(Object item) {
		getHibernateTemplate().delete(item);
		
	}

	
}
