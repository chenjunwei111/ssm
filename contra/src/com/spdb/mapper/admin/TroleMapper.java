package com.spdb.mapper.admin;

import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import com.spdb.pojo.admin.TrolePojo;

/**
 * 用户权限 
 * @author Chan 
*/

@MapperScan
public interface TroleMapper {
	/**  用户权限插入语句*/
	public Integer insert(TrolePojo pojo) throws Exception; 

	/**  用户权限删除语句*/
	public Integer delete(TrolePojo pojo) throws Exception;

	/**  用户权限更新语句*/
	public void update(TrolePojo pojo) throws Exception; 
	
	/**  用户权限更新语句(修正)*/
	public Integer updateRole(TrolePojo pojo) throws Exception; 
	

	/**  用户权限查询语句(参数form),根据条件查询出所有的数据集*/
	public List<TrolePojo> query(TrolePojo Pojo) throws Exception;

}
