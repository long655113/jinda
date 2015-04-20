package org.trustel.util;

import java.util.ArrayList;
import java.util.List;

import org.trustel.util.matrix.IMatrixItem;
import org.trustel.util.matrix.IMatrixTransform;


/**
 * ����������������ֶκ�ԭʼ���ݾ���ͬ����ľ����� ��֧��һά�����������
 * 
 * @author ��־��
 * 
 */
public class MatrixUtils {
	protected StringBuffer buf = new StringBuffer("");

	private boolean clearAfterOutRow = true;

	public int rowCount = 0;

	protected List<IMatrixItem> table = new ArrayList<IMatrixItem>();

	private IMatrixItem getCell(String x, String y, IMatrixTransform transform) {
		// ���ѭ��list.size()��
		IMatrixItem ret = null;
		for (int i = table.size() - 1; i >= 0; i--) {
			IMatrixItem item = table.get(i);
			if (item.getXValue().equalsIgnoreCase(x)
					&& item.getYValue().equalsIgnoreCase(y)) {
				ret = item;
			}
		}
		table.remove(ret);
		return ret;
	}

	private void getRows(String y, String[] titles,
			IMatrixTransform transform, int rowIndex) {

		buf.append(transform.doStartRow(rowIndex));
		buf.append(transform.getRowTitle(y, rowIndex, 0));
		for (int i = 0; i < titles.length; i++) {

			IMatrixItem item = getCell(titles[i], y, transform);
			buf.append(transform.getMatrixCell(item, rowIndex, i + 1));
		}
		buf.append(transform.getAfterMaxtrixLastCell(null, rowIndex,
				titles.length + 1));
		buf.append(transform.doFinishRow(rowIndex));
		if (clearAfterOutRow) {
			boolean find = false;
			for (int i = table.size() - 1; i >= 0; i--) {
				IMatrixItem item = table.get(i);
				if (item.getYValue().equalsIgnoreCase(y)) {
					table.remove(item);
					find = true;
				} else if (find) // �����ͬ�к��ҵ���һ�����б�Ǽ���Ϊ�����Ѿ�������ϡ������������ٶ�
					break;
			}
		}

	}

	/**
	 * ��ָ������ת�����ض����ݾ���,�������Ϣ���Զ������ͬ��ǵ�����
	 * 
	 * @param data
	 *            �����б� ���밴һ����������
	 * @param titleValues
	 *            �����еı��� ���밴��ʾ��˳������
	 * @param transform
	 *            ����ת������
	 * @return ת���������
	 */
	public String matrix(List<?> data, String[] titleValues,
			IMatrixTransform transform) {
		return matrix(data, titleValues, transform, false);
	}

	/**
	 * ��ָ������ת�����ض����ݾ���
	 * 
	 * @param data
	 *            �����б� ���밴һ����������
	 * @param titleValues
	 *            �����еı��� ���밴��ʾ��˳������
	 * @param transform
	 *            ����ת������
	 * @param clearAfterOutRow
	 *            ����������ݰ��б�������ͬ������ݣ���ֹ����ͬ��ǵ�����Ҫ������У�
	 * @return ת���������
	 */

	public String matrix(List<?> data, String[] titleValues,
			IMatrixTransform transform, boolean clearAfterOutRow) {
		this.clearAfterOutRow = clearAfterOutRow;
		if (data == null || data.size() < 1 || titleValues == null
				|| titleValues.length < 1 || transform == null)
			return "";

		for (int i = data.size() - 1; i >= 0; i--) {
			table.add(transform.transform(data.get(i)));
		}

		String lastY = null;
		int row = 0, i = table.size() - 1;
		// ���ѭ��table.size��
		while (table.size() > 0 && (i >= 0)) {
			IMatrixItem item = table.get(i);
			i--;
			String y = item.getYValue();
			// ��ͬһ�в���Ҫ���⴦��
			if (!y.equals(lastY)) // // ���µ�һ��
			{
				row++;
				getRows(y, titleValues, transform, row);
				if (!clearAfterOutRow)
					table.remove(item);
				i = table.size() - 1;
				lastY = y;
			}

		}
		rowCount = row;
		return buf.toString();
	}

}