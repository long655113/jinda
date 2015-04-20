package org.trustel.system;

import java.io.Serializable;

import org.trustel.common.DefaultIntHierarchy;
import org.trustel.common.IIntHierarchy;
import org.trustel.common.ITreeItem;


public abstract class AbstractRegion extends DefaultIntHierarchy implements
		ITreeItem, IIntHierarchy, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2166231382959291390L;
	/**
	 * ����
	 */
	private String postcode;
	/**
	 * ��ʾ���
	 */
	private int seq = 0;

	/**
	 * 
	 * @return ����(postcode<--postcode)
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * 
	 * @return ��ʾ���(seq<--seq)
	 */
	public int getSeq() {
		return seq;
	}

	/**
	 *��������
	 * 
	 * @param ����
	 *            (postcode-->postcode)
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 *������ʾ���
	 * 
	 * @param ��ʾ���
	 *            (seq-->seq)
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}

}
