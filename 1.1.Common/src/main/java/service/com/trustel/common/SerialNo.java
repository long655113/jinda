package com.trustel.common;

import java.text.NumberFormat;

/**
 * @author Administrator
 *
 * ȡ���к���
 */
public class SerialNo {
    private static long sequence;
    private static String compareTime;
    private static NumberFormat numberFormat;
    
    static {
        numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        numberFormat.setMinimumIntegerDigits(5);
        numberFormat.setMaximumIntegerDigits(5);
    }
    
	/**
	 * ����Ψһ���к�
	 * <p>
	 * ���ݵ�ǰʱ�����λ��ţ�һ��20λ
	 * 
	 * @return ���к�
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

	/**
	 * ����Ψһ���к�
	 * <p>
	 * ���ݵ�ǰʱ�����ɣ����ڷ��������ݼ�¼����ʱ��һ��15λ(���������������ʱ�����ܳ����ظ�)
	 * 
	 * @return ���к�
	 */	
	public static String getSerialforDB() {
		return DateFunc.getCurrentDateString("yyMMddHHmmssSSS"); 
	}

	/**
	 * ���ɶ����к�
	 * <p>
	 * ���ݵ�ǰʱ�����ɣ������������ݼ�¼ʱ��(���ܳ����ظ���һ�����ڼ�¼�����ұ䶯��Ƶ���ľ�̬��ļ�¼����)
	 * 
	 * @return ���к�
	 */	
	public static String getShortSerial() {
		return DateFunc.getCurrentDateString("mmssSSS");
	}
}
