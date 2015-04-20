/*
 * Created on Aug 5, 2005
 *
 * 
 */
package com.trustel.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;

/**
 * @author Administrator
 * 
 * ��������㷨
 */
public class Combine {
    public static Combine getInstance() {
        return new Combine();
    }

    private Combine() {

    }

    /**
     * Ԥ�ò��ֱ�ѡ��ȡ�������
     * <p>
     * �����ѡ����ڵ���Ҫȡ����Ʒ���������ر�ѡ��
     * 
     * @param options
     *            ��ѡ������
     * @param selectedKeys
     *            ��ѡ������
     * @param samples
     *            ��Ʒ����
     * @return
     */
    public List combinate(java.util.Hashtable options, List selectedKeys,
            int samples) {
        return combinate(options, selectedKeys, null, samples);
    }

    /**
     * Ԥ�ò��ֱ�ѡ��ȡ�������
     * <p>
     * �����ѡ����ڵ���Ҫȡ����Ʒ���������ر�ѡ��
     * 
     * @param options
     *            ��ѡ������
     * @param selectedKeys
     *            ��ѡ������
     * @param comp
     *            ������
     * @param samples
     *            ��Ʒ����
     * @return
     */
    public List combinate(java.util.Hashtable options, List selectedKeys,
            Comparator comp, int samples) {
        List list = null;
        java.util.Iterator it = selectedKeys.iterator();
        List selectedItems = new ArrayList();
        
        if (selectedKeys.size() > samples || options.size() < samples)
            return null;

        while (it.hasNext()) {
            Object key = it.next();
            Object selectedItem = options.get(key);
            if (selectedItem != null) {
                selectedItems.add(selectedItem);
                options.remove(key);
            }
        }

        if (selectedKeys.size() >= samples)
            list = selectedItems;
        else {
            Object[] items = getItems(options, comp);

            list = combinate(items, samples - selectedKeys.size());
            if (selectedKeys.size() > 0) {
                it = list.iterator();
                while (it.hasNext()) {
                    List item = (List) it.next();
                    item.addAll(selectedItems);
                }
            }
        }

        return list;
    }

    /**
     * ����������ȡ����ѡ��
     * 
     * @param options
     *            ��ѡ��
     * @param comp ������
     * @return
     */
    private Object[] getItems(Hashtable options, Comparator comp) {
        java.util.TreeSet sort = new java.util.TreeSet(comp);
        
        java.util.Enumeration en = options.elements();
        while (en.hasMoreElements()) {
            Object item = en.nextElement();
            sort.add(item);
        }
        
        return sort.toArray();
    }

    /**
     * ȡ�������
     * 
     * @param options
     *            ��ѡ������
     * @param samples
     *            ��Ʒ����
     * @return
     */
    public List combinate(Object[] options, int samples) {
        List list = new ArrayList();
        int[] selected = new int[samples];

        // ��Ʒ��������С�ڵ��ڿ�ѡ�����
        if (options.length >= samples && samples > 0)
            combinate(list, selected, options, 0, samples);
        else
            return null;

        return list;
    }

    /**
     * ����������ϵ���
     * 
     * @param list
     *            ������Ͻ��
     * @param selected
     *            ѡ��������
     * @param options
     *            ��ѡ��
     * @param start
     *            ��ʼ���
     * @param count
     *            ȡ��Ʒ����
     */
    private void combinate(List list, int[] selected, Object[] options,
            int start, int count) {
        for (int i = start; i <= options.length - count; i++) {
            selected[selected.length - count] = i;
            if (count > 1)
                combinate(list, selected, options, i + 1, count - 1);
            else {
                list.add(getSelected(options, selected));
            }
        }
    }

    /**
     * ����ѡ���������ѡ��
     * 
     * @param options
     *            ��ѡ��
     * @param selected
     *            ѡ�����������
     * @return
     */
    private List getSelected(Object[] options, int[] selected) {
        List item = new ArrayList();

        for (int i = 0; i < selected.length; i++)
            item.add(options[selected[i]]);

        return item;
    }
}
