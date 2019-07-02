package com.spdb.common.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.spdb.pojo.generator.TableForm;

public class ActionMapperXml {
	public static String title;

	/**
	 * 
	 * @param fromList
	 * @param datagridList
	 * @param xqList
	 * @param allList
	 * @param Projectpackage
	 * @param objectname
	 * @param path
	 * @param xqtitle
	 * @throws Exception
	 */
	public static void GeneratorMapperXml(String tableName,
			List<TableForm> allList, String Projectpackage, String objectname,
			String path, String xqtitle) throws Exception {
		title = xqtitle;
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
		sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n");
		sb.append("\r\n");
		sb.append("<mapper namespace=\"" + Projectpackage + "." + objectname
				+ GeneratorObject.Mapper + "\">\r\n");

		GeneratorResultMap(sb, objectname, allList, Projectpackage);

		GeneratorInsert(sb, allList, objectname, Projectpackage, tableName);
		GeneratorDelete(sb, allList, objectname, Projectpackage, tableName);
		GeneratorUpdate(sb, allList, objectname, Projectpackage, tableName);
		GeneratorQuery(sb, allList, objectname, Projectpackage, tableName);
		// GeneratorQueryCondition(sb, allList, objectname, Projectpackage,
		// tableName);

		sb.append("</mapper>\r\n");
		// System.out.println(sb);
		wirteFile(sb, path, objectname, Projectpackage);
	}

	public static void GeneratorResultMap(StringBuffer sb, String objectname,
			List<TableForm> allList, String Projectpackage) throws Exception {

		sb.append("	<!--" + title + "返回对象-->\r\n");
		sb.append("<resultMap id=\"ResultMap" + objectname + "\"  type=\""
				+ Projectpackage.replace("mapper", "pojo") + "." + objectname
				+ GeneratorObject.Pojo + "\" >");
		sb.append("\r\n");
		for (TableForm column : allList) {
			sb.append("<result property=\"" + column.getJavaName()
					+ "\" column=\"" + column.getColumn_name()
					+ "\" javaType=\"" + column.getJavaType()
					+ "\" jdbcType=\"" + column.getJdbcType() + "\"  />");
		}
		sb.append("</resultMap>");
		sb.append("\r\n");
		sb.append("\r\n");
	}

	public static void GeneratorInsert(StringBuffer sb,
			List<TableForm> allList, String objectname, String Projectpackage,
			String tableName) throws Exception {
		sb.append("	<!--" + title + "插入语句-->\r\n");
		sb.append("	<" + GeneratorObject.insert + " " + GeneratorObject.id
				+ "=\"insert\" " + GeneratorObject.parameterType + "=\""
				+ Projectpackage.replace("mapper", "pojo") + "." + objectname
				+ GeneratorObject.Pojo + "\"> \r\n");
		sb.append("" + GeneratorObject.INSERT + " " + GeneratorObject.INTO
				+ " " + tableName + " (\r\n");
		int i = 1;
		for (TableForm page : allList) {
			if (i == 1) {
				sb.append(" " + page.getColumn_name());
			} else {
				sb.append("," + page.getColumn_name());
			}
			i++;
			if (i % 15 == 0) {
				sb.append("\r\n");
			}
		}
		sb.append(")\r\n");
		sb.append("" + GeneratorObject.VALUES + "\r\n");
		sb.append("(");
		i = 1;
		for (TableForm page : allList) {
			if (i == 1) {
				sb.append("#{" + page.getJavaName() + ",jdbcType="
						+ page.getJdbcType() + "}");

				// if (page.getData_type().equals("DATE")) {
				// sb.append("to_date(#{" + page.getJavaName()
				// + "},'yyyy-MM-dd')");// hh24:mi:ss
				// } else {
				// sb.append("#{" + page.getJavaName() + "}");
				// }
			} else {

				sb.append(",#{" + page.getJavaName() + ",jdbcType="
						+ page.getJdbcType() + "}");
				// if (page.getData_type().equals("DATE")) {
				// sb.append(",to_date(#{" + page.getJavaName()
				// + "},'yyyy-MM-dd')");// hh24:mi:ss
				// } else {
				// sb.append(",#{" + page.getJavaName() + "}");
				// }
			}
			i++;
			if (i % 5 == 0) {
				sb.append("\r\n");
			}
		}
		sb.append(")\r\n");
		sb.append("</" + GeneratorObject.insert + ">");
		sb.append("\r\n");
		sb.append("\r\n");
	}

