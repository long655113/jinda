package org.trustel.service.form;

public interface IQueryForm extends IExportForm {

	/**
	 * 
	 * @return ҳ�������Ϊ
	 */
	public String getAction();

	/**
	 * 
	 * @return ��Ҫ����������ֶ�
	 */
	public String[] getChk();

	public void setAction(String action);

	public void setChk(String[] chk);
}
