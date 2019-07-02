package com.spdb.wss;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class WSSHelper {
	/**
	 * 根据模板生成新word文档 判断表格是需要替换还是需要插入，判断逻辑有$为替换，表格无$为插入
	 * 
	 * @param inputUrl
	 *            模板存放地址
	 * @param outPutUrl
	 *            新文档存放地址
	 * @param textMap
	 *            需要替换的信息集合
	 * @param tableList
	 *            需要插入的表格信息集合
	 * @return 成功返回true,失败返回false
	 */
	private boolean Words(String inputUrl,
			Map<String, String> textMap, List<String[]> tableList,OutputStream  stream)
			throws Exception {
		// 模板转换默认成功
		boolean changeFlag = true;
		try {
			// 获取docx解析对象
			XWPFDocument document = new XWPFDocument(
					POIXMLDocument.openPackage(inputUrl));
			// 解析替换文本段落对象
			if(textMap!=null&&textMap.size()>0)
			{
				cText(document, textMap);
			}
			// 解析替换表格对象
			if(tableList!=null&&tableList.size()>0)
			{
				cTable(document, textMap, tableList);
			}
			// 生成新的word
			document.write(stream);
			document.close();
		} catch (IOException e) {
			e.printStackTrace();
			changeFlag = false;
		}

		return changeFlag;

	}

	/**
	 * 替换段落文本
	 * 
	 * @param document
	 *            docx解析对象
	 * @param textMap
	 *            需要替换的信息集合
	 */
	private void cText(XWPFDocument document, Map<String, String> textMap)
			throws Exception {
		// 获取段落集合
		List<XWPFParagraph> paragraphs = document.getParagraphs();

		for (XWPFParagraph paragraph : paragraphs) {
			// 判断此段落时候需要进行替换
			String text = paragraph.getText();
			if (ckText(text)) {
				List<XWPFRun> runs = paragraph.getRuns();
				for (XWPFRun run : runs) {
					// 替换模板原来位置
					run.setText(cValue(run.toString(), textMap), 0);
				}
			}
		}

	}

	/**
	 * 替换表格对象方法
	 * 
	 * @param document
	 *            docx解析对象
	 * @param textMap
	 *            需要替换的信息集合
	 * @param tableList
	 *            需要插入的表格信息集合
	 */
	private void cTable(XWPFDocument document, Map<String, String> textMap,
			List<String[]> tableList) throws Exception {
		// 获取表格对象集合
		List<XWPFTable> tables = document.getTables();
		for (int i = 0; i < tables.size(); i++) {
			// 只处理行数大于等于2的表格，且不循环表头
			XWPFTable table = tables.get(i);
			if (table.getRows().size() > 1) {
				// 判断表格是需要替换还是需要插入，判断逻辑有$为替换，表格无$为插入
				if (ckText(table.getText())) {
					List<XWPFTableRow> rows = table.getRows();
					// 遍历表格,并替换模板
					eTable(rows, textMap);
				} else {
					// System.out.println("插入"+table.getText());
					iTable(table, tableList);
				}
			}
		}
	}

	/**
	 * 遍历表格
	 * 
	 * @param rows
	 *            表格行对象
	 * @param textMap
	 *            需要替换的信息集合
	 */
	private void eTable(List<XWPFTableRow> rows, Map<String, String> textMap)
			throws Exception {
		for (XWPFTableRow row : rows) {
			List<XWPFTableCell> cells = row.getTableCells();
			for (XWPFTableCell cell : cells) {
				// 判断单元格是否需要替换
				if (ckText(cell.getText())) {
					List<XWPFParagraph> paragraphs = cell.getParagraphs();
					for (XWPFParagraph paragraph : paragraphs) {
						List<XWPFRun> runs = paragraph.getRuns();
						for (XWPFRun run : runs) {
							run.setText(cValue(run.toString(), textMap), 0);
						}
					}
				}
			}
		}
	}

	/**
	 * 为表格插入数据，行数不够添加新行
	 * 
	 * @param table
	 *            需要插入数据的表格
	 * @param tableList
	 *            插入数据集合
	 */
	private void iTable(XWPFTable table, List<String[]> tableList)
			throws Exception {
		// 创建行,根据需要插入的数据添加新行，不处理表头
		for (int i = 1; i < tableList.size(); i++) {
			XWPFTableRow row = table.createRow();
		}
		// 遍历表格插入数据
		List<XWPFTableRow> rows = table.getRows();
		for (int i = 1; i < rows.size(); i++) {
			XWPFTableRow newRow = table.getRow(i);
			List<XWPFTableCell> cells = newRow.getTableCells();
			for (int j = 0; j < cells.size(); j++) {
				XWPFTableCell cell = cells.get(j);
				cell.setText(tableList.get(i - 1)[j]);
			}
		}

	}

	/**
	 * 判断文本中时候包含$
	 * 
	 * @param text
	 *            文本
	 * @return 包含返回true,不包含返回false
	 */
	private boolean ckText(String text) {
		boolean check = false;
		if (text.indexOf("$") != -1) {
			check = true;
		}
		return check;

	}

	/**
	 * 匹配传入信息集合与模板
	 * 
	 * @param value
	 *            模板需要替换的区域
	 * @param textMap
	 *            传入信息集合
	 * @return 模板需要替换区域信息集合对应值
	 */
	private String cValue(String value, Map<String, String> textMap) {
		Set<Entry<String, String>> textSets = textMap.entrySet();
		for (Entry<String, String> textSet : textSets) {
			// 匹配模板与替换值 格式${key}
			String key = "${" + textSet.getKey() + "}";
			if (value.indexOf(key) != -1) {
				value = textSet.getValue();
			}
		}
		// 模板未匹配到区域替换为空
		if (ckText(value)) {
			value = "";
		}
		return value;
	}
	
//	 String inputUrl = "C:\\Users\\zhihe\\Desktop\\demo\\001.docx";
//     //新生产的模板文件
//     String outputUrl = "C:\\Users\\zhihe\\Desktop\\demo\\test.docx";
//
//     Map<String, String> testMap = new HashMap<String, String>();
//     testMap.put("name", "小明");
//  testMap.put("${name1}", "小明"); word文档对应位置填写 ${name1}
//
//     List<String[]> testList = new ArrayList<String[]>();
//     testList.add(new String[]{"1","1AA","1BB","1CC"});
	public void WSSOutWord(String intUrl,String outUrl,Map<String, String> textMap, List<String[]> tableList) throws Exception {
		try {
			File file = new File(outUrl);
			FileOutputStream stream = new FileOutputStream(file);
			Words(intUrl, textMap, tableList, stream);
			stream.close();
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
	}
	
    public  void WSSOutWord(String inTemplate,String fileName,Map<String, String> textData,List<String[]> tableData,HttpServletResponse response){
        try {
        	  System.out.println("begin");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            Words(inTemplate, textData, tableData, os);
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            response.reset();
            System.out.println("aaa");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.word;charset=utf-8"); //"application/msword"
            response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".docx").getBytes(), "iso-8859-1"));
            response.setContentLength(content.length);
            ServletOutputStream outputStream = response.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            byte[] buff = new byte[10240];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            bis.close();
            bos.close();
            outputStream.flush();
            outputStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