	public static void GeneratorDelete(StringBuffer sb,
			List<TableForm> allList, String objectname, String Projectpackage,
			String tableName) throws Exception {
		sb.append("	<!--" + title + "删除语句-->\r\n");
		sb.append("<delete id=\"");
		sb.append(GeneratorObject.delete);
		sb.append("\"");
		sb.append(" " + GeneratorObject.parameterType + "=\""
				+ Projectpackage.replace("mapper", "pojo") + "." + objectname
				+ GeneratorObject.Pojo + "\">");
		sb.append("\r\n");
		sb.append("DELETE FROM " + tableName + " ");
		sb.append("\r\n");
		sb.append("<where>\r\n");
		int i = 0;
		for (TableForm page : allList) {
			sb.append("<if test=\"" + page.getJavaName() + " != null and "
					+ page.getJavaName() + "!='' \">");
			if (i == 0) {
				sb.append("" + page.getColumn_name() + " = #{"
						+ page.getJavaName() + "}");
			} else {
				sb.append(" AND " + page.getColumn_name() + " = #{"
						+ page.getJavaName() + "}");
			}
			i++;
			sb.append("</if>");
			sb.append("\r\n");
		}
		sb.append("</where>\r\n");
		sb.append("\r\n");
		sb.append("</delete> ");
		sb.append("\r\n");
		sb.append("\r\n");
	}

	public static void GeneratorUpdate(StringBuffer sb,
			List<TableForm> allList, String objectname, String Projectpackage,
			String tableName) throws Exception {
		sb.append("	<!--" + title + "更新语句-->\r\n");
		sb.append("	<" + GeneratorObject.update + " " + GeneratorObject.id
				+ "=\"update\" " + GeneratorObject.parameterType + "=\""
				+ Projectpackage.replace("mapper", "pojo") + "." + objectname
				+ GeneratorObject.Pojo + "\"> \r\n");
		sb.append(GeneratorObject.UPDATE + " " + tableName + " \r\n");
		int i = 1;
		sb.append("\r\n");
		sb.append("<trim prefix=\"set\" suffixOverrides=\",\">\r\n");
		i = 0;
		for (TableForm page : allList) {
			sb.append("<if test=\"" + page.getJavaName() + " != null and "
					+ page.getJavaName() + "!='' \">");
			if (i == 0) {
				sb.append("" + page.getColumn_name() + " = #{"
						+ page.getJavaName() + "}");
			} else {
				sb.append("," + page.getColumn_name() + " = #{"
						+ page.getJavaName() + "}");
			}
			i++;
			sb.append("</if>");
			sb.append("\r\n");
		}
		sb.append("</trim>\r\n");
		sb.append("<where>\r\n");
		i = 0;
		sb.append(" AND 1 = 1 }");
		
		for (TableForm page : allList) {
			sb.append("<if test=\"" + page.getJavaName() + " != null and "
					+ page.getJavaName() + "!='' \">");
			sb.append(" AND " + page.getColumn_name() + " = #{"
					+ page.getJavaName() + "}");
			i++;
			sb.append("</if>");
			sb.append("\r\n");
		}
		sb.append("</where>\r\n");
		sb.append("	</" + GeneratorObject.update + ">");
		sb.append("\r\n");
		sb.append("\r\n");
	}

