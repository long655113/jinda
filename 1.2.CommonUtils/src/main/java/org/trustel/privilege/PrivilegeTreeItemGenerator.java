package org.trustel.privilege;

import org.trustel.common.ITreeItem;
import org.trustel.common.ITreeItemGenerator;

public class PrivilegeTreeItemGenerator implements ITreeItemGenerator {

	private String[] arrSelected;

	public PrivilegeTreeItemGenerator(String[] arrSelected) {
		this.arrSelected = arrSelected;
	}

	public String afterOutItem(ITreeItem item, int level, int index,
			int siblingCount, int childCount) {
//		return (level == 0) ? "</table></td></tr>\n" : "";
		return "";
	}
	
	public String execute(ITreeItem item, int level, int index,
			int siblingCount, int childCount) {
		String tmp = "<input type=checkbox id='"+item.getCode()+"'"+"  name=chk value='" + item.getCode()
				+ "'";
		if (arrSelected != null)
			for (int i = 0; i < arrSelected.length; i++) {
				if (arrSelected[i].equals(item.getCode())) {
					tmp = tmp + " checked";
					break;
				}
			}
		tmp = tmp + ">";
		StringBuffer buf = new StringBuffer(String.format(
				"<tr><td style='padding-left:%spx'>",
				new Object[] { level * 24 }));
		buf.append(tmp);
		buf.append(String.format("<span href='view?code=%s'>%s</span>", new Object[] {
				item.getCode(), item.getTitle() }));
		buf.append("</td></tr>");

		return buf.toString();
	}

}
