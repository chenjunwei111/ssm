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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

/*
 * ESSOutExcel：普通的单个Excel生成并默认导出
 * ESSOutExcelMore：一个Excel内含多个Sheet文件生成并默认导出
 * ESSOutExcelComplex：一个Excel内含多个Sheet文件，Sheet包含特殊列头，跨行跨列
 * getHotLineCityTotalColumn：行合并示例，列合并示例，单元格样式设置示例
 * */
public class ESSHelper {
    /**
     * 普通的单个Excel生成并默认导出
     * @param sheetName Sheet名称，可以中文
     * @param headMap 列头字典，key--value,key对应数据库字段或对象字段，value对应的中文名
     * @param data 数据集，key--value,key对应数据库字段或对象字段，value对应的数据
     * @param maxRows
     * @param out
     * @param XStyle
     */
    private void ESSOutExcel(String sheetName, LinkedHashMap<String, String> headMap, List<LinkedHashMap<String, Object>> data, int maxRows, OutputStream out, XSSFCellStyle XStyle) {
		// if(datePattern==null) datePattern = DEFAULT_DATE_PATTERN;
		// 声明一个工作薄
		SXSSFWorkbook workbook = new SXSSFWorkbook(1000);
		// 生成一个(带标题)表格
		// SXSSFSheet sheet = workbook.createSheet();
		// 设置样式
		if (XStyle != null) {

		}

		// 产生表格标题行,以及设置列宽
		// for (Iterator<String> iter = headMap.keySet().iterator();
		// iter.hasNext();) {
		// String fieldName = iter.next();
		// properties[ii] = fieldName;
		// headers[ii] = headMap.get(fieldName);
		// int bytes = fieldName.getBytes().length;
		// // arrColWidth[ii] = bytes < 17 ? 17 : bytes;
		// // sheet.setColumnWidth(ii,arrColWidth[ii]*256);
		// ii++;
		// }
		//
		Map<String, Integer> hmap = new HashMap<String, Integer>();
		int maxRow = maxRows <= 0 ? 100000 : maxRows;
		int rowidx = 0;
		int colidx = 0;
		int shtnum = 0;
		sheetName = sheetName == null ? "sheet" : sheetName;
		String sheName = sheetName;
		SXSSFSheet sheet = null;
		// SXSSFRow cv = null;
		Object v = null;
		Object k = null;
		try {
			if (data==null||data.size() == 0) {
				colidx = 0;
				hmap.clear();
				sheet = workbook.createSheet(sheName);
				SXSSFRow cv = sheet.createRow(0);
				for (Map.Entry<String, String> entry : headMap.entrySet()) {
					hmap.put(entry.getKey(), colidx);
					SXSSFCell _cell = cv.createCell(colidx);
					_cell.setCellValue(entry.getValue());
					colidx++;
				}
			} else {
				for (LinkedHashMap<String, Object> ls : data) {
					if (rowidx > maxRow || rowidx == 0) {
						if (rowidx > 0) {
							sheName = sheetName + "_" + shtnum;
							shtnum++;
						}
						rowidx = 0;
						colidx = 0;
						hmap.clear();
						sheet = workbook.createSheet(sheName);
						SXSSFRow cv = sheet.createRow(0);
						for (Map.Entry<String, String> entry : headMap
								.entrySet()) {
							hmap.put(entry.getKey(), colidx);
							SXSSFCell _cell = cv.createCell(colidx);
							_cell.setCellValue(entry.getValue());
							colidx++;
						}
						rowidx++;
					}
					SXSSFRow cvs = sheet.createRow(rowidx);
					for (Entry<String, Object> kv : ls.entrySet()) {
						k = kv.getKey();
						if (hmap.containsKey(k)) {
							v = kv.getValue();
							// if ((v = kv.getValue()) != null) {
							SXSSFCell _cellv = cvs.createCell(hmap.get(k));
							_cellv.setCellValue(v != null ? v.toString() : "");
							// }
						}
					}
					rowidx++;
				}
			}
			workbook.write(out);
			workbook.close();
			workbook.dispose();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /*
     * 导出多个Sheet的Excel
     */
    private void ESSOutExcelMore(String[] sheetNames, LinkedHashMap<String, LinkedHashMap<String, String>> headMaps, LinkedHashMap<String, List<LinkedHashMap<String, Object>>> datas, OutputStream out) {
	// if(datePattern==null) datePattern = DEFAULT_DATE_PATTERN;
	// 声明一个工作薄
	SXSSFWorkbook workbook = new SXSSFWorkbook(1000);
	// 生成一个(带标题)表格
	// SXSSFSheet sheet = workbook.createSheet();

	System.out.println("bbb");
	LinkedHashMap<String, Integer> hmap = new LinkedHashMap<String, Integer>();

	int colidx = 0;
	for (String sheetName : sheetNames) {
	    SXSSFSheet sheet = workbook.createSheet(sheetName);
	    // 生成列头
	    SXSSFRow cv = sheet.createRow(0);
	    Map<String, String> headMap = headMaps.get(sheetName);
	    colidx = 0;
	    for (Map.Entry<String, String> entry : headMap.entrySet()) {
		hmap.put(entry.getKey(), colidx);
		SXSSFCell _cell = cv.createCell(colidx);
		_cell.setCellValue(entry.getValue());
		colidx++;
	    }
	    // 生成数据
	    Object v = null;
	    Object k = null;
	    List<LinkedHashMap<String, Object>> data = datas.get(sheetName);
	    int rowidx = 1;
	    for (Map<String, Object> ls : data) {
		SXSSFRow cvs = sheet.createRow(rowidx);
		for (Entry<String, Object> kv : ls.entrySet()) {
		    k = kv.getKey();
		    if (hmap.containsKey(k)) {
			v = kv.getValue();
			SXSSFCell _cellv = cvs.createCell(hmap.get(k));
			_cellv.setCellValue(v != null ? v.toString() : "");
		    }
		}
		rowidx++;
	    }
	}

	try {
	    workbook.write(out);
	    workbook.close();
	    workbook.dispose();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /*
     * 每日工单
     * 复杂列头，预先设置列头模板
     * */
    private void getDayColumn(SXSSFWorkbook workbook, SXSSFSheet sheet) {
	SXSSFRow cv = sheet.createRow(0);
	SXSSFCell _cell = cv.createCell(0);
	_cell.setCellValue("日期");
	// int firstRow, int lastRow, int firstCol, int lastCol)
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 1, 0, (short) 0));

	_cell = cv.createCell(1);
	_cell.setCellValue("网络类投诉受理（含焦点）");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 1, (short) 3));

	_cell = cv.createCell(4);
	_cell.setCellValue("本地上网问题");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 4, (short) 8));

	_cell = cv.createCell(9);
	_cell.setCellValue("本地通话问题");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 9, (short) 13));

	// ------------第二行--------------------//
	SXSSFRow cv2 = sheet.createRow(1);
	_cell = cv2.createCell(1);
	_cell.setCellValue("热线派发投诉量");

	_cell = cv2.createCell(2);
	_cell.setCellValue("现场处理投诉量");

	_cell = cv2.createCell(3);
	_cell.setCellValue("现场处理占比");

	_cell = cv2.createCell(4);
	_cell.setCellValue("2G");

	_cell = cv2.createCell(5);
	_cell.setCellValue("3G");

	_cell = cv2.createCell(6);
	_cell.setCellValue("4G");

	_cell = cv2.createCell(7);
	_cell.setCellValue("总计");

	_cell = cv2.createCell(8);
	_cell.setCellValue("本地上网占比");

	_cell = cv2.createCell(9);
	_cell.setCellValue("2G");

	_cell = cv2.createCell(10);
	_cell.setCellValue("3G");

	_cell = cv2.createCell(11);
	_cell.setCellValue("4G");

	_cell = cv2.createCell(12);
	_cell.setCellValue("总计");

	_cell = cv2.createCell(13);
	_cell.setCellValue("本地通话占比");
    }

    /*
     * 每日工单--省级累计汇总
     * 复杂列头，预先设置列头模板
     * */
    private void getProvColumn(SXSSFWorkbook workbook, SXSSFSheet sheet) {
	SXSSFRow cv = sheet.createRow(0);
	SXSSFCell _cell = cv.createCell(0);
	_cell.setCellValue("日期");
	// int firstRow, int lastRow, int firstCol, int lastCol)
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 1, 0, (short) 0));
	setTitleCellStyle(workbook, _cell);

	_cell = cv.createCell(1);
	_cell.setCellValue("网络类投诉受理（含焦点）");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 1, (short) 3));

	_cell = cv.createCell(4);
	_cell.setCellValue("本地上网问题");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 4, (short) 8));

	_cell = cv.createCell(9);
	_cell.setCellValue("本地通话问题");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 9, (short) 13));

	_cell = cv.createCell(14);
	_cell.setCellValue("现场处理");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 14, (short) 17));

	_cell = cv.createCell(18);
	_cell.setCellValue("回访质检");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 18, (short) 20));

	// ------------第二行--------------------//
	SXSSFRow cv2 = sheet.createRow(1);
	_cell = cv2.createCell(1);
	_cell.setCellValue("热线派发投诉量");

	_cell = cv2.createCell(2);
	_cell.setCellValue("现场处理投诉量");

	_cell = cv2.createCell(3);
	_cell.setCellValue("现场处理占比");

	_cell = cv2.createCell(4);
	_cell.setCellValue("2G");

	_cell = cv2.createCell(5);
	_cell.setCellValue("3G");

	_cell = cv2.createCell(6);
	_cell.setCellValue("4G");

	_cell = cv2.createCell(7);
	_cell.setCellValue("总计");

	_cell = cv2.createCell(8);
	_cell.setCellValue("本地上网占比");

	_cell = cv2.createCell(9);
	_cell.setCellValue("2G");

	_cell = cv2.createCell(10);
	_cell.setCellValue("3G");

	_cell = cv2.createCell(11);
	_cell.setCellValue("4G");

	_cell = cv2.createCell(12);
	_cell.setCellValue("总计");

	_cell = cv2.createCell(13);
	_cell.setCellValue("本地通话占比");

	_cell = cv2.createCell(14);
	_cell.setCellValue("计划解决");

	_cell = cv2.createCell(15);
	_cell.setCellValue("未能解决");

	_cell = cv2.createCell(16);
	_cell.setCellValue("已解决");

	_cell = cv2.createCell(17);
	_cell.setCellValue("解决率");

	_cell = cv2.createCell(18);
	_cell.setCellValue("质检通过（闭环）");

	_cell = cv2.createCell(19);
	_cell.setCellValue("质检驳回");

	_cell = cv2.createCell(20);
	_cell.setCellValue("质检通过率");
    }

    /*
     * 每日工单--区县
     * 特殊列头
     */
    private void getHotLineAreaColumn(SXSSFWorkbook workbook, SXSSFSheet sheet) {
	// 区县
	// 热线派发投诉量(焦点）
	// 现场处理投诉量(焦点）
	// 已处理完成(焦点）
	// 质检通过(焦点）
	// 问题闭环占比（质检通过量/现场投诉处理量）
	// 焦点问题闭环占比（质检焦点通过量/现场处理焦点量）
	// 备注

	SXSSFRow cv = sheet.createRow(0);
	SXSSFCell _cell = cv.createCell(0);
	_cell.setCellValue("区县");
	setTitleCellStyle(workbook, _cell);
	// int firstRow, int lastRow, int firstCol, int lastCol)

	_cell = cv.createCell(1);
	_cell.setCellValue("热线派发投诉量(焦点）");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 1, (short) 2));
	setTitleCellStyle(workbook, _cell);

	_cell = cv.createCell(3);
	_cell.setCellValue("现场处理投诉量(焦点）");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 3, (short) 4));
	setTitleCellStyle(workbook, _cell);

	_cell = cv.createCell(5);
	_cell.setCellValue("已处理完成(焦点）");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 5, (short) 6));
	setTitleCellStyle(workbook, _cell);

	_cell = cv.createCell(7);
	_cell.setCellValue("质检通过(焦点）");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 7, (short) 8));
	setTitleCellStyle(workbook, _cell);

	_cell = cv.createCell(9);
	_cell.setCellValue("问题闭环占比（质检通过量/现场投诉处理量）");
	setTitleCellStyle(workbook, _cell);

	_cell = cv.createCell(10);
	_cell.setCellValue("焦点问题闭环占比（质检焦点通过量/现场处理焦点量）");
	setTitleCellStyle(workbook, _cell);

	_cell = cv.createCell(11);
	_cell.setCellValue("备注");
	setTitleCellStyle(workbook, _cell);
    }

    /*
     * 每日工单--地市累计--当月累计
     * 特殊列头
     */
    private void getHotLineCityTotalColumn(SXSSFWorkbook workbook, SXSSFSheet sheet) {
	SXSSFRow cv = sheet.createRow(0);
	SXSSFCell _cell = cv.createCell(0);
	_cell.setCellValue("日期");
	// int firstRow, int lastRow, int firstCol, int lastCol)
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 1, 0, (short) 0));//合并行，第1、2行合并
	setTitleCellStyle(workbook, _cell);//设置单元格样式

	_cell = cv.createCell(1);
	_cell.setCellValue("网络类投诉受理（含焦点）");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 1, (short) 3));//合并列，第2、3、4列合并
	setTitleCellStyle(workbook, _cell);//设置单元格样式

	//注意行索引号和列索引号的偏移量
	_cell = cv.createCell(4);//上面单元格合并2、3、4列，当前列索引号为4（第五列）
	_cell.setCellValue("本地上网问题");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 4, (short) 8));
	setTitleCellStyle(workbook, _cell);//设置单元格样式

	_cell = cv.createCell(9);
	_cell.setCellValue("本地通话问题");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 9, (short) 13));
	setTitleCellStyle(workbook, _cell);//设置单元格样式

	_cell = cv.createCell(14);
	_cell.setCellValue("现场处理");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 14, (short) 17));
	setTitleCellStyle(workbook, _cell);//设置单元格样式

	_cell = cv.createCell(18);
	_cell.setCellValue("回访质检");
	sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 18, (short) 19));
	setTitleCellStyle(workbook, _cell);//设置单元格样式

	// ------------第二行--------------------//
	SXSSFRow cv2 = sheet.createRow(1);
	_cell = cv2.createCell(1);
	_cell.setCellValue("热线派发投诉量");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(2);
	_cell.setCellValue("现场处理投诉量");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(3);
	_cell.setCellValue("现场处理占比");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(4);
	_cell.setCellValue("2G");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(5);
	_cell.setCellValue("3G");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(6);
	_cell.setCellValue("4G");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(7);
	_cell.setCellValue("总计");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(8);
	_cell.setCellValue("本地上网占比");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(9);
	_cell.setCellValue("2G");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(10);
	_cell.setCellValue("3G");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(11);
	_cell.setCellValue("4G");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(12);
	_cell.setCellValue("总计");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(13);
	_cell.setCellValue("本地通话占比");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(14);
	_cell.setCellValue("计划解决");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(15);
	_cell.setCellValue("未能解决");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(16);
	_cell.setCellValue("已解决");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(17);
	_cell.setCellValue("解决率");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(18);
	_cell.setCellValue("质检通过（闭环）");
	setTitleCellStyle(workbook, _cell);

	_cell = cv2.createCell(19);
	_cell.setCellValue("质检驳回");
	setTitleCellStyle(workbook, _cell);
    }

    /*
     * 导出多个Sheet的Excel,复杂列头的
     */
    private void ESSOutExcelComplex(String[] sheetNames, LinkedHashMap<String, LinkedHashMap<String, String>> headMaps, LinkedHashMap<String, List<LinkedHashMap<String, Object>>> datas, OutputStream out) {
	// if(datePattern==null) datePattern = DEFAULT_DATE_PATTERN;
	// 声明一个工作薄
	SXSSFWorkbook workbook = new SXSSFWorkbook(1000);
	// 生成一个(带标题)表格
	// SXSSFSheet sheet = workbook.createSheet();

	LinkedHashMap<String, Integer> hmap = new LinkedHashMap<String, Integer>();

	int colidx = 0;
	for (String sheetName : sheetNames) {
	    SXSSFSheet sheet = workbook.createSheet(sheetName);
	    int rowidx = 1;
	    // 生成复杂列头--自定义复杂列头需要设置
	    if ("全省累计统计".equals(sheetName) || "当月累计统计".equals(sheetName)) {
		getProvColumn(workbook, sheet);
		rowidx = 2;
	    } else if ("当天统计".equals(sheetName)) {
		getDayColumn(workbook, sheet);
		rowidx = 2;
	    } else if ("累计汇总".equals(sheetName) || "本月汇总".equals(sheetName)) {
		getHotLineCityTotalColumn(workbook, sheet);
		rowidx = 2;
	    } else if ("区县".equals(sheetName)) {
		getHotLineAreaColumn(workbook, sheet);
		rowidx = 1;
	    } else {
		// 生成列头
		SXSSFRow cv = sheet.createRow(0);
		Map<String, String> headMap = headMaps.get(sheetName);
		colidx = 0;
		for (Map.Entry<String, String> entry : headMap.entrySet()) {
		    hmap.put(entry.getKey(), colidx);
		    SXSSFCell _cell = cv.createCell(colidx);
		    _cell.setCellValue(entry.getValue());
		    colidx++;
		}
		rowidx = 1;
	    }

	 // 自定义复杂列头需要设置
	    if ("当天统计".equals(sheetName) || "全省累计统计".equals(sheetName) || "当月累计统计".equals(sheetName) || "累计汇总".equals(sheetName) || "本月汇总".equals(sheetName) || "区县".equals(sheetName)) {
		Map<String, String> headMap = headMaps.get(sheetName);
		colidx = 0;
		for (Map.Entry<String, String> entry : headMap.entrySet()) {
		    hmap.put(entry.getKey(), colidx);
		    colidx++;
		}
	    }

	    // 生成数据
	    Object v = null;
	    Object k = null;
	    List<LinkedHashMap<String, Object>> data = datas.get(sheetName);

	    for (Map<String, Object> ls : data) {
		SXSSFRow cvs = sheet.createRow(rowidx);
		for (Entry<String, Object> kv : ls.entrySet()) {
		    k = kv.getKey();
		    if (hmap.containsKey(k)) {
			v = kv.getValue();
			SXSSFCell _cellv = cvs.createCell(hmap.get(k));
			_cellv.setCellValue(v != null ? v.toString() : "");
		    }
		}
		rowidx++;
	    }
	}

	try {
	    workbook.write(out);
	    workbook.close();
	    workbook.dispose();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * 导出单个Sheet简单的控制器
     * 
     * @param sheetName
     * @param fileName
     * @param headMap
     * @param data
     * @param response
     */
    public void ESSOutExcel(String sheetName, String fileName, LinkedHashMap<String, String> headMap, List<LinkedHashMap<String, Object>> data, HttpServletResponse response) {
	try {
	    ByteArrayOutputStream os = new ByteArrayOutputStream();
	    ESSOutExcel(sheetName, headMap, data, 0, os, null);
	    byte[] content = os.toByteArray();
	    InputStream is = new ByteArrayInputStream(content);
	    response.reset();
	    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
	    response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xlsx").getBytes(), "iso-8859-1"));
	    response.setContentLength(content.length);
	    ServletOutputStream outputStream = response.getOutputStream();
	    BufferedInputStream bis = new BufferedInputStream(is);
	    BufferedOutputStream bos = new BufferedOutputStream(outputStream);
	    byte[] buff = new byte[8192];
	    int bytesRead;
	    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
		bos.write(buff, 0, bytesRead);
	    }
	    bis.close();
	    bos.close();
	    outputStream.flush();
	    outputStream.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
/*
 * 导出多Sheet的控制器
 * */
    public void ESSOutExcelMore(String[] sheetNames, String fileName, LinkedHashMap<String, LinkedHashMap<String, String>> headMaps, LinkedHashMap<String, List<LinkedHashMap<String, Object>>> datas, HttpServletResponse response) {
	try {
	    ByteArrayOutputStream os = new ByteArrayOutputStream();
	    ESSOutExcelMore(sheetNames, headMaps, datas, os);
	    byte[] content = os.toByteArray();
	    InputStream is = new ByteArrayInputStream(content);
	    response.reset();
	    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
	    response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xlsx").getBytes(), "iso-8859-1"));
	    response.setContentLength(content.length);
	    ServletOutputStream outputStream = response.getOutputStream();
	    BufferedInputStream bis = new BufferedInputStream(is);
	    BufferedOutputStream bos = new BufferedOutputStream(outputStream);
	    byte[] buff = new byte[8192];
	    int bytesRead;
	    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
		bos.write(buff, 0, bytesRead);
	    }
	    bis.close();
	    bos.close();
	    outputStream.flush();
	    outputStream.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /*
     * 导出多Sheet复杂表头的控制器
     * */
    public void ESSOutExcelComplex(String[] sheetNames, String fileName, LinkedHashMap<String, LinkedHashMap<String, String>> headMaps, LinkedHashMap<String, List<LinkedHashMap<String, Object>>> datas, HttpServletResponse response) {
	try {
	    System.out.println("begin");
	    ByteArrayOutputStream os = new ByteArrayOutputStream();
	    ESSOutExcelComplex(sheetNames, headMaps, datas, os);
	    byte[] content = os.toByteArray();
	    InputStream is = new ByteArrayInputStream(content);
	    response.reset();
	    System.out.println("aaa");
	    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
	    response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xlsx").getBytes(), "iso-8859-1"));
	    response.setContentLength(content.length);
	    ServletOutputStream outputStream = response.getOutputStream();
	    BufferedInputStream bis = new BufferedInputStream(is);
	    BufferedOutputStream bos = new BufferedOutputStream(outputStream);
	    byte[] buff = new byte[8192];
	    int bytesRead;
	    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
		bos.write(buff, 0, bytesRead);
	    }
	    bis.close();
	    bos.close();
	    outputStream.flush();
	    outputStream.close();
	    System.out.println("end");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void ESSOutExcelComplexFile(String[] sheetNames,  LinkedHashMap<String, LinkedHashMap<String, String>> headMaps, 
	    LinkedHashMap<String, List<LinkedHashMap<String, Object>>> datas,String fileName) {
	try {
	    System.out.println("begin");
	    ByteArrayOutputStream os = new ByteArrayOutputStream();
	    ESSOutExcelComplex(sheetNames, headMaps, datas, os);
	    FileOutputStream fos = new FileOutputStream(new File(fileName));
	    os.writeTo(fos);
	    os.flush();
	    os.close();
	    fos.flush();
	    fos.close();

	    System.out.println("end");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /*
     * 设置单元格样式
     * */
    private void setTitleCellStyle(SXSSFWorkbook wb, SXSSFCell cell) {
	CellStyle style = wb.createCellStyle();
	style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
	style.setVerticalAlignment(VerticalAlignment.CENTER);

	Font font = wb.createFont();
	font.setFontHeightInPoints((short) 10);// 设置字体大小
	font.setBold(true);// 粗体显示
	style.setFont(font);

	// 设置单元格的背景颜色为淡蓝色
	style.setFillForegroundColor(HSSFColor.SEA_GREEN.index);
	// style.setFillBackgroundColor(HSSFColor.WHITE.index);
	// 设置填充字体的样式
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	// cell.setCellStyle(style);
    }
}
