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
 * ����Դ��system_role_privileges(��ɫȨ����Ϣ)
 * 
 * �� ����
 * 
 **/

public class PrivilegeOfRole {
	/**
	 * Ȩ�ޱ���
	 */
	private String code;
	/**
	 * ��ɫ���� (ӳ��role_code�ֶ�)
	 */
	private String roleCode;
	/**
	 * Ȩ�ޱ��� (ӳ��privilege_code�ֶ�)
	 */
	private String privilegeCode;

	/**
	 * 
	 * @return Ȩ�ޱ���(code<--code)
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return ��ɫ����(roleCode<--role_code)
	 */
	public String getRoleCode() {
		return roleCode;
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
	 *            (code-->code)
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 *���ý�ɫ����
	 * 
	 * @param ��ɫ����
	 *            (roleCode-->role_code)
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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
