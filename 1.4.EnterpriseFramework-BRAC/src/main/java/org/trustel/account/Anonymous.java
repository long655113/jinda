package org.trustel.account;

/**
 * �����û�
 */
public class Anonymous extends OnlineUser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1526768911206885432L;

	/**
	 * �״ε�½
	 */
	private String firstLogon;

	/**
	 * @return ��Ա�ȼ�
	 */
	public int getGrade() {
		return super.getGrade();
	}

	/**
	 * @return �״ε�¼(firstLogon)
	 */
	public String getFirstLogon() {
		return firstLogon;
	}

	/**
	 * �����״�(firstLogon)
	 * 
	 * @param firstLogon
	 */
	public void setFirstLogon(String firstLogon) {
		this.firstLogon = firstLogon;
	}

}