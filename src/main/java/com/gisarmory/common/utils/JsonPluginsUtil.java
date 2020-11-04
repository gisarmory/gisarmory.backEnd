package com.gisarmory.common.utils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * Json与javaBean之间的转换工具类
 * 

 * 
 * {@code	现使用json-lib组件实现
 * 			需要
 * 				json-lib-2.4-jdk15.jar
 * 				ezmorph-1.0.6.jar
 * 				commons-collections-3.1.jar
 * 				commons-lang-2.0.jar
 * 			支持
 * }
 */
public class JsonPluginsUtil {
	
	
	public static int[] stringToInts(String strs){
		
		List<String> s = com.alibaba.fastjson.JSON.parseArray(strs, String.class);
		
		 int[] n = new int[s.size()];   
		 for(int i = 0;i<s.size();i++){  
			 n[i] = Integer.parseInt(s.get(i));  
		 }  
		 return n;  
	}  
	
	/**
	 * List转json
	 * @author guxuebei
	 * @date 2016年12月22日
	 */
	public static String arrayTojson(List<Object> objectList){
		if(objectList!=null && objectList.size()>0){
			return JSONArray.fromObject(objectList).toString();
		}else{
			return "";
		}
		
	}
	
	/**
	 * List转json
	 * @author guxuebei
	 * @date 2016年12月22日
	 */
	public static String arrayTojson(Object[] objectList){
		if(objectList!=null && objectList.length>0){
			return JSONArray.fromObject(objectList).toString();
		}else{
			return "";
		}
		
	}
	
	/**
	 * 对象转数组
	 * @author guxuebei
	 * @date 2016年12月22日
	 */
	public static String objectTojson(Object object){
		if(object!=null && object != ""){
			return JSONObject.fromObject(object).toString();
		}else{
			return "";
		}
		
	}


	/**  
	 * 从一个JSON 对象字符格式中得到一个java对象  
	 *   
	 * @param jsonString  
	 * @param beanCalss  
	 * @return  
	 */
	@SuppressWarnings("unchecked")
	public static <T> T json2Bean(String jsonString, Class<T> beanCalss) {
		
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		T bean = (T) JSONObject.toBean(jsonObject, beanCalss);
		
		return bean;
		
	}

	/**  
	 * 将java对象转换成json字符串  
	 *
	 * @param bean  
	 * @return  
	 */
	public static String bean2Json(Object bean) {

		JSONObject json = JSONObject.fromObject(bean);
		
		return json.toString();

	}

	
	/**  
	 * 将java对象转换成json字符串  
	 *
	 * @param bean  
	 * @return  
	 */
	public static String bean2Json(Object bean, String[] _nory_changes, boolean nory) {

		JSONObject json = null;
		
		json = JSONObject.fromObject(bean,configJson(getExcludes( bean, _nory_changes, nory)));
		
		return json.toString();

	}
	
	private static String[] getExcludes(Object bean, String[] _nory_changes, boolean nory) {   

		if(nory){//转换_nory_changes里的属性
			
			Field[] fields = bean.getClass().getDeclaredFields();
			String str = "";
			for(Field field : fields){
//				System.out.println(field.getName());
				str+=(":"+field.getName());
			}
			fields = bean.getClass().getSuperclass().getDeclaredFields();
			for(Field field : fields){
//				System.out.println(field.getName());
				str+=(":"+field.getName());
			}
			str+=":";
			for(String s : _nory_changes){
				str = str.replace(":"+s+":", ":");
			}
			return str.split(":");
			
		}else{//转换除了_nory_changes里的属性
			
			return _nory_changes;
		}  

    }  
	
	 private static JsonConfig configJson(String[] excludes) {   

	            JsonConfig jsonConfig = new JsonConfig();   

	            jsonConfig.setExcludes(excludes);   
//
	            jsonConfig.setIgnoreDefaultExcludes(false);
	           
//
//	            jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);   

//	            jsonConfig.registerJsonValueProcessor(Date.class,   
//
//	                new DateJsonValueProcessor(datePattern));   

	          

	            return jsonConfig;   

	        }  




	

