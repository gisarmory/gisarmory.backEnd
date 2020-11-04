package com.gisarmory.autocode;


public class A_ClassCode extends AB_ClassCode {
	
	public static void main(String[] args) {

		A_ClassCode classCode = new A_ClassCode();
		classCode.initParam();	
		classCode.start();
		classCode.autoCreateFile();	
	}
	
	//参数
	public void initParam(){
		packageName = "runmap";		//runmap、guank
		className = "Geometry";
		classComment = "几何服务";
		classAuthor = "xiaolei";
		classDate = "2020年8月31日";
	}
	
	//执行创建方法
	public void autoCreateFile(){
		
//		editController();
//		editService();
//		editServiceImpl();
//		editDao();
//		editMap();
//		editTest();
	}
	
	
	

}
