package com.gisarmory.autocode;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import com.gisarmory.common.result.Result;
import com.gisarmory.common.utils.JsonPluginsUtil;
import com.gisarmory.common.utils.PostgresUtil;
import com.gisarmory.common.utils.Util;


public class AB_FunctionCode {
	
	
	public void start(){
		basePath = System.getProperty("user.dir")+"\\src\\main\\";
		
		//初始化数据库工具
		pgUtil = new PostgresUtil(postgresUrl, user, passwd);
		
		//获取表字段
		tableFieldList = pgUtil.getTableFieldList(table);	
		
		//获取主键字段名
		Map<String, Object> primarykeyObj = pgUtil.getTablePrimarykey(table);
		if(primarykeyObj != null){
			primarykey = primarykeyObj.get("colname").toString();
			primarykeyType = primarykeyObj.get("typename").toString();
		}else{
			if(tableFieldList != null && tableFieldList.size()>0){
				Map<String, Object> fieldObj = tableFieldList.get(0);
				primarykey = fieldObj.get("field").toString();
				primarykeyType = fieldObj.get("typname").toString();
			}
		}
		
		//设置Dao层前缀
		if(dbType.equals("mybatis")){
			daoPrefix = "D";
		}else if(dbType.equals("jdbc")){
			daoPrefix = "DS";
		}
	}
	
	public String basePath = "";
	public List<Map<String, Object>> tableFieldList;
	
	
	
	//数据库连接
	public PostgresUtil pgUtil;
	public String postgresUrl = "";
	public String user = ""; 
	public String passwd = ""; 

	//配置
	//包、类
	public String packageName = "";	//runmap、guank
	public String fileName = "";	//Dataset
	//注释
	public String funcInfo = "";	//获取、添加、更新、删除
	public String funcDate = "";
	public String funcAuthor = "";
	//方法
	public String funcName = "";	//get、add、update、delete
	//表
	public String table = "";
	public String sqlType = "";	//select、insert、update、delete
	
	//主键和主键类型
	public String primarykey = ""; 
	public String primarykeyType = ""; 
	
	//文件前缀设置
	public String mapPrefix = "M";
	public String daoPrefix = "D";
	
	//数据库连接类型
	public String dbType = "mybatis";	//mybatis 智水地图数据库；jdbc 空间数据库 
	
	
	//删除 Controller层代码
	public void deleteController(){
		String path = getControllerPath();
		String oldStr = getControllerCode();
		String newStr = "//此注释不要删除，用于自动生成代码";
		replaceFileStr_deleteUse(path, oldStr, newStr);
		System.out.println(funcName + " 的 controller 层删除完毕");
	}
	
	
	//Controller层
	public void editController(){
		String path = getControllerPath();
		String oldStr = "//此注释不要删除，用于自动生成代码";
		String newStr = getControllerCode();
		replaceFileStr(path, oldStr, newStr);
		System.out.println(funcName + " 的 controller 层创建完毕");
	}
	
	//获取 Controller 层代码
	public String getControllerCode(){
		
		String newStr = "/**"
				+"\n	 * {funcInfo}"
				+"\n	 * @author {funcAuthor}"
				+"\n	 * @date {funcDate}"
				+"\n	 */"
				+"\n	@RequestMapping(value=\"/{funcName}\")"
				+"\n	public Result {funcName}(@RequestBody String json) {"
				+"\n		try {"
				+"\n			List<Map<String, Object>> result = S_{fileName}.{funcName}(json);"
				+"\n			return Result.success(result);"
				+"\n		} catch (Exception e) {"
				+"\n			e.printStackTrace();"
				+"\n			return Result.error(\"failed.\"+e.getMessage());"
				+"\n		}"
				+"\n	};"
				+"\n"
				+"\n	//此注释不要删除，用于自动生成代码";
		
		newStr = newStr.replace("{funcInfo}", funcInfo);
		newStr = newStr.replace("{funcAuthor}", funcAuthor);
		newStr = newStr.replace("{funcDate}", funcDate);
		newStr = newStr.replace("{funcName}", funcName);
		newStr = newStr.replace("{fileName}", fileName);
		
		return newStr;
	}
	
