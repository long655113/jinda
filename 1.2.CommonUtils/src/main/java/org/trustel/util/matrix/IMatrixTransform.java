package org.trustel.util.matrix;

/**
 * ��ʹ��û�м̳в�ʵ��IMatrixItem�ӿڵ����ݼ����ɾ���ʱʹ�ñ��ӿڽ�������ת��
 * 
 * @author ��־��
 * 
 */
public interface IMatrixTransform {
	/**
	 * �������������ת���ɷ��Ͼ����׼�����ݶ���
	 * 
	 * һ�㽨��ת����MatrixItem,���������ʱ��ֱ��ʹ��ԭʼ���ݽ������
	 * 
	 * @return IMatrixItem
	 */
	public IMatrixItem transform(Object data);

	/**
	 * ��Ԫ�����ݺ������ʽ�͸�������
	 * 
	 * @param item
	 *            ������Ŀ
	 * @param rowIndex
	 *            �У���0��ʼ����
	 * @param colIndex
	 *            �У���0��ʼ����
	 * @return ��ʽ������
	 */
	public String getMatrixCell(IMatrixItem item, int rowIndex, int colIndex);

	/**
	 * ˮƽ���ⵥԪ�����ݺ������ʽ�͸�������
	 * 
	 * @param item
	 *            ������Ŀ
	 * @param rowIndex
	 *            �У���0��ʼ����
	 * @param colIndex
	 *            �У���0��ʼ����
	 * @return ��ʽ������
	 */
	public String getRowTitle(String hFlag, int rowIndex, int colIndex);

	/**
	 * ���һ�����ݵ�Ԫ�������ĺ�������,һ�㣬����������һ�����ַ�������
	 * 
	 * @param item
	 *            ������Ŀ
	 * @param rowIndex
	 *            �У���0��ʼ����
	 * @param colIndex
	 *            �У���0��ʼ����
	 * @return ��ʽ������
	 */
	public String getAfterMaxtrixLastCell(IMatrixItem item, int rowIndex,
			int colIndex);

	/**
	 * 
	 * @param rowIndex
	 * @return �������ǰ�������
	 */
	public String doStartRow(int rowIndex);

	/**
	 * 
	 * @param rowIndex
	 * @return ������к��������
	 */
	public String doFinishRow(int rowIndex);
}