	/**
	 * 将java对象List集合转换成json字符串  
	 * @param beans
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String beanList2Json(List beans) {
		
		StringBuffer rest = new StringBuffer();
		
		rest.append("[");
		
		int size = beans.size();
		
		for (int i = 0; i < size; i++) {
			
			rest.append(bean2Json(beans.get(i))+((i<size-1)?",":""));

		}
		
		rest.append("]");
		return rest.toString();

	}
	

	
	/**
	 * 
	 * @param beans
	 * @param _no_changes
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String beanList2Json(List beans, String[] _nory_changes, boolean nory) {
		
		StringBuffer rest = new StringBuffer();
		
		rest.append("[");
		
		int size = beans.size();
		
		for (int i = 0; i < size; i++) {
			try{
				rest.append(bean2Json(beans.get(i),_nory_changes,nory));
				if(i<size-1){
					rest.append(",");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		rest.append("]");
		
		return rest.toString();

	}

	/**  
	 * 从json HASH表达式中获取一个map，需改map支持嵌套功能  
	 *
	 * @param jsonString  
	 * @return  
	 */
	@SuppressWarnings({ "unchecked" })
	public static Map json2Map(String jsonString) {
		
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		Iterator keyIter = jsonObject.keys();
		String key;
		Object value;
		Map valueMap = new HashMap();

		while (keyIter.hasNext()) {
			
			key = (String) keyIter.next();
			value = jsonObject.get(key).toString();
			valueMap.put(key, value);
			
		}

		return valueMap;
	}
	
	/**
	 * map集合转换成json格式数据
	 * @param map
	 * @return
	 */
	public static String mapString2Json(Map<String, ?> map, String[] _nory_changes, boolean nory){
		
		String s_json = "{";
		
		 Set<String> key = map.keySet();
		 for (Iterator<?> it = key.iterator(); it.hasNext();) {
			 String s = (String) it.next();
			 if(map.get(s) == null){
				 
			 }else if(map.get(s) instanceof List<?>){
				 s_json+=(s+":"+JsonPluginsUtil.beanList2Json((List<?>)map.get(s), _nory_changes, nory));
				
			 }else{
				 JSONObject json = JSONObject.fromObject(map);
				 s_json += (s+":"+json.toString());;
			 }
			 
			 if(it.hasNext()){
				 s_json+=",";
			 }
		}

		 s_json+="}";
		return s_json; 
	}
	/**
	 * map集合转换成json格式数据
	 * @param map
	 * @return
	 */
	public static String mapInt2Json(Map<Integer, ?> map, String[] _nory_changes, boolean nory){
		
		String s_json = "{";
		
		 Set<Integer> key = map.keySet();
		 for (Iterator<?> it = key.iterator(); it.hasNext();) {
			 Integer s = (Integer) it.next();
			 if(map.get(s) == null){
				 
			 }else if(map.get(s) instanceof List<?>){
				 s_json+=(s+":"+JsonPluginsUtil.beanList2Json((List<?>)map.get(s), _nory_changes, nory));
				
			 }else{
				 JSONObject json = JSONObject.fromObject(map);
				 s_json += (s+":"+json.toString());;
			 }
			 
			 if(it.hasNext()){
				 s_json+=",";
			 }
		}

		 s_json+="}";
		return s_json; 
	}
	/**
	 * map集合转换成json格式数据
	 * @param map
	 * @return
	 */
	public static String mapInt2Json(Map<Integer, ?> map, Map<Integer,String[]> _nory_changes, Map<Integer,Boolean> norys){
		
		String s_json = "{";
		
		 Set<Integer> key = map.keySet();
		 for (Iterator<?> it = key.iterator(); it.hasNext();) {
			 Integer s = (Integer) it.next();
			 if(map.get(s) == null){
				 
			 }else if(map.get(s) instanceof List<?>){
				 s_json+=(s+":"+JsonPluginsUtil.beanList2Json((List<?>)map.get(s), _nory_changes.get(s), norys.get(s)));
				
			 }else{
				 JSONObject json = JSONObject.fromObject(map);
				 s_json += (s+":"+json.toString());;
			 }
			 
			 if(it.hasNext()){
				 s_json+=",";
			 }
		}

		 s_json+="}";
		return s_json; 
	}
	/**  
	 * 从json数组中得到相应java数组  
	 *
	 * @param jsonString  
	 * @return  
	 */
	public static Object[] json2ObjectArray(String jsonString) {
		
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		
		return jsonArray.toArray();

	}
	
