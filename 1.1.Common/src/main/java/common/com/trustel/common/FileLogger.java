/*
 * �������� 2005-6-3
 *
 * �����������ļ�ģ��Ϊ
 * ���� > ��ѡ�� > Java > �������� > �����ע��
 */
package com.trustel.common;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Administrator
 * 
 * �ļ���־д����
 */
public class FileLogger {
	/**
	 * ��
	 */
	public final static int NONE = 0;

	/**
	 * 
	 */
	public final static int FINEST = 1;

	/**
	 * 
	 */
	public final static int FINER = 2;

	/**
	 * ����
	 */
	public final static int FINE = 3;

	/**
	 * ����
	 */
	public final static int CONFIG = 4;

	/**
	 * ����
	 */
	public final static int INFO = 5;

	/**
	 * ����
	 */
	public final static int WARNING = 6;

	/**
	 * ����
	 */
	public final static int SEVERE = 7;

	public final static String DEFAULT_PATTERN = "-%g.log";

	public final static int DEFAULT_LIMIT = 2 * 1024 * 1024;

	public final static int DEFAULT_COUNT = 10;

	private static FileLogger singleton = null;

	private static Logger logger;

	/**
	 * ����/ȡ��־ʵ��
	 * 
	 * @param pattern
	 *            ��־�ļ���ʽ
	 * @param limit
	 *            �ļ���С
	 * @param count
	 *            �ļ���
	 * @return
	 * @throws java.io.IOException
	 */
	public static FileLogger singleton(String pattern, int limit, int count)
			throws RuntimeException {
		if (singleton == null) {
			try {
				FileHandler handler = new FileHandler(
						pattern + DEFAULT_PATTERN, limit, count, true);
				handler.setFormatter(new SimpleFormatter());
				logger = Logger.getLogger("FileLogger");
				logger.setLevel(Level.ALL);
				logger.addHandler(handler);
				singleton = new FileLogger();
			} catch (Exception e) {
				throw new RuntimeException("log file initialize failed: "
						+ e.getMessage());
			}
		}

		return singleton;
	}

	/**
	 * ����/ȡ��־ʵ��
	 * 
	 * @param pattern
	 *            ��־�ļ���ʽ
	 * @param limit
	 *            �ļ���С
	 * @param count
	 *            �ļ���
	 * @return
	 * @throws java.io.IOException
	 */
	public static FileLogger singleton(String pattern, int count)
			throws RuntimeException {
		if (singleton == null) {
			try {
				FileHandler handler = new FileHandler(
						pattern + DEFAULT_PATTERN, DEFAULT_LIMIT, count, true);
				handler.setFormatter(new SimpleFormatter());
				logger = Logger.getLogger("FileLogger");
				logger.setLevel(Level.ALL);
				logger.addHandler(handler);
				singleton = new FileLogger();
			} catch (Exception e) {
				throw new RuntimeException("log file initialize failed: "
						+ e.getMessage());
			}
		}

		return singleton;
	}

	/**
	 * ������־д����ʵ��
	 * 
	 * @return
	 */
	public static FileLogger singleton() throws RuntimeException {
		if (singleton == null) {
			singleton(DEFAULT_PATTERN, DEFAULT_LIMIT, DEFAULT_COUNT);
		}

		return singleton;
	}

	private FileLogger() {
	}

	/**
	 * ȡ����
	 * 
	 * @param type
	 * @return
	 */
	private Level getLevel(int type) {
		Level level = Level.FINEST;

		switch (type) {
		case NONE:
			level = Level.OFF;
			break;

		case FINEST:
			level = Level.FINEST;
			break;

		case FINER:
			level = Level.FINER;
			break;

		case FINE:
			level = Level.FINE;
			break;

		case CONFIG:
			level = Level.CONFIG;
			break;

		case INFO:
			level = Level.INFO;
			break;

		case WARNING:
			level = Level.WARNING;
			break;

		case SEVERE:
			level = Level.SEVERE;
			break;

		default:
			break;
		}

		return level;
	}

	/**
	 * ������־��¼����
	 * 
	 * @param level
	 *            ����
	 */
	public void setLevel(int level) {
		logger.setLevel(getLevel(level));
	}

	/**
	 * д��־(��־����ΪINFO)
	 * 
	 * @param message
	 *            ��־����
	 */
	public synchronized void log(String message) {
		log(INFO, message);
	}

	/**
	 * д��־
	 * 
	 * @param level
	 *            ��־����
	 * @param message
	 *            ��־����
	 */
	public synchronized void log(int level, String message) {
		switch (level) {
		case FINEST:
			logger.finest(message);
			break;

		case FINER:
			logger.finer(message);
			break;

		case FINE:
			logger.fine(message);
			break;

		case CONFIG:
			logger.config(message);
			break;

		case INFO:
			logger.info(message);
			break;

		case WARNING:
			logger.warning(message);
			break;

		case SEVERE:
			logger.severe(message);
			break;

		default:
			break;
		}
	}

	/**
	 * д��־
	 * 
	 * @param level
	 *            ����
	 * @param className
	 *            ����
	 * @param methodName
	 *            ������
	 * @param message
	 *            ��־����
	 */
	public synchronized void log(int level, String className,
			String methodName, String message) {
		Level le = getLevel(level);
		logger.logp(le, className, methodName, message);
	}

	/**
	 * д��־
	 * 
	 * @param level
	 *            ����
	 * @param className
	 *            ����
	 * @param methodName
	 *            ������
	 * @param message
	 *            ��־����
	 * @param parameters
	 *            ���ݲ���
	 */
	public synchronized void log(int level, String className,
			String methodName, String message, Object[] parameters) {
		Level le = getLevel(level);
		logger.logp(le, className, methodName, message, parameters);
	}
}
