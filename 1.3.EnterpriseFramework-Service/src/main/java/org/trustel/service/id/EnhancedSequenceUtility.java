package org.trustel.service.id;

import java.util.Date;
import java.util.Random;

import org.trustel.common.Utils;
import org.trustel.service.id.a.INextCodeService;
import org.trustel.util.ParameterFactory;

/**
 * 
 * @author ��־��
 * 
 * @version 2.0.0.0 2011-03-11 ��ɲ���������
 * 
 * 1.0.0.0 2010-10 ��ɻ�������
 * 
 * ����˵����
 * <OL>
 * <LI>SYSTEM_KEY_MAXNUMBEROFRAND�����ͣ���������ʱһ�������������������</LI>
 * <LI>SYSTEM_KEY_MINNUMBEROFRAND�����ͣ���������ʱһ����������������ٸ���</LI>
 * 
 */
public class EnhancedSequenceUtility extends SequenceUtility {
	private int keyIndex = 0;

	private String sequence;

	private static final int MAX_5BIT = 0xFFFFF;

	private static final int MAX_7BIT = 0xFFFFFFF;

	private String[] keys = null;

	private int getMinValue() {
		int ret = ParameterFactory.getInt("SYSTEM_SEQUENCE_DEFAULT_MINVALUE",
				10000);
		return ret < 0 ? 10000 : ret;
	}

	public synchronized String getNext7Plus5Code(INextCodeService service,
			String sequenceName) throws Exception {

		// ǰ��7λ�̶�������5λ�����ǰ��λ��9999��
		if (keys == null || keyIndex == keys.length) {
			generateKeys();
			long value = getNextLongValue(service, sequenceName, getMinValue(),
					MAX_7BIT);
			sequence = Utils.fixLength(Long.toHexString(value), 7);
		}
		String key = keys[keyIndex];
		keyIndex++;
		String ret = sequence + key;
		// String ret = sequence.substring(0, sequence.length() - 1) + key
		// + sequence.substring(sequence.length() - 1);
		return ret.toUpperCase();

	}

	private void generateKeys() {
		// ���ɲ�ͬ������ĸ���
		Random r = new Random(new Date().getTime());

		int t = r.nextInt(ParameterFactory.getInt("SYSTEM_KEY_MAXNUMBEROFRAND",
				500));
		int min = ParameterFactory.getInt("SYSTEM_KEY_MINNUMBEROFRAND", 50);
		t = t < min ? min : t;
		keys = new String[t];
		keyIndex = 0;

		while (keyIndex < keys.length) {
			keys[keyIndex] = Utils.fixLength(Integer.toHexString(r
					.nextInt(MAX_5BIT)), 5);
			boolean exist = false;
			if (keyIndex > 0)
				for (int i = keyIndex - 1; i >= 0; i--) {
					if (keys[keyIndex].equals(keys[i])) {
						exist = true;
						break;
					}
				}
			keyIndex = exist ? keyIndex : ++keyIndex;
		}
		keyIndex = 0;

	}

}
