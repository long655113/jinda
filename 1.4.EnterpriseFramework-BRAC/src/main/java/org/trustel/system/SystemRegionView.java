package org.trustel.system;

import org.trustel.system.AbstractRegion;

/**
 * 
 * �� ����ϵͳ������Ϣ
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-21
 * 
 * ����Դ��v_system_regions(ϵͳ������Ϣ)
 * 
 * �� ����
 * 
 * 
 **/

public class SystemRegionView extends AbstractRegion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3678490977451024657L;
	
	public String name;
	
	/**
	 * ����Ϣ�ڶ�Ӧ���Ʊ���
	 * 
	 * @deprecated
	 */
	public String getName() {
		return name;
	}

	/**
	 * ����Ϣ�ڶ�Ӧ������������
	 * 
	 * @deprecated
	 */
	public String getDescription() {
		return super.getDescription();
	}

	/**
	 * ����Ϣ�ڶ�Ӧ������������
	 * 
	 * @deprecated
	 */
	public String getLang() {
		return super.getLang();
	}

	/**
	 * ����Ϣ�ڶ�Ӧ������������
	 * 
	 * @deprecated
	 */
	public String getTitle() {
		return super.getTitle();
	}



}