	// 获取 Controller 层文件的地址
	public String getControllerPath(){
		String path = basePath + "java\\com\\THHSEI\\"+packageName+"\\controller\\C_{fileName}.java";
		path = path.replace("{fileName}", fileName);
		return path;
	}

	//Service层
	public void editService(){
		
		String path = basePath + "java\\com\\THHSEI\\"+packageName+"\\service\\S_{fileName}.java";
		path = path.replace("{fileName}", fileName);
		
		String oldStr = "//此注释不要删除，用于自动生成代码";
		
		String newStr = "/**"
				+"\n	 * {funcInfo}"
				+"\n	 * @author {funcAuthor}"
				+"\n	 * @date {funcDate}"
				+"\n	 */"
				+"\n	public List<Map<String, Object>> {funcName}(String json) throws Exception;"
				+"\n"
				+"\n	//此注释不要删除，用于自动生成代码";
		
		newStr = newStr.replace("{funcInfo}", funcInfo);
		newStr = newStr.replace("{funcAuthor}", funcAuthor);
		newStr = newStr.replace("{funcDate}", funcDate);
		newStr = newStr.replace("{funcName}", funcName);
		
		replaceFileStr(path, oldStr, newStr);
		
		System.out.println(funcName + " 的 service 层创建完毕");
	}
	
	//ServiceImpl层
	public void editServiceImpl(){
		if(dbType.equals("mybatis")){
			editServiceImpl_mybatis();
		}else if(dbType.equals("jdbc")){
			editServiceImpl_jdbc();
		}
	}
	
	//ServiceImpl层
	public void editServiceImpl_mybatis(){
		
		String path = basePath + "java\\com\\THHSEI\\"+packageName+"\\serviceimpl\\SI_{fileName}.java";
		path = path.replace("{fileName}", fileName);
		
		String oldStr = "//此注释不要删除，用于自动生成代码";
		
		String newStr = "/**"
				+"\n	 * {funcInfo}"
				+"\n	 * @author {funcAuthor}"
				+"\n	 * @date {funcDate}"
				+"\n	 */"
				+"\n	@Override"
				+"\n	public List<Map<String, Object>> {funcName}(String json) throws Exception {"
				+"\n		Map<String, Object> paramMap = JsonPluginsUtil.json2Map(json);"
				+"\n		List<Map<String, Object>> list = {daoPrefix}_{fileName}.{funcName}(paramMap);"
				+"\n		if (list!=null && list.size()>0) {"
				+"\n			Util.replaceNull(list, \"-\");"
				+"\n		}"
				+"\n		return list;"
				+"\n	}"
				+"\n"
				+"\n	//此注释不要删除，用于自动生成代码";
		
		newStr = newStr.replace("{funcInfo}", funcInfo);
		newStr = newStr.replace("{funcAuthor}", funcAuthor);
		newStr = newStr.replace("{funcDate}", funcDate);
		newStr = newStr.replace("{funcName}", funcName);
		newStr = newStr.replace("{fileName}", fileName);
		newStr = newStr.replace("{daoPrefix}", daoPrefix);
		
		replaceFileStr(path, oldStr, newStr);
		
		System.out.println(funcName + " 的 serviceimpl 层创建完毕");
	}
	
	//ServiceImpl层
	public void editServiceImpl_jdbc(){
		
		String path = basePath + "java\\com\\THHSEI\\"+packageName+"\\serviceimpl\\SI_{fileName}.java";
		path = path.replace("{fileName}", fileName);
		
		String oldStr = "//此注释不要删除，用于自动生成代码";
		
		String newStr = "/**"
				+"\n	 * {funcInfo}"
				+"\n	 * @author {funcAuthor}"
				+"\n	 * @date {funcDate}"
				+"\n	 */"
				+"\n	@Override"
				+"\n	public List<Map<String, Object>> {funcName}(String json) throws Exception {"
				+"\n		Map<String, Object> paramMap = JsonPluginsUtil.json2Map(json);"
				+"\n		//获取空间数据库连接配置和jdbc"
				+"\n		Map<String, Object> datastoreMap = getDatastoreInfoByMapid(paramMap.get(\"mapid\").toString());"
				+"\n		{daoPrefix}_{fileName} {daoPrefix}_{fileName} = new DI_{fileName}(datastoreMap);"
				+"\n		//执行查询"
				+"\n		List<Map<String, Object>> list = {daoPrefix}_{fileName}.{funcName}(paramMap);"
				+"\n		if (list!=null && list.size()>0) {"
				+"\n			Util.replaceNull(list, \"-\");"
				+"\n		}"
				+"\n		return list;"
				+"\n	}"
				+"\n"
				+"\n	//此注释不要删除，用于自动生成代码";
		
		newStr = newStr.replace("{funcInfo}", funcInfo);
		newStr = newStr.replace("{funcAuthor}", funcAuthor);
		newStr = newStr.replace("{funcDate}", funcDate);
		newStr = newStr.replace("{funcName}", funcName);
		newStr = newStr.replace("{fileName}", fileName);
		newStr = newStr.replace("{daoPrefix}", daoPrefix);
		
		replaceFileStr(path, oldStr, newStr);
		
		System.out.println(funcName + " 的 serviceimpl 层创建完毕");
	}
	
