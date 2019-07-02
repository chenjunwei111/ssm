package com.spdb.web.base;

import com.alibaba.fastjson.JSONObject;
import com.spdb.common.MD5Util;
import com.spdb.common.WebUtils;
import com.spdb.pojo.admin.UsersPojo;
import com.spdb.service.admin.UsersService;
import com.spdb.service.generator.CommonService;
import com.spdb.serviceImpl.base.AuthHandleImpl;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
// @RequestMapping("/Login")
public class Login {

	@Resource
	CommonService commonservice;

	@Resource
	UsersService usersService;
	

	public static Logger logger=Logger.getLogger(Login.class);

	

	// http://192.168.9.182:8080/contra/Login/loginShiro?userName=xiaotijun&passwd=123
	@RequestMapping(value = "/checkLogin.jhtml")
	@ResponseBody
	public String login(String userName, String passwd, Model model,
			HttpServletResponse response) throws IOException {
		Subject subject = SecurityUtils.getSubject();
		// 永不超时，单位MS微妙
//		System.out.println("前端传入账号 login:" + userName + " passwd:" + passwd);
		SecurityUtils.getSubject().getSession().setTimeout(-1000l);
		UsernamePasswordToken token = new UsernamePasswordToken(userName,
				passwd);
		try {
			subject.login(token);
			// System.out.println(token.getUsername());
			token.setRememberMe(true);
		} catch (LockedAccountException e) {
			// 账号锁定
			System.out.println("账号被锁");
			return "lock";
		} catch (UnknownAccountException e) {
			// 账号错误
			System.out.println("账号不存在");
			return "noaccount";
		} catch (IncorrectCredentialsException e) {
			// 密码错误
			System.out.println("密码错误");
			return "nopasswd";
		}
		return "success";
	}

	@RequestMapping(value = "/getUserInfo")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> getUserInfo(Object userName,
			HttpServletRequest request) throws Exception {
		String sql=null;
		try {
			Subject currentUser = SecurityUtils.getSubject();
			userName = currentUser.getPrincipal().toString();
			String selectSql = "";
//			userName="13708894190";//暂时默认写死肖体俊	
//			if(userName==null || userName.equals("")){
////				AuthHandleImpl su=new AuthHandleImpl(); //调用认证接口
////				Map<String, Object> dataMap=su.getMapData(request);
////				userName=dataMap.get("loginId");
//				
//				userName="13708894190";//暂时默认写死肖体俊
//				
//			}
			
			
			if (userName.equals("admin") || userName.equals("admin1")) {
				selectSql = "t1.user_name = '" + userName + "'";
			} else {
				selectSql = "t1.phone= '" + userName + "'";
			}
			  sql="select  t1.USER_CODE,  t1.user_name,t1.phone,   t1.DEPT_NAME, "
                 +" t1.DEPT_CODE,  t1.PASSWORD,   t2.ROLE_NAME,  t3.ROLE_ID,t4.area_code, t5.level_num "
                 +" from Users t1, trole t2, trole_user t3,department t4, (SELECT t.USER_CODE,t.LEVEL_NUM  FROM VEIW_USER_AUTHORIZATION t group by t.USER_CODE,t.LEVEL_NUM) t5 "
                 +" where "+selectSql+"  "
                 +" and t1.user_code = t3.USER_CODE "
                 +" and t3.role_id = t2.ROLE_ID "
                 +" and t4.DEPT_CODE=t1.DEPT_CODE  and t1.user_code = t5.user_code";
//			System.out.println("获取用户基本信息" + sql);
			List<LinkedHashMap<String, Object>> users = commonservice
					.dynamicSql(sql);

			HttpSession session = request.getSession();
			session.setAttribute("userName", users.get(0).get("USER_NAME"));
			session.setAttribute("deptName", users.get(0).get("DEPT_NAME"));
			session.setAttribute("areaCode", users.get(0).get("AREA_CODE"));
			session.setAttribute("userCode", users.get(0).get("USER_CODE"));
			session.setAttribute("levelNum", users.get(0).get("LEVEL_NUM"));
			// 记录最后登录时间
			UsersPojo user = new UsersPojo();
			user.setUsercode(users.get(0).get("USER_CODE").toString());
			user.setIslogin(1);
			user.setLastlogin(new Timestamp(System.currentTimeMillis()));
			usersService.update(user);
			// 密码解密输出
			users.get(0)
					.put("PASSWORD",
							MD5Util.convertMD5(users.get(0).get("PASSWORD")
									.toString()));
			return users;
		} catch (Exception e) {
			

//			logger.error("查询SQL："+sql+"\n 错误信息："+e.getMessage(),e);
			sql="select * from users where phone='"+userName+"' ";
//				System.out.println("获取用户基本信息-非SHIRO" + sql);
				List<LinkedHashMap<String, Object>> users = commonservice.dynamicSql(sql);
				HttpSession session = request.getSession();
				session.setAttribute("userName", users.get(0).get("USER_NAME"));
//				session.setAttribute("deptName", users.get(0).get("DEPT_NAME"));
//				session.setAttribute("areaCode", users.get(0).get("AREA_CODE"));
//				session.setAttribute("userCode", users.get(0).get("USER_CODE"));
//				session.setAttribute("levelNum", users.get(0).get("LEVEL_NUM"));
				// 记录最后登录时间
				UsersPojo user = new UsersPojo();
				user.setUsercode(users.get(0).get("USER_CODE").toString());
				user.setIslogin(1);
				user.setLastlogin(new Timestamp(System.currentTimeMillis()));
				usersService.update(user);
				// 密码解密输出
				users.get(0).put("PASSWORD",MD5Util.convertMD5(users.get(0).get("PASSWORD").toString()));
			return users;
		}
	}

