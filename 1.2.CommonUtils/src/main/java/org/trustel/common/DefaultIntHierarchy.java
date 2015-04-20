package org.trustel.common;

/**
 * 
 * �� �����ȼ�ģ��[INT]
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-21
 * 
 * 
 * �� ����ʹ�������ֶα���ĵȼ��ṹ���ýṹ������OLAP�е�ά�����ԭ��ͨ���ռ任ȡ�ٶ�
 * 
 */

public class DefaultIntHierarchy implements IIntHierarchy {
	/**
	 * ����
	 */
	private int id = 0;

	/**
	 * �ϼ��ڵ����
	 */
	private int parentId = 0;

	/**
	 * ���ڼ���
	 */
	private int rank = 0;

	/**
	 * ����
	 */
	private String title;

	/**
	 * һ������
	 */
	private int rank1 = 0;

	/**
	 * ��������
	 */
	private int rank2 = 0;

	/**
	 * ��������
	 */
	private int rank3 = 0;

	/**
	 * �ļ�����
	 */
	private int rank4 = 0;

	/**
	 * �弶����
	 */
	private int rank5 = 0;

	/**
	 * ��������
	 */
	private int rank6 = 0;

	/**
	 * �߼�����
	 */
	private int rank7 = 0;

	/**
	 * �˼�����
	 */
	private int rank8 = 0;

	/**
	 * �ż�����
	 */
	private int rank9 = 0;

	/**
	 * ����
	 */
	private String description;

	/**
	 * ����
	 */
	private String lang;

	private int[] ranks = null;

	public int getChildrenCount() {
		return 0;
	}

	public String getCode() {
		return String.valueOf(id);
	}

	/**
	 * 
	 * @return ����(description<--description)
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return ����(id<--id)
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return ����(lang<--lang)
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * 
	 * @return �ϼ��ڵ����(parentId<--parentId)
	 */
	public int getParentId() {
		// TODO:parent_id
		return parentId;
	}

	/**
	 * 
	 * @return ���ڼ���(rank<--rank)
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * 
	 * @return һ������(rank1<--rank1)
	 */
	public int getRank1() {
		return rank1;
	}

	/**
	 * 
	 * @return ��������(rank2<--rank2)
	 */
	public int getRank2() {
		return rank2;
	}

	/**
	 * 
	 * @return ��������(rank3<--rank3)
	 */
	public int getRank3() {
		return rank3;
	}

	/**
	 * 
	 * @return �ļ�����(rank4<--rank4)
	 */
	public int getRank4() {
		return rank4;
	}

	/**
	 * 
	 * @return �弶����(rank5<--rank5)
	 */
	public int getRank5() {
		return rank5;
	}

	/**
	 * 
	 * @return ��������(rank6<--rank6)
	 */
	public int getRank6() {
		return rank6;
	}

	/**
	 * 
	 * @return �߼�����(rank7<--rank7)
	 */
	public int getRank7() {
		return rank7;
	}

	/**
	 * 
	 * @return �˼�����(rank8<--rank8)
	 */
	public int getRank8() {
		return rank8;
	}

	/**
	 * 
	 * @return �ż�����(rank9<--rank9)
	 */
	public int getRank9() {
		return rank9;
	}

	public String getTip() {
		return description;
	}

	/**
	 * 
	 * @return ����(title<--title)
	 */
	public String getTitle() {
		return title;
	}

	public String getUcode() {
		return String.valueOf(parentId);
	}

	public boolean isHomologous(IIntHierarchy hierarchy) {
		if (hierarchy == null)
			return false;
		if (ranks == null)
			ranks = new int[] { rank1, rank2, rank3, rank4, rank5, rank6,
					rank7, rank8, rank9 };
		return ranks[hierarchy.getRank() - 1] == hierarchy.getId();
	}

	/**
	 * ��������
	 * 
	 * @param ����
	 *            (description-->description)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * ���ñ���
	 * 
	 * @param ����
	 *            (id-->id)
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��������
	 * 
	 * @param ����
	 *            (lang-->lang)
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * �����ϼ��ڵ����
	 * 
	 * @param �ϼ��ڵ����
	 *            (parentId-->parentId)
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	/**
	 * �������ڼ���
	 * 
	 * @param ���ڼ���
	 *            (rank-->rank)
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * ����һ������
	 * 
	 * @param һ������
	 *            (rank1-->rank1)
	 */
	public void setRank1(int rank1) {
		this.rank1 = rank1;
	}

	/**
	 * ���ö�������
	 * 
	 * @param ��������
	 *            (rank2-->rank2)
	 */
	public void setRank2(int rank2) {
		this.rank2 = rank2;
	}

	/**
	 * ������������
	 * 
	 * @param ��������
	 *            (rank3-->rank3)
	 */
	public void setRank3(int rank3) {
		this.rank3 = rank3;
	}

	/**
	 * �����ļ�����
	 * 
	 * @param �ļ�����
	 *            (rank4-->rank4)
	 */
	public void setRank4(int rank4) {
		this.rank4 = rank4;
	}

	/**
	 * �����弶����
	 * 
	 * @param �弶����
	 *            (rank5-->rank5)
	 */
	public void setRank5(int rank5) {
		this.rank5 = rank5;
	}

	/**
	 * ������������
	 * 
	 * @param ��������
	 *            (rank6-->rank6)
	 */
	public void setRank6(int rank6) {
		this.rank6 = rank6;
	}

	/**
	 * �����߼�����
	 * 
	 * @param �߼�����
	 *            (rank7-->rank7)
	 */
	public void setRank7(int rank7) {
		this.rank7 = rank7;
	}

	/**
	 * ���ð˼�����
	 * 
	 * @param �˼�����
	 *            (rank8-->rank8)
	 */
	public void setRank8(int rank8) {
		this.rank8 = rank8;
	}

	/**
	 * ���þż�����
	 * 
	 * @param �ż�����
	 *            (rank9-->rank9)
	 */
	public void setRank9(int rank9) {
		this.rank9 = rank9;
	}

	/**
	 * ��������
	 * 
	 * @param ����
	 *            (title-->title)
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public void inherit(IIntHierarchy root) {
		rank1 = -1;
		rank2 = -1;
		rank3 = -1;
		rank4 = -1;
		rank5 = -1;
		rank6 = -1;
		rank7 = -1;
		rank8 = -1;
		rank9 = -1;
		if (root == null) {
			rank = 1;
			parentId = 0;
		} else {
			rank = root.getRank() + 1;
			parentId = root.getId();
			rank1 = root.getRank1();
			rank2 = root.getRank2();
			rank3 = root.getRank3();
			rank4 = root.getRank4();
			rank5 = root.getRank5();
			rank6 = root.getRank6();
			rank7 = root.getRank7();
			rank8 = root.getRank8();
			rank9 = root.getRank9();
		}
		switch (rank) {
		case 1:
			rank1 = id;
			break;
		case 2:
			rank2 = id;
			break;
		case 3:
			rank3 = id;
			break;
		case 4:
			rank4 = id;
			break;
		case 5:
			rank5 = id;
			break;
		case 6:
			rank6 = id;
			break;
		case 7:
			rank7 = id;
			break;
		case 8:
			rank8 = id;
			break;
		case 9:
			rank9 = id;
			break;

		}
	}
}
