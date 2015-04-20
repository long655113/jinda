package org.trustel.system.service;

import java.util.List;

import org.trustel.system.Visitor;

public interface ISystemService {
	public List<?> queryRegions(Visitor visitor);

	public List<?> queryControllers(Visitor visitor);

	public List<?> getLanguages(Visitor visitor);

	public List<?> queryRoles(Visitor visitor);

}
