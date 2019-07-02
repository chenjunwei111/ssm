package com.spdb.service.admin;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.spdb.pojo.admin.TrolePojo;

/**
 * 用户权限

 * @author Chan
*/

public interface TroleService {
	/**  用户权限插入语句*/
	public Integer insert(TrolePojo pojo) throws Exception; 

	/**  用户权限删除语句*/
	public Integer delete(TrolePojo pojo) throws Exception;

	/**  用户权限更新语句*/
	public void update(TrolePojo pojo) throws Exception; 

	/**  用户权限查询语句(参数form),根据条件查询出所有的数据集*/
	public List<TrolePojo> query(TrolePojo pojo) throws Exception;

	/**  用户权限查询分页语句(参数form),根据条件查询出每页的数据集*/
	public  PageInfo<TrolePojo> queryforpage(TrolePojo pojo,String field, String sort,Integer pageNo,Integer pageSize) throws Exception;

	public Integer updateRole(TrolePojo pojo) throws Exception; 

}
