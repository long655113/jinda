package org.trustel.exception;

public class OverflowException extends RuntimeException {

	private static final long serialVersionUID = -6188886204144079719L;

	public OverflowException() {
		super("����Ҫ��ѯ�������Ѿ������������Ʒ�Χ���������ѯ��������С��ѯ��Χ!");

	}

	public OverflowException(String msg) {
		super(msg);
	}

}
