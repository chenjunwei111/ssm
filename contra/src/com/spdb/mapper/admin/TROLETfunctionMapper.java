package com.spdb.mapper.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.spdb.pojo.admin.TROLETfunctionPojo;

/**
 * 用户权限 
 * @author Chan 
*/

@MapperScan
public interface TROLETfunctionMapper {
	/**  用户权限插入语句*/
	public Integer insert(TROLETfunctionPojo pojo) throws Exception; 

	/**  用户权限删除语句*/
	public Integer delete(TROLETfunctionPojo pojo) throws Exception;

	/**  用户权限更新语句*/
	public Integer update(TROLETfunctionPojo pojo) throws Exception; 

	/**  用户权限查询语句(参数form),根据条件查询出所有的数据集*/
	public List<TROLETfunctionPojo> query(TROLETfunctionPojo Pojo) throws Exception;

	
	/**
	 * 批量插入角色功能
	 * @param tfList
	 * @return
	 * @throws Exception
	 */
	public Integer insetListFun(List<TROLETfunctionPojo> tfList)throws Exception;
	
	/**
	 * 批量删除角色功能
	 * 
	 * @return
	 * @throws Exception
	 */
	public Integer deleteListFun(@Param("roleId") String roleId,@Param("funNames") String[] funNames)throws Exception;
	
}
