package com.trustel.id;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.trustel.common.SerialNo;

/*
 * �������� 2005-6-5
 *
 * �����������ļ�ģ��Ϊ
 * ���� > ��ѡ�� > Java > �������� > �����ע��
 */

/**
 * @author Administrator
 *
 * UNID������(���ݵ�ǰʱ��)
 */
public class UnIdGeneratorByDate implements IdentifierGenerator {

	/* ���� Javadoc��
	 * @see org.hibernate.id.IdentifierGenerator#generate(org.hibernate.engine.SessionImplementor, java.lang.Object)
	 */
	public Serializable generate(SessionImplementor arg0, Object arg1)
		throws HibernateException {

		return SerialNo.getUNID();
	}

}
