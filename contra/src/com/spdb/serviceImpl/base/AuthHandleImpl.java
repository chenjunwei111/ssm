package com.spdb.serviceImpl.base;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spdb.common.ConfigReaderUtils;
import com.spdb.service.generator.CommonService;
import org.apache.log4j.Logger;
import org.jasig.cas.client.authentication.AttributePrincipal;

import com.bonc.sso.client.IAuthHandle;

/**
 * 认证中心登录成功，回调 Handle
 * @author by mhz
 *
 */
public class AuthHandleImpl implements IAuthHandle {


    protected Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rs;

	@Resource
	CommonService commonservice;

	@Override
	public boolean onSuccess(HttpServletRequest request, HttpServletResponse response,String logid) {
		Logger logger=Logger.getLogger(AuthHandleImpl.class);
		try {
			AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
			Map<String , Object> map = principal.getAttributes();
            logger.info("CAS对象信息"+map);
            String name=map.get("userName").toString();
			String sql="select * from users where user_Name='"+name+"' ";
			Object a1[]=new Object[0];
//            logger.info("该sql"+sql);
            ResultSet listName=executeSQL(sql,a1);
            listName.last();
            logger.info(listName);
            if(listName.getRow()==0){
				logger.info("该对象无权限登录-CAS对象信息"+map);
				return false;
			}

				logger.info("可登录CAS对象信息"+map);
				return true;

		} catch (Exception e) {
			logger.info("错误码", e);
            e.printStackTrace();
			return false;
		}
	}
	
	public Map<String, Object> getMapData(HttpServletRequest request) {
		AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
		Map<String , Object> map = principal.getAttributes();
		return map;
	}


    // 建立连接
    public boolean getConnection() {
        String driver = ConfigReaderUtils.getProperty("driver");
        String url = ConfigReaderUtils.getProperty("url");
        String username = ConfigReaderUtils.getProperty("username");
        String password = ConfigReaderUtils.getProperty("password");
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    // 查询
    public ResultSet executeSQL(String sql, Object[] params) {
        getConnection();
        try {
            ps = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // 填充占位符
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // 关闭资源
    public boolean closeResource() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }


}