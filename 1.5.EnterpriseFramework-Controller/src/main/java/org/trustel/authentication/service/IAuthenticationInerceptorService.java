package org.trustel.authentication.service;

import org.trustel.system.Visitor;

public interface IAuthenticationInerceptorService {
	
	public boolean accessible(Visitor visitor, String privilegeCode);
}
