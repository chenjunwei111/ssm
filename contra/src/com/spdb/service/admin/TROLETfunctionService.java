package com.spdb.service.admin;

import java.util.List;


import com.github.pagehelper.PageInfo;
import com.spdb.pojo.admin.TROLETfunctionPojo;

/**
 * 用户权限

 * @author Chan
*/

public interface TROLETfunctionService {
	/**  用户权限插入语句*/
	public void insert(TROLETfunctionPojo pojo) throws Exception; 

	/**  用户权限删除语句*/
	public void delete(TROLETfunctionPojo pojo) throws Exception;

	/**  用户权限更新语句*/
	public void update(TROLETfunctionPojo pojo) throws Exception; 

	/**  用户权限查询语句(参数form),根据条件查询出所有的数据集*/
	public List<TROLETfunctionPojo> query(TROLETfunctionPojo pojo) throws Exception;

	/**  用户权限查询分页语句(参数form),根据条件查询出每页的数据集*/
	public  PageInfo<TROLETfunctionPojo> queryforpage(TROLETfunctionPojo pojo,String field, String sort,Integer pageNo,Integer pageSize) throws Exception;

	/**
	 * 批量插入角色功能
	 * @param tfList
	 * @return
	 * @throws Exception
	 */
	public Integer insetListFun(List<TROLETfunctionPojo> tfList,String roleFun[],String roleId)throws Exception;

	/**
	 * 批量删除角色功能
	 * @param tfList
	 * @return
	 * @throws Exception
	 */
	public Integer deleteListFun(String  roleId,String[] funNames)throws Exception;

}
