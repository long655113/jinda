package org.trustel.system.service;

import java.util.List;

import org.trustel.system.Visitor;

/**
 * @Description: ��̨��ҳ�˵���ѯ
 * @author  guof
 * @date    2013-9-25 ����03:24:44
 * @version V1.0
 */
public interface IPortalMenuService {
	
	/**
	 * @Description: ��ѯ�˵�
	 * @param visitor
	 * @return
	 */
	public List<?> queryMenu(Visitor visitor);
	
	/**
	 * @Description: ����ʹ��
	 * @param visitor
	 * @param label
	 * @return
	 */
	public List<?>queryMenu(Visitor visitor,String label);

}
