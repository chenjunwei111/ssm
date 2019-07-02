package com.spdb.common.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.spdb.pojo.base.DepartmentPojo;
import com.spdb.pojo.generator.PartitionPojo;
import com.spdb.service.base.DepartmentService;
import com.spdb.service.generator.CommonService;

public class ActionWeb {
	public static String title;

	public static void GeneratorWeb(String Projectpackage, String objectname,
			String path, String xqtitle, String tableName) throws Exception {
		title = xqtitle;

		StringBuffer sb = new StringBuffer();
		GenComment(sb, Projectpackage, objectname);
		GenForm(sb, objectname, tableName);
		wirteFile(sb, path, objectname, Projectpackage);
	}

	public static void GenComment(StringBuffer sb, String Projectpackage,
			String objectname) throws Exception {
		sb.append("package " + Projectpackage + ";\r\n");
		sb.append("\r\n");
		sb.append("import java.util.List;\r\n");
		sb.append("import java.util.Map;\r\n");
		sb.append("import java.util.HashMap;\r\n");
		sb.append("import java.util.LinkedHashMap;\r\n");
		sb.append("import javax.annotation.Resource;\r\n");
		sb.append("import com.github.pagehelper.PageInfo;\r\n");
		sb.append("import com.spdb.pojo.base.DepartmentPojo;\r\n");
		sb.append("import com.spdb.pojo.generator.PartitionPojo;\r\n");
		sb.append("import com.spdb.service.base.DepartmentService;\r\n");
		sb.append("import com.spdb.service.generator.CommonService;\r\n");
		
		sb.append("import org.springframework.stereotype.Controller;\r\n");
		sb.append("import org.springframework.web.bind.annotation.RequestMapping;\r\n");
		sb.append("import org.springframework.web.bind.annotation.ResponseBody;\r\n");
		sb.append("import org.springframework.web.bind.annotation.RequestBody;\r\n");

		// sb.append("import " + Projectpackage.replace("web", "pojo") + "."
		// + objectname + GeneratorObject.Form + ";\r\n");
		sb.append("import " + Projectpackage.replace("web", "pojo") + "."
				+ objectname + GeneratorObject.Pojo + ";\r\n");
		sb.append("import " + Projectpackage.replace("web", "service") + "."
				+ objectname + GeneratorObject.Service + ";\r\n");

		sb.append("\r\n");
		sb.append("/**\r\n");
		sb.append(" * " + title + "\r\n");
		sb.append("\r\n");
		sb.append(" * @author Chan\r\n");
		sb.append("*/\r\n");
		sb.append("\r\n");

	}

	public static void GenForm(StringBuffer sb, String objectname,
			String tableName) throws Exception {
		sb.append("\r\n");
		sb.append("@Controller");
		sb.append("\r\n");
		sb.append("@RequestMapping(\"/" + objectname + "\")");
		sb.append("\r\n");
		sb.append(GeneratorObject.pub + " " + GeneratorObject.cla + " "
				+ objectname + GeneratorObject.Controller + " {\r\n");

		sb.append("@Resource\r\n");
		sb.append(objectname + GeneratorObject.Service + " "
				+ GeneratorObject.service + ";");

		sb.append("@Resource\r\n");
		sb.append("CommonService commonservice;\r\n");
		sb.append("@Resource\r\n");
		sb.append("DepartmentService departmentservice;\r\n");

		sb.append("\r\n");
		// 生成insert
		Geninsert(sb, objectname);
		// 生成delete
		Gendelete(sb, objectname);
		// 生成update
		Genupdate(sb, objectname);
		// 生成query
		Genquery(sb, objectname);
		// 生成queryforpage
		Genqueryforpage(sb, objectname);
		// 生成queryCondition
		// GenqueryCondition(sb, objectname);
		// 生成queryforpage
		// Genqueryforpage(sb, objectname);
		// 生成queryforCondition
		// GenqueryforpageCondition(sb, objectname);
		GendydynamicMsg(sb, tableName);
		sb.append("}\r\n");
	}

	public static void Geninsert(StringBuffer sb, String objectname) {

		sb.append("	/**  " + title + "插入语句*/\r\n");

		sb.append("@RequestMapping(\"/insert\")");
		sb.append("\r\n");
		sb.append("@ResponseBody");
		sb.append("\r\n");
		sb.append("	" + GeneratorObject.pub + " " + GeneratorObject.Integer
				+ " insert(@RequestBody " + objectname + GeneratorObject.Pojo
				+ " " + GeneratorObject.pojo + "){ \r\n");
		sb.append("try { \r\n");
		sb.append(GeneratorObject.service + ".insert(" + GeneratorObject.pojo
				+ ");\r\n");
		sb.append("return 1; \r\n");
		sb.append("} catch (Exception e) { \r\n");
		sb.append("return 0; \r\n");
		sb.append("} ");
		sb.append("\r\n");
		sb.append("}\r\n");
	}

