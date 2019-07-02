package com.spdb.serviceImpl.admin;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spdb.pojo.admin.TROLEDepartmentPojo;
import com.spdb.service.admin.TROLEDepartmentService;
import com.spdb.mapper.admin.TROLEDepartmentMapper;

/**
 * 角色部门
 * 
 * @author Chan
 */

@Service("tROLEDepartmentService")
@Transactional 
public class TROLEDepartmentserviceImpl implements TROLEDepartmentService {

	@Resource
	TROLEDepartmentMapper tROLEDepartmentMapper;

	/** 角色部门插入语句 */
	public Integer insert(TROLEDepartmentPojo pojo) throws Exception {
		return tROLEDepartmentMapper.insert(pojo);
	}

	/** 角色部门删除语句 */
	@Transactional(propagation=Propagation.REQUIRED) 	
	public Integer delete(TROLEDepartmentPojo pojo) throws Exception {
		return tROLEDepartmentMapper.delete(pojo);
	}

	/** 角色部门更新语句 */
	public Integer update(TROLEDepartmentPojo pojo) throws Exception {
		return tROLEDepartmentMapper.update(pojo);
	}

	/** 角色部门查询语句(参数form),根据条件查询出所有的数据集 */
	public List<TROLEDepartmentPojo> query(TROLEDepartmentPojo pojo)
			throws Exception {
		return tROLEDepartmentMapper.query(pojo);
	}

	/** 角色部门查询分页语句(参数form),根据条件查询出每页的数据集 */
	public PageInfo<TROLEDepartmentPojo> queryforpage(TROLEDepartmentPojo pojo,
			String field, String sort, Integer pageNo, Integer pageSize)
			throws Exception {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		String order = "";
		if (field != null && !field.trim().equals("")) {
			if (field.equals("sectornum")) {
				order = "sector_num";// 因为无法自动判断转化属性名。需要手动判断来写。
			}
			PageHelper.orderBy(order + " " + sort);// 单给一个排序,分页控件无法使用
		}

		List<TROLEDepartmentPojo> list = tROLEDepartmentMapper.query(pojo);
		PageInfo<TROLEDepartmentPojo> page = new PageInfo<TROLEDepartmentPojo>(
				list);
		return page;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED) 
	public Integer insetListDept(List<TROLEDepartmentPojo> tfList,
			String roleId, String[] deptNames) throws Exception {
			delete(new TROLEDepartmentPojo(roleId,null));
			return tROLEDepartmentMapper.insetListDept(tfList);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED) 
	public Integer deleteListDept(String roleId, String[] deptNames)
			throws Exception {
		return tROLEDepartmentMapper.deleteListDept(roleId, deptNames);
	}

}
