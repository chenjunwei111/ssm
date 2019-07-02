package com.spdb.serviceImpl.admin;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spdb.pojo.admin.UsersPojo;
import com.spdb.service.admin.UsersService;
import com.spdb.mapper.admin.UsersMapper;

/**
 * 用户权限
 * 
 * @author Chan
 */

@Service("usersService")
public class UsersserviceImpl implements UsersService {

	@Resource
	UsersMapper usersMapper;

	/** 用户权限插入语句 */
	@Transactional
	public Integer insert(UsersPojo pojo) throws Exception {
		return usersMapper.insert(pojo);
	}

	/** 用户权限删除语句 */
	public Integer delete(UsersPojo pojo) throws Exception {
		return usersMapper.delete(pojo);
	}

	/** 用户权限更新语句 */
	@Transactional
	public Integer update(UsersPojo pojo) throws Exception {
		return usersMapper.update(pojo);
	}

	/** 用户权限查询语句(参数form),根据条件查询出所有的数据集 */
	public List<UsersPojo> query(UsersPojo pojo) throws Exception {
		return usersMapper.query(pojo);
	}

	/** 用户权限查询分页语句(参数form),根据条件查询出每页的数据集 */
	public PageInfo<UsersPojo> queryforpage(UsersPojo pojo, String field,
			String sort, Integer pageNo, Integer pageSize) throws Exception {
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

		List<UsersPojo> list = usersMapper.query(pojo);
		PageInfo<UsersPojo> page = new PageInfo<UsersPojo>(list);
		return page;
	}

}
