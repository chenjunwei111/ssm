package com.spdb.service.base;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.spdb.pojo.base.PLteSectorPojo;

/**
 * 小区工参信息

 * @author Chan
*/

public interface PLteSectorService {
	/**  小区工参信息插入语句*/
	public void insert(PLteSectorPojo pojo) throws Exception; 

	/**  小区工参信息删除语句*/
	public void delete(PLteSectorPojo pojo) throws Exception;

	/**  小区工参信息更新语句*/
	public void update(PLteSectorPojo pojo) throws Exception; 

	/**  小区工参信息查询语句(参数form),根据条件查询出所有的数据集*/
	public List<PLteSectorPojo> query(PLteSectorPojo pojo) throws Exception;

	/**  小区工参信息查询分页语句(参数form),根据条件查询出每页的数据集*/
	public  PageInfo<PLteSectorPojo> queryforpage(PLteSectorPojo pojo,Integer pageNo,Integer pageSize) throws Exception;

}
