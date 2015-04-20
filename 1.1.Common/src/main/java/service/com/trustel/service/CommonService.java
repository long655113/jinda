package com.trustel.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.trustel.common.ItemPage;

/**
 * @author Administrator
 *
 */
public interface CommonService {
	/**
	 * ɾ������
	 * 
	 * @param classType
	 * @param id
	 */
	public void delete(Class classType, String id);
    /**
     * ɾ������
     * 
     * @param classType
     * @param ids
     */
    public void delete(Class classType, java.util.List ids);
    /**
     * ɾ������
     * 
     * @param classType
     * @param ids
     */
    public void delete(Class classType, Object[] ids);
    /**
     * ��������/ɾ��
     * 
     * @param hql SQL���
     * @return
     */
    public int execute(String hql);
    /**
     * ��������/ɾ��
     * 
     * @param query SQL���
     * @param args ����
     * @return
     */
    public int execute(String query, Object[] args);
    /**
     * ȡ���ж���
     * 
     * @param classType ����
     * @param orderBys �����ֶ�
     * @return
     */
    public java.util.List getAll(Class classType, String orderBys);
    /**
     * ��ҳȡ���ж���
     * 
     * @param classType ����
     * @param orderBys �����ֶ�
     * @param pageNo ҳ��
     * @param pageSize ����
     * @return
     */
    public com.trustel.common.ItemPage getAll(Class classType, String orderBys, int pageNo, int pageSize);
    /**
     * ����IDȡ����
     * 
     * @param classType ������
     * @param id
     * @return
     */
    public Object getById(Class classType, Serializable id);
    
    /**
     * ��������ȡ����
     * 
     * @param classType ����
     * @param formula ������ʽ
     * @param orderBys ����
     * @return
     */
    public List getByCondition(Class classType, Formula formula, String orderBys) throws RuntimeException;
    
    /**
     * ��������ȡһҳ����
     * 
     * @param classType ����
     * @param formula ������ʽ
     * @param orderBys ����
     * @param pageNo ҳ��
     * @param pageSize ����
     * @return
     */
    public ItemPage getByCondition(Class classType, Formula formula, String orderBys, int pageNo, int pageSize) throws RuntimeException;
    
    /**
     * �������
     * 
     * @param item 
     * @return ��¼����
     */
    public Serializable save(Object item);
    /**
     * ������󼯺�
     * 
     * @param items
     */
    public void saveAll(java.util.List items);
    /**
     * ������󼯺�
     * 
     * @param items
     */
    public void saveAll(Object[] items);
    /**
     * �޸Ķ���
     * 
     * @param item
     */
    public void update(Object item);
    
    /**
     * �޸Ķ��󼯺�
     * 
     * @param items
     */
    public void updateAll(java.util.List items);
    
    /**
     * �޸Ķ��󼯺�
     * 
     * @param items
     */
    public void updateAll(Object[] items);
	/**
	 * ȡ��¼����
	 * 
	 * @param hql
	 *            ��ѯ���
	 * @return
	 */
	public long getCount(String hql) throws RuntimeException;    
	/**
	 * ȡ��¼����
	 * 
	 * @param output
	 *            ��ѯ��������磺"select count(*) from Object"
	 * @param conditions
	 *            ��������
	 * @return
	 */
	public long getCount(String output, List conditions) throws RuntimeException;

	/**
	 * ִ��HQL����ѯ��ҳ����
	 * 
	 * @param hql
	 *            ��ѯ���
	 * @return
	 * @throws RuntimeException
	 */
	public List query(String hql) throws RuntimeException;
	
	/**
	 * ִ��HQL����ѯ��ҳ����
	 * 
	 * @param hql
	 *            ��ѯ���
	 * @param pageNo
	 *            ҳ��
	 * @param pageSize
	 *            ����
	 * @return
	 * @throws RuntimeException
	 */
	public ItemPage query(String hql, int pageNo, int pageSize) throws RuntimeException;
	
	/**
	 * ȡ��ǰ����
	 * 
	 * @return
	 */
	public Session getCurrentSession();
}
