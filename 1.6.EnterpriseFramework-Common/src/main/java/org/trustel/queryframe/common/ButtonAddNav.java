package org.trustel.queryframe.common;


public class ButtonAddNav implements IButtonAdd {

	@Override
	public String getHtmlStr() {
		String htmlStr = "<input class='btn09' type='button' name='button' id='button'"
				+ "style='margin-right: 20px' value='新 增'"
				+ "onclick='javascript:toAdd();' />"
				+ "<input class='btn09' type='button' name='button' id='button'"
				+ "value='删 除' style='margin-right: 20px' onclick='javascript:todetele();' /><br/><br/>";
			htmlStr+= "<input class='btn09' type='button' name='button' id='nav'"
				+ " value='自定义商家导航' onclick='javascript:toChange(1);' />"
				+ "<input class='btn09' type='button' name='button' id='lgo'"
				+ " value='商家logo' style='display:none;' onclick='javascript:toChange(2);' />";
		
		return htmlStr;
	}

}
