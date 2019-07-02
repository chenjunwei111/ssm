package com.spdb.mapper.base;

import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import com.spdb.pojo.base.SPDBSaveClickPojo;

/**
 * 用户点击记录 
 * @author Chan 
*/

@MapperScan
public interface SPDBSaveClickMapper {
	/**  用户点击记录插入语句*/
	public void insert(SPDBSaveClickPojo pojo) throws Exception; 

	/**  用户点击记录删除语句*/
	public void delete(SPDBSaveClickPojo pojo) throws Exception;

	/**  用户点击记录更新语句*/
	public void update(SPDBSaveClickPojo pojo) throws Exception; 

	/**  用户点击记录查询语句(参数form),根据条件查询出所有的数据集*/
	public List<SPDBSaveClickPojo> query(SPDBSaveClickPojo Pojo) throws Exception;

}
