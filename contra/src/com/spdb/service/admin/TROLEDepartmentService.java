package com.spdb.service.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.spdb.pojo.admin.TROLEDepartmentPojo;

/**
 * 角色部门

 * @author Chan
*/

public interface TROLEDepartmentService {
	/**  角色部门插入语句*/
	public Integer insert(TROLEDepartmentPojo pojo) throws Exception; 

	/**  角色部门删除语句*/
	public Integer delete(TROLEDepartmentPojo pojo) throws Exception;

	/**  角色部门更新语句*/
	public Integer update(TROLEDepartmentPojo pojo) throws Exception; 

	/**  角色部门查询语句(参数form),根据条件查询出所有的数据集*/
	public List<TROLEDepartmentPojo> query(TROLEDepartmentPojo pojo) throws Exception;

	/**  角色部门查询分页语句(参数form),根据条件查询出每页的数据集*/
	public  PageInfo<TROLEDepartmentPojo> queryforpage(TROLEDepartmentPojo pojo,String field, String sort,Integer pageNo,Integer pageSize) throws Exception;

	
	/**
	 * 批量插入角色部门
	 * @param tfList
	 * @return
	 * @throws Exception
	 */
	public Integer insetListDept(List<TROLEDepartmentPojo> tfList,String roleId,String[] deptNames)throws Exception;
	
	/**
	 * 批量删除角色部门
	 * 
	 * @return
	 * @throws Exception
	 */
	public Integer deleteListDept(String roleId,String[] deptNames)throws Exception;
	
}
