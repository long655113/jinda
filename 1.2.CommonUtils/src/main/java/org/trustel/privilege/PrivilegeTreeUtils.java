package org.trustel.privilege;

import java.util.List;

import org.trustel.util.TableTreeUtils;


public class PrivilegeTreeUtils extends TableTreeUtils {

	public PrivilegeTreeUtils(List<?> list, String[] arrSelected) {
		super(list, new PrivilegeTreeItemGenerator(arrSelected));
	}
	// private JspWriter out;
	//
	// private List<ITreeItem> privileges;
	//
	// private String[] selected;
	//
	// public PrivilegeTreeUtils(JspWriter out, List<ITreeItem> privileges) {
	// this.out = out;
	// this.privileges = privileges;
	//
	// }
	//
	// public PrivilegeTreeUtils(JspWriter out, List<ITreeItem> privileges,
	// String[] selected) {
	// this.selected = selected;
	// this.privileges = privileges;
	// this.out = out;
	// }
	//
	// private String getBlank(int level) {
	// StringBuffer s = new StringBuffer("");
	// for (int i = 0; i < level; i++)
	// s.append("¡¡");
	// return s.toString();
	//
	// }
	//
	// private String getCheckBox(String code) {
	// String tmp = "<input type=checkbox name=chk value='" + code + "'";
	// if (selected != null)
	// for (int i = 0; i < selected.length; i++) {
	// if (selected[i].equals(code)) {
	// tmp = tmp + " checked";
	// break;
	// }
	// }
	//
	// return tmp + ">";
	//
	// }
	//
	// private String getIdent(int level) {
	//
	// return " style='padding-left:" + String.valueOf(level * 24) + "px;'";
	// }
	//
	// private boolean isTop(ITreeItem channel) {
	// for (int i = privileges.size() - 1; i >= 0; i--) {
	// ITreeItem ch = privileges.get(i);
	// if (channel.getUcode().equals(ch.getCode()))
	// return false;
	// }
	// return true;
	// }
	//
	// public void optionTree(String current) throws IOException {
	// for (int i = 0; i < privileges.size(); i++)
	// // while(i>=0)
	// {
	// ITreeItem ch = privileges.get(i);
	// if (isTop(ch)) {
	// outOption(ch.getCode(), ch.getTitle(), current);
	// optionTree(current, ch.getCode(), 1);
	// }
	//
	// }
	// }
	//
	// private void optionTree(String current, String ucode, int level)
	// throws IOException {
	// level++;
	// for (int i = 0; i < privileges.size(); i++) {
	// ITreeItem ch = privileges.get(i);
	// if (ch.getUcode().equalsIgnoreCase(ucode)) {
	//
	// outOption(ch.getCode(), getBlank(level) + ch.getTitle(),
	// current);
	// optionTree(current, ch.getCode(), level);
	// }
	// }
	// }
	//
	// private void outOption(String value, String title, String current)
	// throws IOException {
	// if (current.equalsIgnoreCase(value))
	// value = " value='" + value + "' selected>";
	// else
	// value = " value='" + value + "'>";
	// out.println("<option" + value + title + "</option>");
	// }
	//
	// public void tree() throws IOException {
	// // out.println("<table border='1' cellspacing='0' cellpadding='0'>");
	// // int i=channels.size()-1;
	// if (privileges != null)
	// for (int i = 0; i < privileges.size(); i++) {
	// ITreeItem item = (ITreeItem) privileges.get(i);
	// if (isTop(item)) {
	// out.println("<tr align='left' valign='middle'>");
	// out.println("<td class='table_cell'" + getIdent(1) + ">"
	// + getCheckBox(item.getCode()) + "¡ô"
	// + item.getTitle() + "</td></tr>");
	// tree(item.getCode(), 2);
	// }
	//
	// }
	//
	// }
	//
	// private void tree(String ucode, int level) throws IOException {
	// level++;
	// for (int i = 0; i < privileges.size(); i++) {
	// ITreeItem ch = privileges.get(i);
	// if (ch.getUcode().equalsIgnoreCase(ucode)) {
	//
	// out.println("<tr>");
	// out.println("<td class='table_cell'" + getIdent(level) + ">"
	// + getCheckBox(ch.getCode()) + "¡ó" + ch.getTitle()
	// + "</td>");
	// out.println("</tr>");
	// tree(ch.getCode(), level);
	// }
	// }
	// }

}
