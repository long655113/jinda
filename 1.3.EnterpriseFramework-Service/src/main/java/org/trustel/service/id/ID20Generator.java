package org.trustel.service.id;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * 20位UUID主键生成器
 * 
 * @author kenny
 * 
 */
public class ID20Generator implements IdentifierGenerator {

	public synchronized Serializable generate(SessionImplementor session,
			Object entity) throws HibernateException {
		return getNextSequence((Session) session, entity.getClass()
				.getSimpleName());
	}

	private String getNextSequence(Session session, String name) {
		return SequenceUtils.getNext20Code(session, name);
	}

}
