package org.trustel.account;


/**
 * 
 * �� ����ͨ�������û�
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-04 09:41
 * 
 * ����Դ��onlineuser(ͨ�������û�)
 * 
 * �� ����
 * 
 **/

public class OnlineUser extends CommonAccount {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3875565244632508771L;
	/**
	 * ����
	 */
	private int points = 0;
	/**
	 * ��Ա�ȼ�
	 */
	private int grade;
	
	/**
	 * ��Ա�ȼ�������
	 */
	private String gradeZh;
	
	/**
	 * �Ƿ���ʾ�۸񣨷ǵ�¼�û�û��Ȩ�ޣ�
	 */
	private int isShowPrice = 0;

	/**
	 * ��������
	 */
	private int regionId = 0;

	

	/**
	 * 
	 * @return ����(points<--points)
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * 
	 * @return ��Ա�ȼ�(grade<--grade)
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * 
	 * @return ��������(regionid<--regionid)
	 */
	public int getRegionId() {
		return regionId;
	}

	/**
	 *���û���
	 * 
	 * @param ����
	 *            (points-->points)
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 *���û�Ա�ȼ�
	 * 
	 * @param ��Ա�ȼ�
	 *            (grade-->grade)
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 *������������
	 * 
	 * @param ��������
	 *            (regionid-->regionid)
	 */
	public void setRegionId(int regionid) {
		this.regionId = regionid;
	}
	
	public String getGradeZh() {
		return gradeZh;
	}

	public void setGradeZh(String gradeZh) {
		this.gradeZh = gradeZh;
	}
	
	public int getIsShowPrice() {
		return isShowPrice;
	}

	public void setIsShowPrice(int isShowPrice) {
		this.isShowPrice = isShowPrice;
	}
}
