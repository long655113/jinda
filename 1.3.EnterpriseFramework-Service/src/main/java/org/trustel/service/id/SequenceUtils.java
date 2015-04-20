package org.trustel.service.id;

import java.util.HashMap;

import org.hibernate.Session;
import org.trustel.common.Utils;
import org.trustel.service.IEnterpriseService;
import org.trustel.service.id.a.NextCodeAService;
import org.trustel.service.id.a.NextCodeService;
import org.trustel.system.SystemLogger;

public class SequenceUtils {
	private static HashMap<String, EnhancedSequenceUtility> sequences = new HashMap<String, EnhancedSequenceUtility>();

	/**
	 * ��ȡָ������������ֵ
	 * 
	 * @param service
	 *            ���ݷ���
	 * @param sequenceName
	 *            ��������
	 * @param minValue
	 *            ���п�ʼֵ
	 * @param maxValue
	 *            �������ֵ���ﵽ���ֵ������¿�ʼ���
	 * @return ָ����������ֵ
	 */
	public static long getNextLongValue(IEnterpriseService service,
			String sequenceName, int minValue, long maxValue) {
		return service._getNextCode(sequenceName, minValue, maxValue);
	}

	/**
	 * ��ȡָ������������ֵ
	 * 
	 * @param Session
	 *            ���ݷ���
	 * @param sequenceName
	 *            ��������
	 * @param minValue
	 *            ���п�ʼֵ
	 * @param maxValue
	 *            �������ֵ���ﵽ���ֵ������¿�ʼ���
	 * @return ָ����������ֵ
	 */
	public static long getNextLongValue(Session session, String sequenceName,
			int minValue, long maxValue) {
		EnhancedSequenceUtility sequence = getSequenceByName(sequenceName);
		try {
			return sequence.getNextLongValue(new NextCodeService(session),
					sequenceName, minValue, maxValue);
		} catch (Exception e) {
			SystemLogger.error(e.getMessage());
			SystemLogger.error(e);
		}
		return minValue;
	}

	/**
	 * ��ȡ��ǿ������
	 * 
	 * @param service
	 *            ���ݷ���
	 * @param sequenceName
	 *            ��������
	 * @return ��һ������ֵ��16�����ַ�������7λ��ˮ�ź�5λ��������ɡ�
	 */
	public static String getNext7Plus5Code(IEnterpriseService service,
			String sequenceName) {
		EnhancedSequenceUtility sequence = getSequenceByName(sequenceName);
		try {
			return sequence.getNext7Plus5Code(new NextCodeAService(service),
					sequenceName);
		} catch (Exception e) {
			SystemLogger.error(e.getMessage());
			SystemLogger.error(e);
		}
		return "00000000FFFF";
	}

	/**
	 * ��ȡ��ǿ������
	 * 
	 * @param session
	 *            ���ݷ���
	 * @param sequenceName
	 *            ��������
	 * @return ��һ������ֵ��16�����ַ�������7λ��ˮ�ź�5λ��������ɡ�
	 */
	public static String getNext7Plus5Code(Session session, String sequenceName) {
		EnhancedSequenceUtility sequence = getSequenceByName(sequenceName);
		try {
			return sequence.getNext7Plus5Code(new NextCodeService(session),
					sequenceName);
		} catch (Exception e) {
			SystemLogger.error(e.getMessage());
			SystemLogger.error(e);
		}
		return "00000000FFFF";
	}

	/**
	 * ��ȡ����������
	 * 
	 * @param service
	 *            ���ݷ���
	 * @param sequenceName
	 *            ��������
	 * @return ����ֵ
	 */
	public static long getNextLongValue(IEnterpriseService service,
			String sequenceName) {
		EnhancedSequenceUtility sequence = getSequenceByName(sequenceName);
		try {
			return sequence.getNextLongValue(new NextCodeAService(service),
					sequenceName);
		} catch (Exception e) {
			SystemLogger.error(e.getMessage());
			SystemLogger.error(e);
		}
		return 10000;
	}

