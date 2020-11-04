package com.gisarmory.common.utils;


import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.gisarmory.common.entity.ReplaceStrEntity;

import java.util.List;

public class FileStringUtil {

	public static void main(String[] args) {

	}


	/**
	 * 替换文件中的关键字,同一个文件
	 * @param path	文件地址
	 * @param oldStr 待替换字符
	 * @param newStr 替换字符
	 * @throws Exception
	 */
	public static void replaceFileStr(String path, String oldStr, String newStr) {
        try{
        	//读取文件
            File file=new File(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            //内存流
            CharArrayWriter caw=new CharArrayWriter();
            //替换
            String line=null;
            //以行为单位进行遍历
            while((line=br.readLine())!=null){
                //替换每一行中符合被替换字符条件的字符串
                line = line.replaceAll(oldStr, newStr);
                //将该行写入内存
                caw.write(line);
                //添加换行符，并进入下次循环
                caw.append(System.getProperty("line.separator"));
            }
            //关闭输入流
            br.close();
            //将内存中的流写入源文件
            FileWriter fw=new FileWriter(file);
            caw.writeTo(fw);
            fw.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
    }

	/**
	 * 替换文件中的关键字,替换后输出到另一个文件
	 * @param inPath	读取的文件地址
	 * @param outPath	输出的文件地址
	 * @param oldStr 待替换字符
	 * @param newStr 替换字符
	 * @throws Exception
	 */
	public static void replaceFileStr(String inPath, String outPath, List<ReplaceStrEntity> replaceStrList) {
        try{
        	//读取文件
            File file=new File(inPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            //内存流
            CharArrayWriter caw=new CharArrayWriter();
            //替换
            String line=null;
            //以行为单位进行遍历
            while((line=br.readLine())!=null){
            	
            	for(ReplaceStrEntity replaceObj : replaceStrList){
            		//替换每一行中符合被替换字符条件的字符串
            		String oldStr = replaceObj.getOldString();
            		String newStr = replaceObj.getNewString();
                    line = line.replaceAll(oldStr, newStr);
            	}
                
                //将该行写入内存
                caw.write(line);
                //添加换行符，并进入下次循环
                caw.append(System.getProperty("line.separator"));
            }
            //关闭输入流
            br.close();
            //将内存中的流写入源文件
            FileWriter fw=new FileWriter(outPath);
            caw.writeTo(fw);
            fw.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
    }


	/**
	 * 获取文件中的内容
	 * @param path	文件地址
	 * @throws Exception
	 */
	public static String getFileString(String path) {
		String lineAll = "";
		try{
        	//读取文件
            File file=new File(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            //文本
            String line=null;
            //以行为单位进行遍历
            while((line=br.readLine())!=null){
                //替换每一行中符合被替换字符条件的字符串
            	lineAll += line;
            	//添加换行符，并进入下次循环
            	lineAll += System.getProperty("line.separator");
            }
            //关闭输入流
            br.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
		return lineAll;
    }

	/**
	 * 创建文件，并写入内容
	 */
	public static void writeStringToFile(String filePath, String fileContent) {
        try{
        	File file=new File(filePath);
        	File fileParentPath = file.getParentFile();
        	if(!fileParentPath.exists()){
        		fileParentPath.mkdirs();
        	}
        	
        	OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(filePath),"utf-8");
        	out.write(fileContent);
        	out.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
	
	
}
