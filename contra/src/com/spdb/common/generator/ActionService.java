package com.spdb.common.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.lang.StringUtils;

public class ActionService {
	public static String title;

	public static void GeneratorService(String Projectpackage,
			String objectname, String path, String xqtitle) throws Exception {
		title = xqtitle;

		StringBuffer sb = new StringBuffer();
		GenComment(sb, Projectpackage, objectname);
		GenForm(sb, objectname);
		wirteFile(sb, path, objectname, Projectpackage);
	}

	public static void GenComment(StringBuffer sb, String Projectpackage,
			String objectname) throws Exception {
		sb.append("package " + Projectpackage + ";\r\n");
		sb.append("\r\n");
		sb.append("import java.util.List;\r\n");
		sb.append("import com.github.pagehelper.PageInfo;\r\n");
		// sb.append("import " + Projectpackage.replace("service", "pojo") + "."
		// + objectname + GeneratorObject.Form + ";\r\n");
		sb.append("import " + Projectpackage.replace("service", "pojo") + "."
				+ objectname + GeneratorObject.Pojo + ";\r\n");
		sb.append("\r\n");
		sb.append("/**\r\n");
		sb.append(" * " + title + "\r\n");
		sb.append("\r\n");
		sb.append(" * @author Chan\r\n");
		sb.append("*/\r\n");
		sb.append("\r\n");

	}

	public static void GenForm(StringBuffer sb, String objectname)
			throws Exception {
		sb.append(GeneratorObject.pub + " " + GeneratorObject.inter + " "
				+ objectname + GeneratorObject.Service + " {\r\n");
		// 生成insert
		Geninsert(sb, objectname);
		// 生成delete
		Gendelete(sb, objectname);
		// 生成update
		Genupdate(sb, objectname);
		// 生成query
		Genquery(sb, objectname);
		// 生成query
		Genqueryforpage(sb, objectname);
		// 生成queryforpage
		// Genqueryforpage(sb, objectname);
		// 生成queryforCondition
		// GenqueryforpageCondition(sb, objectname);

		sb.append("}\r\n");
	}

	public static void Geninsert(StringBuffer sb, String objectname) {

		sb.append("	/**  " + title + "插入语句*/\r\n");
		sb.append("	" + GeneratorObject.pub + " " + GeneratorObject.voi
				+ " insert(" + objectname + GeneratorObject.Pojo + " "
				+ GeneratorObject.pojo + ") throws Exception; \r\n");

		sb.append("\r\n");
	}

	public static void Gendelete(StringBuffer sb, String objectname) {
		sb.append("	/**  " + title + "删除语句*/\r\n");
		sb.append("	" + GeneratorObject.pub + " " + GeneratorObject.voi
				+ " delete(" + objectname + GeneratorObject.Pojo + " "
				+ GeneratorObject.pojo + ") throws Exception;\r\n");

		sb.append("\r\n");
	}

	public static void Genupdate(StringBuffer sb, String objectname) {
		sb.append("	/**  " + title + "更新语句*/\r\n");
		sb.append("	" + GeneratorObject.pub + " " + GeneratorObject.voi
				+ " update(" + objectname + GeneratorObject.Pojo + " "
				+ GeneratorObject.pojo + ") throws Exception; \r\n");

		sb.append("\r\n");
	}

	public static void Genquery(StringBuffer sb, String objectname) {
		sb.append("	/**  " + title + "查询语句(参数form),根据条件查询出所有的数据集*/\r\n");
		sb.append("	" + GeneratorObject.pub + " List<" + objectname
				+ GeneratorObject.Pojo + ">" + " query(" + objectname
				+ GeneratorObject.Pojo + " " + GeneratorObject.pojo
				+ ") throws Exception;\r\n");

		sb.append("\r\n");
	}

	public static void Genqueryforpage(StringBuffer sb, String objectname) {
		sb.append("	/**  " + title + "查询分页语句(参数form),根据条件查询出每页的数据集*/\r\n");
		sb.append("	" + GeneratorObject.pub + " " + " PageInfo<" + objectname
				+ GeneratorObject.Pojo + ">" + " queryforpage(" + objectname
				+ GeneratorObject.Pojo + " " + GeneratorObject.pojo
				+ ",String field, String sort,Integer pageNo,Integer pageSize) throws Exception;\r\n");

		sb.append("\r\n");
	}

	public static void GenqueryCondition(StringBuffer sb, String objectname) {
		sb.append("	/**  "
				+ title
				+ "查询语句(参数form中的condition,可自定义组装在condition属性中),根据条件查询出所有的数据集*/\r\n");
		sb.append("	" + GeneratorObject.pub + " List<" + objectname
				+ GeneratorObject.Pojo + ">" + " queryCondition(" + objectname
				+ GeneratorObject.Pojo + " " + GeneratorObject.pojo
				+ ") throws Exception;\r\n");
		sb.append("\r\n");
	}

	public static void GenqueryforpageCondition(StringBuffer sb,
			String objectname) {
		sb.append("	/**  "
				+ title
				+ "查询语句(参数form中的condition,可自定义组装在condition属性中),根据条件查询出每页的数据集*/\r\n");
		sb.append("	" + GeneratorObject.pub + " " + " List<" + objectname
				+ GeneratorObject.Pojo + ">" + " queryforpageCondition("
				+ objectname + GeneratorObject.Pojo + " "
				+ GeneratorObject.pojo + ") throws Exception;\r\n");

		sb.append("\r\n");
	}

	// 生成java文件
	public static void wirteFile(StringBuffer sb, String path,
			String objectname, String Projectpackage) throws Exception {
		String[] p = Projectpackage.split("\\.");
		StringUtils.join(p, "//");
		path = path + StringUtils.join(p, "//") + "//" + objectname
				+ GeneratorObject.Service + ".java";

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