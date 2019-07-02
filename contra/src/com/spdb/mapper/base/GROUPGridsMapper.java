package com.spdb.mapper.base;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.spdb.pojo.base.GROUPGridsPojo;

/**
 * 地图栅格参数信息 
 * @author Chan 
*/

@MapperScan
public interface GROUPGridsMapper {
	/**  地图栅格参数信息插入语句*/
	public void insert(GROUPGridsPojo pojo) throws Exception; 

	/**  地图栅格参数信息删除语句*/
	public void delete(GROUPGridsPojo pojo) throws Exception;

	/**  地图栅格参数信息更新语句*/
	public void update(GROUPGridsPojo pojo) throws Exception; 

	/**  地图栅格参数信息查询语句(参数form),根据条件查询出所有的数据集*/
	public List<GROUPGridsPojo> query(GROUPGridsPojo Pojo) throws Exception;

}
