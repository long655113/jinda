package org.trustel.queryframe.common;

public class ButtonAddAdd implements IButtonAdd {

	@Override
	public String getHtmlStr() {
		String htmlStr = "<input class='btn09' type='button' name='button' id='button'"
				+ "style='margin-right: 20px' value='�� ��'"
				+ "onclick='javascript:toAdd();' />"
				+ "<input class='btn09' type='button' name='button' id='button'"
				+ "value='ɾ ��' onclick='javascript:todetele();' />";
		return htmlStr;
	}

}
