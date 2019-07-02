package com.spdb.service.base;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.spdb.pojo.base.DepartmentPojo;

/**
 * 部门信息

 * @author Chan
*/

public interface DepartmentService {
	/**  部门信息插入语句*/
	public Integer insert(DepartmentPojo pojo) throws Exception; 

	/**  部门信息删除语句*/
	public Integer delete(DepartmentPojo pojo) throws Exception;

	/**  部门信息更新语句*/
	public Integer update(DepartmentPojo pojo) throws Exception; 

	/**  部门信息查询语句(参数form),根据条件查询出所有的数据集*/
	public List<DepartmentPojo> query(DepartmentPojo pojo) throws Exception;

	/**  部门信息查询分页语句(参数form),根据条件查询出每页的数据集*/
	public  PageInfo<DepartmentPojo> queryforpage(DepartmentPojo pojo,Integer pageNo,Integer pageSize) throws Exception;

}
