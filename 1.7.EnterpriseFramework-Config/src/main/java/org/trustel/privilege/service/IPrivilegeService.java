package org.trustel.privilege.service;

import java.util.List;

import org.trustel.privilege.SystemMenu;
import org.trustel.system.Visitor;

public interface IPrivilegeService {

	public abstract List<?> query(Visitor visitor);

	public abstract SystemMenu view(Visitor visitor, String code);

	/**
	 * 获取用户控制权限信息
	 * 
	 * @param visitor
	 * @param grade
	 * @return String[]
	 */
	public String[] queryPrivilegeOfRole(Visitor visitor, String grade);

}