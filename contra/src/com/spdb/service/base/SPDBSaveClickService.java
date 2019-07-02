package com.spdb.service.base;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.spdb.pojo.base.SPDBSaveClickPojo;

/**
 * 用户点击记录

 * @author Chan
*/

public interface SPDBSaveClickService {
	/**  用户点击记录插入语句*/
	public void insert(SPDBSaveClickPojo pojo) throws Exception; 

	/**  用户点击记录删除语句*/
	public void delete(SPDBSaveClickPojo pojo) throws Exception;

	/**  用户点击记录更新语句*/
	public void update(SPDBSaveClickPojo pojo) throws Exception; 

	/**  用户点击记录查询语句(参数form),根据条件查询出所有的数据集*/
	public List<SPDBSaveClickPojo> query(SPDBSaveClickPojo pojo) throws Exception;

	/**  用户点击记录查询分页语句(参数form),根据条件查询出每页的数据集*/
	public  PageInfo<SPDBSaveClickPojo> queryforpage(SPDBSaveClickPojo pojo,String field, String sort,Integer pageNo,Integer pageSize) throws Exception;

}
