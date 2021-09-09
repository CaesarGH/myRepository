package com.example.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFileLine {


    /**
     * @param @param  path - 文件路径
     * @param @return
     * @return List<String> - 返回读取文件行的集合
     * @throws
     * @Title: getTxtContent
     * @Description: 将文本读取到List中并返回
     */
    public static List<String> getFileContent(String path) {
        List<String> strList = new ArrayList<String>();
        try {
            File file = new File(path);
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                strList.add(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strList;
    }


    /**
     * @param @param path - 文件路径
     * @param @param row - 指定行
     * @return String - 返回指定行的数据,没有指定行时数据返回空字符串
     * @throws
     * @Title: listFileByRow
     * @Description: 获取指定行的值
     */
    public static String listFileByRow(String path, Integer row) {
        List<String> strList = getFileContent(path);
        int size = strList.size();
        if (size >= (row - 1))
            return strList.get(row - 1);
        else
            return "";
    }

    public static List<String> listFileByRegionRow(String path, Integer startLine, Integer endLine) {
        List<String> strList = getFileContent(path);
        //指定区间的值存到regionList
        List<String> regionList = new ArrayList<String>();
        int size = strList.size();
        if (size >= (endLine - 1)) {
            for (int i = startLine; i <= endLine; i++)
                regionList.add(strList.get(i - 1));
        }
        return regionList;
    }

    public static void main(String[] args) {


        int startLine = 17, endLine = 53;
        System.out.println("第" + startLine + "行：" + listFileByRow("D:\\f5-log\\access.log", startLine));

        List<String> regionList = listFileByRegionRow("D:\\f5-log\\access.log", startLine, endLine);
        if (!regionList.isEmpty()) {
            for (String strLine : regionList) {
                System.out.println("第" + startLine + "行：" + strLine);
                startLine++;
            }
        }
    }
}
