package com.gisarmory.autocode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

public class A_FunctionCode extends AB_FunctionCode {
	
	public static void main(String[] args) {
		
		A_FunctionCode functionCode = new A_FunctionCode();
		functionCode.initParam();	//初始化参数
		functionCode.start();		//初始化底层参数
		functionCode.autoCreateCode();		//开始执行 
	}
	
	public void initParam(){
		
		//数据库连接
		postgresUrl = A_DataSource.url;
		user = A_DataSource.username; 
		passwd = A_DataSource.password; 
		
		//配置
		//包、类
		packageName = "runmap";	//runmap、guank
		fileName = "Geometry";	//Website、MapFeature、Geometry、NewProject
		//注释
		funcInfo = "缓冲查询";	//获取、添加、更新、删除
		funcDate = "2020年11月3日";
		funcAuthor = "xiaolei";
		//方法
		funcName = "buffer_ellipse";	//get、add、update、delete
		//表
		table = "tb_rmap_layer";
		sqlType = "select";		//select、insert、update、delete
		//数据库连接类型
		dbType = "jdbc";		//mybatis 智水地图数据库；jdbc 空间数据库 
	}
	
	//执行创建方法
	public void autoCreateCode(){
		
//		editController();
//		editService();
//		editServiceImpl();
//		editDao();
//		editMapOrDaoImpl();
//		editTest();
		
	}
	
	
	
	

}
