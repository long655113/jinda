package org.trustel.common;

import org.trustel.common.ITreeItem;

public interface ITreeItemGenerator {

	public String afterOutItem(ITreeItem item, int level, int index,
			int siblingCount, int childCount);

	/**
	 * ��ΪTreeUtils����������������Զ��������Ϣ��չʾ��ʽ
	 * 
	 * @param item
	 * @param level
	 * @param index
	 * @param siblingCount
	 * @param childCount
	 * @return
	 */
	public String execute(ITreeItem item, int level, int index,
			int siblingCount, int childCount);

}
