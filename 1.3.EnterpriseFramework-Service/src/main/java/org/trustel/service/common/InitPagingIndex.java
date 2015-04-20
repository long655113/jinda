package org.trustel.service.common;

import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class InitPagingIndex {

	protected static final Log logger = LogFactory.getLog(InitPagingIndex.class);
	
	public static String DBTYPE_ORACLE="oracle";
	
	public static String DBTYPE_MYSQL="mysql";
	
	public static String DBTYPE_SQLSERVER="sqlserver";
	
	/**
	 * 用于分页初始化第一条记录和最后一条记录的索引位置
	 * 
	 * @param SQL sql语句
	 * @param paramMap sql参数
	 * @param skipPage 第几页
	 * @param pageSize 每页几条记录
	 */
	public static String generatePagingSql(String dbtype,String sql,Map<String ,Object> paramMap,int skipPage,int pageSize){
		//sql=sql.toUpperCase();
		String sqlPage="";
		if (dbtype.equalsIgnoreCase(DBTYPE_ORACLE)) {
			sqlPage = "SELECT * FROM (SELECT A.*,ROWNUM ROWNUM_ FROM (";
			sqlPage += sql;
			if (skipPage > 0 && pageSize > 0) {
				int sindex = 1 + (skipPage - 1) * pageSize;
				int eindex = 1 + skipPage * pageSize;
				logger.debug("start:" + sindex + "  end:" + eindex);
				paramMap.put("SINDEX", sindex);
				paramMap.put("EINDEX", eindex);
			}
			sqlPage += ") A WHERE ROWNUM<#EINDEX#) WHERE ROWNUM_>=#SINDEX#";
		}else if(dbtype.equalsIgnoreCase(DBTYPE_MYSQL)){
			int skip=(skipPage-1)*pageSize;
			int page=pageSize;
			paramMap.put("SKIP", skip);
			paramMap.put("PAGE", page);
			sqlPage=sqlPage+"SELECT * FROM ("+sql+") A LIMIT #SKIP#,#PAGE#";
		}
		return sqlPage;
	}
	
	
	/**
	 * 用于生成统计记录sql
	 * 
	 * @param SQL sql语句
	 */
	public static String generateStatisRecordSql(String sql){
		//sql=sql.toUpperCase();
		sql="SELECT COUNT(*) TOTAL FROM ("+sql+") A";
		return sql;
	}
}
