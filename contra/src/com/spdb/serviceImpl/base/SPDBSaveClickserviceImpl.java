package com.spdb.serviceImpl.base;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.spdb.pojo.base.SPDBSaveClickPojo;
import com.spdb.service.base.SPDBSaveClickService;
import com.spdb.mapper.base.SPDBSaveClickMapper;

/**
 * 用户点击记录

 * @author Chan
*/

@Service("sPDBSaveClickService")
public class SPDBSaveClickserviceImpl implements SPDBSaveClickService {

@Resource
SPDBSaveClickMapper sPDBSaveClickMapper;
	/**  用户点击记录插入语句*/
	public void insert(SPDBSaveClickPojo pojo) throws Exception{ 
 sPDBSaveClickMapper.insert(pojo);
}
	/**  用户点击记录删除语句*/
	public void delete(SPDBSaveClickPojo pojo) throws Exception{
 sPDBSaveClickMapper.delete(pojo);
}
	/**  用户点击记录更新语句*/
	public void update(SPDBSaveClickPojo pojo) throws Exception{ 
 sPDBSaveClickMapper.update(pojo);
}
	/**  用户点击记录查询语句(参数form),根据条件查询出所有的数据集*/
	public List<SPDBSaveClickPojo> query(SPDBSaveClickPojo pojo) throws Exception{
return sPDBSaveClickMapper.query(pojo);
}
	/**  用户点击记录查询分页语句(参数form),根据条件查询出每页的数据集*/
	public  PageInfo<SPDBSaveClickPojo> queryforpage(SPDBSaveClickPojo pojo,String field, String sort,Integer pageNo,Integer pageSize) throws Exception{
pageNo = pageNo == null ? 1 : pageNo;
pageSize = pageSize == null ? 10 : pageSize;
PageHelper.startPage(pageNo, pageSize);
String order = ""; 
if (field != null && !field.trim().equals("")) {
if (field.equals("sectornum")) {
order = "sector_num";// 因为无法自动判断转化属性名。需要手动判断来写。
}
PageHelper.orderBy(order + " " + sort);// 单给一个排序,分页控件无法使用
}

List<SPDBSaveClickPojo> list = sPDBSaveClickMapper.query(pojo);
PageInfo<SPDBSaveClickPojo> page = new PageInfo<SPDBSaveClickPojo>(list);
return page;
}

}
