package org.trustel.service.id;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.trustel.service.jdbc.JdbcService;

/**
 * <pre>
 * �� ����ID12NumGenerator.java
 * �� �ߣ�hujh
 * �� �ڣ�2012-10-23
 * �� ����12λ��ֵ��id����������λʱ������+��λ�����+5λ���ݿ�����ֵ
 * </pre>
 */
public class ID12NumGenerator implements IdentifierGenerator {
	private final int minValue = 10000; 
	private final int maxValue = 90000; 
	public synchronized Serializable generate(SessionImplementor session,
			Object entity) throws HibernateException {
		return getNextSequence((Session) session, entity.getClass().getSimpleName());
	}

	/**
	 * ��λʱ������+��λ�����+5λ���ݿ�����ֵ
	 * @param session
	 * @param name
	 * @return
	 */
	private String getNextSequence(Session session, String name) {
		String dateSequence = getDateSerialNo();
		int random = generateThreeRandom() ;
		String databaseSequence = String.valueOf(getNextLongSequence(session, name));   
		String result = dateSequence + random+ fixLength(databaseSequence, 5); 
		return result;
	}
	
	/**
	 * ��ȡʱ�����У���λ��+��λ��
	 * @return
	 */
	private String getDateSerialNo(){ 
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyMM");
		return format.format(now);
	}
	
	/**
	 * @return ������λ�����
	 */
	private int generateThreeRandom() {
		Random r = new Random(new Date().getTime());
		double t = 0.0;
		while (t==0.0) {
			t = r.nextDouble();
		} 
		int result = (int)(t*1000); 
		return result;
	}
	
	/**
	 * ��ȡ���ݿ������ֵ
	 * @param session
	 * @param name(λ����С�����)
	 * @return
	 */
	private Long getNextLongSequence(Session session, String name) {
		Connection conn = null;
		long value = minValue;
		try {
			conn = SessionFactoryUtils.getDataSource(
					session.getSessionFactory()).getConnection();
			JdbcService service = new JdbcService();
			service.setConnection(conn);
			value = service._getNextCode(name, minValue, maxValue);
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			DataSourceUtils.releaseConnection(conn, SessionFactoryUtils
					.getDataSource(session.getSessionFactory()));
		}
		return value;//SequenceUtils.getNextLongValue(session, name,10000,99999);  
	}
	
	/**
	 * ������0��ǰ׺��ָ�����ȵ����к�
	 */
	public String fixLength(String value, int fixLen) {
		return fixLength(value, fixLen, '0');
	}

	/**
	 * ����ָ�����ƺͳ����Լ�ָ��ǰ׺�����кţ�ͨ��ʹ��0��ǰ׺
	 */
	public String fixLength(String value, int fixLen, char fixChar) {
		String stmp = "";
		if (value!=null && value.length()>fixLen) {
			value = value.substring(0,fixLen); 
		}
		for (int i = 0; i < fixLen - value.length(); i++) {
			stmp = stmp + fixChar;
		}
		return stmp + value;
	}

	

}
