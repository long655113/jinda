package org.trustel.service.form;

public interface IPageQueryForm extends IExportForm {
	/**
	 * 
	 * @return ��ǰҳ����1��ʼ
	 */
	public int getPageIndex();

	/**
	 * 
	 * @return ��ҳ��С,ȱʡΪ25��ÿҳ
	 */
	public int getPageSize();

	public void setPageIndex(int pageIndex);

	public void setPageSize(int pageSize);
}
