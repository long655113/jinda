package org.trustel.queryframe.common;

public class ButtonAddAdd implements IButtonAdd {

	@Override
	public String getHtmlStr() {
		String htmlStr = "<input class='btn09' type='button' name='button' id='button'"
				+ "style='margin-right: 20px' value='ÐÂ Ôö'"
				+ "onclick='javascript:toAdd();' />"
				+ "<input class='btn09' type='button' name='button' id='button'"
				+ "value='É¾ ³ý' onclick='javascript:todetele();' />";
		return htmlStr;
	}

}
