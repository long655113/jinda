package org.trustel.service.sql;

public final class JoinConst {
	/**
	 * ԭ��ɨ��һ����ÿ��ȡ�������һ����¼���͸�������ȥ��һ����������ң�����ƥ���¼���ڽ�����У�Ȼ���ٶ�ȡ���������һ�С�û������һ��Ͳ�����
	 * nested loops �� <br />
	 * �������������������󣬱������������ֶ�Ҫ��������<br />
	 * �ص㣺ʹ��Ƕ��ѭ�������Ǵ����ӽ������ȡ��һ����¼������ٷ����� <br />
	 * ʹ�ã� USE_NL(t1 t2) ��ʾ��ǿ��ִ�� Nested Loops ��
	 */
	public static int NESTED_LOOPs = 0;

	/**
	 * ԭ���Ż�����ɨ��С���������Ӽ����ڴ��н��� hash ��Ȼ��ɨ����ÿ�õ�һ����¼��̽�� hash ��һ�Σ��ҳ�ƥ���С� <br />
	 * �����������޴��֮������ӣ���һ���޴�ı�һ��С��֮������ӡ������Ӽ��������� <br />
	 * �ص㣺��Ҫ�ϴ���ڴ棬���̫������Ҫ���з���������ʱ�洢�����̵���ʱ�Ρ�ɨ��ɱ� = ȫ��ɨ���� + ������ *
	 * ��ȫ��ɨ��С������Ҫע����ǣ����뽫 HASH_JOIN_ENABLED ��Ϊ True, ����Ϊ���� PGA_AGGREGATE_TARGET
	 * ������һ���㹻���ֵ�󣬲ſ���ִ�� Hash Join �� <br />
	 * ʹ�ã� USE_HASH(t1 t2) ��ʾ��ǿ��ִ�� Hash Join
	 */
	public static int HASH_JOIN = 1;

	/**
	 * ԭ����������ֱ��������Ȼ��������ϲ������ҳ�ƥ��ļ�¼��<br />
	 * ��������Դ�Ѿ����Ź���������ʹ�á�<br />
	 * �ص㣺��Ҫ�������������ȫ��ɨ��͸��Ե������ϡ�<br />
	 * ʹ�ã� USE_MERGE(t1 t2) ��ʾ��ǿ��ִ�� Sort Merge Join ��
	 */
	public static int SORT_MERGE = 2;

	/**
	 * �ⲿ����:��ȫƥ��
	 */
	public static int INNER_JOIN = 3;

	/**
	 * �ⲿ����:������
	 */
	public static int LEFT_JOIN = 4;

	/**
	 * �ⲿ����:��������
	 */
	public static int RIGHT_JOIN = 5;

	/**
	 * ȫ������ �ϲ���ͬ����������,�൱��UNION
	 */
	public static int FULL_JOIN = 6;

	/**
	 * �������ӣ��൱�ڵѿ����˻�
	 */
	public static int CROSS_JOIN = 7;
}
