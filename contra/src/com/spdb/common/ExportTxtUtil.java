package com.spdb.common;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExportTxtUtil {

    private static String path = "D:/versionController/";


    public static void main(String[] args) throws IOException {
//        delFolder(path);//删除文件
//        创建文件
//        txtExport.creatTxtFile("spdbnb","20190514","CJW");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date=df.format(new Date());

        String updateSql="\n\n\n\n--更新菜单图标样式 "+date+" \n" +
                "DECLARE \n" +
                "TAB_NUM NUMBER(4,0);\n" +
                "TABLE_CLOB CLOB;\n" +
                "BEGIN\n" +
                "TABLE_CLOB:= ' insert into SPDB_NB.cfunction(FUNCTION_CODE, FUNCTION_NAME, FUNCTION_PARENT_CODE, FUNCTION_ICON, FUNCTION_HREF, ISVALID)\n" +
                "values (''B-A03-B09'',''终端管理'',''A03''  ,''icon-complaint'',  ''view/specialopt/terminalManagement.html'',  ''1'')';\n" +
                "SELECT COUNT(*) INTO TAB_NUM  from SPDB_NB.cfunction where FUNCTION_CODE='B-A03-B09';\n" +
                "IF TAB_NUM=0 THEN\n" +
                "EXECUTE IMMEDIATE TABLE_CLOB ;\n" +
                "COMMIT;\n" +
                "END IF;\n" +
                "END;";
        ExportTxtUtil.writeTxtFile(updateSql,"D:\\versionController\\spdbnb20190514_CJW.sql");

    }


    /**
     * Description 创建文件(脚本文件，还原脚本文件)
     * @param  proName 项目名称（userperce）
     * @param  version  版本号（20190101）
     * @param  userName 开发用户（CJW）
     * @Author: junwei
     * @Date:18:25 2019/5/8
     **/
    public static boolean creatTxtFile(String proName,String version,String userName ) throws IOException {
        boolean flag = false;
        String filenameTemp = path + proName+version+"_"+userName+".sql";
        File filename = new File(filenameTemp);
        if (!filename.exists()) {
            filename.createNewFile();
            flag = true;
        }

        String filenameTemp2 = path + proName+version+"_"+userName+"_RESET"+ ".sql";
        File filename2 = new File(filenameTemp2);
        if (!filename2.exists()) {
            filename2.createNewFile();
            flag = true;
        }
        return flag;
    }

    /**
     * 写文件
     *
     * @param newStr
     *            新内容
     * @throws IOException
     */
    public static boolean writeTxtFile(String newStr,String filenameTemp) throws IOException {
        // 先读取原有文件内容，然后进行写入操作
        boolean flag = false;
        String filein = newStr + "\r\n";
        String temp = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        PrintWriter pw = null;
        try {
            // 文件路径
            File file = new File(filenameTemp);
            if (!file.exists()) {
                file.createNewFile();
            }
            // 将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            // 保存该文件原有的内容
            for (int j = 1; (temp = br.readLine()) != null; j++) {
                buf = buf.append(temp);
                // System.getProperty("line.separator")
                // 行与行之间的分隔符 相当于“\n”
                buf = buf.append(System.getProperty("line.separator"));
            }
            buf.append(filein);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            flag = true;
        } catch (IOException e1) {
            // TODO 自动生成 catch 块
            throw e1;
        } finally {
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return flag;
    }



    /**
     *  Descript: 删除文件夹下的所有文件
     * @param  folderPath 文件夹目录
     * @Author: junwei
     * @Date:18:29 2019/5/8
     */
    public static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
//            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);//再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }
}
