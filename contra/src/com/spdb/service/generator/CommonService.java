package com.spdb.service.generator;

import com.github.pagehelper.PageInfo;
import com.spdb.pojo.generator.PartitionPojo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface CommonService {

	/**
	 * 判断表中是否包含数据
	 * 
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer existSPData(Map<String, Object> map) throws Exception;

	
	/**
	 * 判断表中是否包含数据
	 * 
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public Integer existSPData2(Map<String, Object> map) throws Exception;
	
	
	/**
	 * 获取分区表中的所有对应地市下的子分区信息
	 * 
	 * @param pojo
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>> selectSP(PartitionPojo pojo)
			throws Exception;

	/**
	 * 动态SQL
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<LinkedHashMap<String, Object>> dynamicSql(String sql)
			throws Exception;

	/**
	 * 分页的动态sql查询
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public PageInfo<LinkedHashMap<String, Object>> dynamicSqlforpage(
			String sql, Integer pageNo, Integer pageSize) throws Exception;
	
	
	
	/**
	 * 动态SQL
	 * @param sql
	 * @return int数据类型
 	 */
	public int dynamicSqltoInt(String sql);
	
	
	/**
	 * 动态插入SQL
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public int  dynamicSqlinsert(String sql)throws Exception;
	
	/**
	 * 动态更新SQL
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public int  dynamicSqlUpdate(String sql)throws Exception;
	
	/**
	 * 动态删除SQL
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public int  dynamicSqlDelete(String sql)throws Exception;
	
	/**
	 * 动态多语句增删改SQL
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public int  dynamicMutilSqlsOnTrans(ArrayList<String> sqls)throws Exception;


	/**分区存储过程
	 * @param param
	 * @throws Exception
	 */
	public  void execproState(Map<String, String> param ) throws Exception;
}