	//Dao层
	public void editDao(){
		if(dbType.equals("mybatis")){
			editDao_mybatis();
		}else if(dbType.equals("jdbc")){
			editDao_jdbc();
		} 
	}
	
	//Dao层
	public void editDao_mybatis(){
		String path = basePath + "java\\com\\THHSEI\\"+packageName+"\\dao\\{daoPrefix}_{fileName}.java";
		path = path.replace("{fileName}", fileName);
		path = path.replace("{daoPrefix}", daoPrefix);
		
		String oldStr = "//此注释不要删除，用于自动生成代码";
		
		String newStr = "/**"
				+"\n	 * {funcInfo}"
				+"\n	 * @author {funcAuthor}"
				+"\n	 * @date {funcDate}"
				+"\n	 */"
				+"\n	public List<Map<String, Object>> {funcName}("
				+"\n			@Param(\"param\") Map<String, Object> param"
				+"\n			);"
				+"\n"
				+"\n	//此注释不要删除，用于自动生成代码";
		
		newStr = newStr.replace("{funcInfo}", funcInfo);
		newStr = newStr.replace("{funcAuthor}", funcAuthor);
		newStr = newStr.replace("{funcDate}", funcDate);
		newStr = newStr.replace("{funcName}", funcName);
		
		replaceFileStr(path, oldStr, newStr);
		
		System.out.println(funcName + " 的 dao 层创建完毕");
	}
	
	//Dao层
	public void editDao_jdbc(){
		String path = basePath + "java\\com\\THHSEI\\"+packageName+"\\dao\\{daoPrefix}_{fileName}.java";
		path = path.replace("{fileName}", fileName);
		path = path.replace("{daoPrefix}", daoPrefix);
		
		String oldStr = "//此注释不要删除，用于自动生成代码";
		
		String newStr = "/**"
				+"\n	 * {funcInfo}"
				+"\n	 * @author {funcAuthor}"
				+"\n	 * @date {funcDate}"
				+"\n	 */"
				+"\n	public List<Map<String, Object>> {funcName}(Map<String, Object> param) throws Exception;"
				+"\n"
				+"\n	//此注释不要删除，用于自动生成代码";
		
		newStr = newStr.replace("{funcInfo}", funcInfo);
		newStr = newStr.replace("{funcAuthor}", funcAuthor);
		newStr = newStr.replace("{funcDate}", funcDate);
		newStr = newStr.replace("{funcName}", funcName);
		
		replaceFileStr(path, oldStr, newStr);
		
		System.out.println(funcName + " 的 dao 层创建完毕");
	}
	
	public void editMapOrDaoImpl(){
		if(dbType.equals("mybatis")){
			editMap();
		}else if(dbType.equals("jdbc")){
			editDaoImpl();
		} 
	}
	
