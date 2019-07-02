package com.spdb.serviceImpl.generator;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spdb.exception.TransactionalException;
import com.spdb.mapper.generator.CommonMapper;
import com.spdb.pojo.generator.PartitionPojo;
import com.spdb.service.generator.CommonService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	@Resource
	CommonMapper Mapper;

	public static Logger logger=Logger.getLogger(CommonServiceImpl.class);

	
	@Override
	public Integer existSPData(Map<String, Object> map) throws Exception {
		return Mapper.existSPData(map);
	}

	@Override
	public List<LinkedHashMap<String, Object>> selectSP(PartitionPojo pojo)
			throws Exception {
		return Mapper.selectSP(pojo);
	}

	@Override
	public List<LinkedHashMap<String, Object>> dynamicSql(String sql)
			throws Exception {
		return Mapper.dynamicSql(sql);
	}

	@Override
	public PageInfo<LinkedHashMap<String, Object>> dynamicSqlforpage(
			String sql, Integer pageNo, Integer pageSize)  throws Exception{
//		try {
			pageNo = pageNo == null ? 1 : pageNo;
			pageSize = pageSize == null ? 10 : pageSize;
			PageHelper.startPage(pageNo, pageSize);
			List<LinkedHashMap<String, Object>> list = Mapper.dynamicSql(sql);
			PageInfo<LinkedHashMap<String, Object>> page = new PageInfo<LinkedHashMap<String, Object>>(
					list);
			return page;
//		} catch (Exception e) {
//			logger.error("错误信息:"+e.getMessage(),e);
//			return null;
//		}
	
	}

	@Override
	public int dynamicSqltoInt(String sql) {
		return Mapper.dynamicSqltoInt(sql);
	}

	@Override
	public Integer existSPData2(Map<String, Object> map) throws Exception {
		return Mapper.existSPData2(map);
	}

	@Override
	@Transactional
	public int dynamicSqlinsert(String sql) throws Exception {
		return Mapper.dynamicSqlinsert(sql);
	}

	@Override
	@Transactional
	public int dynamicSqlUpdate(String sql) throws Exception {
		return Mapper.dynamicSqlUpdate(sql);
	}

	@Override
	@Transactional(noRollbackFor = TransactionalException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED, timeout = 30)
	public int dynamicMutilSqlsOnTrans(ArrayList<String>  sqls) throws Exception {
		int r=-1;
		for(String sql:sqls)
		{
			r=-1;
			if(sql.trim().toLowerCase().startsWith("delete"))
			{
				r=Mapper.dynamicSqlDelete(sql);
			}
			else if(sql.trim().toLowerCase().startsWith("update"))
			{
				r= Mapper.dynamicSqlUpdate(sql);
			}
			else if(sql.trim().toLowerCase().startsWith("insert"))
			{
				r= Mapper.dynamicSqlinsert(sql);
			}
			if(r==-1)
				return -1;
		}
		return r;
	}

	@Override
	public void execproState(Map<String, String> param) throws Exception {
		 Mapper.execproState(param);
	}

	@Override
	@Transactional
	public int dynamicSqlDelete(String sql) throws Exception {
		return Mapper.dynamicSqlDelete(sql);
	}

}
