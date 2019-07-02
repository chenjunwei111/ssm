package com.spdb.web.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.lang.String;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.spdb.pojo.base.Menu;
import com.spdb.pojo.base.PLteSectorPojo;
import com.spdb.pojo.base.SampleTreePojo;
import com.spdb.pojo.base.TreePojo;
import com.spdb.service.base.MenuService;
import com.spdb.service.generator.CommonService;

/**
 * 功能菜单
 * 
 * @author junwei
 * 
 */
@Controller
@RequestMapping("/funcution")
public class MenuController {

    @Resource
    MenuService menuService;

    @Resource
    CommonService commonservice;

    // http://192.168.9.182:8080/contra/getMuen
    @RequestMapping("/getMuen")
    @ResponseBody
    public Map<String, Object> getMuen(String userCode,Boolean ifRoot) {
	try {
		 List<Menu> rootMenu=null;
//		if(ifRoot){
//			rootMenu = menuService.queryMenuList();
//		}else {
			rootMenu = menuService.queryMenuListCode(userCode);
//		}
	    // 查看结果
	    // for (Menu menu : rootMenu) {
	    // System.out.println(menu);
	    // }
	    // 最后的结果
	    List<Menu> menuList = new ArrayList<Menu>();
	    // 先找到所有的一级菜单
	    for (int i = 0; i < rootMenu.size(); i++) {
		// 一级菜单没有parentId
		if (StringUtils.isBlank(rootMenu.get(i).getFunctionParentCode())) {
		    menuList.add(rootMenu.get(i));
		}
	    }
	    // 为一级菜单设置子菜单，getChild是递归调用的
	    for (Menu menu : menuList) {
		menu.setChildren(getChild(menu.getFunctionCode(), rootMenu));
	    }
	    Map<String, Object> jsonMap = new HashMap<>();
	    jsonMap.put("menu", menuList);
	    return jsonMap;
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }

    /**
     * 递归查找子菜单
     * 
     * @param id
     *            当前菜单id
     * @param rootMenu
     *            要查找的列表
     * @return
     */
    private List<Menu> getChild(String id, List<Menu> rootMenu) {
	// 子菜单
	List<Menu> childList = new ArrayList<>();
	for (Menu menu : rootMenu) {
	    // 遍历所有节点，将父菜单id与传过来的id比较
	    if (StringUtils.isNotBlank(menu.getFunctionParentCode())) {
		if (menu.getFunctionParentCode().equals(id)) {
		    childList.add(menu);
		}
	    }
	}
	// 把子菜单的子菜单再循环一遍
	for (Menu menu : childList) {// 没有url子菜单还有子菜单
	    if (StringUtils.isBlank(menu.getHref())) {
		// 递归
		menu.setChildren(getChild(menu.getFunctionCode(), rootMenu));
	    }
	} // 递归退出条件
	if (childList.size() == 0) {
	    return null;
	}
	return childList;
    }

    // ------------------------后台：用于生成无限级功能树菜单----------------------------------//

    // 获取功能列表，用于checkbox的功能树组装数据源
    @RequestMapping("/getAdminFunction")
    @ResponseBody
    public List<TreePojo> getAdminFunction() {
	List<TreePojo> list = new ArrayList<TreePojo>();
	try {
	    List<Menu> ld = menuService.queryMenuList();
	    for (Menu d : ld) {
		if (d.getFunctionParentCode() == null) {
		    TreePojo t = new TreePojo();
		    String title = d.getTitle();
		    String id = d.getFunctionCode().toUpperCase();
		    t.setTitle(title);
		    t.setValue(id);
		    List<TreePojo> lchild = getChildFunction(ld, id);
		    t.setData(lchild);
		    list.add(t);
		}
	    }
	    return list;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}
    }

    // 获取功能列表，用于checkbox的功能树组装数据源
    private List<TreePojo> getChildFunction(List<Menu> ld, String parentid) {
	List<TreePojo> list = new ArrayList<TreePojo>();
	for (Menu d : ld) {
	    if (d.getFunctionParentCode() == null || d.getFunctionCode() == null) {
		continue;
	    }
	    if (parentid.equals(d.getFunctionParentCode().toUpperCase())) {
		TreePojo t = new TreePojo();
		String title = d.getTitle();
		String id = d.getFunctionCode().toUpperCase();
		t.setTitle(title);
		t.setValue(id);
		List<TreePojo> lchild = getChildFunction(ld, id);
		t.setData(lchild);
		list.add(t);
	    }
	}
	if (list.size() == 0)
	    return null;
	return list;
    }

    // 获取功能列表，用于checkbox的功能树组装数据源
    @RequestMapping("/getAdminFunctionByCheckBox")
    @ResponseBody
    public List<TreePojo> getAdminFunctionByCheckBox(String roleid) {
	List<TreePojo> list = new ArrayList<TreePojo>();
	try {
	    String sql = " Select distinct c.FUNCTION_CODE, c.FUNCTION_NAME, c.FUNCTION_PARENT_CODE,nvl2(t.ROLE_ID,1,0) ISVALID " + 
		    " from CFunction c left join (select * from  TROLE_Tfunction where ROLE_ID='" + roleid + "') t  " + 
		    " on c.FUNCTION_CODE=t.FUNCTION_CODE";
	    List<LinkedHashMap<String, Object>> ll = commonservice.dynamicSql(sql);
	    if (ll == null || ll.size() == 0)
		return null;

	    for (LinkedHashMap<String, Object> m : ll) {
		if (m.get("FUNCTION_PARENT_CODE") == null) {
		    TreePojo t = new TreePojo();
		    String title = getStr(m.get("FUNCTION_NAME"));
		    String id = getStr(m.get("FUNCTION_CODE")).toUpperCase();
		    String isvalid = getStr(m.get("ISVALID"));
		    boolean checked = false;
		    if ("1".equals(isvalid))
			checked = true;
		    t.setTitle(title);
		    t.setValue(id);
		    t.setChecked(checked);
		    List<TreePojo> lchild = getChildFunctionByCheckBox(ll, id);
		    t.setData(lchild);
		    list.add(t);
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

    // 获取功能列表，用于checkbox的功能树组装数据源
    private List<TreePojo> getChildFunctionByCheckBox(List<LinkedHashMap<String, Object>> ll, String parentid) {
	List<TreePojo> list = new ArrayList<TreePojo>();
	for (LinkedHashMap<String, Object> m : ll) {
	    if (m.get("FUNCTION_PARENT_CODE") == null || m.get("FUNCTION_CODE") == null) {
		continue;
	    }
	    if (parentid.equals(m.get("FUNCTION_PARENT_CODE").toString().toUpperCase())) {
		TreePojo t = new TreePojo();
		String title = getStr(m.get("FUNCTION_NAME"));
		 String id = getStr(m.get("FUNCTION_CODE")).toUpperCase();
		String isvalid = getStr(m.get("ISVALID"));
		boolean checked = false;
		if ("1".equals(isvalid))
		    checked = true;
		t.setTitle(title);
		t.setValue(id);
		t.setChecked(checked);
		List<TreePojo> lchild = getChildFunctionByCheckBox(ll, id);
		t.setData(lchild);
		list.add(t);
	    }
	}
	if (list.size() == 0)
	    return null;
	return list;
    }

    // 获取功能列表，用于单选的功能树组装数据源
    @RequestMapping("/getAdminSmapleFunction")
    @ResponseBody
    public List<SampleTreePojo> getAdminSmapleDepartment() {
	List<SampleTreePojo> list = new ArrayList<SampleTreePojo>();
	try {
	    List<Menu> ld = menuService.queryMenuList();
	    for (Menu d : ld) {
		if (d.getFunctionParentCode() == null) {
		    SampleTreePojo t = new SampleTreePojo();
		    String title = d.getTitle();
		    String id = d.getFunctionCode().toUpperCase();
		    t.setName(title);
		    t.setId(id);
		    List<SampleTreePojo> lchild = getSampleChildFunction(ld, id);
		    t.setChildren(lchild);
		    list.add(t);
		}
	    }
	    return list;
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return null;
	}
    }

    // 获取功能列表，用于单选的功能树组装数据源
    private List<SampleTreePojo> getSampleChildFunction(List<Menu> ld, String parentid) {
	List<SampleTreePojo> list = new ArrayList<SampleTreePojo>();
	for (Menu d : ld) {
	    if (d.getFunctionParentCode() == null || d.getFunctionCode() == null) {
		continue;
	    }

	    if (parentid.equals(d.getFunctionParentCode().toUpperCase())) {
		SampleTreePojo t = new SampleTreePojo();
		String title = d.getTitle();
		String id = d.getFunctionCode().toUpperCase();
		t.setName(title);
		t.setId(id);
		List<SampleTreePojo> lchild = getSampleChildFunction(ld, id);
		t.setChildren(lchild);
		list.add(t);
	    }
	}
	if (list.size() == 0)
	    return null;
	return list;
    }

    /**
     * 添加新功能
     * 
     * @param pojo
     * @return
     */
    @RequestMapping("/addOneFunction")
    @ResponseBody
    public String addOneFunction(@RequestBody Menu pojo) {
	if (pojo == null || pojo.getFunctionCode() == null)
	    return "error";
	try {
	    // 根据Code判断是否已存在该功能
	    String sql = "select count(0)COUNTCODE from Cfunction where FUNCTION_CODE='" + pojo.getFunctionCode() + "'";
	    List<LinkedHashMap<String, Object>> list = commonservice.dynamicSql(sql);
	    if (Integer.parseInt(list.get(0).get("FUNCTION_CODE").toString()) > 0) {
		return "error";
	    }
	    int res = menuService.insert(pojo);
	    if (res == 1) {
		return "OK";
	    } else {
		return "error";
	    }

	} catch (Exception ex) {
	    ex.printStackTrace();
	    return "error";
	}
    }

    /**
     * 根据Code 修改功能
     * 
     * @param pojo
     * @return
     */
    @RequestMapping("/aditOneFunction")
    @ResponseBody
    public String aditOneFunction(@RequestBody Menu pojo) {
	if (pojo == null || pojo.getFunctionCode() == null)
	    return "error";
	try {
	    int res = menuService.update(pojo);
	    if (res == 1) {
		return "OK";
	    } else {
		return "error";
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return "error";
	}
    }
    
    @RequestMapping("/getRequestFunctionTotal")
    @ResponseBody
    public Map<String,Object> getRequestFunctionTotal(@RequestBody PLteSectorPojo pojo, String field, String sort, Integer pageNo, Integer pageSize) {
	Map<String,Object> maps = new HashMap<String, Object>();
	if (pojo == null){
	    maps.clear();
		maps.put("code", 0);// 成功返回代码
		maps.put("msg", "success");// 返回信息
		maps.put("total", 0);// 数据总量
		maps.put("list", null);// 返回数据的list集合
		return maps;
	}	   
	try {
	    String where=" 1=1 ";
	   
	    String name = pojo.getSectorid();
	    String start=pojo.getCity();
	    String end=pojo.getCitycode();
	    if(name!=null&&"".equals(name)==false){
		where=" and (PARENT_NAME like '%"+name+"%' or CHILDREN_NAME like '%"+name+"%') ";
	    }
	    if(start!=null&&"".equals(start)==false){
	  		where=" and (Click_Date>=to_date('"+start+"','YYYY-MM-DD HH24:MI:SS')  and Click_Date<=to_date('"+end+"','YYYY-MM-DD HH24:MI:SS') ) ";
	  }
	    String sql=" select parent_name,CHILDREN_NAME,count(parent_name) CNT from "+
		    " (select distinct parent_name,CHILDREN_NAME ,trunc(CLICK_DATE, 'mi') from SPDB_SAVE_CLICK  where "+where+") a1  "+
		    " group by parent_name,CHILDREN_NAME";
	    
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
	    List<LinkedHashMap<String, Object>> ll = list.getList();	   
	    maps.put("list", ll);// 返回数据的list集合
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

}
