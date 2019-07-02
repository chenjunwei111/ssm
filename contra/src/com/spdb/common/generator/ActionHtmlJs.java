package com.spdb.common.generator;

import com.spdb.pojo.generator.TableForm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class ActionHtmlJs {

	public static void Generator(List<TableForm> allList,
			String Projectpackage, String objectname, String path,
			String xqtitle) throws Exception {

		StringBuffer sbhtml = new StringBuffer();
		Genhtml(allList, sbhtml, Projectpackage, objectname, xqtitle);
		wirteHtmlFile(sbhtml, path, objectname, Projectpackage);

		StringBuffer sbjs = new StringBuffer();
		Genjs(allList, sbjs, objectname);
		wirteJsFile(sbjs, path, objectname, Projectpackage);
	}

	public static void Genhtml(List<TableForm> allList, StringBuffer sb,
			String Projectpackage, String objectname, String xqtitle) {

		sb.append("<div class=\"layui-field-box layui-form\"\r\n");
		sb.append("style=\"height: 300px; text-align: center;\">\r\n");
		sb.append("<h4>\r\n");
		sb.append("<b>" + xqtitle + "</b>\r\n");
		sb.append("</h4>\r\n");
		sb.append("<fieldset class=\"layui-elem-field\">\r\n");
		sb.append("<div class=\"layui-field-box layui-form\">\r\n");
		sb.append("<table class=\"table table-hover\" style=\"height: 250px;\">\r\n");
		sb.append("<thead>\r\n");
		sb.append("<tr>\r\n");
		sb.append("<th>序号</th>\r\n");
		for (int i = 0; i < allList.size(); i++) {
			sb.append("<th>" + allList.get(i).getJavaName().toLowerCase()
					+ "</th>");
		}
		sb.append("</tr>\r\n");
		sb.append("</thead>\r\n");
		sb.append("<tbody class=\"tbody\">\r\n");
		sb.append("</tbody>\r\n");
		sb.append("</table>\r\n");
		sb.append("</div>\r\n");
		sb.append("</fieldset>\r\n");
		sb.append("</div>\r\n");
		sb.append("\r\n");
		sb.append("<div style=\"margin: 0 auto; width: 70%; height: 40px;\">\r\n");
		sb.append("<div id=\"paging\"></div>\r\n");
		sb.append("</div>\r\n");
		sb.append("\r\n");

	}

	public static void Genjs(List<TableForm> allList, StringBuffer sb,
			String objectname) {
		sb.append("$(document).ready(function() {\r\n");
		sb.append("var url=\"/contra/" + objectname
				+ "/queryforpage\";\r\n");
		sb.append("var obj=" + objectname + GeneratorObject.Pojo + " = {};\r\n");
		sb.append("var pageNum=null;\r\n");
		sb.append("var pageSize=null;\r\n");
		sb.append("getResult(pageNum,pageSize,url, obj);\r\n");
		sb.append("});\r\n");
		sb.append("\r\n");
		sb.append("function getResult(pageNum,pageSize,url,obj){\r\n");
		sb.append("if(pageNum==null || pageNum==\"\"){\r\n");
		sb.append("pageNum=\"1\";}\r\n");
		sb.append("if (pageSize==\"\" || pageSize==null) {\r\n");
		sb.append("pageSize=\"5\";}\r\n");
		sb.append(" $.ajax({\r\n");
		sb.append("type: \"post\", //地址指定到特定分页\r\n");
		sb.append("url: \"\"+url+\"?pageNo=\"+pageNum+\"&pageSize=\"+pageSize+\"\",\r\n");
		sb.append("contentType: 'application/json',\r\n");
		sb.append("data: JSON.stringify(obj),\r\n");
		sb.append("success: function(data){\r\n");
		sb.append("createPageNav({\r\n");
		sb.append("$container : $(\"#paging\"),\r\n");
		sb.append("pageCount : data.pages,\r\n");
		sb.append("currentNum : data.pageNum,\r\n");
		sb.append("nextPage :data.nextPage,\r\n");
		sb.append("afterFun : function(nextPage){\r\n");
		sb.append("getResult(pageNum,pageSize,url,obj);\r\n");
		sb.append("}\r\n");
		sb.append("});\r\n");
		sb.append("//表格生成\r\n");
		sb.append(" $('.tbody').empty();\r\n");
		sb.append(" for (var i = 0; i < data.list.length; i++) {\r\n");
		sb.append("var tab = data.list[i];\r\n");
		sb.append("var tr = \"<tr class='Tr'>\" +\r\n");
		sb.append("\"<td>\" + parseInt(1+i) + \"</td>\" +\r\n");
		for (int i = 0; i < allList.size(); i++) {
			if (i == 0) {
				sb.append("\"<td style='cursor: pointer;' class='selectCity'><a>\" + tab."
						+ allList.get(i).getJavaName().toLowerCase()
						+ " + \"</a></td>\" +");
			} else {
				sb.append("\"<td>\" + tab."
						+ allList.get(i).getJavaName().toLowerCase()
						+ " + \"</td>\" +");
			}
		}
		sb.append("\"</tr>\";\r\n");
		sb.append(" $(\".tbody\").append(tr);\r\n");
		sb.append("}\r\n");
		sb.append("console.info(data);\r\n");
		sb.append("}\r\n");
		sb.append("});\r\n");
		sb.append("}\r\n");
		sb.append("\r\n");

	}

	// 生成html文件
	public static void wirteHtmlFile(StringBuffer sb, String path,
			String objectname, String Projectpackage) throws Exception {

		path = path + "view" + "//" + Projectpackage + "//"
				+ objectname.toLowerCase() + ".html";

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

	// 生成js文件
	public static void wirteJsFile(StringBuffer sb, String path,
			String objectname, String Projectpackage) throws Exception {

		path = path + "js" + "//" + Projectpackage + "//"	+ objectname.toLowerCase() + ".js";

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
