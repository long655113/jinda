package org.trustel.account;


/**
 * 
 * 类 名：通用在线用户
 * 
 * 版 本：0.0.0.1
 * 
 * 设 计：万志勇
 * 
 * 日 期：2011-03-04 09:41
 * 
 * 数据源：onlineuser(通用在线用户)
 * 
 * 描 述：
 * 
 **/

public class OnlineUser extends CommonAccount {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3875565244632508771L;
	/**
	 * 积分
	 */
	private int points = 0;
	/**
	 * 会员等级
	 */
	private int grade;
	
	/**
	 * 会员等级中文名
	 */
	private String gradeZh;
	
	/**
	 * 是否显示价格（非登录用户没有权限）
	 */
	private int isShowPrice = 0;

	/**
	 * 所在区域
	 */
	private int regionId = 0;

	

	/**
	 * 
	 * @return 积分(points<--points)
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * 
	 * @return 会员等级(grade<--grade)
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * 
	 * @return 所在区域(regionid<--regionid)
	 */
	public int getRegionId() {
		return regionId;
	}

	/**
	 *设置积分
	 * 
	 * @param 积分
	 *            (points-->points)
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 *设置会员等级
	 * 
	 * @param 会员等级
	 *            (grade-->grade)
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 *设置所在区域
	 * 
	 * @param 所在区域
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
