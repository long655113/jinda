package com.trustel.algorithm;

import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * 
 */
public class Subtotal extends Thread {
	private static Subtotal singleton;
	/**
	 * ��ͳ�Ƽ�¼
	 */
	private List items;
	/**
	 * ͳ�Ƽ�¼MAP
	 */
	private HashMap nodes;
	/**
	 * ͳ�ƽ��MAP
	 */
	private HashMap subtotals;
	/**
	 * ͳ�ƽ�����־(���ں�̨ͳ��)
	 */
	private boolean finished;

	public static Subtotal getInstance(List items) throws RuntimeException {
		if (singleton == null)
			singleton = new Subtotal(items);
		else
			singleton.items = items;
		
		singleton.finished = false;

		return singleton;
	}

	private Subtotal() {

	}

	private Subtotal(List items) {
		this.items = items;
		nodes = new HashMap();
		subtotals = new HashMap();

		for (int i = 0; i < items.size(); i++)
			nodes.put(((Node) items.get(i)).getId(), items.get(i));
	}

	public void run() {
		calculate();
	}

	public boolean getFinished() {
		return finished;
	}

	/**
	 * ȡС�ƽ��
	 * 
	 * @return
	 */
	public HashMap getSubtotals() {
		return subtotals;
	}

	/**
	 * ����
	 */
	public void calculate() {
		for (int i = 0; i < items.size(); i++) {
			Node item = (Node) items.get(i);
			subtotal(item.getId(), item);
		}

		finished = true;
	}

	private void subtotal(String id, Node item) {
		if (subtotals.get(id) != null)
			((Summary) subtotals.get(id)).subtotal(item.getSumary());
		else
			subtotals.put(id, item.getSumary());

		Node node = (Node) nodes.get(id);
		if (node.getParentId() != null)
			subtotal(node.getParentId(), node);

	}
}
