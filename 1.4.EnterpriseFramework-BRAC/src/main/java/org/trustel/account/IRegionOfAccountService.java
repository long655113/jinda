package org.trustel.account;

import org.trustel.system.AbstractRegion;

public interface IRegionOfAccountService {

	/**
	 * @param account
	 * @param fieldName
	 *            ҵ������û������֯���ԣ����У��ֶ�����hibernateӳ��������
	 * @param orgid
	 *            ������ģ�ʹ���Ĳ�ѯ�������û�ѡ�еĵ��У�
	 * @return �û�����Ȩ�������� fieldName in (select orgid from ORGANIZATIONS where
	 *         orgid=?)
	 */
	public String getRegionJDBCCondition(CommonAccount account,
			String fieldName, int orgid);

	/**
	 * @param account
	 * @param fieldName
	 *            ҵ������û������֯���ԣ����У�hibernateӳ��������
	 * @param orgid
	 *            ������ģ�ʹ���Ĳ�ѯ�������û�ѡ�еĵ��У�
	 * @return �û�����Ȩ�������� fieldName in (select orgid from ORGANIZATIONS where
	 *         orgid=?)
	 */
	public String getRegionHBMCondition(CommonAccount account,
			String fieldName, int orgid);

	public AbstractRegion hasRegionPrivilege(CommonAccount account, int regionId);
}
