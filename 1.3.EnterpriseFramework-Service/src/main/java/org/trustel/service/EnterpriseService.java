package org.trustel.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.trustel.service.common.IORTransform;
import org.trustel.service.common.InitPagingIndex;
import org.trustel.service.form.IPageQueryForm;
import org.trustel.service.hibernate.HibernateService;
import org.trustel.service.jdbc.ExecuteResult;
import org.trustel.service.jdbc.ICallableStatementGetter;
import org.trustel.service.jdbc.ICallableStatementSetter;
import org.trustel.service.jdbc.IJdbcService;
import org.trustel.service.jdbc.JdbcService;
import org.trustel.service.sql.a.ICondition;
import org.trustel.service.sql.a.IField;
import org.trustel.service.sql.a.IModifiableQuery;
import org.trustel.service.sql.a.IQuery;

import com.trustel.common.ItemPage;

public class EnterpriseService extends HibernateService implements IEnterpriseService {


	private IJdbcService getJdbcService() {
		final JdbcService ret = new JdbcService();
		Connection connection = DataSourceUtils.getConnection(
				SessionFactoryUtils.getDataSource(getSessionFactory()));
		ret.setConnection(connection);
		ret.setMaxRows(getMaxRows());
		return ret;

	}

	private void releaseJdbcService(IJdbcService jdbcService) {
		if (null != jdbcService){
			DataSourceUtils.releaseConnection(
					jdbcService.getCurrentConnection(), 
					SessionFactoryUtils.getDataSource(getSessionFactory()));
		}
	}

	public ExecuteResult _call(String callSQL, ICallableStatementSetter setter,
			ICallableStatementGetter getter) throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._call(callSQL, setter, getter);
		} finally {
			releaseJdbcService(jdbcService);
		}
	}

	public ExecuteResult _execute(final String SQL, final List<IField> values)
		throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._execute(SQL, values);
		} finally {
			releaseJdbcService(jdbcService);
		}
	}

	public ExecuteResult _execute(final String SQL) throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._execute(SQL);
		} finally {
			releaseJdbcService(jdbcService);
		}
	}

	public long _getNextCode(final String name, final int minValue,
			final long maxValue) throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._getNextCode(name, minValue, maxValue);
		} finally {
			releaseJdbcService(jdbcService);
		}
	}

	public long _getRecordCount(final String SQL, final List<ICondition> values)
			throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._getRecordCount(SQL, values);
		} finally {
			releaseJdbcService(jdbcService);
		}

	}

	public long _getRecordCount(final String SQL) throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._getRecordCount(SQL);
		} finally {
			releaseJdbcService(jdbcService);
		}
	}

	public List<?> _query(final IORTransform transform, final IQuery query,
			final int skip, final int maxRows) throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._query(transform, query, skip, maxRows);
		} finally {
			releaseJdbcService(jdbcService);
		}
	}

	public ItemPage _query(final IORTransform transform, final IQuery query,
			final IPageQueryForm form) throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._query(transform, query, form);
		} finally {
			releaseJdbcService(jdbcService);
		}
	}

	public List<?> _query(final IORTransform transform, final IQuery query)
			throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._query(transform, query);
		} finally {
			releaseJdbcService(jdbcService);
		}
	}

	public List<?> _query(final IORTransform transform, final String SQL,
			final List<ICondition> values, final int skipSize, final int maxRows)
			throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._query(transform, SQL, values, skipSize, maxRows);
		} finally {
			releaseJdbcService(jdbcService);
		}
	}

	public List<?> _query(final IORTransform transform, final String SQL,
			final List<ICondition> values, final int skipSize)
			throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._query(transform, SQL, values, skipSize);
		} finally {
			releaseJdbcService(jdbcService);
		}
	}

	public ItemPage _query(final IORTransform transform, final String SQL,
			final List<ICondition> conditions, final long total,
			final IPageQueryForm form) throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._query(transform, SQL, conditions, total, form);
		} finally {
			releaseJdbcService(jdbcService);
		}
	}

	public List<?> _query(final IORTransform transform, final String SQL,
			final List<ICondition> values) throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._query(transform, SQL, values);
		} finally {
			releaseJdbcService(jdbcService);
		}

	}

	public long _update(final IModifiableQuery query) throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._update(query);
		} finally {
			releaseJdbcService(jdbcService);
		}
	}

	public long _update(final List<IModifiableQuery> queries)
			throws ServiceException {
		final IJdbcService jdbcService = getJdbcService();
		try {
			return jdbcService._update(queries);
		} finally {
			releaseJdbcService(jdbcService);
		}
	}

	public void setMaxRows(final int maxRows) {
		final IJdbcService jdbcService = getJdbcService();
		try {
			jdbcService.setMaxRows(maxRows);
		} finally {
			releaseJdbcService(jdbcService);
		}
	}
	
	public int getRecordCount_(String sql,Map<String,Object> paramMap){
		String sqlStatis=InitPagingIndex.generateStatisRecordSql(sql);
		final IJdbcService jdbcService = getJdbcService();
		int count =0;
		try {
			count=jdbcService.getRecordCount_(sqlStatis, paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			releaseJdbcService(jdbcService);
		}
		return count;
	}

	public List<Map<String,Object>> query(String SQL, Map<String,Object> paramMap)throws Exception{
		final IJdbcService jdbcService = getJdbcService();
		List<Map<String,Object>> resultList=jdbcService.query(SQL, paramMap);
		releaseJdbcService(jdbcService);
		return resultList;
	}

	public List<Object> queryObject(String SQL, Map<String,Object> paramMap,Class<?> c)throws Exception{
		final IJdbcService jdbcService = getJdbcService();
		List<Object> resultList=jdbcService.queryObject(SQL, paramMap, c);
		releaseJdbcService(jdbcService);
		return resultList;
	}

	/**
	 * @deprecated
	 */
	public Connection getCurrentConnection() {
		return null;
	}


}