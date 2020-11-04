package com.gisarmory.autocode;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gisarmory.common.utils.DateToolsUtil;
import com.gisarmory.common.utils.PostgresUtil;


public class A_TableCode {
	

	public static void main(String[] args) {
		new A_TableCode();
	}
	

	//数据库连接
	public PostgresUtil pgUtil;
	public String postgresUrl = A_DataSource.url;
	public String user = A_DataSource.username; 
	public String passwd = A_DataSource.password; 

	//配置
	//包、类
	public String packageName = "runmap";		
	//注释
	public String funcDate = "";
	public String funcAuthor = "工具自动创建";
	
	
	public A_TableCode(){
		
//		funcDate = DateToolsUtil.dateToStr(new Date(), DateToolsUtil.DATEFORMAT_YMD);
		
		pgUtil = new PostgresUtil(postgresUrl, user, passwd);
		
		//查询所有表
		String sql = "select tablename from pg_tables where schemaname = 'public' and tablename like 'tb_rmap%';";
		List<Map<String, Object>> filedList = pgUtil.doPostgresSql(sql);
		for(Map<String, Object> tableObj : filedList){
			String tableName = tableObj.get("tablename").toString();
			addFileAndCode(tableName);
		}
		
		//查询所有视图
//		List<Map<String, Object>> allView = pgUtil.getAllViews();
//		for(Map<String, Object> viewObj : allView){
//			String viewname = viewObj.get("viewname").toString();
//			addFileAndCode(viewname);
//		}
	}
	
	//添加文件和代码
	public void addFileAndCode(String tableName){
		addClassFile(tableName);
		addFunctionCode(tableName, "select", "查询");
		addFunctionCode(tableName, "insert", "增加");
		addFunctionCode(tableName, "update", "更新");
		addFunctionCode(tableName, "delete", "删除");
	}
	
	//为每一张表创建一个dao文件和map文件
	public void addClassFile(String tableName){
		AB_ClassCode fileUtil = new AB_ClassCode();
		fileUtil.packageName = packageName;
		fileUtil.className = tableName;
		fileUtil.classComment = "数据库表,工具自动创建";
		fileUtil.classAuthor = funcAuthor;
		fileUtil.classDate = funcDate;
		fileUtil.mapPrefix = "MT";
		fileUtil.daoPrefix = "DT";
		fileUtil.isDeleteExist = true;
		fileUtil.start();
		fileUtil.editDao();
		fileUtil.editMap();
	}
	
	//为每一个dao文件和map文件写入增删改查代码
	public void addFunctionCode(String tableName, String funcName, String funcInfo){
		AB_FunctionCode funcUtil = new AB_FunctionCode();
		//数据库连接
		funcUtil.postgresUrl = postgresUrl;
		funcUtil.user = user; 
		funcUtil.passwd = passwd; 
		//包、类
		funcUtil.packageName = packageName;	
		funcUtil.fileName = tableName;	
		//注释
		funcUtil.funcInfo = funcInfo;	//获取、添加、更新、删除
		funcUtil.funcAuthor = funcAuthor;
		funcUtil.funcDate = funcDate;
		//方法
		funcUtil.funcName = funcName;	//select、insert、update、delete
		//表
		funcUtil.table = tableName;
		funcUtil.sqlType = funcName;		//select、insert、update、delete
		//前缀
		funcUtil.mapPrefix = "MT";
		funcUtil.daoPrefix = "DT";
		funcUtil.start();
		funcUtil.editDao();
		funcUtil.editMap();
	}
	
	
	
	

}