	//DaoImpl层
	public void editDaoImpl(){
		
		String path = basePath + "java\\com\\THHSEI\\"+packageName+"\\daoimpl\\DI_{fileName}.java";
		path = path.replace("{fileName}", fileName);
		
		String oldStr = "//此注释不要删除，用于自动生成代码";
		
		String newStr = "/**"
				+"\n	 * {funcInfo}"
				+"\n	 * @author {funcAuthor}"
				+"\n	 * @date {funcDate}"
				+"\n	 */"
				+"\n	public List<Map<String, Object>> {funcName}(Map<String, Object> param) throws Exception {"
				+"\n		String sql = \"SELECT * FROM {table}\";"
				+"\n	    List<Map<String, Object>> result = super.jdbcTemplateMap.queryForList(sql);"
				+"\n	    return result;"
				+"\n	}"
				+"\n"
				+"\n	//此注释不要删除，用于自动生成代码";
		
		newStr = newStr.replace("{funcInfo}", funcInfo);
		newStr = newStr.replace("{funcAuthor}", funcAuthor);
		newStr = newStr.replace("{funcDate}", funcDate);
		newStr = newStr.replace("{funcName}", funcName);
		newStr = newStr.replace("{fileName}", fileName);
		newStr = newStr.replace("{table}", table);
		
		replaceFileStr(path, oldStr, newStr);
		
		System.out.println(funcName + " 的 editDaoImpl 层创建完毕");
	}
	
	//Map层
	public void editMap(){
		
		String path = basePath + "resources\\mybatis\\"+packageName+"\\{mapPrefix}_{fileName}.xml";
		path = path.replace("{fileName}", fileName);
		path = path.replace("{mapPrefix}", mapPrefix);
		
		String oldStr = "<!-- 此注释不要删除，用于自动生成代码 -->";
		
		String newStr = "";
		if(sqlType.equals("select")){
			newStr = getSelectCode();
		}else if(sqlType.equals("insert")){
			newStr = getInsertCode();
		}else if(sqlType.equals("update")){
			newStr = getUpdateCode();
		}else if(sqlType.equals("delete")){
			newStr = getDeleteCode();
		}
		
		replaceFileStr(path, oldStr, newStr);
		
		System.out.println(funcName + " 的 mapper 层创建完毕");
	}
	
	public String getSelectCode(){
		String newStr = "<!-- {funcInfo} -->"
				+"\n	<select id=\"{funcName}\" parameterType=\"java.util.Map\"  resultType=\"java.util.HashMap\">"
				+"\n		-- {funcName}"
				+"\n		select "
				+"\n			{fieldSqlList}"
				+"\n		from "
				+"\n			\"{table}\" "
				+"\n		where 1=1"
				+"\n			{whereSqlList}"
				+"\n	</select>"
				+"\n"
				+"\n	<!-- 此注释不要删除，用于自动生成代码 -->";
		
		//生成字段
		String fieldSqlList = "";
		String whereSqlList = "";
		for(int i=0; i<tableFieldList.size(); i++){
			Map<String, Object> fieldObj = tableFieldList.get(i);
			String fieldName = fieldObj.get("field").toString();
			String fieldType = fieldObj.get("typname").toString();
			
			//字段说明 xiaolei 2020年3月26日
//			String fieldComment = "";
//			Object commentObject = fieldObj.get("comment");
//			if(commentObject != null){
//				fieldComment = "--"+commentObject.toString();
//			}
			
			String fieldSql = "";
			String fName = "";
			String whereSql = "";
			
			String fiName = "\""+fieldName+"\"";
			//字段如果是时间格式则进行格式转换
			if(fieldType.equals("timestamp")){
				fiName = "to_char(\""+fieldName+"\", 'yyyy-mm-dd hh24:mi:ss') as \""+fieldName+"\"";
			}
//			fieldSql =fName+fiName+"		"+fieldComment;		//带字段说明的版本，因为报错时不方便调试，所以暂时不用  xiaolei 2020年3月26日
			fieldSql =fName+fiName;
			
			//where条件
			whereSql = "<if test=\"param.{fieldName} != null\">"
			+"\n				and \"{fieldName}\" = cast(#{param.{fieldName}} as {fieldType})"
			+"\n			</if>";
			whereSql = whereSql.replace("{fieldName}", fieldName);
			whereSql = whereSql.replace("{fieldType}", fieldType);
			
			if(i>0){
				fieldSql = "\n			,"+fieldSql;
				whereSql = "\n			"+whereSql;
			}
			
			fieldSqlList += fieldSql;
			whereSqlList += whereSql;
		}
		
		newStr = newStr.replace("{funcInfo}", funcInfo);
		newStr = newStr.replace("{funcName}", funcName);
		newStr = newStr.replace("{table}", table);
		newStr = newStr.replace("{fieldSqlList}", fieldSqlList);
		newStr = newStr.replace("{whereSqlList}", whereSqlList);
		
		return newStr;
	}
	
