package com.spdb.serviceImpl.admin;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spdb.pojo.admin.TROLETfunctionPojo;
import com.spdb.service.admin.TROLETfunctionService;
import com.spdb.mapper.admin.TROLETfunctionMapper;

/**
 * 用户权限
 * 
 * @author Chan
 */

@Service("tROLETfunctionService")
public class TROLETfunctionserviceImpl implements TROLETfunctionService {

	@Resource
	TROLETfunctionMapper tROLETfunctionMapper;

	/** 用户权限插入语句 */
	public void insert(TROLETfunctionPojo pojo) throws Exception {
		tROLETfunctionMapper.insert(pojo);
	}

	/** 用户权限删除语句 */
	public void delete(TROLETfunctionPojo pojo) throws Exception {
		tROLETfunctionMapper.delete(pojo);
	}

	/** 用户权限更新语句 */
	public void update(TROLETfunctionPojo pojo) throws Exception {
		tROLETfunctionMapper.update(pojo);
	}

	/** 用户权限查询语句(参数form),根据条件查询出所有的数据集 */
	public List<TROLETfunctionPojo> query(TROLETfunctionPojo pojo)
			throws Exception {
		return tROLETfunctionMapper.query(pojo);
	}

	/** 用户权限查询分页语句(参数form),根据条件查询出每页的数据集 */
	public PageInfo<TROLETfunctionPojo> queryforpage(TROLETfunctionPojo pojo,
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

		List<TROLETfunctionPojo> list = tROLETfunctionMapper.query(pojo);
		PageInfo<TROLETfunctionPojo> page = new PageInfo<TROLETfunctionPojo>(
				list);
		return page;
	}

	@Override
	@Transactional
	public Integer insetListFun(List<TROLETfunctionPojo> tfList,String roleFun[],String roleId)
			throws Exception {
//			deleteListFun(roleId,roleFun);//	插入前执行删除操作
		delete(new TROLETfunctionPojo(roleId,null));	
		return tROLETfunctionMapper.insetListFun(tfList);
	}

	@Override
	@Transactional
	public Integer deleteListFun(String roleId, String[] funNames)
			throws Exception {
		return tROLETfunctionMapper.deleteListFun(roleId, funNames);
	}

	
}
