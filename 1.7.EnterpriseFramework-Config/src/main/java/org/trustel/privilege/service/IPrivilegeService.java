package org.trustel.privilege.service;

import java.util.List;

import org.trustel.privilege.SystemMenu;
import org.trustel.system.Visitor;

public interface IPrivilegeService {

	public abstract List<?> query(Visitor visitor);

	public abstract SystemMenu view(Visitor visitor, String code);

	/**
	 * ��ȡ�û�����Ȩ����Ϣ
	 * 
	 * @param visitor
	 * @param grade
	 * @return String[]
	 */
	public String[] queryPrivilegeOfRole(Visitor visitor, String grade);

}