package com.spdb.common.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.lang.StringUtils;

public class ActionTest {
	public static String title;

	public static void GeneratorTest(String Projectpackage, String objectname,
			String path, String title) throws Exception {
		title = title;
		StringBuffer sb = new StringBuffer();
		GenComment(sb, Projectpackage, objectname);
		GenForm(sb, objectname, Projectpackage);
		wirteFile(sb, path, objectname, Projectpackage);
	}

	public static void GenComment(StringBuffer sb, String Projectpackage,
			String objectname) throws Exception {
		sb.append("package " + Projectpackage + ";");
		sb.append("import java.util.List;\r\n");
		sb.append("import com.github.pagehelper.PageInfo;\r\n");
		sb.append("import org.junit.Before;\r\n");
		sb.append("import org.junit.Test;\r\n");
		sb.append("import org.springframework.context.ApplicationContext;\r\n");
		sb.append("import org.springframework.context.support.ClassPathXmlApplicationContext;\r\n");
		// sb.append("import com.spdb.common.StrTras;\r\n");
		// sb.append("import com.spdb.common.generator.ActionMapper;\r\n");
		// sb.append("import com.spdb.common.generator.ActionMapperXml;\r\n");
		// sb.append("import com.spdb.common.generator.ActionPojo;\r\n");
		// sb.append("import com.spdb.common.generator.ActionService;\r\n");
		// sb.append("import com.spdb.common.generator.ActionServiceImpl;\r\n");
		// sb.append("import com.spdb.common.generator.ActionWeb;\r\n");
		sb.append("import " + Projectpackage.replace("test", "service") + "."
				+ objectname + GeneratorObject.Service + ";\r\n");
		// sb.append("import " + Projectpackage.replace("test", "pojo") + "."
		// + objectname + GeneratorObject.Form + ";\r\n");
		sb.append("import " + Projectpackage.replace("test", "pojo") + "."
				+ objectname + GeneratorObject.Pojo + ";\r\n");

		sb.append("\r\n");
		sb.append("/**\r\n");
		sb.append(" * " + title + "\r\n");
		sb.append("\r\n");
		sb.append(" * @author Chan\r\n");
		sb.append("*/\r\n");
		sb.append("\r\n");
	}

	public static void GenForm(StringBuffer sb, String objectname,
			String Projectpackage) throws Exception {
		sb.append(GeneratorObject.pub + " " + GeneratorObject.cla + " "
				+ objectname + GeneratorObject.Test);
		sb.append(" {\r\n");
		sb.append("\r\n");
		sb.append("" + objectname + GeneratorObject.Service + " service;");
		sb.append("\r\n");
		sb.append("@Before\r\n");
		sb.append("public void setUp() throws Exception {\r\n");
		sb.append("// 启动spring容器\r\n");
		sb.append("ApplicationContext ctx = new ClassPathXmlApplicationContext(\r\n");
		sb.append("\"application.xml\");\r\n");
		sb.append("// 获取service bean;\r\n");
		sb.append("service = (" + objectname + GeneratorObject.Service
				+ ") ctx.getBean(\"" + objectname.substring(0, 1).toLowerCase()
				+ objectname.substring(1) + GeneratorObject.Service
				+ "\");\r\n");

		sb.append("}\r\n");

		sb.append("@Test\r\n");
		sb.append("public void test() throws Exception {\r\n");
		sb.append("\r\n");
		sb.append("// 测试方法\r\n");
		// sb.append(objectname + GeneratorObject.Form + " form = new "
		// + objectname + GeneratorObject.Form + "(); \r\n");
		sb.append(objectname + GeneratorObject.Pojo + " pojo = new "
				+ objectname + GeneratorObject.Pojo + "(); \r\n");

		sb.append("\r\n");
		sb.append("service.insert(pojo);\r\n");
		sb.append("\r\n");
		sb.append("service.delete(pojo);\r\n");
		sb.append("\r\n");
		sb.append("service.update(pojo);\r\n");
		sb.append("\r\n");
		sb.append("List<" + objectname + GeneratorObject.Pojo
				+ "> list = service.query(pojo);\r\n");
		sb.append("\r\n");
		sb.append("PageInfo<"
				+ objectname
				+ GeneratorObject.Pojo
				+ "> pagelist =service.queryforpage(pojo,\"\",\"\", 1, 10);\r\n");
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append("}\r\n");
		sb.append("}\r\n");
	}

	// 生成java文件
	public static void wirteFile(StringBuffer sb, String path,
			String objectname, String Projectpackage) throws Exception {

		String[] p = Projectpackage.split("\\.");
		StringUtils.join(p, "//");
		path = path + StringUtils.join(p, "//") + "//" + objectname
				+ GeneratorObject.Test + ".java";
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
