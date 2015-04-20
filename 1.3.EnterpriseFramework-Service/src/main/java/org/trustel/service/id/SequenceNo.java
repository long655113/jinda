package org.trustel.service.id;

import java.text.NumberFormat;

import com.trustel.common.DateFunc;

/**
 * 
 * @author kenny
 * 
 */
public class SequenceNo {

	private static long sequence;

	private static String compareTime;

	private static NumberFormat numberFormat;

	static {
		numberFormat = NumberFormat.getInstance();
		numberFormat.setGroupingUsed(false);
		numberFormat.setMinimumIntegerDigits(3);
		numberFormat.setMaximumIntegerDigits(3);
	}

	/**
	 * 生成唯一序列号
	 * <p>
	 * 根据当前时间加三位序号，一共18位
	 * 
	 * @return 序列号
	 */
	public static synchronized String getUNID() {
		String currentTime = DateFunc.getCurrentDateString("yyMMddHHmmssSSS");
		if (compareTime == null || compareTime.compareTo(currentTime) != 0) {
			compareTime = currentTime;
			sequence = 1;
		} else
			sequence++;

		return currentTime + numberFormat.format(sequence);
	}

}
