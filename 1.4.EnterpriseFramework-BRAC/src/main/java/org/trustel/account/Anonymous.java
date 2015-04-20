package org.trustel.account;

/**
 * 匿名用户
 */
public class Anonymous extends OnlineUser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1526768911206885432L;

	/**
	 * 首次登陆
	 */
	private String firstLogon;

	/**
	 * @return 会员等级
	 */
	public int getGrade() {
		return super.getGrade();
	}

	/**
	 * @return 首次登录(firstLogon)
	 */
	public String getFirstLogon() {
		return firstLogon;
	}

	/**
	 * 设置首次(firstLogon)
	 * 
	 * @param firstLogon
	 */
	public void setFirstLogon(String firstLogon) {
		this.firstLogon = firstLogon;
	}

}