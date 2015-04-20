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
 * 类 名：ID12NumGenerator.java
 * 作 者：hujh
 * 日 期：2012-10-23
 * 描 述：12位数值型id生成器，四位时间序列+三位随机数+5位数据库序列值
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
	 * 四位时间序列+三位随机数+5位数据库序列值
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
	 * 获取时间序列：两位年+两位月
	 * @return
	 */
	private String getDateSerialNo(){ 
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyMM");
		return format.format(now);
	}
	
	/**
	 * @return 生成三位随机数
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
	 * 获取数据库的序列值
	 * @param session
	 * @param name(位于最小和最大)
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
	 * 返回以0作前缀的指定长度的序列号
	 */
	public String fixLength(String value, int fixLen) {
		return fixLength(value, fixLen, '0');
	}

	/**
	 * 返回指定名称和长度以及指定前缀的序列号，通常使用0作前缀
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
