package com.spdb.mapper.admin;

import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import com.spdb.pojo.admin.UsersPojo;

/**
 * 用户权限 
 * @author Chan 
*/

@MapperScan
public interface UsersMapper {
	/**  用户权限插入语句*/
	public Integer insert(UsersPojo pojo) throws Exception; 

	/**  用户权限删除语句*/
	public Integer delete(UsersPojo pojo) throws Exception;

	/**  用户权限更新语句*/
	public Integer update(UsersPojo pojo) throws Exception; 

	/**  用户权限查询语句(参数form),根据条件查询出所有的数据集*/
	public List<UsersPojo> query(UsersPojo Pojo) throws Exception;

}
