package org.trustel.privilege.service;

import java.util.List;

import org.trustel.privilege.SystemRole;
import org.trustel.system.Visitor;

public interface IRoleService {

	public List<?> queryRoles(Visitor visitor);

	public SystemRole getRoleById(Visitor visitor, String id);

	public List<?> getRoleDescription(Visitor visitor, String roleId);

	public void save(Visitor visitor, SystemRole role);

}
