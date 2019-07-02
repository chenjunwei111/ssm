package com.spdb.web.admin;

import java.util.ArrayList;
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
import com.spdb.pojo.base.PLteSectorPojo;
import com.spdb.pojo.base.SampleTreePojo;
import com.spdb.pojo.base.TreePojo;
import com.spdb.service.base.DepartmentService;
import com.spdb.service.generator.CommonService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    DepartmentService departmentservice;

    @Resource
    CommonService commonservice;

    // 获取部门列表，用于checkbox的部门树组装数据源
    @RequestMapping("/getAdminDepartment")
    @ResponseBody
    public List<TreePojo> getAdminDepartment() {
	List<TreePojo> list = new ArrayList<TreePojo>();
	try {
	    DepartmentPojo pojo = new DepartmentPojo();
	    // pojo.setIsvalid(1);
	    List<DepartmentPojo> ld = departmentservice.query(pojo);
	    for (DepartmentPojo d : ld) {
		if ("ROOT".equals(d.getParentdeptcode().toUpperCase())) {
		    TreePojo t = new TreePojo();
		    String deptname = d.getDeptname();
		    String areacode = d.getAreacode().toString();
		    String deptcode = d.getDeptcode();//用于父子链接关系的值
		    List<TreePojo> lchild = getChildDepartment(ld, deptcode);
		    t.setTitle(deptname);
		    t.setValue(areacode);
		    t.setData(lchild);
		    if ("530000".equals(d.getAreacode())) {//云南
			list.add(0, t);
		    } else {
			list.add(t);
		    }
		}
	    }
	    return list;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}
    }

    // 获取部门列表，用于checkbox的部门树组装数据源
    private List<TreePojo> getChildDepartment(List<DepartmentPojo> ld, String parentid) {
	if (parentid == null || "".equals(parentid) || ld == null) {
	    return null;
	}
	List<TreePojo> list = new ArrayList<TreePojo>();
	for (DepartmentPojo d : ld) {
	    if (d.getParentdeptcode() == null || 
		    d.getAreacode() == null || 
		    d.getDeptcode() == null || 
		    "ROOT".equals(d.getParentdeptcode() ))
		continue;
	    if (parentid.equals(d.getParentdeptcode().toUpperCase())) {
		TreePojo t = new TreePojo();
		String deptname = d.getDeptname();
		String areacode = d.getAreacode().toString();
		String deptcode = d.getDeptcode().toString();
		t.setTitle(deptname);
		t.setValue(areacode);
		List<TreePojo> lchild = getChildDepartment(ld, deptcode);
		t.setData(lchild);
		list.add(t);
	    }
	}
	if (list.size() == 0)
	    return null;
	return list;
    }

    // 获取部门列表，用于checkbox的部门树组装数据源
    @RequestMapping("/getAdminDepartmentByCheckBox")
    @ResponseBody
    public List<TreePojo> getAdminDepartmentByCheckBox(String roleid,String isvalid) {
	if (roleid == null || "".equals(roleid))
	    return null;
	List<TreePojo> list = new ArrayList<TreePojo>();
	try {
	    String sql = "Select c.DEPT_CODE, c.DEPT_NAME,c.AREA_CODE, c.PARENT_DEPT_CODE,nvl2(t.ROLE_ID,1,0) ISVALID " + 
		    " from department c left join (select * from  TROLE_Department where ROLE_ID='" + roleid + "') t  " + " on c.AREA_CODE=t.dept_code";
	    //部门有效才显示出来
	    if("1".equals(isvalid)){
		sql= sql+"  where c.ISVALID=1 ";
	    }
	    List<LinkedHashMap<String, Object>> ll = commonservice.dynamicSql(sql);
	    if (ll == null || ll.size() == 0)
		return null;
	    for (LinkedHashMap<String, Object> m : ll) {
		if ("ROOT".equals(m.get("PARENT_DEPT_CODE").toString().toUpperCase())) {
		    TreePojo t = new TreePojo();
		    String deptname = getStr(m.get("DEPT_NAME"));
		    String deptcode = getStr(m.get("DEPT_CODE"));
		    String areacode = getStr(m.get("AREA_CODE"));
		    String isvaliddb = getStr(m.get("ISVALID"));
		    boolean checked = false;
		    if ("1".equals(isvaliddb))
			checked = true;
		    List<TreePojo> lchild = getChildDepartmentByCheckBox(ll, deptcode);
		    t.setTitle(deptname);
		    t.setValue(areacode);
		    t.setChecked(checked);
		    t.setData(lchild);
		    if ("YUNNAN".equals(deptcode)) {
			list.add(0, t);
		    } else {
			list.add(t);
		    }
		}
	    }
	    return list;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}
    }

    private String getStr(Object o) {
	if (o == null)
	    return "";
	return o.toString();
    }

    // 获取部门列表，用于checkbox的部门树组装数据源
    private List<TreePojo> getChildDepartmentByCheckBox(List<LinkedHashMap<String, Object>> ll, String parentid) {
	if (parentid == null || "".equals(parentid) || ll == null) {
	    return null;
	}
	List<TreePojo> list = new ArrayList<TreePojo>();
	for (LinkedHashMap<String, Object> m : ll) {
	    if(m.get("PARENT_DEPT_CODE")==null||
		    m.get("DEPT_NAME")==null||
		    m.get("DEPT_CODE")==null||
		    m.get("AREA_CODE")==null
		    ){
		continue;
	    }
	    if("ROOT".equals(m.get("PARENT_DEPT_CODE").toString()) ){
		continue;
	    }
	    if (parentid.equals(m.get("PARENT_DEPT_CODE").toString().toUpperCase())) {
		TreePojo t = new TreePojo();
		String deptname = getStr(m.get("DEPT_NAME"));
		String deptcode = getStr(m.get("DEPT_CODE"));
		String areacode = getStr(m.get("AREA_CODE"));
		String isvalid = getStr(m.get("ISVALID"));
		boolean checked = false;
		if ("1".equals(isvalid))
		    checked = true;
		List<TreePojo> lchild =  getChildDepartmentByCheckBox(ll,deptcode);
		t.setTitle(deptname);
		t.setValue(areacode);
		t.setChecked(checked);
		if(lchild==null || lchild.size()==0){
		    t.setData(null);
		}else{
		    t.setData(lchild);
		}		
		list.add(t);
	    } else {
		continue;
	    }
	}
	if (list.size() == 0)
	    return null;
	return list;
    }

    // 获取部门列表，用于单选的部门树组装数据源
    @RequestMapping("/getAdminSmapleDepartment")
    @ResponseBody
    public List<SampleTreePojo> getAdminSmapleDepartment(String isvalid,String selecteddeptcode) {
	List<SampleTreePojo> list = new ArrayList<SampleTreePojo>();
	try {
	    DepartmentPojo pojo = new DepartmentPojo();
	    if(isvalid!=null && "1".equals(isvalid))pojo.setIsvalid(1);
	    List<DepartmentPojo> ld = departmentservice.query(pojo);
	    for (DepartmentPojo d : ld) {
		if ("ROOT".equals(d.getParentdeptcode().toUpperCase())) {
		    SampleTreePojo t = new SampleTreePojo();
		    String deptname = d.getDeptname();
		    String deptcode = d.getDeptcode();
		    String areacode = d.getAreacode().toString();
		    t.setName(deptname);
		    t.setId(areacode);		   
		    t.setSpread(false);
		    if(selecteddeptcode!=null && selecteddeptcode.equals(deptcode)){
			     t.setSpread(true);//展开还是关闭
			 }
		    t.setObj(deptcode);
		    List<SampleTreePojo> lchild = getSampleChildDepartment(ld, deptcode,selecteddeptcode,t);
		    t.setChildren(lchild);
		    if ("YUNNAN".equals(d.getDeptcode())) {
			t.setSpread(true);
			list.add(0, t);
		    } else {
			list.add(t);
		    }
		}
	    }
	    return list;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}
    }   

    // 获取部门列表，用于单选的部门树组装数据源
    private List<SampleTreePojo> getSampleChildDepartment(List<DepartmentPojo> ld, String parentid,String selecteddeptcode,SampleTreePojo parentObj) {
	List<SampleTreePojo> list = new ArrayList<SampleTreePojo>();
	for (DepartmentPojo d : ld) {
	    if (parentid.equals(d.getParentdeptcode().toUpperCase())) {
		SampleTreePojo t = new SampleTreePojo();
		String deptname = d.getDeptname();
		String deptcode = d.getDeptcode();
		String areacode = d.getAreacode().toString();
		t.setName(deptname);
		t.setId(areacode);		
		t.setObj(deptcode);
		 t.setSpread(false);//展开还是关闭
		 if(selecteddeptcode!=null && selecteddeptcode.equals(deptcode)){
		     parentObj.setSpread(true);
		     t.setSpread(true);//展开还是关闭
		 }
		List<SampleTreePojo> lchild = getSampleChildDepartment(ld, deptcode,selecteddeptcode,t);
		if(lchild!=null && lchild.size()>0){
		    t.setChildren(lchild);
		    for(Integer i=0;i<lchild.size();i++){
			if(lchild.get(i).isSpread()){
			    parentObj.setSpread(true);
			     t.setSpread(true);//展开还是关闭
			     break;
			}
		    }
		}else{
		    t.setChildren(null);
		}		
		list.add(t);
	    }
	}
	if (list.size() == 0)
	    return null;
	return list;
    }
  

    // 测试
    @RequestMapping("/getTreeTestData")
    @ResponseBody
    public String getTreeTestData() {
	try {
	    return "[{title:\"节点1\",value:\"jd1\",data:[{title:\"节点1.1\",value:\"jd1.1\",data:[]},{title:\"节点1.2\",value:\"jd1.2\",data:[]},{title:\"节点1.3\",value:\"jd1.3\",data:[]},{title:\"节点1.4\",value:\"jd1.4\",data:[]}]},{title:\"节点2\",value:\"jd2\",data:[{title:\"节点2.1\",value:\"jd2.1\",data:[]},{title:\"节点2.2\",value:\"jd2.2\",data:[{title:\"节点2.2.1\",value:\"jd2.2.1\",data:[]},{title:\"节点2.2.2\",value:\"jd2.2.2\",data:[]},{title:\"节点2.2.3\",value:\"jd2.2.3\",data:[]},{title:\"节点2.2.4\",value:\"jd2.2.4\",data:[]}]},{title:\"节点2.3\",value:\"jd2.3\",data:[]},{title:\"节点2.4\",value:\"jd2.4\",data:[]}]},{title:\"节点3\",value:\"jd3\",data:[]}]";
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}
    }

    // 获取单个部门
    @RequestMapping("/getOneDepartment")
    @ResponseBody
    public Map<String, Object> getOneDepartment(@RequestBody PLteSectorPojo pojo) {
	Map<String, Object> maps = new LinkedHashMap<String, Object>();
	try {
	    String sql = "";
	    sql = "Select * from Department where AREA_CODE='" + pojo.getCellid() + "'";
	    List<LinkedHashMap<String, Object>> list = commonservice.dynamicSql(sql);
	    if (list == null) {
		return maps;
	    }
	    maps = list.get(0);
	    return maps;
	} catch (Exception ex) {
	    return maps;
	}
    }

    // 部门列表
    @RequestMapping("/getDepartmentList")
    @ResponseBody
    public Map<String, Object> getDepartmentList(@RequestBody PLteSectorPojo pojo, String field, String sort, Integer pageNo, Integer pageSize) {
	Map<String, Object> maps = new LinkedHashMap<String, Object>();
	try {
	    String sql = "";
	    sql = "Select * from DEPARTMENT  where 1=1 ";
	    if (pojo != null ) {
		  if (pojo.getSectorid() != null) {			
			sql = sql + " and DEPT_NAME like '%" + pojo.getSectorid() + "%'";
		    }	
		  if (pojo.getCellid() != null && "".equals(pojo.getCellid())==false && "不限".equals(pojo.getCellid())==false) {			
			sql = sql + " and PARENT_DEPT_CODE = '" + pojo.getCellid() + "'";
		    }		
	    }

	    PageInfo<LinkedHashMap<String, Object>> list = commonservice.dynamicSqlforpage(sql, pageNo, pageSize);
	    if (list == null) {
		maps.clear();
		maps.put("code", 0);// 成功返回代码
		maps.put("msg", "success");// 返回信息
		maps.put("total", 0);// 数据总量
		maps.put("list", null);// 返回数据的list集合
		return maps;
	    }
	    maps.put("code", 0);// 成功返回代码
	    maps.put("msg", "success");// 返回信息
	    maps.put("total", list.getTotal());// 数据总量
	    List<LinkedHashMap<String, Object>> listold = list.getList();
	    maps.put("list", listold);// 返回数据的list集合
	    return maps;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    maps.clear();
	    maps.put("code", 0);// 成功返回代码
	    maps.put("msg", "success");// 返回信息
	    maps.put("total", 0);// 数据总量
	    maps.put("list", null);// 返回数据的list集合
	    return maps;
	}
    }

    // 部门列表
    @RequestMapping("/getDepartmentCnList")
    @ResponseBody
    public Map<String, Object> getDepartmentCnList(@RequestBody PLteSectorPojo pojo, String field, String sort, Integer pageNo, Integer pageSize) {
	Map<String, Object> maps = new LinkedHashMap<String, Object>();
	try {
	    String sql = "";
	    sql = "Select A.DEPT_NAME, A.PARENT_DEPT_CODE, A.DESCRIPTION, A.ISVALID, A.DEPT_CODE, A.SEQUENCE, A.AREA_CODE, "
	    	+ "A.LONGITUDE, A.LATITUDE,B.DEPT_NAME PARENT_DEPT_NAME from DEPARTMENT A,DEPARTMENT B "
	    	+ "where A.PARENT_DEPT_CODE=b.DEPT_CODE  and 1=1 ";
	    if (pojo != null ) {
		  if (pojo.getSectorid() != null) {			
			sql = sql + " and A.DEPT_NAME like '%" + pojo.getSectorid() + "%'";
		    }	
		  if (pojo.getCellid() != null && "".equals(pojo.getCellid())==false && "不限".equals(pojo.getCellid())==false) {			
			sql = sql + " and A.PARENT_DEPT_CODE = '" + pojo.getCellid() + "'";
		    }		
	    }

	    PageInfo<LinkedHashMap<String, Object>> list = commonservice.dynamicSqlforpage(sql, pageNo, pageSize);
	    if (list == null) {
		maps.clear();
		maps.put("code", 0);// 成功返回代码
		maps.put("msg", "success");// 返回信息
		maps.put("total", 0);// 数据总量
		maps.put("list", null);// 返回数据的list集合
		return maps;
	    }
	    maps.put("code", 0);// 成功返回代码
	    maps.put("msg", "success");// 返回信息
	    maps.put("total", list.getTotal());// 数据总量
	    List<LinkedHashMap<String, Object>> listold = list.getList();
	    maps.put("list", listold);// 返回数据的list集合
	    return maps;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    maps.clear();
	    maps.put("code", 0);// 成功返回代码
	    maps.put("msg", "success");// 返回信息
	    maps.put("total", 0);// 数据总量
	    maps.put("list", null);// 返回数据的list集合
	    return maps;
	}
    }
    // 添加部门
    @RequestMapping("/addOneDepartment")
    @ResponseBody
    public String addOneDepartment(@RequestBody DepartmentPojo pojo) {
	if(pojo==null
		||pojo.getDeptname()==null
		||pojo.getAreacode()==null
		||pojo.getDeptcode()==null
		){
	    return "数据为空";
	}
	if(hasDeptName(pojo.getDeptname())){
	    return "部门名："+pojo.getDeptname()+" 已存在";
	}
	if(hasAreaCode(pojo.getAreacode().toString())){
	    return "区域编号："+pojo.getAreacode()+" 已存在";
	}
	if(hasDeptCode(pojo.getDeptcode())){
	    return "部门编号："+pojo.getDeptcode()+" 已存在";
	}
	try {
	    // 根据Code判断是否已存在该部门
	    String sql = "select count(0)COUNTCODE from department where DEPT_CODE='" + pojo.getDeptcode() + "'";
	    List<LinkedHashMap<String, Object>> list = commonservice.dynamicSql(sql);
	    if (Integer.parseInt(list.get(0).get("COUNTCODE").toString()) > 0) {
		return "error";
	    }
	    int res = departmentservice.insert(pojo);
	    if (res == 1) {
		return "ok";
	    } else {
		return "error";
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return "error";
	}
    }
    // 部门名是否存在
    public boolean hasDeptName(String name) {
	try {	   
	    String sql = "Select count(0) cnt from DEPARTMENT where DEPT_NAME='" + name + "'";
	    Integer cnt = commonservice.dynamicSqltoInt(sql);
	    if (cnt > 0) {
		return true;
	    }
	    return false;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return false;
	}
    }
    //区域编号是否存在
    public boolean hasAreaCode(String name) {
	try {	   
	    String sql = "Select count(0) cnt from DEPARTMENT where AREA_CODE=" + name ;
	    Integer cnt = commonservice.dynamicSqltoInt(sql);
	    if (cnt > 0) {
		return true;
	    }
	    return false;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return false;
	}
    }
    //部门编号是否存在
    public boolean hasDeptCode(String name) {
	try {	   
	    String sql = "Select count(0) cnt from DEPARTMENT where DEPT_CODE='" + name + "'";
	    Integer cnt = commonservice.dynamicSqltoInt(sql);
	    if (cnt > 0) {
		return true;
	    }
	    return false;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return false;
	}
    }

    // 编辑部门
    @RequestMapping("/editOneDepartment")
    @ResponseBody
    public String editOneDepartment(@RequestBody DepartmentPojo pojo) {
	if (pojo == null || pojo.getDeptcode() == null)
	    return "error";
	try {
	    // 根据deptCode 为条件去修改
	    int res = departmentservice.update(pojo);
	    if (res == 1) {
		return "ok";
	    } else {
		return "error";
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return "error";
	}
    }

    // 获取ROOT部门列表，用于省市联动
    @RequestMapping("/getAdminDepartmentByParentDeptCode")
    @ResponseBody
    public List<DepartmentPojo> getAdminDepartmentByParentDeptCode(String parentDeptCode) {
	List<DepartmentPojo> list = new ArrayList<DepartmentPojo>();
	try {
	    DepartmentPojo pojo = new DepartmentPojo();
	    if(parentDeptCode==null||"".equals(parentDeptCode)||"不限".equals(parentDeptCode)){
		
	    }else{
		pojo.setParentdeptcode(parentDeptCode);
	    }
	    
	    List<DepartmentPojo> ld = departmentservice.query(pojo);
	    for (DepartmentPojo d : ld) {
		if ("YUNNAN".equals(d.getDeptcode().toUpperCase())) {
		    list.add(0, d);
		} else {
		    list.add(d);
		}
	    }
	    return list;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}
    }
}
