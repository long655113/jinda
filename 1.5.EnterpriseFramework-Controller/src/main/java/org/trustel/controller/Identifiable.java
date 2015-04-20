package org.trustel.controller;

public interface Identifiable {
	/**
	 * 验证和使用本功能的权限编码,建议使用类名或有意义的名字
	 * 
	 * @return 返回本功能本功能的权限编码，通常对应system_contollers中的code字段值
	 */
	public String getPrivilegeCode();
}
