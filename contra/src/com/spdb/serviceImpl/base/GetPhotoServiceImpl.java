package com.spdb.serviceImpl.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.spdb.common.ConfigReaderUtils;
import com.spdb.service.base.GetPhotoService;
import com.spdb.service.generator.CommonService;
 

/**
 * 地图栅格参数信息

 * @author YINQIN
*/

@Service("GetPhotoServiceImpl")
public class GetPhotoServiceImpl implements GetPhotoService {
	@Resource
	CommonService commonservice;
	
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	@Autowired
    private DataSourceTransactionManager txManager;
	
	
	
	@Override
	//@Transactional(noRollbackFor = TransactionalException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED, timeout = 30)
	public String selectOrderImg(String orderNum) throws Exception {
	   return execute(orderNum);
	}
	
	public String execute(String orderNum) {
		Statement stmt = null;
		try {
			// 建立连接
			getConnection();
			String sql="select site_photos from P_WORK_LIST_District where ORDERNUMBER='"+orderNum+"'";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			String site_photos = "";
			while(rs.next()){
		        site_photos = rs.getString(1);
			}
			closeResource();
			return site_photos;
			
		} catch (Exception e) {
			closeResource();
			return "";
		}
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

	// 增加，修改，删除
	public int executeUpdate(String sql, Object[] params) {
		getConnection();
		int updateRow = 0;
		try {
			ps = conn.prepareStatement(sql);
			// 填充占位符
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			updateRow = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateRow;
	}

	//
	// 查询
	public ResultSet executeSQL(String sql, Object[] params) {
		getConnection();

		try {
			ps = conn.prepareStatement(sql);
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
