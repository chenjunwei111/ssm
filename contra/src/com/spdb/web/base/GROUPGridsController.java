package com.spdb.web.base;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.spdb.pojo.base.DepartmentPojo;
import com.spdb.pojo.base.GROUPGridsPojo;
import com.spdb.pojo.generator.PartitionPojo;
import com.spdb.service.base.DepartmentService;
import com.spdb.service.base.GROUPGridsService;
import com.spdb.service.generator.CommonService;

/**
 * 地图栅格参数信息
 * 
 * @author Chan
 */

@Controller
@RequestMapping("/GROUPGrids")
public class GROUPGridsController {
	@Resource
	GROUPGridsService service;
	@Resource
	CommonService commonservice;
	@Resource
	DepartmentService departmentservice;

	/** 地图栅格参数信息插入语句 */
	@RequestMapping("/insert")
	@ResponseBody
	public Integer insert(@RequestBody GROUPGridsPojo pojo) {
		try {
			service.insert(pojo);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/** 地图栅格参数信息删除语句 */
	@RequestMapping("/delete")
	@ResponseBody
	public Integer delete(@RequestBody GROUPGridsPojo pojo) {
		try {
			service.delete(pojo);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/** 地图栅格参数信息更新语句 */
	@RequestMapping("/update")
	@ResponseBody
	public Integer update(@RequestBody GROUPGridsPojo pojo) {
		try {
			service.update(pojo);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/** 地图栅格参数信息查询语句(参数form),根据条件查询出所有的数据集 */
	@RequestMapping("/query")
	@ResponseBody
	public List<GROUPGridsPojo> query(@RequestBody GROUPGridsPojo pojo) {
		try {
			return service.query(pojo);
		} catch (Exception e) {
			return null;
		}
	}

	/** 地图栅格参数信息查询分页语句(参数form),根据条件查询出每页的数据集 */
	@RequestMapping("/queryforpage")
	@ResponseBody
	public PageInfo<GROUPGridsPojo> queryforpage(
			@RequestBody GROUPGridsPojo pojo, String field, String sort,
			Integer pageNo, Integer pageSize) {
		try {
			return service.queryforpage(pojo, field, sort, pageNo, pageSize);
		} catch (Exception e) {
			return null;
		}
	}

	/** 否存在分区数据 */
	@RequestMapping("/existSPData")
	@ResponseBody
	public Integer existSPData(@RequestBody PartitionPojo pojo)
			throws Exception {
		try {
			if (getDepartmentCode(pojo) == null) {
				return null;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			Integer num = commonservice.existSPData(map);
			return num;
		} catch (Exception e) {
			return 0;
		}
	}

	/** 判断表中是否包含数据 需要传入tableName、areaCode */
	@RequestMapping("/selectSP")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> selectSP(
			@RequestBody PartitionPojo pojo) throws Exception {
		pojo.setTableName("GROUP_GRIDS");
		return commonservice.selectSP(pojo);
	}

	/** 动态SQL 在这里组装查询的sql */
	@RequestMapping("/dynamicSql")
	@ResponseBody
	public List<LinkedHashMap<String, Object>> dynamicSql() throws Exception {
		String sql = "";
		return commonservice.dynamicSql(sql);
	}

	/** 分页的动态sql查询 在这里组装查询的sql */
	@RequestMapping("/dynamicSqlforpage")
	@ResponseBody
	public PageInfo<LinkedHashMap<String, Object>> dynamicSqlforpage(
			Integer pageNo, Integer pageSize) throws Exception {
		String sql = "";
		return commonservice.dynamicSqlforpage(sql, pageNo, pageSize);
	}

	/** 返回行政区号 */
	public PartitionPojo getDepartmentCode(PartitionPojo pojo) {
		try {
			DepartmentPojo dpojo = new DepartmentPojo();
			dpojo.setDeptname(pojo.getDeptName());
			List<DepartmentPojo> dpojos = departmentservice.query(dpojo);
			if (dpojos != null && dpojos.size() == 1) {
				pojo.setCityCode(dpojos.get(0).getDeptcode());
				pojo.setDeptName("");
			}
			return pojo;
		} catch (Exception e) {
			return null;
		}
	}

}
