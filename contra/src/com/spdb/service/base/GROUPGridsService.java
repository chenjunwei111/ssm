package com.spdb.service.base;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.spdb.pojo.base.GROUPGridsPojo;

/**
 * 地图栅格参数信息
 * 
 * @author Chan
 */

public interface GROUPGridsService {
	/** 地图栅格参数信息插入语句 */
	public void insert(GROUPGridsPojo pojo) throws Exception;

	/** 地图栅格参数信息删除语句 */
	public void delete(GROUPGridsPojo pojo) throws Exception;

	/** 地图栅格参数信息更新语句 */
	public void update(GROUPGridsPojo pojo) throws Exception;

	/** 地图栅格参数信息查询语句(参数form),根据条件查询出所有的数据集 */
	public List<GROUPGridsPojo> query(GROUPGridsPojo pojo) throws Exception;

	/** 地图栅格参数信息查询分页语句(参数form),根据条件查询出每页的数据集 */
	public PageInfo<GROUPGridsPojo> queryforpage(GROUPGridsPojo pojo,
			String field, String sort, Integer pageNo, Integer pageSize)
			throws Exception;

}
