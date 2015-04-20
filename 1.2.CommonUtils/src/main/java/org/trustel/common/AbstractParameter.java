package org.trustel.common;

/**
 * 
 * �� ����ϵͳ����[ͨ��]
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-22 
 * 
 * ����Դ��ͨ������ϵͳ������system_parameters,�����������ļ���ָ��
 * 
 * �� ��������ʱʹ������ӳ��
 * 
 **/
public abstract class AbstractParameter implements IListItem {

	/**
	 * ��������
	 */
	private String code;
	/**
	 * ��������
	 */
	private String name;
	/**
	 * ����ֵ
	 */
	private String value;
	/**
	 * ��������
	 */
	private Integer category = 0;

	/**
	 * 
	 * @return ��������(code<--code)
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return ��������(name<--name)
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return ����ֵ(value<--value)
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 
	 * @return ��������(category<--category)
	 */
	public Integer getCategory() {
		return category;
	}

	/**
	 *���ò�������
	 * 
	 * @param ��������
	 *            (code-->code)
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 *���ò�������
	 * 
	 * @param ��������
	 *            (name-->name)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *���ò���ֵ
	 * 
	 * @param ����ֵ
	 *            (value-->value)
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 *���ò�������
	 * 
	 * @param ��������
	 *            (category-->category)
	 */
	public void setCategory(Integer category) {
		this.category = category;
	}

	public String toString() {
		String ret = String.format("c=%s n=%s v=%s", new Object[] { code,
				getName(), getValue() });
		return ret;
	}

	public String getTitle() {
		return name;
	}

}
