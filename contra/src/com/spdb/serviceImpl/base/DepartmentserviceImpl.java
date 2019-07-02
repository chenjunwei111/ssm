package com.spdb.serviceImpl.base;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.spdb.pojo.base.DepartmentPojo;
import com.spdb.service.base.DepartmentService;
import com.spdb.mapper.base.DepartmentMapper;

/**
 * 部门信息
 * 
 * @author Chan
 */

@Service("departmentService")
public class DepartmentserviceImpl implements DepartmentService {

	@Resource
	DepartmentMapper departmentMapper;

	/** 部门信息插入语句 */
	public Integer insert(DepartmentPojo pojo) throws Exception {
		return departmentMapper.insert(pojo);
	}

	/** 部门信息删除语句 */
	public Integer delete(DepartmentPojo pojo) throws Exception {
		return departmentMapper.delete(pojo);
	}

	/** 部门信息更新语句 */
	public Integer update(DepartmentPojo pojo) throws Exception {
		return departmentMapper.update(pojo);
	}

	/** 部门信息查询语句(参数form),根据条件查询出所有的数据集 */
	public List<DepartmentPojo> query(DepartmentPojo pojo) throws Exception {
		return departmentMapper.query(pojo);
	}

	/** 部门信息查询分页语句(参数form),根据条件查询出每页的数据集 */
	public PageInfo<DepartmentPojo> queryforpage(DepartmentPojo pojo,
			Integer pageNo, Integer pageSize) throws Exception {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<DepartmentPojo> list = departmentMapper.query(pojo);
		PageInfo<DepartmentPojo> page = new PageInfo<DepartmentPojo>(list);
		return page;
	}

}
