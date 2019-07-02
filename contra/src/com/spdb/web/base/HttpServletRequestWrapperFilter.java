package com.spdb.web.base;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spdb.common.MacUtil;
import com.spdb.pojo.base.SPDBSaveClickPojo;
import com.spdb.service.base.SPDBSaveClickService;
import com.spdb.service.generator.CommonService;


/**
 * 该类用于记录每一个HTTP的路径，地址，参数等
 * @author 陈君威
 *
 */
public class HttpServletRequestWrapperFilter implements Filter {

	Enumeration<?> enu=null;
	SPDBSaveClickService service;
	CommonService commonService;
	long saveTime= new Date().getTime();
	
	public static Logger logger=Logger.getLogger(HttpServletRequestWrapperFilter.class);
	
//	初始化方法 （获取service接口方法）
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"application.xml");
		service = (SPDBSaveClickService) ctx.getBean("sPDBSaveClickService");
		commonService = (CommonService) ctx.getBean("commonService");
	
	     Timer timer = new Timer();  
	     timer.schedule(new MyTask(), 0, 4000);  
	}

//	过滤方法
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
		ServletRequest requestWrapper = null;//定义缓存request
		List<LinkedHashMap<String, Object>> list=null;//定义查询list集合
		if (request instanceof HttpServletRequest) {//判断是否数据子类
			enu=request.getParameterNames();  //枚举所有参数（此步为最重要一步）
			requestWrapper = new BodyReaderHttpServletRequestWrapper((HttpServletRequest) request);
		}//request缓存克隆
//		if (((HttpServletRequest) request).getMethod().equals("POST")) {
		String uri=((HttpServletRequest) requestWrapper).getRequestURI();
		String getNameSql=null;
		if(uri.indexOf(".js")>0 || uri.indexOf(".css")>0 ){
		
		}else{
			getNameSql="select * from P_LTE_USERPERCE_REFECT where FUNCTION_URI='"+uri+"'";
			list = commonService.dynamicSql(getNameSql);//数据库查询是否有该请求的中文映射
			if (list.size()!=0) {
				request.setCharacterEncoding("UTF-8");  
				String ip= (getIpAddress(requestWrapper));
				String payload=getBody(requestWrapper).replace(":", "=");
				StringBuilder buffString=new StringBuilder(payload);
				if(!uri.equals("/contra/newAnaly/getWorkList")){//如果是综合分析模块则不拿参数
					if(payload.length()==0){
						while(enu.hasMoreElements()){
							String paraName=(String)enu.nextElement();  //获取参数名称
							buffString.append(paraName+"="+request.getParameter(paraName)+",");
						}
					}
				}

			
					java.util.Date datetime=new java.util.Date();//获取时间
					java.sql.Timestamp time=new java.sql.Timestamp(datetime.getTime());
					String FUNCTION_PARENT=String.valueOf(list.get(0).get("FUNCTION_PARENT"));//获取中文映射
					String FUNCTION_NAME=String.valueOf(list.get(0).get("FUNCTION_NAME"));
					String userName="";
					String city="";
//					判断是否登录，是则不去查询，否则查询
					if(uri.equals("/contra/checkLogin.jhtml") || uri.equals("/contra/loginApp.jhtml")){
						 String phone=buffString.substring(buffString.indexOf("=")+1,buffString.indexOf(","));
						 if(phone.equals("admin")||phone.equals("admin1")){
							 userName="管理员:"+phone;
						     city="云南";
						 }else {
							 List<LinkedHashMap<String, Object>> listUser=commonService.dynamicSql("select user_Name,DEPT_NAME from users where phone='"+phone+"'");
							    if(listUser.size()!=0){
							    	userName=listUser.get(0).get("USER_NAME").toString();
							    	city=listUser.get(0).get("DEPT_NAME").toString();
							    }
						}
						
					}else {
//						System.out.println(((HttpServletRequest) request).getSession().getAttribute("userName"));
						if(((HttpServletRequest) request).getSession().getAttribute("userName")==null){
							userName="匿名访问";
							city="匿名地市";
						}else{
							 userName=((HttpServletRequest) request).getSession().getAttribute("userName").toString();
							 if(((HttpServletRequest) request).getSession().getAttribute("deptName")==null){
								 city="未分配部门用户";
							 }else{
								 city=((HttpServletRequest) request).getSession().getAttribute("deptName").toString();
							 }

						}

					}
					
//					获取月份
					Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));   
					   //获取年
					int month=c.get(Calendar.MONTH)+1;
					String yyyymm="";
					if(month<10){
						yyyymm=String.valueOf(c.get(Calendar.YEAR))+"0"+String.valueOf(month);
					}else {
						yyyymm=String.valueOf(c.get(Calendar.YEAR))+String.valueOf(month);
					}
					
					
					if(uri.equals("/contra/getSitePhoto/appImageUpload") || uri.equals("/contra/getSitePhoto/ImageUpload")){
						buffString=new StringBuilder(buffString.substring(buffString.indexOf("filename="),buffString.indexOf("Content-Type")-1));
					}
					
