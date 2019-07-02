package com.spdb.serviceImpl.base;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spdb.pojo.base.GROUPGridsPojo;
import com.spdb.service.base.GROUPGridsService;
import com.spdb.mapper.base.GROUPGridsMapper;

/**
 * 地图栅格参数信息

 * @author Chan
*/

@Service("gROUPGridsService")
public class GROUPGridsserviceImpl implements GROUPGridsService {

@Resource
GROUPGridsMapper gROUPGridsMapper;
	/**  地图栅格参数信息插入语句*/
	public void insert(GROUPGridsPojo pojo) throws Exception{ 
 gROUPGridsMapper.insert(pojo);
}
	/**  地图栅格参数信息删除语句*/
	public void delete(GROUPGridsPojo pojo) throws Exception{
 gROUPGridsMapper.delete(pojo);
}
	/**  地图栅格参数信息更新语句*/
	public void update(GROUPGridsPojo pojo) throws Exception{ 
 gROUPGridsMapper.update(pojo);
}
	/**  地图栅格参数信息查询语句(参数form),根据条件查询出所有的数据集*/
	public List<GROUPGridsPojo> query(GROUPGridsPojo pojo) throws Exception{
return gROUPGridsMapper.query(pojo);
}
	/**  地图栅格参数信息查询分页语句(参数form),根据条件查询出每页的数据集*/
	public  PageInfo<GROUPGridsPojo> queryforpage(GROUPGridsPojo pojo,String field, String sort,Integer pageNo,Integer pageSize) throws Exception{
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

List<GROUPGridsPojo> list = gROUPGridsMapper.query(pojo);
PageInfo<GROUPGridsPojo> page = new PageInfo<GROUPGridsPojo>(list);
return page;
}

}
