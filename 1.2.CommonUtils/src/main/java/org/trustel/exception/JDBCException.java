package org.trustel.exception;

public class JDBCException extends RuntimeException {

	private static final long serialVersionUID = 941901160150244180L;

	/**
	 * ���ش�����Ϣ
	 */
	public String toString() {
		return getCause().getClass().getCanonicalName() + ":" + getMessage();
	}
}