	/**
	 * 插入
	 * 默认第一个为自增长主键
	 */
	public String getInsertCode(){
		String newStr = "<!-- {funcInfo} -->"
				+"\n	<select id=\"{funcName}\" parameterType=\"java.util.Map\"  resultType=\"java.util.HashMap\">"
				+"\n		-- {funcName}"
				+"\n		insert into \"{table}\" "
				+"\n		<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"
				+"\n			{fieldSqlList}"
				+"\n		</trim>"
				+"\n		<trim prefix=\"values (\" suffix=\");\" suffixOverrides=\",\">"
				+"\n			{valueSqlList}"
				+"\n		</trim>"
				+"\n		select max(\"{primarykey}\") as \"{primarykey}\" from \"{table}\""
				+"\n	</select>"
				+"\n"
				+"\n	<!-- 此注释不要删除，用于自动生成代码 -->";
		
		//生成字段
		String fieldSqlList = "";
		String valueSqlList = "";
		for(int i=1; i<tableFieldList.size(); i++){
			Map<String, Object> fieldObj = tableFieldList.get(i);
			String fieldName = fieldObj.get("field").toString();
			String fieldType = fieldObj.get("typname").toString();
			
			String fieldSql = 
					"<if test=\"param."+fieldName+" != null\">"
			    	+"\n				\""+fieldName+"\","
			    	+"\n			</if>";
			String valueSql = 
					"<if test=\"param."+fieldName+" != null\">"
			    	+"\n				cast(#{param."+fieldName+"} as "+fieldType+"),"
			    	+"\n			</if>";
			if(i>1){
				fieldSql = "\n			"+fieldSql;
				valueSql = "\n			"+valueSql;
			}
			fieldSqlList += fieldSql;
			valueSqlList += valueSql;
		}
		
		newStr = newStr.replace("{funcInfo}", funcInfo);
		newStr = newStr.replace("{funcName}", funcName);
		newStr = newStr.replace("{table}", table);
		newStr = newStr.replace("{primarykey}", primarykey);
		newStr = newStr.replace("{fieldSqlList}", fieldSqlList);
		newStr = newStr.replace("{valueSqlList}", valueSqlList);
		
		return newStr;
	}

	public String getUpdateCode(){
		String newStr = "<!-- {funcInfo} -->"
				+"\n	<select id=\"{funcName}\" parameterType=\"java.util.Map\"  resultType=\"java.util.HashMap\">"
				+"\n		-- {funcName}"
				+"\n		update \"{table}\" set"
				+"\n		<trim suffixOverrides=\",\">"
				+"\n			{fieldSqlList}"
				+"\n		</trim>"
				+"\n		where"
				+"\n			\"{primarykey}\" = cast(#{param.{primarykey}} as {primarykeyType})"	
				+"\n	</select>"
				+"\n"
				+"\n	<!-- 此注释不要删除，用于自动生成代码 -->";
		
		//生成字段
		String fieldSqlList = "";
		for(int i=0; i<tableFieldList.size(); i++){
			Map<String, Object> fieldObj = tableFieldList.get(i);
			String fieldName = fieldObj.get("field").toString();
			String fieldType = fieldObj.get("typname").toString();
			String fieldSql = "<if test=\"param."+fieldName+" != null\">"
			    	+"\n				\""+fieldName+"\"=cast(#{param."+fieldName+"} as "+fieldType+"),"
			    	+"\n			</if>";
			if(i>1){
				fieldSql = "\n			" +fieldSql;
			}
			fieldSqlList += fieldSql;
		}
		
		newStr = newStr.replace("{funcInfo}", funcInfo);
		newStr = newStr.replace("{funcName}", funcName);
		newStr = newStr.replace("{table}", table);
		newStr = newStr.replace("{fieldSqlList}", fieldSqlList);
		newStr = newStr.replace("{primarykey}", primarykey);
		newStr = newStr.replace("{primarykeyType}", primarykeyType);
		
		return newStr;
	}

