/*
 * Created on Aug 12, 2005
 *
 * 
 */
package com.trustel.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 * 
 *         һҳ����
 */
public class ItemPage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7387958776520019636L;

	/**
	 * ��������
	 */
	private List<?> items;

	/**
	 * ��������
	 */
	private long total;

	/**
	 * ҳ��
	 */
	private int pageIndex;
	private int pageSize;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * ��ҳ��
	 */
	private long pageCount;

	private ItemPage() {
	}

	public ItemPage(List<?> items, long totals, int pageNo, int pageSize) {
		this.items = items;
		this.total = totals;
		this.pageIndex = pageNo;
		this.pageCount = (total - 1) / pageSize + 1;
		this.pageSize = pageSize;
	}

	public List<?> getItems() {
		return items;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public long getPageCount() {
		return pageCount;
	}

	public long getTotal() {
		return total;
	}

	public void setItems(List<?> items) {
		this.items = items;
	}

	public void setPageIndex(int pageNo) {
		this.pageIndex = pageNo;
	}

	public void setPageCount(long pages) {
		this.pageCount = pages;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
