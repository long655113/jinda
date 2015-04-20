package org.trustel.service.id;

import org.trustel.service.id.a.INextCodeService;
import org.trustel.util.ParameterFactory;

public class SequenceUtility {
	public static String schema = "";

	private long index = 0;

	private int interval = 10000;

	private long value = -1;

	/**
	 * ID前缀,由数据库初始化获取
	 */
	private String prefix = "";

	private long getMaxValue() {
		return ParameterFactory.getLong("SYSTEM_SEQUENCE_DEFAULT_MAVVALUE",
				Integer.MAX_VALUE - 10000);
	}

	private int getMinValue() {
		return ParameterFactory.getInt("SYSTEM_SEQUENCE_DEFAULT_MINVALUE",
				10000);
	}

	public synchronized Long getNextLongValue(INextCodeService service,
			String sequenceName) throws Exception {
		return getNextLongValue(service, sequenceName, getMinValue(),
				getMaxValue());
	}

	public synchronized Long getNextLongValue(INextCodeService service,
			String sequenceName, int minValue, long maxValue) throws Exception {

		if (value < 0)
			value = service.getNextCode(sequenceName, minValue, maxValue);
		if (index < interval) {
			index++;
			return value * interval + index;
		}
		index = 0;
		value = service.getNextCode(sequenceName, minValue, maxValue);
		return value*interval;
	}

	/**
	 * 获取UNID序列
	 * 
	 * @param service
	 * @param sequenceName
	 * @param minValue
	 * @param maxValue
	 * @return
	 * @throws Exception
	 */
	public synchronized String getNextUUIDValue(INextCodeService service)
			throws Exception {
		if (prefix.equals("")) {
			prefix = Long
					.toHexString(service.getNextCode("ID20PREFIX", 1, 255));
		}
		return prefix + SequenceNo.getUNID();
	}
}
