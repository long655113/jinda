package com.trustel.common;

import java.util.Vector;

/**
 * @author Administrator
 * 
 * �ֽڴ�����
 */
public class ByteFunc {
	public static ByteFunc getInstance() {
		return new ByteFunc();
	}

	private ByteFunc() {
	}

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * ���ֽڴ�ת��Ϊ�ɼ��ַ���
	 * 
	 * @param b
	 *            �ֽڴ�
	 * @param length
	 *            ת������
	 * @return
	 */
	public String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();

		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
			if (i < b.length - 1)
				resultSb.append(" ");
		}
		return resultSb.toString();
	}

	/**
	 * ���ֽڴ�ת��Ϊ�ɼ��ַ���
	 * 
	 * @param b
	 *            �ֽڴ�
	 * @param length
	 *            ת������
	 * @return
	 */
	public String byteArrayToHexString(byte[] b, int length) {
		StringBuffer resultSb = new StringBuffer();
		// ���ֽڴ����Ⱥ�Ҫ���ת������֮��ȡ��Сֵ
		length = (length < b.length) ? length : b.length;

		for (int i = 0; i < length; i++) {
			resultSb.append(byteToHexString(b[i]));
			if (i < length - 1)
				resultSb.append(" ");
		}
		return resultSb.toString();
	}

	/**
	 * ���ֽڴ�ת��Ϊ�ɼ��ַ���
	 * 
	 * @param b
	 *            �ֽڴ�
	 * @param length
	 *            ת������
	 * @return
	 */
	public String byteArrayToHexString(byte[] b, int offset, int length) {
		StringBuffer resultSb = new StringBuffer();
		// ���ֽڴ����Ⱥ�Ҫ���ת������֮��ȡ��Сֵ
		length = (length < b.length - offset) ? length : b.length - offset;

		for (int i = offset; i < offset + length; i++) {
			resultSb.append(byteToHexString(b[i]));
			if (i < offset + length - 1)
				resultSb.append(" ");
		}
		return resultSb.toString();
	}
	
	/**
	 * ���ֽ�ת��Ϊ�ɼ��ַ���
	 * 
	 * @param b
	 * @return
	 */
	private String byteToHexString(byte b) {
		int n = unsignedByte(b);

		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * �������ֽڴ����Ƶ�����ֽڴ���
	 * 
	 * @param output
	 *            ����ֽڴ�
	 * @param input
	 *            �����ֽڴ�
	 * @param length
	 *            ���Ƴ���
	 * @param offset
	 *            �����ֽڴ�ƫ����
	 */
	public void copy(byte[] output, byte[] input, int length, int offset) {
		for (int i = 0; i < length; i++) {
			if (i + offset < input.length)
				output[i] = input[offset + i];
			else
				output[i] = 0;
		}
	}

	/**
	 * �������ֽڴ����Ƶ�����ֽڴ���(��0��Ϊ�ַ����Ľ�����)
	 * 
	 * @param output
	 *            ����ֽڴ�
	 * @param input
	 *            �����ֽڴ�
	 * @param length
	 *            ���Ƴ���
	 * @param offset
	 *            �����ֽڴ�ƫ����
	 */
	public void fetch(byte[] output, byte[] input, int length, int offset) {
		for (int i = 0; i < length; i++) {
			if (input[offset + i] == 0)
				break;
			else if (offset + i < input.length)
				output[i] = input[offset + i];
			else
				output[i] = 0;
		}
	}

	/**
	 * �������ֽڴ����Ƶ�����ֽڴ��ϣ������ַ����Ľ�β�ӿո�'0x00'
	 * 
	 * @param output
	 *            ����ֽڴ�
	 * @param input
	 *            �����ֽڴ�
	 * @param offset
	 *            ����ֽڴ�ƫ����
	 */
	public void encode(byte[] output, byte[] input, int offset) {
		if (input == null)
			output[offset] = 0;
		else {
			for (int i = 0; i < input.length; i++)
				output[offset + i] = input[i];
			output[offset + input.length] = 0;
		}
	}

	/**
	 * �������ֽڴ����Ƶ�����ֽڴ���
	 * 
	 * @param output
	 *            ����ֽڴ�
	 * @param input
	 *            �����ֽڴ�
	 * @param length
	 *            ���Ƴ���
	 * @param offset
	 *            ����ֽڴ�ƫ����
	 */
	public void encode(byte[] output, byte[] input, int length, int offset) {
		for (int i = 0; i < length; i++) {
			if (i < input.length)
				output[offset + i] = input[i];
			else
				output[offset + i] = 0;
		}
		
		if (offset + length < output.length)
			output[offset + length] = 0;
	}

	public void encode(byte[] output, short input, int offset) {
		output[offset + 1] = (byte) (input & 0xff);
		output[offset] = (byte) ((input >>> 8) & 0xff);
	}

	/**
	 * ������ת��Ϊ�ֽڴ�����λ�ֽ���ǰ
	 * 
	 * @param output
	 *            ����ֽڴ�
	 * @param input
	 *            ����
	 * @param offset
	 *            ����ֽڴ�ƫ����
	 */
	public void encode(byte[] output, long input, int offset) {
		output[offset + 3] = (byte) (input & 0xff);
		output[offset + 2] = (byte) ((input >>> 8) & 0xff);
		output[offset + 1] = (byte) ((input >>> 16) & 0xff);
		output[offset] = (byte) ((input >>> 24) & 0xff);
	}

	/**
	 * ���ַ���ת��Ϊ�ֽڴ��������ַ���β�ӿո�'0x00'
	 * 
	 * @param output
	 *            ����ֽڴ�
	 * @param input
	 *            �����ַ���
	 * @param offset
	 *            ����ֽڴ�ƫ����
	 */
	public void encode(byte[] output, String input, int offset) {
		if (input == null)
			output[offset] = 0;
		else {
			byte[] buffer = input.getBytes();
			for (int i = 0; i < buffer.length; i++)
				output[offset + i] = buffer[i];
			output[offset + buffer.length] = 0;
		}
	}

	/**
	 * ���ַ���ת��Ϊ�ֽڴ�
	 * 
	 * @param output
	 *            ����ֽڴ�
	 * @param input
	 *            �����ַ���
	 * @param length
	 *            ת������
	 * @param offset
	 *            ����ֽڴ�ƫ����
	 */
	public void encode(byte[] output, String input, int length, int offset) {
		byte[] buffer = input != null ? input.getBytes()
				: new byte[] { (byte) 0 };

		for (int i = 0; i < length; i++) {
			if (i < buffer.length)
				output[offset + i] = buffer[i];
			else
				output[offset + i] = 0;
		}
	}

	/**
	 * �ֽڴ�����
	 * 
	 * @param buffer
	 *            �ֽڴ�
	 * @param length
	 *            �����ֽڴ�����
	 * @param offset
	 *            ����ƫ����
	 */
	public void leftMove(byte[] buffer, int length, int offset) {
		for (int i = 0; i < length; i++) {
			buffer[i] = buffer[offset + i];
			buffer[offset + i] = 0;
		}
		buffer[length] = 0;
	}

	/**
	 * ���ֽڴ��������
	 * 
	 * @param input
	 *            �����ֽڴ�
	 * @param offset
	 *            �ֽڴ�ƫ����
	 * @return ����
	 */
	public int parseInt(byte[] input, int offset) {
		int result = unsignedByte(input[offset]);

		result = result << 8;
		result += unsignedByte(input[offset + 1]);
		result = result << 8;
		result += unsignedByte(input[offset + 2]);
		result = result << 8;
		result += unsignedByte(input[offset + 3]);

		return result;
	}

	/**
	 * ���ֽڴ���ɳ�����
	 * 
	 * @param input
	 *            �����ֽڴ�
	 * @param offset
	 *            �ֽڴ�ƫ����
	 * @return ������
	 */
	public long parseLong(byte[] input, int offset) {
		long result = unsignedByte(input[offset]);

		result = result << 8;
		result += unsignedByte(input[offset + 1]);
		result = result << 8;
		result += unsignedByte(input[offset + 2]);
		result = result << 8;
		result += unsignedByte(input[offset + 3]);
		result = result << 8;
		result += unsignedByte(input[offset + 4]);
		result = result << 8;
		result += unsignedByte(input[offset + 5]);
		result = result << 8;
		result += unsignedByte(input[offset + 6]);
		result = result << 8;
		result += unsignedByte(input[offset + 7]);

		return result;
	}

	/**
	 * ��byte��������
	 * <p>
	 * ���ֱ�ӽ�byteֵ����int�����������127��byteֵ��ת��Ϊ������
	 * 
	 * @param origin
	 * @return
	 */
	public int unsignedByte(byte origin) {
		return (origin < 0) ? origin + 256 : origin;
	}

	/**
	 * �����ַ����ֽڴ��е�λ��
	 * 
	 * @param input
	 *            �ֽڴ�
	 * @param ch
	 *            �ַ�
	 * @param offset
	 * @return
	 */
	public int indexOf(byte[] input, char ch, int offset) {
		int index = -1;

		for (int i = offset; i < input.length; i++) {
			if (input[i] == ch) {
				index = i;
				break;
			}
		}

		return index;
	}

	/**
	 * ȡ�����ֽڴ�
	 * <p>
	 * ���ݷָ��ַ���ȡһ���ֽڴ�
	 * 
	 * @param input
	 *            �ֽڴ�
	 * @param ch
	 *            �ָ��ַ�
	 * @param no
	 *            ��ʼ�ֽ�
	 * @return
	 */
	public String getPart(byte[] input, char ch, int no) {
		String part = null;
		int offset = 0, length, count = 0;

		while ((length = indexOf(input, ch, offset)) != -1) {
			count++;

			if (count == no) {
				byte[] buf = new byte[length - offset];
				copy(buf, input, length - offset, offset);
				part = new String(buf);
				break;
			}
			offset = length + 1;
		}

		count++;
		if (count == no) {
			byte[] buf = new byte[input.length - offset];
			copy(buf, input, input.length - offset, offset);
			part = new String(buf);
		}

		return part;
	}

	/**
	 * ȡnull����������һ���ֽڴ�
	 * 
	 * @param input
	 *            �����ֽڴ�
	 * @param offset
	 *            ��ʼ�ֽ����
	 * @return
	 */
	public byte[] getPart(byte[] input, int offset) {
		int length = input.length - offset;

		for (int i = offset; i < input.length; i++) {
			if (input[i] == 0) {
				length = i - offset;
				break;
			}
		}

		byte[] output = new byte[length];
		for (int i = 0; i < length; i++)
			output[i] = input[offset + i];

		return output;
	}

	public byte[] getPart(byte[] input, int length, int offset) {
		byte[] output = new byte[length];
		for (int i = 0; i < length; i++)
			if (offset + i < input.length)
				output[i] = input[offset + i];
			else
				output[i] = 0;

		return output;
	}

	/**
	 * �ָ��ֽڴ�
	 * <p>
	 * ���ݽ��ֽڴ��ָ�Ϊ�ֽڴ����飬ȡ����ʼ����֮����ֽڴ�����
	 * 
	 * @param input
	 *            �ֽڴ�
	 * @param ch
	 *            �ָ��ַ�
	 * @param start
	 *            ��ʼ����
	 * @return
	 */
	public Vector separate(byte[] input, char ch, int start) {
		Vector array = new Vector();
		int offset = 0, length, count = 0;

		while ((length = indexOf(input, ch, offset)) != -1) {
			count++;

			if (count >= start) {
				byte[] part = new byte[length - offset];
				copy(part, input, length - offset, offset);
				array.add(new String(part));
			}
			offset = length + 1;
		}

		count++;
		if (count >= start) {
			byte[] part = new byte[input.length - offset];
			copy(part, input, input.length - offset, offset);
			array.add(new String(part));
		}

		return array;
	}

	public boolean isEqual(byte[] source, byte[] dest) {
		if (source.length != dest.length)
			return false;

		for (int i = 0; i < source.length; i++) {
			if (source[i] != dest[i])
				return false;
		}

		return true;
	}
}
