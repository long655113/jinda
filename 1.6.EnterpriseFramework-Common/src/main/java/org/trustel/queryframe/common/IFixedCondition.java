package org.trustel.queryframe.common;
/**
 * 用于查询框架的接口
 * @author joll
 *
 */
public interface IFixedCondition {
	
	/**
	 * 生成固定查询条件用于查询框架
	 * @param id为指定视图记录
	 * @return 部分SQL条件
	 */
	public String generateFixCondition();

}
