package com.spdb.mapper.base;

import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import com.spdb.pojo.base.DepartmentPojo;

/**
 * 部门信息 
 * @author Chan 
*/

@MapperScan
public interface DepartmentMapper {
	/**  部门信息插入语句*/
	public Integer insert(DepartmentPojo pojo) throws Exception; 

	/**  部门信息删除语句*/
	public Integer delete(DepartmentPojo pojo) throws Exception;

	/**  部门信息更新语句*/
	public Integer update(DepartmentPojo pojo) throws Exception; 

	/**  部门信息查询语句(参数form),根据条件查询出所有的数据集*/
	public List<DepartmentPojo> query(DepartmentPojo Pojo) throws Exception;

}
