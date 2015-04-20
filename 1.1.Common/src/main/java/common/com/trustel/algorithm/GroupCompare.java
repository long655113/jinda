package com.trustel.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Administrator �Ƚ��������֮�������
 *         <p>
 *         ��������������������һ��
 */
public class GroupCompare {
	private ObjectComparator comparator;

	private List result;

	private GroupCompare() {

	}

	public GroupCompare(ObjectComparator comparator) {
		this.comparator = comparator;
		result = new ArrayList();
	}

	/**
	 * ������ñȽϺ���
	 * 
	 * @param items
	 *            ��������
	 * @param key
	 *            ���������
	 * @return
	 */
	public List compare(Iterator items, Object baseline, Object define) {
		if (items.hasNext())
			compare(items.next(), items, baseline, define);

		return result;
	}

	/**
	 * �ȽϺ���
	 * 
	 * @param source
	 *            ������ȡ���Ķ���
	 * @param items
	 *            ����
	 * @param baseline
	 *            ��׼��־
	 * @param define
	 *            ��������
	 * @param result
	 *            �����
	 */
	public void compare(Object source, Iterator items, Object baseline,
			Object define) {
		if (items.hasNext()) {
			Object compare = items.next();

			if (comparator.isKeyEqual(source, compare, define)) {
				if (comparator.fromSameGroup(source, compare)) {
					comparator.toDuplicate(result, source, compare, define);

					compare(compare, items, baseline, define);
				} else {
					if (!comparator.isEqual(source, compare, define))
						comparator.toDifference(result, source, compare,
								baseline, define);

					if (items.hasNext())
						compare(items.next(), items, baseline, define);
				}
			} else {
				comparator.toExtra(result, source, baseline, define);

				compare(compare, items, baseline, define);
			}
		} else
			comparator.toExtra(result, source, baseline, define);
	}
}
