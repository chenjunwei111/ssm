package com.spdb.shiro;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.spdb.common.MD5Util;
import com.spdb.service.generator.CommonService;

/**
 * shiro拦截器
 * @author Chan
 */
public class CustomRealm extends AuthorizingRealm {
	
	
	@Resource
	CommonService commonservice;
	
	/**
	 * 授权
	 * 
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
//		System.out.println("SHIRO授权");
//		String userName = (String) principalCollection.getPrimaryPrincipal();
//		List<String> permissionList = new ArrayList<String>();
//		permissionList.add("user:add");
//		permissionList.add("user:delete");
//		if (userName.equals("xiaotijun")) {
//			permissionList.add("user:query");
//		}
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.addStringPermissions(permissionList);
//		info.addRole("admin");
		
		System.out.println("进入权限赋值");
        Set<String> roleNames = new HashSet<String>();  
        Set<String> permissions = new HashSet<String>();  
        roleNames.add("administrator");//添加角色
        permissions.add("newPage.jhtml");  //添加权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);  
        info.setStringPermissions(permissions);  
        
        //创建授权信息对象
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        
		return info;
	}

	/**
	 * 认证
	 * 
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {
		String userName = (String) authenticationToken.getPrincipal();
		String checksql="";
//		如果是管理员账号另外查
		if(userName.equals("admin")||userName.equals("admin1")){
			checksql="select * from Users where  USER_NAME='"+userName+"'";
		}else {
			checksql="select * from Users where  PHONE='"+userName+"'";
		}
		
//		逻辑判断获取数据 用户信息
		String psd=null;
		List<LinkedHashMap<String, Object>> users = null;
		try {
			users = commonservice.dynamicSql(checksql);
		} catch (Exception e) {
			e.printStackTrace();
		}
        if(users.size()!=0){
        	if(!users.get(0).get("ISVALID").toString().equals("1")){
        			throw new LockedAccountException();
        	}else {
        		 psd=MD5Util.convertMD5(users.get(0).get("PASSWORD").toString());
			} 	
        }else {
        	throw new UnknownAccountException();
		}
//        System.out.println("数据库账号："+userName+"密码："+psd);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName,
					psd, this.getName());
		return info;
	}
}