	public String getDeleteCode(){
		String newStr = "<!-- {funcInfo} -->"
				+"\n	<select id=\"{funcName}\" parameterType=\"java.util.Map\"  resultType=\"java.util.HashMap\">"
				+"\n		-- {funcName}"
				+"\n		delete from \"{table}\" "
				+"\n		where"
				+"\n			\"{primarykey}\" = cast(#{param.{primarykey}} as {primarykeyType})"	
				+"\n	</select>"
				+"\n"
				+"\n	<!-- 此注释不要删除，用于自动生成代码 -->";
		
		newStr = newStr.replace("{funcInfo}", funcInfo);
		newStr = newStr.replace("{funcName}", funcName);
		newStr = newStr.replace("{table}", table);
		newStr = newStr.replace("{primarykey}", primarykey);
		newStr = newStr.replace("{primarykeyType}", primarykeyType);
		
		return newStr;
	}

	//Test层
	public void editTest(){
		
		String path = basePath + "resources\\static\\"+packageName+"\\T_{fileName}.html";
		path = path.replace("{fileName}", fileName);
		
		String oldCallStr = "//此注释不要删除，用于自动生成代码，调用方法";
		String newCallStr = "{funcName}();		//{funcInfo}"
				+ "\n\n		//此注释不要删除，用于自动生成代码，调用方法";
		newCallStr = newCallStr.replace("{funcInfo}", funcInfo);
		newCallStr = newCallStr.replace("{funcName}", funcName);
		replaceFileStr(path, oldCallStr, newCallStr);
		
		String oldFuncStr = "//此注释不要删除，用于自动生成代码，方法主体";
		String newFuncStr = "//此注释不要删除，用于自动生成代码，方法主体"
				+"\n"
				+"\n		//{funcInfo}"
				+"\n		function {funcName}(){"
				+"\n			var jsonObj = {"
				+"\n					{whereFiled}"
				+"\n			};"
				+"\n			var jsonStr = JSON.stringify(jsonObj);"
				+"\n			callAjax(\"{funcName}\", jsonStr, \"{funcInfo}，{funcName}\");"
				+"\n		}"
				+"\n		";
		//生成字段
		String whereFiled = "";
		if(tableFieldList.size() > 0){
			Map<String, Object> fieldObj = tableFieldList.get(0);
			String fieldName = fieldObj.get("field").toString();
			String fieldComment = "";
			Object commentObject = fieldObj.get("comment");
			if(commentObject != null){
				fieldComment = "//"+commentObject.toString();
			}
			whereFiled = fieldName+":1		"+fieldComment;
		}
		newFuncStr = newFuncStr.replace("{funcInfo}", funcInfo);
		newFuncStr = newFuncStr.replace("{funcName}", funcName);
		newFuncStr = newFuncStr.replace("{whereFiled}", whereFiled);
		replaceFileStr(path, oldFuncStr, newFuncStr);
		
		System.out.println(funcName + " 的 test 层创建完毕");
	}
	
	/**
	 * 替换文件中的关键字
	 * @param path	文件地址
	 * @param oldStr 待替换字符
	 * @param newStr 替换字符
	 * @throws Exception
	 */
	public void replaceFileStr(String path, String oldStr, String newStr) {
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
                line = line.replace(oldStr, newStr);
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
	 * 替换文件中的关键字
	 * @param path	文件地址
	 * @param oldStr 待替换字符
	 * @param newStr 替换字符
	 * @throws Exception
	 */
	public void replaceFileStr_deleteUse(String path, String oldStr, String newStr) {
        try{
        	//读取文件
            File file=new File(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            //内存流
            CharArrayWriter caw=new CharArrayWriter();
            //替换
            String lineAll = "";
            String line=null;
            //以行为单位进行遍历
            while((line=br.readLine())!=null){
                //替换每一行中符合被替换字符条件的字符串
            	lineAll += line;
            	lineAll += System.getProperty("line.separator");
            }
            //关闭输入流
            br.close();
            int aa = lineAll.indexOf(oldStr);
            lineAll = lineAll.replace(oldStr, newStr); 
            
            //将内存中的流写入源文件
            FileWriter fw=new FileWriter(file);
            fw.write(lineAll);
            fw.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
	

}
