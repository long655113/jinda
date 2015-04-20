package org.trustel.account;

import org.trustel.privilege.Role;

public interface IRoleService {

	/**
	 * �����û��ʺŵĽ�ɫ��Ϣ����û�Ȩ������
	 * 
	 * @param roleOfUser
	 * @param fieldName
	 *            ��
	 * @return��fieldName in (select ..from role where)
	 */
	public String getRoleCondition(Role roleOfUser, String fieldName);

	/**
	 * �����ʺŵĽ�ɫ��Ϣ��ȡ���ʺſ�������ɫ��Ȩ������
	 * 
	 * @param account
	 * @return rankN =?
	 */
	public String getRoleListCondition(Role role);

}
