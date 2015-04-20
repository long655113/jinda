package org.trustel.common;

/**
 * 
 * �� ����Ŀ¼��
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-04
 * 
 * ����Դ��
 * 
 * �� ����
 * 
 */

public class DefaultTreeItem extends DefaultListItem implements ITreeItem {

	private String ucode;

	public int childrenCount = 0;

	public DefaultTreeItem(String code, String title, String ucode) {
		super(code, title);
		this.ucode = ucode;
	}

	public DefaultTreeItem(String code, String title, String ucode,
			int childrenCount) {
		super(code, title);
		this.ucode = ucode;
		this.childrenCount = childrenCount;
	}

	public String getUcode() {
		return ucode;
	}

	public int getChildrenCount() {
		return childrenCount;
	}

}