	public static String list2Json(List<?> list) {
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		
		return jsonArray.toString();

	}

	/**  
	 * 从json对象集合表达式中得到一个java对象列表  
	 *
	 * @param jsonString  
	 * @param beanClass  
	 * @return  
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> json2BeanList(String jsonString, Class<T> beanClass) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject jsonObject;
		T bean;
		int size = jsonArray.size();
		List<T> list = new ArrayList<T>(size);

		for (int i = 0; i < size; i++) {

			jsonObject = jsonArray.getJSONObject(i);
			bean = (T) JSONObject.toBean(jsonObject, beanClass);
			list.add(bean);

		}
		
		return list;

	}

	/**  
	 * 从json数组中解析出java字符串数组  
	 *
	 * @param jsonString  
	 * @return  
	 */
	public static String[] json2StringArray(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		String[] stringArray = new String[jsonArray.size()];
		int size = jsonArray.size();

		for (int i = 0; i < size; i++) {

			stringArray[i] = jsonArray.getString(i);

		}

		return stringArray;
	}

	/**  
	 * 从json数组中解析出javaLong型对象数组  
	 *
	 * @param jsonString  
	 * @return  
	 */
	public static Long[] json2LongArray(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		int size = jsonArray.size();
		Long[] longArray = new Long[size];
		
		for (int i = 0; i < size; i++) {
			
			longArray[i] = jsonArray.getLong(i);

		}
		
		return longArray;
		
	}

	/**  
	 * 从json数组中解析出java Integer型对象数组  
	 *
	 * @param jsonString  
	 * @return  
	 */
	public static Integer[] json2IntegerArray(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		int size = jsonArray.size();
		Integer[] integerArray = new Integer[size];
		
		for (int i = 0; i < size; i++) {
			
			integerArray[i] = jsonArray.getInt(i);

		}
		
		return integerArray;
		
	}

	/**  
	 * 从json数组中解析出java Double型对象数组  
	 *
	 * @param jsonString  
	 * @return  
	 */
	public static Double[] json2DoubleArray(String jsonString) {

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		int size = jsonArray.size();
		Double[] doubleArray = new Double[size];
		
		for (int i = 0; i < size; i++) {
			
			doubleArray[i] = jsonArray.getDouble(i);

		}
		
		return doubleArray;
		
	}
	
	


	public static void main(String[] args) {
		
		
		
		
		
	}
	/**
	 * 对象转json，格式化时间字段
	 * @param bean
	 * @param dateFormat "yyyy-MM-dd"
	 * @return
	 */
	public static String bean2jsonForDate(Object bean,String dateFormat){
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor(dateFormat));
		JSONObject json = JSONObject.fromObject(bean, jsonConfig);
		return json.toString();
	}
    /**
     * json时间处理器
     * @author hujun
     *
     */
	static class DateJsonValueProcessor implements JsonValueProcessor {
		private String format = "yyyy-MM-dd";

		public DateJsonValueProcessor() {
		}

		public DateJsonValueProcessor(String format) {
			if(format!=null&&!"".equals(format))
			this.format = format;
		}

		public Object processArrayValue(Object value, JsonConfig jsonConfig) {
			String[] obj = {};
			if (value instanceof Date[]) {
				SimpleDateFormat sf = new SimpleDateFormat(format);
				Date[] dates = (Date[]) value;
				obj = new String[dates.length];
				for (int i = 0; i < dates.length; i++) {
					obj[i] = sf.format(dates[i]);
				}
			}
			return obj;
		}

		public Object processObjectValue(String key, Object value,
				JsonConfig jsonConfig) {
			if (value instanceof Date) {
				String str = new SimpleDateFormat(format).format((Date) value);
				return str;
			}
			if(value!=null){
				return value.toString();
			}
			return null;
		}

		public String getFormat() {
			return format;
		}

		public void setFormat(String format) {
			this.format = format;
		}

	}
}
