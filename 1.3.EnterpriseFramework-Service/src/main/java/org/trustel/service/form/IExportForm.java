package org.trustel.service.form;

public interface IExportForm {

	/**
	 * 
	 * @return ����N����¼
	 */
	public int getExportSize();

	/**
	 * ��ʹ��PageQueryFormʱ��ǿ��ΪpageSize*pageIndex
	 * 
	 * @return
	 */
	public int getSkipSize();

	/**
	 * ��ҳ��ʹ��
	 * 
	 * @return �Ƿ񵼳�ģʽ������ģʽ�ڼ�������ʱ��Ҫ����skipsize����¼
	 */
	public boolean isExport();

	public void setExp(String export);

	public void setExportSize(int exportSize);
}
