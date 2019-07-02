package com.spdb.common;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

/*用于存放server配置信息
 * yuan
 */
public class ServerPropUtil {
	public static String get(String key) throws Exception {
		String pathString=System.getProperty("catalina.home")+"\\conf\\server.properties"; 
        try  { 
        	Properties prop =  new  Properties();  
            InputStream in =  new FileInputStream( pathString );  
            prop.load(in);  
           return prop.getProperty(key).trim();  
        }  catch  (IOException e) {  
           return "";
        }  
	}
	public static boolean set(String key,String value) throws Exception {
		String pathString=System.getProperty("catalina.home")+"\\conf\\server.properties"; 
		OutputStream out=null;
		Properties prop=null;
        try  { 
        	 prop =  new  Properties();  
        	prop.load(new FileInputStream(pathString));   
        	 out=new  FileOutputStream(pathString);
        	 prop.setProperty(key, value);
        	 prop.store(out, "server-config");
            return true;
        }  catch  (IOException e) {  
        	return false;
        }  
        finally
        {
        	if(out!=null)
        	out.close();
        	prop=null;
        }
	}
}
