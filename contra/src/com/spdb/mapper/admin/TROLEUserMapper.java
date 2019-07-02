package com.spdb.mapper.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.spdb.pojo.admin.TROLEUserPojo;

/**
 * 用户权限 
 * @author Chan 
*/

@MapperScan
public interface TROLEUserMapper {
	/**  用户权限插入语句*/
	public Integer insert(TROLEUserPojo pojo) throws Exception; 

	/**  用户权限删除语句*/
	public Integer delete(TROLEUserPojo pojo) throws Exception;

	/**  用户权限更新语句*/
	public Integer update(TROLEUserPojo pojo) throws Exception; 

	/**  用户权限查询语句(参数form),根据条件查询出所有的数据集*/
	public List<TROLEUserPojo> query(TROLEUserPojo Pojo) throws Exception;
	
	
	/**
	 * 批量插入角色用户
	 * @param tfList
	 * @return
	 * @throws Exception
	 */
	public Integer insetListUser(List<TROLEUserPojo> tfList)throws Exception;
	
	/**
	 * 批量删除角色用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public Integer deleteListUser(@Param("roleId") String roleId,@Param("userNames") String[] userNames)throws Exception;


}
