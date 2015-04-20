/**
 * 
 */
package org.trustel.account;

import java.io.Serializable;
import java.util.Date;

import org.trustel.common.Utils;
import org.trustel.system.AbstractRegion;

/**
 * @author yangyw
 *
 */
/**
 * ������com.trustel.l3x.system.Visitor ���ԣ������л� ���ڣ�2006-05-31 19:30 ��ƣ���־��
 * ���ܣ����浱ǰ�û�(session)��Ϣ,�����û�Ȩ�ޣ����һ��������ʾ
 */
public class OnlineVisitor implements Serializable {

	private static final long serialVersionUID = -7124624921649774935L;
	

	// ���浱ǰ�û���½��Ϣ
	public OnlineUser account = null;

	// ��ǰ�û���Ȩ���б�

	public String IP;

	public boolean logined = false;

	public String loginId;

	public String loginTime = Utils.format(new Date(), "yyyy-MM-dd HH:mm:ss","GMT+8");

	public String url;
	
	public String cookie;
	
	public String language = "zh_CN";
	
	public String isMark = "false";/**�Ƿ���ͬ����¼*/
	
	public String key;/**Զ�̵���˽Կ*/

	public int filter(int regionId) {
		AbstractRegion region = account._hasRegionPrivilege(regionId);
		if (region == null)
			return -1;
		else
			return region.getId();
	}

	public String getRegionJDBCCondition(String fieldName, int regionId) {
		return account._getRegionJDBCCondition(fieldName, regionId);
	}

	public String getRegionHBMCondition(String fieldName, int regionId) {
		return account._getRegionHBMCondition(fieldName, regionId);
	}

	public String getRegionCondition(String fieldName, int regionId,
			boolean jdbc) {
		if (jdbc)
			return getRegionJDBCCondition(fieldName, regionId);
		else
			return getRegionHBMCondition(fieldName, regionId);
	}

	public boolean isLogined() {
		return logined;
	}

	public OnlineUser getAccount() {
		return account;
	}

	public void setAccount(OnlineUser account) {
		this.account = account;
	}

	public String getIsMark() {
		return isMark;
	}

	public void setIsMark(String isMark) {
		this.isMark = isMark;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
