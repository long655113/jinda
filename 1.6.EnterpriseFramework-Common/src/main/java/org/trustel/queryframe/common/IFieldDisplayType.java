package org.trustel.queryframe.common;

import java.util.Map;
/**
 * 用于查询框架的接口
 * @author joll
 *
 */
public interface IFieldDisplayType {

	/**
	 * 给指定的查询字段生成查询页面中的input样式
	 * @param resultMap指定字段的记录
	 * @return
	 */
	public String getHtmlStr(Map<String,Object> resultMap);
}
