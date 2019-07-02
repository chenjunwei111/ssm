package com.spdb.serviceImpl.admin;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spdb.pojo.admin.TROLEUserPojo;
import com.spdb.service.admin.TROLEUserService;
import com.spdb.mapper.admin.TROLEUserMapper;

/**
 * 用户权限
 * 
 * @author Chan
 */

@Service("tROLEUserService")
@Transactional
public class TROLEUserserviceImpl implements TROLEUserService {

	@Resource
	TROLEUserMapper tROLEUserMapper;

	/** 用户权限插入语句 */
	public void insert(TROLEUserPojo pojo) throws Exception {
		tROLEUserMapper.insert(pojo);
	}

	/** 用户权限删除语句 */
	@Transactional
	public void delete(TROLEUserPojo pojo) throws Exception {
		tROLEUserMapper.delete(pojo);
	}

	/** 用户权限更新语句 */
	public void update(TROLEUserPojo pojo) throws Exception {
		tROLEUserMapper.update(pojo);
	}

	/** 用户权限查询语句(参数form),根据条件查询出所有的数据集 */
	public List<TROLEUserPojo> query(TROLEUserPojo pojo) throws Exception {
		return tROLEUserMapper.query(pojo);
	}

	/** 用户权限查询分页语句(参数form),根据条件查询出每页的数据集 */
	public PageInfo<TROLEUserPojo> queryforpage(TROLEUserPojo pojo,
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

		List<TROLEUserPojo> list = tROLEUserMapper.query(pojo);
		PageInfo<TROLEUserPojo> page = new PageInfo<TROLEUserPojo>(list);
		return page;
	}

	@Override
	@Transactional
	public Integer insetListUser(List<TROLEUserPojo> tfList,String usesId[],String roleId) throws Exception {
	    if(tfList==null || usesId==null || usesId.length==0){
		//可以为角色清空用户，或者说：把所有的用户的勾选全部去掉再提交上来
		delete(new TROLEUserPojo(roleId,null));
//		deleteListUser(roleId,usesId);
		return 1;
	    }else{
//		deleteListUser(roleId,usesId);
		delete(new TROLEUserPojo(roleId,null));
		
		return tROLEUserMapper.insetListUser(tfList);
	    }
	}

	@Override
	@Transactional
	public Integer deleteListUser(String roleId, String[] userNames)
			throws Exception {
		return tROLEUserMapper.deleteListUser(roleId, userNames);
	}

}