	public static void Gendelete(StringBuffer sb, String objectname) {
		sb.append("	/**  " + title + "删除语句*/\r\n");
		sb.append("@RequestMapping(\"/delete\")");
		sb.append("\r\n");
		sb.append("@ResponseBody");
		sb.append("\r\n");
		sb.append("	" + GeneratorObject.pub + " " + GeneratorObject.Integer
				+ " delete(@RequestBody " + objectname + GeneratorObject.Pojo
				+ " " + GeneratorObject.pojo + "){\r\n");
		sb.append("try { \r\n");
		sb.append(" " + GeneratorObject.service + ".delete("
				+ GeneratorObject.pojo + ");");
		sb.append("return 1; \r\n");
		sb.append("} catch (Exception e) { \r\n");
		sb.append("return 0; \r\n");
		sb.append("} ");
		sb.append("\r\n");
		sb.append("}\r\n");
	}

	public static void Genupdate(StringBuffer sb, String objectname) {
		sb.append("	/**  " + title + "更新语句*/\r\n");
		sb.append("@RequestMapping(\"/update\")");
		sb.append("\r\n");
		sb.append("@ResponseBody");
		sb.append("\r\n");
		sb.append("	" + GeneratorObject.pub + " " + GeneratorObject.Integer
				+ " update(@RequestBody " + objectname + GeneratorObject.Pojo
				+ " " + GeneratorObject.pojo + "){ \r\n");
		sb.append("try { \r\n");
		sb.append(" " + GeneratorObject.service + ".update("
				+ GeneratorObject.pojo + ");");
		sb.append("return 1; \r\n");
		sb.append("} catch (Exception e) { \r\n");
		sb.append("return 0; \r\n");
		sb.append("} ");
		sb.append("\r\n");
		sb.append("}\r\n");
	}

	public static void Genquery(StringBuffer sb, String objectname) {
		sb.append("	/**  " + title + "查询语句(参数form),根据条件查询出所有的数据集*/\r\n");

		sb.append("@RequestMapping(\"/query\")");
		sb.append("\r\n");
		sb.append("@ResponseBody");
		sb.append("\r\n");
		sb.append("	" + GeneratorObject.pub + " List<" + objectname
				+ GeneratorObject.Pojo + ">" + " query(@RequestBody "
				+ objectname + GeneratorObject.Pojo + " "
				+ GeneratorObject.pojo + ") {\r\n");
		sb.append("try { \r\n");
		sb.append("return " + GeneratorObject.service + ".query("
				+ GeneratorObject.pojo + ");");
		sb.append("} catch (Exception e) { \r\n");
		sb.append("return null; \r\n");
		sb.append("} ");
		sb.append("\r\n");
		sb.append("}\r\n");
	}

	public static void Genqueryforpage(StringBuffer sb, String objectname) {
		sb.append("	/**  " + title + "查询分页语句(参数form),根据条件查询出每页的数据集*/\r\n");
		sb.append("@RequestMapping(\"/queryforpage\")");
		sb.append("\r\n");
		sb.append("@ResponseBody");
		sb.append("\r\n");
		sb.append("	" + GeneratorObject.pub + " PageInfo<" + objectname
				+ GeneratorObject.Pojo + ">" + " queryforpage(@RequestBody "
				+ objectname + GeneratorObject.Pojo + " "
				+ GeneratorObject.pojo
				+ ",String field, String sort,Integer pageNo, Integer pageSize) {\r\n");
		sb.append("try { \r\n");
		sb.append("return " + GeneratorObject.service + ".queryforpage("
				+ GeneratorObject.pojo + ",field,sort,pageNo,pageSize);");
		sb.append("} catch (Exception e) { \r\n");
		sb.append("return null; \r\n");
		sb.append("} ");
		sb.append("\r\n");
		sb.append("}\r\n");
	}

	public static void GenqueryCondition(StringBuffer sb, String objectname) {
		sb.append("	/**  "
				+ title
				+ "查询语句(参数form中的condition,可自定义组装在condition属性中),根据条件查询出所有的数据集*/\r\n");

		sb.append("@RequestMapping(\"/queryCondition\")");
		sb.append("\r\n");
		sb.append("@ResponseBody");
		sb.append("\r\n");
		sb.append("	" + GeneratorObject.pub + " List<" + objectname
				+ GeneratorObject.Pojo + ">" + " queryCondition(" + objectname
				+ GeneratorObject.Pojo + " " + GeneratorObject.pojo + "){\r\n");
		sb.append("try { \r\n");
		sb.append("return " + GeneratorObject.service + ".queryCondition("
				+ GeneratorObject.form + ");");
		sb.append("} catch (Exception e) { \r\n");
		sb.append("return null; \r\n");
		sb.append("} ");
		sb.append("\r\n");
		sb.append("}\r\n");
	}