	@RequestMapping(value = "/loginApp.jhtml")
	@ResponseBody
	public void loginApp(String phone, String passwd,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// System.out.println("userName:" + PHONE);
		// String username = request.getParameter("userName");
		// System.out.println("username:" + username);
		// String username1 = new String(username.getBytes("iso8859-1"),
		// "utf-8"); //可用
		// System.out.println("username1:" + username1);
		// String username2 = URLDecoder.decode(userName, "utf-8");
		// System.out.println("username2:" + username2);

		Map<String, Object> maps = new HashMap<String, Object>();
		String sql =null;
		try {
			Subject currentUser = SecurityUtils.getSubject();
			 sql = "SELECT USER_CODE,USER_NAME,PASSWORD,DEPT_CODE,DEPT_NAME,PHONE,AREA_CODE,LEVEL_NUM,FUNCTION_CODE,FUNCTION_NAME"
					+ " FROM VEIW_USER_AUTHORIZATION WHERE PHONE= '"
					+ phone
					+ "' and PASSWORD ='" + MD5Util.convertMD5(passwd) + "'";
//			System.out.println(sql);

			List<LinkedHashMap<String, Object>> users = commonservice
					.dynamicSql(sql);
			LinkedHashMap<String, Object> retrunObj = new LinkedHashMap<String, Object>();

			LinkedHashMap<String, Object> functionNames = new LinkedHashMap<String, Object>();

			// 功能菜单列表
			for (LinkedHashMap<String, Object> lm : users) {
				functionNames.put(lm.get("FUNCTION_CODE").toString(),
						lm.get("FUNCTION_NAME").toString());
			}
			retrunObj.put("access_token", "1");
			retrunObj.put("userCode", users.get(0).get("USER_CODE"));
			retrunObj.put("userName", users.get(0).get("USER_NAME"));
			// retrunObj.put("password", users.get(0).get("PASSWORD"));
			retrunObj.put("deptcode", users.get(0).get("AREA_CODE"));
			retrunObj.put("deptName", users.get(0).get("DEPT_NAME"));
			retrunObj.put("phone", users.get(0).get("PHONE"));
			retrunObj.put("areaCode", users.get(0).get("DEPT_CODE"));
			retrunObj.put("levelNum", users.get(0).get("LEVEL_NUM"));
			retrunObj.put("length", functionNames.size());
			retrunObj.put("functionNames", functionNames);
			
			
			
			HttpSession session = request.getSession();
			session.setAttribute("userName", users.get(0).get("USER_NAME"));
			session.setAttribute("deptName", users.get(0).get("DEPT_NAME"));
			session.setAttribute("areaCode", users.get(0).get("AREA_CODE"));
			session.setAttribute("userCode", users.get(0).get("USER_CODE"));
	// 记录最后登录时间
			UsersPojo user = new UsersPojo();
			user.setUsercode(users.get(0).get("USER_CODE").toString());
			user.setIslogin(1);
			user.setLastlogin(new Timestamp(System.currentTimeMillis()));
			usersService.update(user);
			// 密码解密输出
			users.get(0).put("PASSWORD",MD5Util.convertMD5(users.get(0).get("PASSWORD").toString()));
			
			maps.put("return", true);// 成功返回代码
			maps.put("status", 200);// 成功返回代码
			maps.put("msg", "请求成功");// 返回信息
			maps.put("data", retrunObj);// 数据总量
//			logger.info("APP登陆返回信息："+maps);
		} catch (Exception e) {
//			e.printStackTrace();
			String userSql="with t1 as( select * from users where phone='"+phone+"') "
                           +"  select (case when (select count(*) from t1  )=0 then '用户不存在'  "
                           +" when (select count(*) from t1 where   PASSWORD='"+MD5Util.convertMD5(passwd)+"')=0 then '密码错误' "
                           +" else '用户已失效' end ) login_msg from dual";
			List<LinkedHashMap<String, Object>> list2=commonservice.dynamicSql(userSql);
			Object MSG=list2.get(0).get("LOGIN_MSG");
			logger.error("查询SQL："+sql+"\n 错误信息："+MSG,e);
			maps.put("return", false);
			maps.put("status", 100);
			maps.put("msg", "请求失败:" + MSG);
			maps.put("data", null);
		}
		Object jsonObject = JSONObject.toJSON(maps);
		WebUtils.writeObjectJsonToClient(jsonObject, response);
	}

