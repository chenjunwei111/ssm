package com.spdb.mapper.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.spdb.pojo.admin.TROLEDepartmentPojo;
import com.spdb.pojo.admin.TROLETfunctionPojo;

/**
 * 角色部门 
 * @author Chan 
*/

@MapperScan
public interface TROLEDepartmentMapper {
	/**  角色部门插入语句*/
	public Integer insert(TROLEDepartmentPojo pojo) throws Exception; 

	/**  角色部门删除语句*/
	public Integer delete(TROLEDepartmentPojo pojo) throws Exception;

	/**  角色部门更新语句*/
	public Integer update(TROLEDepartmentPojo pojo) throws Exception; 

	/**  角色部门查询语句(参数form),根据条件查询出所有的数据集*/
	public List<TROLEDepartmentPojo> query(TROLEDepartmentPojo Pojo) throws Exception;

	
	
	/**
	 * 批量插入角色部门
	 * @param tfList
	 * @return
	 * @throws Exception
	 */
	public Integer insetListDept(List<TROLEDepartmentPojo> tfList)throws Exception;
	
	/**
	 * 批量删除角色部门
	 * 
	 * @return
	 * @throws Exception
	 */
	public Integer deleteListDept(@Param("roleId") String roleId,@Param("deptNames") String[] deptNames)throws Exception;
	
}
