package com.gisarmory.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * postgres数据库查询工具
 * @author xiaolei
 * @date 2020年3月26日
 */
public class PostgresUtil {

	public String dbUrl = "";
	public String user = "";
	public String passwd = "";
	
	public PostgresUtil(){
	}
	
	/**
	* @param postgresUrl	数据库连接字符串,示例：jdbc:postgresql://192.168.200.30:5432/runmapdb_dev
	* @param user 数据库连接用户名
	* @param passwd 数据库连接密码
	*/
	public PostgresUtil(String dbUrl, String user, String passwd){
		this.dbUrl = dbUrl;
		this.user = user;
		this.passwd = passwd;
	}
	

    /**
	 * 链接数据库查询数据
	 * 
	 * @param dbUrl	数据库连接字符串,示例：jdbc:postgresql://192.168.200.30:5432/runmapdb_dev
	 * @param user 数据库连接用户名
	 * @param passwd 数据库连接密码
	 * @param sql	要执行的sql语句
	 * @author xiaolei
	 * @date 2020年4月4日
	 */
	public static List<Map<String, Object>> doPostgresSql(String dbUrl, String user, String passwd, String sql) {
		// 调用数据库查询
		PostgresUtil postgresUtil = new PostgresUtil(dbUrl, user, passwd);
		List<Map<String, Object>> resultList = postgresUtil.doPostgresSql(sql);
		return resultList;
	}

	
    /**
	 * 链接数据库查询数据
	 * 
	 * @param sql	要执行的sql语句
	 * @author xiaolei
	 * @date 2019年4月25日
	 */
	public List<Map<String, Object>> doPostgresSql(String sql) {
		// 调用数据库查询
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(dbUrl, user, passwd);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			ResultSetMetaData md = resultSet.getMetaData(); // 获得结果集结构信息,元数据
			int columnCount = md.getColumnCount(); // 获得列数
			while (resultSet.next()) {
				Map<String, Object> rowData = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					Object value = resultSet.getObject(i);
					rowData.put(md.getColumnName(i), value);
				}
				resultList.add(rowData);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		return resultList;
	}

	
    /**
	 * 查询传入表的主键字段名称,只取第一个主键，不适用于联合主键。
	 * <br>
	 * <br><b>pk_name</b>	主键名称
	 * <br><b>colname</b>	主键字段
	 * <br><b>typename</b>	主键字段类型
	 * 
	 * @param tableName	要查询主键信息的表
	 * @author xiaolei
	 * @date 2020年3月26日
	 */
	public Map<String, Object> getTablePrimarykey(String tableName) {
		
		String sql = 
				"SELECT "
				+"	a.conname AS pk_name, "
				+"	c.attname AS colname, "
				+"	d.typname AS typename "
				+"FROM "
				+"	pg_constraint a "
				+"INNER JOIN pg_class b ON a.conrelid = b.oid "
				+"INNER JOIN pg_attribute c ON c.attrelid = b.oid "
				+"AND c.attnum = a.conkey [1] "
				+"INNER JOIN pg_type d ON d.oid = c.atttypid "
				+"WHERE "
				+"	b.relname = '{table}' "
				+"	AND a.contype = 'p'; ";
		sql = sql.replace("{table}", tableName);
		List<Map<String, Object>> dataList = doPostgresSql(sql);
		Map<String, Object> primarykey = null;
		if(dataList.size()>0){
			primarykey = dataList.get(0);
		}
		return primarykey;
	}

	/**
	 * 获取表结构
	 * @param table 要获取表结构的表名称
	 */
	public List<Map<String, Object>> getTableFieldList(String table){
		String sql = "SELECT "
				+"\n	A .attname AS field, "
				+"\n	b.description AS COMMENT "
				+"\n	,typname"	
				+"\nFROM "
				+"\n	pg_class C, "
				+"\n	pg_attribute A "
				+"\nLEFT OUTER JOIN pg_description b ON A .attrelid = b.objoid "
				+"\nAND A .attnum = b.objsubid, "
				+"\n pg_type T "
				+"\nWHERE "
				+"\n	C .relname = '"+table.trim()+"' "
				+"\nAND A .attnum > 0 "
				+"\nAND A .attrelid = C .oid "
				+"\nAND A .atttypid = T .oid "
				+"\nORDER BY "
				+"\n	A .attnum; "
				+"\n";
		List<Map<String, Object>> filedList = doPostgresSql(sql);
		return filedList;
	}

	/**
	 * 获取数据库中的所有表名称
	 */
	public List<Map<String, Object>> getAllTables(){
		String sql = "select tablename from pg_tables where schemaname = 'public';";
		List<Map<String, Object>> filedList = doPostgresSql(sql);
		return filedList;
	}

	/**
	 * 获取数据库中的所有视图名称
	 */
	public List<Map<String, Object>> getAllViews(){
		String sql = "select viewname from pg_views where schemaname = 'public';";
		List<Map<String, Object>> filedList = doPostgresSql(sql);
		return filedList;
	}
	
}
