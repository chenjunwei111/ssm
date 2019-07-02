package com.spdb.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.spdb.pojo.base.Menu;

@MapperScan
public interface MenuMapper {
	
	/**
	 * 所有查询功能
	 * @return
	 */
	public  List<Menu> queryMenuList();
	
	/**
	 * 查询制定用户拥有的功能
	 * @return
	 */
	public  List<Menu> queryMenuListCode(@Param("userCode") String userCode);
	/**
	 * 插入功能
	 * @param menu
	 * @return
	 */
	public Integer insert(Menu menu);
	
	
	/**  功能更新语句*/
	public Integer update(Menu menu) throws Exception; 
}
