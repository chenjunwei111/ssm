package com.spdb.serviceImpl.admin;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spdb.pojo.admin.TrolePojo;
import com.spdb.service.admin.TroleService;
import com.spdb.mapper.admin.TroleMapper;

/**
 * 用户权限
 * 
 * @author Chan
 */

@Service("troleService")
public class TroleserviceImpl implements TroleService {

	@Resource
	TroleMapper troleMapper;

	/** 用户权限插入语句 */
    @Transactional
	public Integer insert(TrolePojo pojo) throws Exception {
		return troleMapper.insert(pojo);
	}

	/** 用户权限删除语句 */
    @Transactional
	public Integer delete(TrolePojo pojo) throws Exception {
		return troleMapper.delete(pojo);
	}

	/** 用户权限更新语句 */
	public void update(TrolePojo pojo) throws Exception {
		troleMapper.update(pojo);
	}

	/** 用户权限查询语句(参数form),根据条件查询出所有的数据集 */
	public List<TrolePojo> query(TrolePojo pojo) throws Exception {
		return troleMapper.query(pojo);
	}

	/** 用户权限查询分页语句(参数form),根据条件查询出每页的数据集 */
	public PageInfo<TrolePojo> queryforpage(TrolePojo pojo, String field,
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

		List<TrolePojo> list = troleMapper.query(pojo);
		PageInfo<TrolePojo> page = new PageInfo<TrolePojo>(list);
		return page;
	}

	@Transactional
	@Override
	public Integer updateRole(TrolePojo pojo) throws Exception {
		return troleMapper.updateRole(pojo);
	}

}
