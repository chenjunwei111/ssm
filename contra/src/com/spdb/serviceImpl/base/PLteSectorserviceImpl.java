package com.spdb.serviceImpl.base;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spdb.pojo.base.PLteSectorPojo;
import com.spdb.service.base.PLteSectorService;
import com.spdb.mapper.base.PLteSectorMapper;

/**
 * 小区工参信息

 * @author Chan
*/

@Service("pLteSectorService")
public class PLteSectorserviceImpl implements PLteSectorService {

@Resource
PLteSectorMapper pLteSectorMapper;
	/**  小区工参信息插入语句*/
	public void insert(PLteSectorPojo pojo) throws Exception{ 
 pLteSectorMapper.insert(pojo);
}
	/**  小区工参信息删除语句*/
	public void delete(PLteSectorPojo pojo) throws Exception{
 pLteSectorMapper.delete(pojo);
}
	/**  小区工参信息更新语句*/
	public void update(PLteSectorPojo pojo) throws Exception{ 
 pLteSectorMapper.update(pojo);
}
	/**  小区工参信息查询语句(参数form),根据条件查询出所有的数据集*/
	public List<PLteSectorPojo> query(PLteSectorPojo pojo) throws Exception{
return pLteSectorMapper.query(pojo);
}
	/**  小区工参信息查询分页语句(参数form),根据条件查询出每页的数据集*/
	public  PageInfo<PLteSectorPojo> queryforpage(PLteSectorPojo pojo, Integer pageNo,Integer pageSize) throws Exception{
pageNo = pageNo == null ? 1 : pageNo;
pageSize = pageSize == null ? 10 : pageSize;
PageHelper.startPage(pageNo, pageSize);
List<PLteSectorPojo> list = pLteSectorMapper.query(pojo);
PageInfo<PLteSectorPojo> page = new PageInfo<PLteSectorPojo>(list);
return page;
}

}
