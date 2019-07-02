package com.spdb.common.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.spdb.pojo.generator.TableForm;

public class ActionPojo {

	/**
	 * @param list
	 *            处理java对象的生成list
	 * @param objectname
	 *            对象别名
	 * @param Projectpackage
	 *            包路径
	 * @param objType
	 *            Form Pojo
	 * @param path
	 *            文件生成路径
	 * @throws Exception
	 */

	public static void GeneratorObject(List<TableForm> list, String objectname,
			String Projectpackage, String objType, String path, String title)
			throws Exception {

		StringBuffer sb = new StringBuffer();
		GenComment(sb, Projectpackage, objType, title);
		GenForm(sb, list, objectname, Projectpackage, objType);
		// System.out.println(sb);
		wirteFile(sb, path, objectname, objType, Projectpackage);
	}

	public static void GenComment(StringBuffer sb, String Projectpackage,
			String objType, String title) throws Exception {
		sb.append("package " + Projectpackage + ";");
		if (objType.equals("Form")) {
			sb.append("\r\n");

			String[] pack = Projectpackage.split("\\.");
			sb.append("import " + pack[0] + "." + pack[1]
					+ ".common.generator.BasePageForm;\r\n");
		} else if (objType.equals("Pojo")) {
			// sb.append(GeneratorObject.Pojo + ";\r\n");
		}
		sb.append("\r\n");
		sb.append("import java.sql.Date;\r\n");

		sb.append("\r\n");
		sb.append("/**\r\n");
		sb.append(" * " + title + "\r\n");
		sb.append("\r\n");
		sb.append(" * @author Chan\r\n");
		sb.append("*/\r\n");
		sb.append("\r\n");
	}

	public static void GenForm(StringBuffer sb, List<TableForm> list,
			String objectname, String Projectpackage, String objType)
			throws Exception {
		sb.append(GeneratorObject.pub + " " + GeneratorObject.cla + " "
				+ objectname + objType);
		if (objType.equals("Form")) {
			sb.append(" extends BasePageForm");
		}
		sb.append(" {\r\n");
		sb.append("\r\n");

		GenProperties(sb, list);
		sb.append("\r\n");
		for (TableForm page : list) {
			GenSet(sb, page);
			GenGet(sb, page);
		}
		sb.append("}\r\n");
	}

	public static void GenProperties(StringBuffer sb, List<TableForm> list)
			throws Exception {
		for (TableForm column : list) {
			sb.append(GeneratorObject.pri);
			sb.append(" ");
			sb.append(column.getJavaType());
			sb.append(" ");
			sb.append(column.getJavaName());
			sb.append(";\r\n");
		}

	}

	public static void GenSet(StringBuffer sb, TableForm column)
			throws Exception {
		sb.append(GeneratorObject.pub);
		sb.append(" ");
		sb.append(GeneratorObject.voi);
		sb.append(" ");
		sb.append("set" + column.getJavaName().substring(0, 1).toUpperCase()
				+ column.getJavaName().substring(1).toLowerCase());
		sb.append("(");
		sb.append(column.getJavaType());
		sb.append(" ");
		sb.append(column.getJavaName());
		sb.append(") {\r\n");
		sb.append("		" + GeneratorObject.thi);
		sb.append("." + column.getJavaName());
		sb.append(" = ");
		sb.append(column.getJavaName());
		sb.append(";\r\n");
		sb.append("}\r\n");
		sb.append("\r\n");
	}

	public static void GenGet(StringBuffer sb, TableForm column)
			throws Exception {
		sb.append(GeneratorObject.pub);
		sb.append(" ");
		sb.append(column.getJavaType());
		sb.append(" ");
		sb.append("get" + column.getJavaName().substring(0, 1).toUpperCase()
				+ column.getJavaName().substring(1).toLowerCase());
		sb.append("(");
		sb.append(") {\r\n");
		sb.append("		" + GeneratorObject.ret + " ");
		sb.append(column.getJavaName());
		sb.append(";\r\n");
		sb.append("}\r\n");
		sb.append("\r\n");
	}

	// 生成java文件
	public static void wirteFile(StringBuffer sb, String path,
			String objectname, String objType, String Projectpackage)
			throws Exception {

		String[] p = Projectpackage.split("\\.");
		StringUtils.join(p, "//");
		path = path + StringUtils.join(p, "//") + "//" + objectname + objType
				+ ".java";
		File file = new File(path);

		if (!new File(file.getParent()).exists()) {
			new File(file.getParent()).mkdirs();
		}

		FileOutputStream fos = new FileOutputStream(file);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		bw.write(sb.toString());
		bw.close();
	}

}