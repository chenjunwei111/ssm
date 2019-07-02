package com.spdb.service.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.spdb.pojo.admin.TROLEUserPojo;

/**
 * 用户权限

 * @author Chan
*/

public interface TROLEUserService {
	/**  用户权限插入语句*/
	public void insert(TROLEUserPojo pojo) throws Exception; 

	/**  用户权限删除语句*/
	public void delete(TROLEUserPojo pojo) throws Exception;

	/**  用户权限更新语句*/
	public void update(TROLEUserPojo pojo) throws Exception; 

	/**  用户权限查询语句(参数form),根据条件查询出所有的数据集*/
	public List<TROLEUserPojo> query(TROLEUserPojo pojo) throws Exception;

	/**  用户权限查询分页语句(参数form),根据条件查询出每页的数据集*/
	public  PageInfo<TROLEUserPojo> queryforpage(TROLEUserPojo pojo,String field, String sort,Integer pageNo,Integer pageSize) throws Exception;

	
	/**
	 * 批量插入角色用户
	 * @param tfList
	 * @return
	 * @throws Exception
	 */
	public Integer insetListUser(List<TROLEUserPojo> tfList,String usesId[],String roleId)throws Exception;
	
	/**
	 * 批量删除角色用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public Integer deleteListUser( String roleId, String[] userNames)throws Exception;

}
