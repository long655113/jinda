package org.trustel.system.service;

import java.util.List;

import org.trustel.system.Visitor;

/**
 * @Description: 后台首页菜单查询
 * @author  guof
 * @date    2013-9-25 下午03:24:44
 * @version V1.0
 */
public interface IPortalMenuService {
	
	/**
	 * @Description: 查询菜单
	 * @param visitor
	 * @return
	 */
	public List<?> queryMenu(Visitor visitor);
	
	/**
	 * @Description: 暂无使用
	 * @param visitor
	 * @param label
	 * @return
	 */
	public List<?>queryMenu(Visitor visitor,String label);

}
