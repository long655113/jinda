package org.trustel.service.form;

import org.trustel.util.ParameterFactory;

public class ExportForm implements IExportForm {

	private int exportSize = 0;

	private int skipSize = 0;

	private String exp;

	public int getExportSize() {
		return exportSize <= 0 ? ParameterFactory.getInt("SYSTEM_EXPORT_ROWS",
				10000) : exportSize;
	}

	/**
	 * ����ʱͨ����Ҫָ��������¼�����絼���ڶ�ҳʱ����Ҫ������һҳ
	 */
	public int getSkipSize() {
		return skipSize;
	}

	/**
	 * Ŀǰ��֧�ֵ���EXCEL��ʽ
	 */
	public boolean isExport() {
		return "EXCEL".equalsIgnoreCase(exp);
	}

	public void setExp(String export) {
		this.exp = export;
	}

	public void setExportSize(int exportSize) {
		this.exportSize = exportSize;
	}

}
