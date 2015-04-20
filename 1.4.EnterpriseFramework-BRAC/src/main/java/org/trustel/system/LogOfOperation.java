package org.trustel.system;

import java.util.Date;

/**
 * 
 * �� ����ϵͳ������־
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-11 13:23
 * 
 * ����Դ��system_operationlogs(ϵͳ������־)
 * 
 * �� ����
 * 
 */

public class LogOfOperation {
	/**
	 * ��������
	 */
	private String description;

	/**
	 * ���ܱ���(Ȩ����) (ӳ��function_code�ֶ�)
	 */
	private String functionCode;

	/**
	 * ����ID
	 */
	private int id = 0;

	/**
	 * ��½ID (ӳ��logon_id�ֶ�)
	 */
	private int logonId = 0;

	/**
	 * ��������:�����ռ��û�ʹ��ϰ�� (ӳ��operation_category�ֶ�)
	 */
	private int operationCategory = 0;

	/**
	 * ����ʱ�� (ӳ��operation_seconds�ֶ�)
	 */
	private Date operationSeconds;

	/**
	 * 
	 * @return ��������(description<--description)
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return ���ܱ���(Ȩ����)(functionCode<--function_code)
	 */
	public String getFunctionCode() {
		return functionCode;
	}

	/**
	 * 
	 * @return ����ID(id<--id)
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return ��½ID(logonId<--logon_id)
	 */
	public int getLogonId() {
		return logonId;
	}

	/**
	 * 
	 * ��ο�SYSTEM_OPERATIONLOG_CATEGORIESϵͳ����
	 * 
	 * @return ��������:�����ռ��û�ʹ��ϰ��(operationCategory<--operation_category)
	 */
	public int getOperationCategory() {
		return operationCategory;
	}

	/**
	 * 
	 * @return ����ʱ��(operationSeconds<--operation_seconds)
	 */
	public Date getOperationSeconds() {
		return operationSeconds;
	}

	/**
	 * ���ò�������
	 * 
	 * @param ��������
	 *            (description-->description)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * ���ù��ܱ���(Ȩ����)
	 * 
	 * @param ���ܱ���
	 *            (Ȩ����)(functionCode-->function_code)
	 */
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	/**
	 * ���ò���ID
	 * 
	 * @param ����ID
	 *            (id-->id)
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ���õ�½ID
	 * 
	 * @param ��½ID
	 *            (logonId-->logon_id)
	 */
	public void setLogonId(int logonId) {
		this.logonId = logonId;
	}

	/**
	 * ���ò�������:�����ռ��û�ʹ��ϰ��
	 * 
	 * @param ��������
	 *            :�����ռ��û�ʹ��ϰ��(operationCategory-->operation_category)
	 */
	public void setOperationCategory(int operationCategory) {
		this.operationCategory = operationCategory;
	}

	/**
	 * ���ò���ʱ��
	 * 
	 * @param ����ʱ��
	 *            (operationSeconds-->operation_seconds)
	 */
	public void setOperationSeconds(Date operationSeconds) {
		this.operationSeconds = operationSeconds;
	}
}
