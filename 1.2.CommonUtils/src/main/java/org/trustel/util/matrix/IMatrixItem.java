package org.trustel.util.matrix;

/**
 * ���й�ʽ��������ݺ�����
 * 
 * @author ��־��
 * 
 */
public interface IMatrixItem {

	/**
	 * ȡˮƽά�ȣ����ĵ�һ�У���ֵ <BR>
	 * ������Ψһֵ
	 * 
	 * @return �����Ƕ���ֶκϲ�����
	 */
	public String getXValue();

	/**
	 * ȡ����ά��(�����б��)��ֵ <BR>
	 * ������Ψһֵ
	 * 
	 * @return ����ά�ȱ�־
	 */
	public String getYValue();

	/**
	 * �Ƿ�����һ���µľ����
	 * 
	 * @param XValue
	 *            ����/ˮƽά������
	 * @return true-�����µľ����false-ͬһ��ά�ȱ�
	 */
	public boolean newMatrix(String XValue);

}
