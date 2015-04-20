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
	 * ÇøºÅ
	 */
	private String postcode;
	/**
	 * ÏÔÊ¾ÐòºÅ
	 */
	private int seq = 0;

	/**
	 * 
	 * @return ÇøºÅ(postcode<--postcode)
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * 
	 * @return ÏÔÊ¾ÐòºÅ(seq<--seq)
	 */
	public int getSeq() {
		return seq;
	}

	/**
	 *ÉèÖÃÇøºÅ
	 * 
	 * @param ÇøºÅ
	 *            (postcode-->postcode)
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 *ÉèÖÃÏÔÊ¾ÐòºÅ
	 * 
	 * @param ÏÔÊ¾ÐòºÅ
	 *            (seq-->seq)
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}

}