	// http://192.168.9.182:8080/contra/login.jhtml
	@RequestMapping(value = "/login.jhtml")
	@ResponseBody
	public void getLogin(HttpServletResponse response) throws IOException {
		// ModelAndView mav = new ModelAndView("/login");
		// response.sendRedirect("login.html");
		// return mav;
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<script>");
		out.println("window.open ('login.html','_top')");
		out.println("</script>");
		out.println("</html>");
	}

	// http://192.168.9.182:8080/contra/index.jhtml
	@RequestMapping(value = "/index.jhtml")
	public ModelAndView getIndex(HttpServletResponse response)
			throws IOException {
		ModelAndView mav = new ModelAndView("/index");
		return mav;
	}

	// http://192.168.9.182:8080/contra/Login/logout.jhtml
	/**
	 * 退出登录
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout.jhtml")
	public void logout(HttpServletResponse response) throws Exception {
		System.out.println("退出");
		try {
		Subject currentUser = SecurityUtils.getSubject();
		String userName = currentUser.getPrincipal().toString();
		String selectSql = "";
		if (userName.equals("admin") || userName.equals("admin1")) {
			selectSql = "t1.user_name = '" + userName + "'";
		} else {
			selectSql = "t1.phone= '" + userName + "'";
		}

		String sql = " select t1.USER_CODE,t1.user_name,t1.DEPT_NAME,t1.DEPT_CODE,"
				+ " t1.PASSWORD,t2.ROLE_NAME  from Users t1,trole t2, trole_user t3 "
				+ "    where "
				+ selectSql
				+ " and t1.user_code=t3.USER_CODE"
				+ "    and t3.role_id=t2.ROLE_ID";
		List<LinkedHashMap<String, Object>> users = commonservice
				.dynamicSql(sql);
		UsersPojo user = new UsersPojo();
		user.setUsercode(users.get(0).get("USER_CODE").toString());
		user.setIslogin(0);
		usersService.update(user);
		currentUser.logout();
		response.sendRedirect("/contra/login.html");
		} catch (Exception e) {
		logger.error("错误信息:"+e.getMessage(),e);
		response.sendRedirect("/contra/login.html");
		}
	}
	
	
//	http://39.129.4.172:8081/contra/loginIndex.jhtml?id=13888074873;
	/**
	 * 亿阳人员跳转
	 * @param model
	 * @param response
	 * @throws IOException
	 */
	  
	@RequestMapping(value = "/loginIndex.jhtml")
	@ResponseBody
	public void login2(String id, Model model,
			HttpServletResponse response,HttpServletRequest request) throws IOException{
		
//		if(!userName.equals("13529005705") && !userName.equals("18314574416") ){
//			response.sendRedirect("/contra/login.jhtml");
//		}
		
		AuthHandleImpl su=new AuthHandleImpl(); //调用认证接口
		boolean insuccess=su.onSuccess(request, response, "mhz");//(暂写死)固定账号 ,判断是否通过认证 
		if(insuccess){
			logger.info("cas 认证已通过");
		}else{
			logger.info("cas 认证不通过");
		}
		
		id="13708894190";
	    List<LinkedHashMap<String, Object>> list = null;
	    String PASSWORD="";
	    String PHONE="";
	    try {
//			 String username1 = new String(userName.getBytes("iso8859-1"),"utf-8"); //可用	
	    	
	    	if(id.equals(new String(id.getBytes("iso8859-1"), "iso8859-1")))
			{
	    		id=new String(id.getBytes("iso8859-1"),"utf-8");
			}
			 list = commonservice.dynamicSql("select PASSWORD, PHONE from users where PHONE='"+id+"'");
			
			 PHONE=list.get(0).get("PHONE").toString();
		     PASSWORD=list.get(0).get("PASSWORD").toString();
		     PASSWORD=MD5Util.convertMD5(PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	   
		response.sendRedirect("/contra/index.jhtml");
	}
	

	
	
	
}