	/**
	 * ��ȡ����������
	 * 
	 * @param session
	 *            ���ݷ���
	 * @param sequenceName
	 *            ��������
	 * @return ����ֵ
	 */
	public static long getNextLongValue(Session session, String sequenceName) {
		EnhancedSequenceUtility sequence = getSequenceByName(sequenceName);
		try {
			return sequence.getNextLongValue(new NextCodeService(session),
					sequenceName);
		} catch (Exception e) {
			SystemLogger.error(e.getMessage());
			SystemLogger.error(e);
		}
		return 10000;
	}

	/**
	 * ��ȡָ�����ȵ�����ֵ�������Ȳ���ʱ����
	 * 
	 * @param service
	 *            ���ݷ���
	 * @param sequenceName
	 *            ��������
	 * @param fixLength
	 *            �̶�����
	 * @return ָ����������
	 */
	public static String getNextCode(IEnterpriseService service,
			String sequenceName, int fixLength) {
		long value = getNextLongValue(service, sequenceName);
		String ret = Long.toHexString(value);
		return Utils.fixLength(ret, fixLength);
	}

	/**
	 * ��ȡָ�����ȵ�����ֵ�������Ȳ���ʱ����
	 * 
	 * @param session
	 *            ���ݷ���
	 * @param sequenceName
	 *            ��������
	 * @param fixLength
	 *            �̶�����
	 * @return ָ����������
	 */
	public static String getNextCode(Session session, String sequenceName,
			int fixLength) {
		long value = getNextLongValue(session, sequenceName);
		String ret = Long.toHexString(value);
		return Utils.fixLength(ret, fixLength);
	}

	/**
	 * ��ȡ20λ��ID����ֵ
	 * 
	 * @param session
	 * @param squenceName
	 * @param fixLength
	 * @return
	 */
	public static String getNext20Code(Session session, String squenceName) {
		EnhancedSequenceUtility sequence = getSequenceByName("ID20PREFIX");
		try {
			String value = sequence.getNextUUIDValue(new NextCodeService(
					session));
			return Utils.fixLength(value, 20);
		} catch (Exception e) {
			SystemLogger.error(e.getMessage());
			SystemLogger.error(e);
		}
		return "10000";
	}

	/**
	 * ��ȡָ����������
	 * 
	 * @param service
	 *            ���ݷ���
	 * @param sequenceName
	 *            ��������
	 * @param fixLength
	 *            �̶�����
	 * @param minValue
	 *            ���п�ʼֵ
	 * @param maxValue
	 *            �������ֵ
	 * @return ָ����������
	 */
	public static String getNextCode(IEnterpriseService service,
			String sequenceName, int fixLength, int minValue, long maxValue) {
		long value = getNextLongValue(service, sequenceName, minValue, maxValue);
		String ret = Long.toHexString(value);
		return Utils.fixLength(ret, fixLength);
	}

	/**
	 * ��ȡָ����������
	 * 
	 * @param session
	 *            ���ݷ���
	 * @param sequenceName
	 *            ��������
	 * @param fixLength
	 *            �̶�����
	 * @param minValue
	 *            ���п�ʼֵ
	 * @param maxValue
	 *            �������ֵ
	 * @return ָ����������
	 */
	public static String getNextCode(Session session, String sequenceName,
			int fixLength, int minValue, long maxValue) {
		long value = getNextLongValue(session, sequenceName, minValue, maxValue);
		String ret = Long.toHexString(value);
		return Utils.fixLength(ret, fixLength);
	}

	private synchronized static EnhancedSequenceUtility getSequenceByName(
			String name) {
		EnhancedSequenceUtility item;
		name = name.toLowerCase();
		if (sequences.containsKey(name))
			item = sequences.get(name);
		else {
			item = new EnhancedSequenceUtility();
			sequences.put(name, item);
		}
		return item;
	}

}
