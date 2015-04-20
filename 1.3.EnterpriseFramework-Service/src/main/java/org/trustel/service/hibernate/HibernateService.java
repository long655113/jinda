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
	 * 通过HQL查询语句返回查询对像,本方法一般情况下不建议使用
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
	 * 根据Query构造的SQL删除数据
	 * 
	 * @param query
	 *            参考[sql]Query定义
	 * @return 删除记录行数
	 */
	public long delete(IQuery builder) {
		Query query = createQuery(builder.getDeleteSQL(), builder.getValues());
		return query.executeUpdate();
	}

	/**
	 * 
	 * 根据SQL删除数据
	 * 
	 * @param sql
	 *            参考[sql]Query定义
	 * @param transaction
	 *            是否支持事务/是否添加事务控制语法
	 * @return 删除记录行数
	 */
	public long delete(String sql, List<ICondition> values) {
		Query query = createQuery(sql, values);
		return query.executeUpdate();
	}

	/**
	 * 更新数据
	 * 
	 * @param query
	 *            请参考 ModifiableQuery定义
	 * @param transaction
	 *            是否添加事务控制语句
	 * @return 影响记录行数
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
	 * 修改数据
	 * 
	 * @param query
	 *            请参考 ModifiableQuery定义 可以是InsertBuilder 或UpdateBuilder
	 * @return 影响记录行数
	 */
	public long execute(IModifiableQuery builder) {
		Query query = createQuery(builder.getPrepareSQL(), builder.value2Conditions());
		return query.executeUpdate();
	}

	/**
	 * 执行存SQL
	 * 
	 * @param sql 
	 *            SQL
	 * @param transaction
	 *            是否添加事务支持语句
	 * @return 影响记录行数
	 */
	public long execute(String sql, List<ICondition> values) {
		Query query = createQuery(sql, values);
		return query.executeUpdate();
	}

	public long getRecordCount(IQuery query) {
		return getRecordCount(query.getTotalSQL(), query.getValues());
	}

	/**
	 * 获取记录行数
	 * 
	 * @param HQL
	 * @return 行数
	 */
	public long getRecordCount(String HQL) {
		Object value = getHibernateTemplate().find(HQL).get(0);

		if (value instanceof Long)
			return ((Long) value).longValue();
		else
			return ((Integer) value).intValue();
	}

	/**
	 * 获取记录行数
	 * 
	 * @param HQL
	 *            可使用QueryBuilder生成
	 * @param values
	 *            参考Condition定义 可使用QueryBuilder生成
	 * @return 记录数
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
	 * 根据ID取对象
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
	 * 插入数据
	 * 
	 * @param query
	 *            请参考 ModifiableQuery定义
	 * @param transaction
	 *            是否添加事务控制语句
	 * @return 影响记录行数
	 */
	public long insert(List<IModifiableQuery> queries) {
		return execute(queries);
	}

	/**
	 * 插入数据
	 * 
	 * @param query
	 *            请参考 ModifiableQuery定义
	 * @return 影响记录行数
	 */
	public long insert(IModifiableQuery query) {
		return execute(query);
	}

	/**
	 * 查询并返回指定类型对象
	 * 
	 * @param query
	 *            参考CommonQuery定义 可使用QueryBuilder生成
	 * @param maxrows
	 * @return 对象集
	 */
	public List<?> query(IQuery query, int maxrows) {
		return query(query.getHQL(), query.getValues(), maxrows);
	}

	/**
	 * 查询并返回指定对象集
	 * 
	 * @param query
	 *            参考 CommonQuery定义
	 * @param form -
	 *            请求模型，请参考PageQueryForm定义
	 * @return 分页对象集
	 */
	public ItemPage query(IQuery query, IPageQueryForm form) {
		long total = getRecordCount(query);
		return query(query, form, total);

	}

	/**
	 * 查询并返回指定对象集
	 * 
	 * @param query
	 *            参考 CommonQuery定义
	 * @param form
	 *            请求模型，请参考PageQueryForm定义
	 * @param recordCount
	 *            query对应的数据集行数
	 * @return 分页对象集
	 */
	public ItemPage query(IQuery query, IPageQueryForm form, long recordCount) {

		return query(query.getHQL(), query.getValues(), form, recordCount);

	}

	/**
	 * 查询并返回指定对象集
	 * 
	 * @param HQL
	 *            HQL
	 * @param maxrows
	 *            最多返回记录行数
	 * @return 分页对象集
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
	 * 查询并返回指定对象集
	 * 
	 * @param HQL
	 * @param conditions
	 *            可使用QueryBuilder生成
	 * @param form
	 *            请求模型，请参考PageQueryForm定义
	 * @return 对象集
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
	 * 分页查询
	 * 
	 * @param HQL
	 *            和数据库系统兼容的HQL
	 * @param values
	 *            参考Condition定义
	 * @param form
	 *            参考PageQueryForm定义
	 * @param recordCount
	 *            HQL对应数据集记录数
	 * @return 分页数据集
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
	 * 分页查询
	 * 
	 * @param HQL
	 * @param form
	 *            参考PageQueryForm定义
	 * @param recordCount
	 *            HQL对应数据集的记录数
	 * @return 分页数据集，ITEM中存储的是pojo实例
	 */
	public ItemPage query(String HQL, IPageQueryForm form, long recordCount) {
		return query(HQL, null, form, recordCount);
	}

	/**
	 * 更新数据
	 * 
	 * @param query
	 *            请参考 ModifiableQuery定义
	 * @param transaction
	 *            是否添加事务控制语句
	 * @return 影响记录行数
	 */
	public long update(List<IModifiableQuery> list) {
		return execute(list);
	}

	/**
	 * 更新数据
	 * 
	 * @param query
	 *            请参考 ModifiableQuery定义
	 * @param transaction
	 *            是否添加事务控制语句
	 * @return 影响记录行数
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