//					System.out.println(yyyymm);
//					插入记录 城市、用户名、时间、父名、功能名、IP、MAC、参数、地址指向
					if(buffString.length()>4000){
						buffString=new StringBuilder("传入参数过长 ");
					}
					service.insert(new SPDBSaveClickPojo(yyyymm,city,userName,time,FUNCTION_PARENT,FUNCTION_NAME,ip,MacUtil.getMacAddress(), String.valueOf(buffString).replaceAll("\"", ""),uri,saveTime));
				}		 
		}
//			注意：该结构不可更改，位置变动则报错
//			System.out.println("--------------------------------------------------------------");
//		}
		if ( null== requestWrapper) {
			chain.doFilter(request, response);
		} else {
			chain.doFilter(requestWrapper, response);
		}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
//			e.printStackTrace();
		}
	}


//	输出流获取payload 中的 JSON 参数
	public static String getBody(ServletRequest requestWrapper) throws IOException {  
	    String body = null;  
	    StringBuilder stringBuilder = new StringBuilder();  
	    BufferedReader bufferedReader = null;  
	    try {  
	        InputStream inputStream = requestWrapper.getInputStream();  
	        if (inputStream != null) {  
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));  
	            char[] charBuffer = new char[128];  
	            int bytesRead = -1;  
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {  
	                stringBuilder.append(charBuffer, 0, bytesRead);  
	            }  
	        } else {  
	            stringBuilder.append("");  
	        }  
	    } catch (IOException ex) {  
	        throw ex;  
	    } finally {  
	        if (bufferedReader != null) {  
	            try {  
	                bufferedReader.close();  
	            } catch (IOException ex) {  
	                throw ex;  
	            }  
	        }  
	    }  
	  
	    body = stringBuilder.toString();  
	    return body;  
	}  

	

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	 private String BinstrToStr(String binStr) {  
	        String[] tempStr = StrToStrArray(binStr);  
	        char[] tempChar = new char[tempStr.length];  
	        for (int i = 0; i < tempStr.length; i++) {  
	            tempChar[i] = BinstrToChar(tempStr[i]);  
	        }  
	        return String.valueOf(tempChar);  
	    }  
	 
	 
	// 将初始二进制字符串转换成字符串数组，以空格相隔  
	    private String[] StrToStrArray(String str) {  
	        return str.split(" ");  
	    }  
	
	    // 将二进制字符串转换为char  
	    private char BinstrToChar(String binStr) {  
	        int[] temp = BinstrToIntArray(binStr);  
	        int sum = 0;  
	        for (int i = 0; i < temp.length; i++) {  
	            sum += temp[temp.length - 1 - i] << i;  
	        }  
	        return (char) sum;  
	    }  

	    // 将二进制字符串转换成int数组  
	    private int[] BinstrToIntArray(String binStr) {  
	        char[] temp = binStr.toCharArray();  
	        int[] result = new int[temp.length];  
	        for (int i = 0; i < temp.length; i++) {  
	            result[i] = temp[i] - 48;  
	        }  
	        return result;  
	    }  
	    
	    	
	 public static String getIpAddress(ServletRequest requestWrapper) {  
		        String ip = ((HttpServletRequest) requestWrapper).getHeader("x-forwarded-for");  
		       if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		            ip = ((HttpServletRequest) requestWrapper).getHeader("Proxy-Client-IP");  
		         }  
		         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		            ip = ((HttpServletRequest) requestWrapper).getHeader("WL-Proxy-Client-IP");  
		        }  
		       if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		             ip = ((HttpServletRequest) requestWrapper).getHeader("HTTP_CLIENT_IP");  
		         }  
		         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		              ip = ((HttpServletRequest) requestWrapper).getHeader("HTTP_X_FORWARDED_FOR");  
		         }  
		        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		            ip = requestWrapper.getRemoteAddr();  
		         }  
		         return ip;  
		     }  
	 
	 
	 class MyTask extends TimerTask {  
		  
		    @Override  
		    public void run() {  
		        saveTime=new Date().getTime();
//		        System.out.println(saveTime);
		    }  
		  
		}  
}
