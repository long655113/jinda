package com.trustel.algorithm;

import org.hibernate.Session;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 * �����ӿ�
 */
public interface Function {
	/**
	 * �޲����ĺ�������
	 * 
	 * @param session ���ݿ�����
	 * @return
	 * @throws RuntimeException
	 */
	public Double calculate(Session session) throws RuntimeException;
	/**
	 * �������ĺ�������
	 * 
	 * @param session ���ݿ�����
	 * @param args ����
	 * @return
	 * @throws RuntimeException
	 */
	public Double calculate(Session session, String[] args) throws RuntimeException;
}
