package com.spdb.common;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 命名转化
 * 
 * @author Chan
 * 
 */
public class StrTras {
	/**
	 * 去掉下划线 转换成驼峰式命名 用于属性
	 * 
	 * @param str
	 * @return
	 */
	public static String transform(String str) {
		if (str.contains("_")) {
			String[] s = str.split("_");
			String reStr = "";
			int i = 0;

			do {
				if (i == 0) {
					reStr += s[i].toLowerCase();
				} else {
					reStr += s[i].substring(0, 1).toUpperCase()
							+ s[i].substring(1).toLowerCase();
				}
				i = i + 1;
			} while (i < s.length);
			return reStr;
		} else {
			return str.toLowerCase();
		}
	}

	/**
	 * 去掉下划线 转换成驼峰式命名 用于类名
	 * 
	 * @param str
	 * @return
	 */
	public static String transformClass(String str) {
		if (str.contains("_")) {
			String[] s = str.split("_");
			String reStr = "";
			int i = 0;

			do {
				if (i == 0) {
					reStr += s[i].toUpperCase();
				} else {
					reStr += s[i].substring(0, 1).toUpperCase()
							+ s[i].substring(1).toLowerCase();
				}
				i = i + 1;
			} while (i < s.length);
			return reStr;
		} else {
			return str.substring(0, 1).toUpperCase()
					+ str.substring(1).toLowerCase();
		}
	}

	/**
	 * 去掉下划线，全部小写
	 * 
	 * @param str
	 * @return
	 */
	public static String transallsmall(String str) {

		return str.replaceAll("_", "").toLowerCase();
	}
	/*
	 * 判断是否为正整数 ，含负数
	  * @param str 传入的字符串 
	  * @return 是整数返回true,否则返回false 
	 */
	public static boolean isNumeric(String str){
	    Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(str).matches();   
	}
	
	/*
	  * 判断是否为整数 ，含负数
	  * @param str 传入的字符串 
	  * @return 是整数返回true,否则返回false 
	*/
	  public static boolean isInteger(String str) {  
	    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	    return pattern.matcher(str).matches();  
	  }
	  
	  /* 
	   * 判断是否为浮点数，包括double和float 
	   * @param str 传入的字符串 
	   * @return 是浮点数返回true,否则返回false 
	 */  
	   public static boolean isDouble(String str) {  
	     Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");  
	     return pattern.matcher(str).matches();  
	   }
	   /** 
	     * 判断字符串值是否为空 
	     * @param value 
	     * @return 
	     */  
	    public static boolean isEmpty(String value){  
	        if(value == null || "".equals(value)){  
	            return true;  
	        }  
	        return false;  
	    }  
	    /** 
	     * 判断字符串值是否为指定日期格式
	     * @param value 
	     * @param format 
	     * @return 
	     */  
	    public static boolean isDate(String value,String format){  
	          
	        SimpleDateFormat sdf = null;  
	        ParsePosition pos = new ParsePosition(0);//指定从所传字符串的首位开始解析  
	          
	        if(value == null || isEmpty(format)){  
	            return false;  
	        }  
	        try {  
	            sdf = new SimpleDateFormat(format);  
	            sdf.setLenient(false);  
	            Date date = sdf.parse(value,pos);  
	            if(date == null){  
	                return false;  
	            }else{  
	                System.out.println("-------->pos : " + pos.getIndex());  
	                System.out.println("-------->date : " + sdf.format(date));  
	                //更为严谨的日期,如2011-03-024认为是不合法的  
	                if(pos.getIndex() > sdf.format(date).length()){  
	                    return false;  
	                }  
	                return true;  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return false;  
	        }  
	    }  

}