	public static void GeneratorQuery(StringBuffer sb, List<TableForm> allList,
			String objectname, String Projectpackage, String tableName)
			throws Exception {
		sb.append("	<!--" + title + "查询数据集语句(传参在form中)-->\r\n");

		sb.append("<select id=\"query\" " + GeneratorObject.parameterType
				+ "=\"" + Projectpackage.replace("mapper", "pojo") + "."
				+ objectname + GeneratorObject.Pojo
				+ "\" resultMap=\"ResultMap" + objectname + "\">");
		sb.append("\r\n");
		sb.append("<![CDATA[");
		sb.append("\r\n");
		sb.append(" SELECT ");

		int i = 0;
		for (TableForm page : allList) {
			if (i == 0) {
				sb.append(" " + page.getColumn_name());
			} else {
				sb.append("," + page.getColumn_name());
			}
			i++;
			if (i % 10 == 0) {
				sb.append("\r\n");
			}
		}

		sb.append(" FROM " + tableName);
		sb.append("\r\n");
		sb.append(" ]]>");
		sb.append("\r\n");
		sb.append("<where>\r\n");
		i = 0;
		for (TableForm page : allList) {
			sb.append("<if test=\"" + page.getJavaName() + " != null and "
					+ page.getJavaName() + "!='' \">");
			if (i == 0) {
				sb.append("" + page.getColumn_name() + " = #{"
						+ page.getJavaName() + "}");
			} else {
				sb.append(" and " + page.getColumn_name() + " = #{"
						+ page.getJavaName() + "}");
			}
			i++;
			sb.append("</if>");
			sb.append("\r\n");
		}
		sb.append("</where>\r\n");
		sb.append("</select>");
		sb.append("\r\n");
		sb.append("\r\n");
	}

	public static void GeneratorQueryCondition(StringBuffer sb,
			List<TableForm> datagridList, String objectname,
			String Projectpackage, String tableName) throws Exception {
		sb.append("	<!--" + title + "查询数据集语句(传参在form中的condition属性)-->\r\n");
		sb.append("	<" + GeneratorObject.select + " " + GeneratorObject.id
				+ "=\"queryCondition\" " + GeneratorObject.parameterType
				+ "=\"" + Projectpackage.replace("mapper", "pojo") + "."
				+ objectname + "" + GeneratorObject.Form + "\" ");
		sb.append(" " + " resultMap=\"ResultMap" + objectname + "\"> \r\n");
		sb.append("		<![CDATA[" + GeneratorObject.SELECT + " \r\n");

		int i = 1;
		for (TableForm page : datagridList) {
			if (i == 1) {
				// if (page.getData_type().equals("DATE")) {
				// sb.append("" + "to_char(" + page.getBak6()
				// + ",'yyyy-MM-dd hh24:mi:ss') ");
				// } else {
				sb.append("" + page.getColumn_name());
				// }
			} else {
				// if (page.getData_type().equals("DATE")) {
				// sb.append("," + "to_char(" + page.getBak6()
				// + ",'yyyy-MM-dd hh24:mi:ss') ");
				// } else {
				sb.append("," + page.getColumn_name());
				// }
			}

			i++;
			if (i % 10 == 0) {
				sb.append("\r\n");
			}
		}

		sb.append(" " + GeneratorObject.FROM + " " + tableName + " "
				+ GeneratorObject.WHERE + " 1=1 #{" + GeneratorObject.Condition
				+ "} ]]>\r\n");
		sb.append("	</" + GeneratorObject.select + ">\r\n");
		sb.append("\r\n");
		sb.append("\r\n");

	}

	// 生成java文件
	public static void wirteFile(StringBuffer sb, String path,
			String objectname, String Projectpackage) throws Exception {

		String[] p = Projectpackage.split("\\.");
		StringUtils.join(p, "//");

		path = path + StringUtils.join(p, "//") + "//" + objectname
				+ GeneratorObject.Mapper + ".xml";
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