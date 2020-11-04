package com.gisarmory.autocode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.gisarmory.common.entity.ReplaceStrEntity;
import com.gisarmory.common.utils.FileStringUtil;
import com.gisarmory.common.utils.FileToolsUtil;

public class AB_ClassCode {
	
	
	public void start(){
		String userDir = System.getProperty("user.dir");
		inBasePath = userDir +"\\src\\main\\resources\\autocode\\fileTemplate\\";
		outBasePath = userDir+"\\src\\main\\";
		replaceParam();
	}
	
	public String inBasePath = "";
	public String outBasePath = "";
	public List<ReplaceStrEntity> replaceList = new ArrayList<ReplaceStrEntity>();
	

	public String packageName = "";		
	public String className = "";
	public String classComment = "";
	public String classAuthor = "";
	public String classDate = "";
	
	//文件前缀设置
	public String mapPrefix = "M";
	public String daoPrefix = "D";

	//对已经存在的文件是否删除重新创建
	public boolean isDeleteExist = false;
	
	
	
	public void replaceParam(){
		replaceList.add(new ReplaceStrEntity("\\{packageName}",packageName));
		replaceList.add(new ReplaceStrEntity("\\{className}",className));
		replaceList.add(new ReplaceStrEntity("\\{classComment}",classComment));
		replaceList.add(new ReplaceStrEntity("\\{classAuthor}",classAuthor));
		replaceList.add(new ReplaceStrEntity("\\{classDate}",classDate));
		replaceList.add(new ReplaceStrEntity("\\{mapPrefix}",mapPrefix));
		replaceList.add(new ReplaceStrEntity("\\{daoPrefix}",daoPrefix));
		
		System.out.println("执行创建文件方法");
	}
	
	
	//Controller层
	public void editController(){
		
		String inPath = inBasePath + "C_Template.java";
		String fileName = "C_"+className+".java";
		String outPath = outBasePath + "java\\com\\THHSEI\\"+packageName+"\\controller\\"+fileName;
		
		doReplaceFile(inPath,outPath, fileName);
	}


	//Service层
	public void editService(){
		
		String inPath = inBasePath + "S_Template.java";
		String fileName = "S_"+className+".java";
		String outPath = outBasePath + "java\\com\\THHSEI\\"+packageName+"\\service\\"+fileName;
		
		doReplaceFile(inPath,outPath, fileName);
	}

	//ServiceImpl层
	public void editServiceImpl(){
		
		String inPath = inBasePath + "SI_Template.java";
		String fileName = "SI_"+className+".java";
		String outPath = outBasePath + "java\\com\\THHSEI\\"+packageName+"\\serviceimpl\\"+fileName;
		
		doReplaceFile(inPath,outPath, fileName);
	}
	
	//Dao层
	public void editDao(){
		
		String inPath = inBasePath + "D_Template.java";
		String fileName = daoPrefix+"_"+className+".java";
		String outPath = outBasePath + "java\\com\\THHSEI\\"+packageName+"\\dao\\"+fileName;
		
		doReplaceFile(inPath,outPath, fileName);
	}
	
	//Map层
	public void editMap(){
		
		String inPath = inBasePath + "M_Template.xml";
		String fileName = mapPrefix+"_"+className+".xml";
		String outPath = outBasePath + "resources\\mybatis\\"+packageName+"\\"+fileName;
		
		doReplaceFile(inPath,outPath, fileName);
	}
	
	//Test层
	public void editTest(){
		
		String inPath = inBasePath + "T_Template.html";
		String fileName = "T_"+className+".html";
		String outPath = outBasePath + "resources\\static\\"+packageName+"\\"+fileName;
		
		doReplaceFile(inPath,outPath, fileName);
	}
	
	//执行替换
	public void doReplaceFile(String inPath, String outPath, String fileName){
		File file = new File(outPath);
		if (!file.exists()) {
			FileToolsUtil.createParentFolder(outPath);
			FileStringUtil.replaceFileStr(inPath, outPath, replaceList);
			System.out.println(fileName + " 创建完毕");
		}else{
			if(isDeleteExist){
				file.delete();
				doReplaceFile(inPath, outPath, fileName);
			}else{
				System.out.println(fileName + " 已经存在");
			}
		}
	}
	

}
