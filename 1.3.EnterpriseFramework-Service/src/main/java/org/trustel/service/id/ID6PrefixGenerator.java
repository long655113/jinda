package org.trustel.service.id;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ID6PrefixGenerator implements IdentifierGenerator {

	/**
	 * ID补位长度
	 */
	private int fixLength = 5;
	
	/**
	 * ID前缀
	 */
	private String prefix;  	
	
	
	public synchronized Serializable generate(SessionImplementor session,
			Object entity) throws HibernateException {
		return getNextSequence((Session) session, entity.getClass()
				.getSimpleName());
	}
	
	private String getNextSequence(Session session, String name) {
		return getPrefix(name) + SequenceUtils.getNextCode(session, name, fixLength).toUpperCase();
	}
	
	private String getPrefix(String name){
		if(prefix==null){
			prefix = name.substring(0, 1).toUpperCase();
		}
		return prefix;
	}

}
