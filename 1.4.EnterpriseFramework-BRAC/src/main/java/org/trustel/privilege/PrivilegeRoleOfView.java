package org.trustel.privilege;

/**
 * 
 * �� ������ɫȨ����Ϣ
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-21
 * 
 * ����Դ��v_system_roleprivileges(��ɫȨ����Ϣ)
 * 
 * �� ����
 * 
 **/

public class PrivilegeRoleOfView {
	/**
	 * Ȩ�ޱ���
	 */
	private String id;
	/**
	 * ��ɫ״̬ (ӳ��flag�ֶ�)
	 */
	private String flag;
	/**
	 * Ȩ�ޱ��� (ӳ��privilege_code�ֶ�)
	 */
	private String privilegeCode;

	/**
	 * 
	 * @return Ȩ�ޱ���(id<--id)
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @return ��ɫ����(flag<--flag)
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 
	 * @return Ȩ�ޱ���(privilegeCode<--privilege_code)
	 */
	public String getPrivilegeCode() {
		return privilegeCode;
	}

	/**
	 *����Ȩ�ޱ���
	 * 
	 * @param Ȩ�ޱ���
	 *            (id-->id)
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 *���ý�ɫ����
	 * 
	 * @param ��ɫ����
	 *            (flag-->flag)
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 *����Ȩ�ޱ���
	 * 
	 * @param Ȩ�ޱ���
	 *            (privilegeCode-->privilege_code)
	 */
	public void setPrivilegeCode(String privilegeCode) {
		this.privilegeCode = privilegeCode;
	}
}