	public static void GenqueryforpageCondition(StringBuffer sb,
			String objectname) {
		sb.append("	/**  "
				+ title
				+ "查询语句(参数form中的condition,可自定义组装在condition属性中),根据条件查询出每页的数据集*/\r\n");
		sb.append("	" + GeneratorObject.pub + " " + " List<" + objectname
				+ GeneratorObject.Pojo + ">" + " queryforpageCondition("
				+ GeneratorObject.pojo + ") throws Exception;\r\n");

		sb.append("\r\n");
	}

	public static void GendydynamicMsg(StringBuffer sb, String tableName) {

		sb.append("/** 否存在分区数据 */\r\n");
		sb.append("@RequestMapping(\"/existSPData\")\r\n");
		sb.append("@ResponseBody\r\n");
		sb.append("public Integer existSPData(@RequestBody PartitionPojo pojo) throws Exception {\r\n");
		sb.append("try {\r\n");
		sb.append("if (getDepartmentCode(pojo) == null) {\r\n");
		sb.append("return null;\r\n");
		sb.append("}\r\n");
		sb.append("Map<String, Object> map = new HashMap<String, Object>();\r\n");
		sb.append("Integer num = commonservice.existSPData(map);\r\n");
		sb.append("return num;\r\n");
		sb.append("} catch (Exception e) {\r\n");
		sb.append("return 0;\r\n");
		sb.append("}\r\n");
		sb.append("}\r\n");
		sb.append("\r\n");
		sb.append("/** 判断表中是否包含数据 需要传入tableName、areaCode */ \r\n");
		sb.append("@RequestMapping(\"/selectSP\")\r\n");
		sb.append("@ResponseBody\r\n");
		sb.append("public List<LinkedHashMap<String, Object>> selectSP(@RequestBody PartitionPojo pojo)\r\n");
		sb.append("throws Exception {\r\n");
		sb.append("pojo.setTableName(\"" + tableName + "\");\r\n");
		sb.append("return commonservice.selectSP(pojo);\r\n");
		sb.append("}\r\n");
		sb.append("\r\n");
		sb.append("/** 动态SQL 在这里组装查询的sql */\r\n");
		sb.append("@RequestMapping(\"/dynamicSql\")\r\n");
		sb.append("@ResponseBody\r\n");
		sb.append("public List<LinkedHashMap<String, Object>> dynamicSql() throws Exception {\r\n");
		sb.append("String sql = \"\";\r\n");
		sb.append("return commonservice.dynamicSql(sql);\r\n");
		sb.append("}\r\n");
		sb.append("\r\n");
		sb.append("/** 分页的动态sql查询 在这里组装查询的sql */\r\n");
		sb.append("@RequestMapping(\"/dynamicSqlforpage\")\r\n");
		sb.append("@ResponseBody\r\n");
		sb.append("public PageInfo<LinkedHashMap<String, Object>> dynamicSqlforpage(\r\n");
		sb.append("Integer pageNo, Integer pageSize) throws Exception {\r\n");
		sb.append("String sql = \"\";\r\n");
		sb.append("return commonservice.dynamicSqlforpage(sql, pageNo, pageSize);\r\n");
		sb.append("}\r\n");
		sb.append("\r\n");
		sb.append("/** 返回行政区号 */\r\n");
		sb.append("public PartitionPojo getDepartmentCode(PartitionPojo pojo) {\r\n");
		sb.append("try {\r\n");
		sb.append("DepartmentPojo dpojo = new DepartmentPojo();\r\n");
		sb.append("dpojo.setDeptname(pojo.getDeptName());\r\n");
		sb.append("List<DepartmentPojo> dpojos = departmentservice.query(dpojo);\r\n");
		sb.append("if (dpojos != null && dpojos.size() == 1) {\r\n");
		sb.append("pojo.setCityCode(dpojos.get(0).getDeptcode());\r\n");
		sb.append("pojo.setDeptName(\"\");\r\n");
		sb.append("}\r\n");
		sb.append("return pojo;\r\n");
		sb.append("} catch (Exception e) {\r\n");
		sb.append("return null;\r\n");
		sb.append("}\r\n");
		sb.append("}\r\n");
		sb.append("\r\n");

	}

	// 生成java文件
	public static void wirteFile(StringBuffer sb, String path,
			String objectname, String Projectpackage) throws Exception {
		String[] p = Projectpackage.split("\\.");
		StringUtils.join(p, "//");
		path = path + StringUtils.join(p, "//") + "//" + objectname
				+ GeneratorObject.Controller + ".java";

		File file = new File(path);

		if (!new File(file.getParent()).exists()) {
			new File(file.getParent()).mkdirs();
		}
		FileOutputStream fos = new FileOutputStream(path);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		bw.write(sb.toString());
		bw.close();
	}
}
