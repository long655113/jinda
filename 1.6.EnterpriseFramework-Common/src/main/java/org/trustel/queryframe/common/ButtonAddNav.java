package org.trustel.queryframe.common;


public class ButtonAddNav implements IButtonAdd {

	@Override
	public String getHtmlStr() {
		String htmlStr = "<input class='btn09' type='button' name='button' id='button'"
				+ "style='margin-right: 20px' value='�� ��'"
				+ "onclick='javascript:toAdd();' />"
				+ "<input class='btn09' type='button' name='button' id='button'"
				+ "value='ɾ ��' style='margin-right: 20px' onclick='javascript:todetele();' /><br/><br/>";
			htmlStr+= "<input class='btn09' type='button' name='button' id='nav'"
				+ " value='�Զ����̼ҵ���' onclick='javascript:toChange(1);' />"
				+ "<input class='btn09' type='button' name='button' id='lgo'"
				+ " value='�̼�logo' style='display:none;' onclick='javascript:toChange(2);' />";
		
		return htmlStr;
	}

}
