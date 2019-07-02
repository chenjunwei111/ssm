package com.spdb.mapper.base;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.spdb.pojo.base.PLteSectorPojo;

/**
 * 小区工参信息 
 * @author Chan 
*/

@MapperScan
public interface PLteSectorMapper {
	/**  小区工参信息插入语句*/
	public void insert(PLteSectorPojo pojo) throws Exception; 

	/**  小区工参信息删除语句*/
	public void delete(PLteSectorPojo pojo) throws Exception;

	/**  小区工参信息更新语句*/
	public void update(PLteSectorPojo pojo) throws Exception; 

	/**  小区工参信息查询语句(参数form),根据条件查询出所有的数据集*/
	public List<PLteSectorPojo> query(PLteSectorPojo Pojo) throws Exception;

}
