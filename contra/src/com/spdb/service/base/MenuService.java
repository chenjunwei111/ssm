package com.spdb.service.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spdb.pojo.base.Menu;

public interface MenuService {
	
	/**查询所有功能
	 * @return
	 */
	public  List<Menu> queryMenuList();
	
	/**
	 * 插入功能
	 * @param menu
	 * @return
	 */
	public Integer insert(Menu menu);
	
	/**  功能更新语句*/
	public Integer update(Menu menu) throws Exception; 
	
	
	/**
	 * 查询制定用户拥有的功能
	 * @return
	 */
	public  List<Menu> queryMenuListCode(@Param("userCode") String userCode);
}
