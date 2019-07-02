package com.spdb.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
/**
 * 描述：读取配置文件   config.properties
 * @author YINQIN
 *
 */
public class ConfigReaderUtils {

	private static Properties props;
	
	static{
		
		try {
			props = new Properties();
			ClassLoader classLoader=ConfigReaderUtils.class.getClassLoader();
			InputStream jdbcInputStream=classLoader.getResourceAsStream("jdbc.properties");
			InputStream configInputStream=classLoader.getResourceAsStream("config.properties");
			props.load(jdbcInputStream);
			props.load(configInputStream);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * <pre>
	 *根据属性名得到值
	 * </pre>
	 * @param property 属性名
	 * @return
	 */
	public static String getProperty(String property){
		return props.getProperty(property);
	}
}
