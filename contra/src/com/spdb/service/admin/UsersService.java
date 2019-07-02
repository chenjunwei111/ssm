package com.spdb.service.admin;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.spdb.pojo.admin.UsersPojo;

/**
 * 用户权限

 * @author Chan
*/

public interface UsersService {
	/**  用户权限插入语句*/
	public Integer insert(UsersPojo pojo) throws Exception; 

	/**  用户权限删除语句*/
	public Integer delete(UsersPojo pojo) throws Exception;

	/**  用户权限更新语句*/
	public Integer update(UsersPojo pojo) throws Exception; 

	/**  用户权限查询语句(参数form),根据条件查询出所有的数据集*/
	public List<UsersPojo> query(UsersPojo pojo) throws Exception;

	/**  用户权限查询分页语句(参数form),根据条件查询出每页的数据集*/
	public  PageInfo<UsersPojo> queryforpage(UsersPojo pojo,String field, String sort,Integer pageNo,Integer pageSize) throws Exception;

}
