package com.gisarmory.common.utils;

import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.DynaBean;
/**
 * 
 * 工具类 <具有项目无关性>
 * 
 */
public class Util extends ConstantUtil{
	
	
	/**
	 * 判断是否为空字符串
	 * @param str
	 * @return 字符串为null 'null' '' 时返回true 否则返回false
	 */
	public static Integer strToInt (String str) {
		
		if(!isNull(str)){
			return Integer.valueOf(str);
		}else{
			return 0;
		}
		
	}
	
	/**
	 * 判断是否为空字符串
	 * @param str
	 * @return 字符串为null 'null' '' 时返回true 否则返回false
	 */
	public static boolean isNull (String str) {
		
		return str == null || "".equals(str.trim()) || "null".equals(str.trim());
		
	}
	
	public static String toString (Object _obj) {
		
		return _obj==null?"":_obj.toString();
		
	}
	
	/**
	 * 替换空字符串
	 * @param str
	 * @return 字符串为null 返回'' 字符串为'null' 返回'' 否则返回str去空格后的字符串
	 */
	public static String replaceNull (String str) {
		
		return (str != null && ! "null".equals(str.trim())) ? str.trim() : "";
		
	}

		 /**
		 * 将String转成Clob ,静态方法
		 * 
		 * @param str
		 *            字段
		 * @return clob对象，如果出现错误，返回 null
		 */
		public static Clob stringToClob(String str) {
			if (null == str)
				return null;
			else {
				try {
					java.sql.Clob c = new javax.sql.rowset.serial.SerialClob(str
							.toCharArray());
					return c;
				} catch (Exception e) {
					return null;
				}
			}
		}

		/**
		 * 将Clob转成String ,静态方法
		 * 
		 * @param clob
		 *            字段
		 * @return 内容字串，如果出现错误，返回 null
		 */
		public static String clobToString(Clob clob) {
			if (clob == null)
				return null;
			StringBuffer sb = new StringBuffer();
			Reader clobStream = null;
			try {
				clobStream = clob.getCharacterStream();
				char[] b = new char[60000];// 每次获取60K
				int i = 0;
				while ((i = clobStream.read(b)) != -1) {
					sb.append(b, 0, i);
				}
			} catch (Exception ex) {
				sb = null;
			} finally {
				try {
					if (clobStream != null) {
						clobStream.close();
					}
				} catch (Exception e) {
				}
			}
			if (sb == null)
				return null;
			else
				return sb.toString();
		}
		
	/**
	 * 将字符串转换成日期
	 * @param str			转换的字符串
	 * @param dateFormat	转换后的日期格式
	 * @return				字符串转换的日期
	 */
	public static Date strtodate(String str, String dateFormat){
		
		Date date = null;
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			if (! isNull(str)) {
				
				date = sdf.parse(str);
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return date;
		
	}
	/**
	 * 将日期转换成格式化字符串
	 * @param date			日期转换成格式化字符串
	 * @param dateFormat	日期格式化形式
	 * @return				格式化后日期的字符串
	 */
	public static String datetostr(Date date,String dateFormat){
		
		String str = null;
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			str = sdf.format(date);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return str;
		
	}
	
	/**
	 * 去字符串中所有的空格
	 * @param str	所需替换的字符串
	 * @return		去所有的空格的字符串
	 */
	public static String replaceBlank(String  str){
		
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		
		Matcher m = p.matcher(str);
		
		String after = m.replaceAll("");
		
		return after;
	}
	/**
	 * 去除当前日期中的- 得到如20101116
	 * 
	 */
	public static String getTodayPath(){
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		return (date+"").replaceAll("-", "");
	}
	/**
	 * 对身份证的有效性进行验证
	 * @param sfzhm		身份证号码
	 * @return			true验证成功 false验证失败
	 */
	public static boolean validateSfzhm(String sfzhm) {
		
		return false;
		
	}
	
	/**
	 * 判断是否为邮箱的格式
	 * @param email
	 * @return
	 */
	public static boolean validateEmail(String email){
		
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
		
	}

	/**
	 * 获取当前日期的年月日
	 * @return String[] [0]年[1]月[2]日[3]时[4]分[5]秒[6]毫秒
	 */
	public static String[] getNowDate () {
		 
		Calendar cal = Calendar.getInstance();
        String[] date = new String[7];
        date[0] = cal.get(Calendar.YEAR) + "";
        date[1] = (cal.get(Calendar.MONTH ) + 1) + "";
        date[2] = cal.get(Calendar.DATE) + "";
        date[3] = cal.get(Calendar.HOUR) + "";
        date[4] = cal.get(Calendar.MINUTE) + "";
        date[5] = cal.get(Calendar.SECOND) + "";
        date[6] = cal.get(Calendar.MILLISECOND) + "";
        return date;
		
	}
	
	public static String getNowDate(Integer print_date_format, final String... vals){
		
		String[] date = getNowDate();
		String _nowdate = null;
		
		if(print_date_format == null){
			
			print_date_format = PRINT_DATE_FORMAT_DEFAULT;
		}
		
		switch (print_date_format){
		
			case 1:{
				
				_nowdate = date[0] + "年" + date[1] + "月" +date[2] + "日";
				
				break;
			}
			
			case 2:{

				_nowdate = date[0] + "/" + date[1] + "/" +date[2] + "/";
				
				break;
			}
			
			case 3:{

				if(vals != null){
					StringBuffer s = new StringBuffer();
					int _length = vals.length;
					for(int i=0; i<_length; i++){
						s.append(date[i]);
						s.append(vals[i]);
					}
					
					_nowdate = s.toString();
				}
				break;
			}
			
			default:{
				System.out.println("break");
				break;
			}
			
		}
		return _nowdate;
	}
	
	/**
	 * 不定参数调用示例
	 * @param vals
	 */
	public static void test(final Object... vals){
		
		if(vals != null){
			for(Object val : vals){
				System.out.println(val);
			}
		}
	}
	/**
	 * 判断字符串长度是否符合
	 * @param minLength		最小长度 <包括>
	 * @param maxLength		最大长度<包括>
	 * @return				true格式正确false格式不正确
	 */
	public static boolean validateLength (String str, int minLength, int maxLength) {
		
		str = replaceNull(str);
		
		if(minLength != -1 && maxLength != -1) {
			
			return minLength<=str.length() && str.length()<=maxLength;
			
		} else{
			
			return true;
			
		}
		
	}
	
	/**
	 * 字符串日期验证
	 * @param strDate		字符串日期
	 * @param dateFormat	字符串日期类型格式
	 * @return				true格式正确false格式不正确
	 */
	public static boolean validateDatestr (String datestr, String dateFormat) {
		
		datestr = replaceNull(datestr);
		
		if (! isNull(datestr)) {
			
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
				
				if (! isNull(datestr)) {
					
					sdf.parse(datestr);
					
				}
				return true;
				
			} catch (Exception e) {
				
				return false;
				
			}
			
		} else{
			
			return false;
			
		}
	}
	/**
	 * 验证是否是Double类型
	 * @param strDouble		字符串Double类型格式
	 * @return				true格式正确false格式不正确
	 */
	public static boolean validateStrDouble (String strDouble) {
		
		strDouble = replaceNull(strDouble);
		
		if (! isNull(strDouble)) {
			
			try {
				
				Double.parseDouble(strDouble);
				return true;
				
			} catch (Exception e) {
				
				return false;
				
			}
			
		} else {
			
			return false;
			
		}
		
	}
	/**
	 * 验证是否是int类型
	 * @param strInt		字符串int类型格式
	 * @return				true格式正确false格式不正确
	 */
	public static boolean validateStrInt (String strInt) {
		
		strInt = replaceNull(strInt);
		
		if (! isNull(strInt)) {
			
			try {
				
				Integer.parseInt(strInt);
				return true;
				
			} catch (Exception e) {
				
				return false;
				
			}
			
		} else {
			
			return false;
			
		}
		
	}
	
	/**
	 * 获取时间戳
	 * @return	时间戳
	 */
	public static long getTimestamp(){
	    
	    return new Date().getTime();
	    
	}
//	/**
//	 * 字符串转化成Clob类型
//	 * @param str
//	 * @return
//	 * @throws Exception
//	 */
//	public static Clob strtoclob(String str) throws Exception { 
//		LobHelper.
//	    return Hibernate.createClob(str);
//	    
//	} 
	
	/**
     * 反射获得方法，若本类不存在该方法则递归调用父类查找，若方法始终不存在返回空
     * @author lzxz
     * @param clazz           类对象
     * @param methodName      方法名
     * @param parameterTypes  方法参数列表
     * @return 此方法获得Method对象总是可用的
	 * @throws NoSuchMethodException 
     */
	public static Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {

        Method method = null;
        try {
            if(clazz == null) return null;
            
            method = clazz.getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);
            
        } catch (NoSuchMethodException e) {
        	method = getMethod(clazz.getSuperclass(), methodName, parameterTypes);
        }
        if(method == null){
        	throw new NoSuchMethodException();
        }
        return method;
    }
	/**
	 * 获取方法名称
	 * @param _name
	 * @param _prefix
	 * @return
	 */
	public static String getMethodName(String _name,String _prefix){
		String str = _prefix+_name.substring(0,1).toUpperCase()+_name.substring(1,_name.length());
//		System.out.println(str);
		return str;
	}
	
	public static Object getMethodValue(Object obj, String attribute){
		Method ms1;
		try {
			ms1 = obj.getClass().getDeclaredMethod(Util.getMethodName(attribute,"get"));
			return ms1.invoke(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 构建树结构 [支持 构建rootValue对应节点下的所有子节点组成的结构树]
	 * 
	 * @param dynaBeanList	查询结果集
	 * @param parentName	父级属性名称
	 * @param rootValue		父级节点属性值
	 * @param keyName		唯一值构建点属性名称
	 * @param keyValue		唯一值构建点属性值
	 * @return
	 */
	public static DynaBean buildTree(List<DynaBean> dynaBeanList, String parentName, String parentValue, String keyName, String keyValue ) {
		
		/**
		 * 逻辑
		 * 先获取 根节点
		 * 构建各节点所属的子节点集合
		 * 再从根节点分层逐级挂接各层节点
		 */
		//根节点
		DynaBean parent = null;
		//各节点所属的子节点集合
		Map<String,List<DynaBean>> treeMap = new HashMap<String,List<DynaBean>>();

		String _temp_pdid = null;
		String _temp_did = null;
		//System.out.println(parentName +"---"+ parentValue +"---"+  keyName +"---"+ keyValue);
		for(DynaBean _dBean : dynaBeanList){
			
			_temp_pdid = (String)_dBean.get(parentName);
			_temp_did = (String)_dBean.get(keyName);
			
			if(!Util.isNull(keyValue)&& keyValue.equals(_temp_did)){//获取 根节点 parentValue.equals(_temp)
				parent = _dBean;
			}else if(Util.isNull(keyValue) && !Util.isNull(parentValue)&& parentValue.equals(_temp_pdid)){//获取 根节点
				parent = _dBean;
			}else if(Util.isNull(keyValue) && Util.isNull(parentValue) && DATA_TREEROOTVALUE.equals(_temp_pdid)){//获取 根节点 如果 两项都为空 默认读取根节点
				parent = _dBean;
			}else{
				if(treeMap.get(_temp_pdid) == null){//构建各节点所属的子节点集合
					treeMap.put(_temp_pdid, new ArrayList<DynaBean>());
				}
				treeMap.get(_temp_pdid).add(_dBean);
			}
			
		}
		//从根节点分层逐级挂接各层节点
		buildChildrenTree(treeMap, parent, keyName);

		return parent;
		
	}
	
	/**
	 * 分层逐级挂接各层节点
	 * 
	 * @param treeMap	各节点所属的子节点集合
	 * @param parent	构建节点
	 * @param keyName	唯一值构建点属性名称
	 */
	private static void buildChildrenTree(Map<String,List<DynaBean>> treeMap, DynaBean parent, String keyName){
		
		List<DynaBean> children = treeMap.get((String)parent.get(keyName));
		if(children == null){
			children = new ArrayList<DynaBean>();
		}
		parent.set("children", children);
		
		if(children != null && children.size() > 0){
			
			for(DynaBean _dBean : children){
				
				buildChildrenTree(treeMap, _dBean, keyName);
			}
		}
	}
	
	/**
	 * 解析出rootValue对应节点下的所有子节点
	 * 
	 * @param dynaBeanList	查询结果集
	 * @param rootValue		根节点值
	 * @param parentName	父级属性名称
	 * @param keyName		唯一值构建点属性名称
	 * @return
	 */
	public static List<DynaBean> buildList(List<DynaBean> dynaBeanList,String parentName, String parentValue, String keyName, String keyValue ) {
		
		/**
		 * 逻辑
		 * 先获取 根节点
		 * 构建各节点所属的子节点集合
		 * 再从根节点分层逐级挂接各层节点
		 */
		//根节点
		List<DynaBean> _list = new ArrayList<DynaBean>();
		DynaBean parent = null;
		//各节点所属的子节点集合
		Map<String,List<DynaBean>> treeMap = new HashMap<String,List<DynaBean>>();

		String _temp_pdid = null;
		String _temp_did = null;
		
		for(DynaBean _dBean : dynaBeanList){
			
			_temp_pdid = (String)_dBean.get(parentName);
			_temp_did = (String)_dBean.get(keyName);
			
			if(!Util.isNull(keyValue)&& keyValue.equals(_temp_did)){//获取 根节点 parentValue.equals(_temp)
				parent = _dBean;
			}else if(Util.isNull(keyValue) && !Util.isNull(parentValue) && parentValue.equals(_temp_pdid)){//获取 根节点
				parent = _dBean;
			}else if(Util.isNull(keyValue) && Util.isNull(parentValue) && DATA_TREEROOTVALUE.equals(_temp_pdid)){//获取 根节点 如果 两项都为空 默认读取根节点
				parent = _dBean;
			}else{
				if(treeMap.get(_temp_pdid) == null){//构建各节点所属的子节点集合
					treeMap.put(_temp_pdid, new ArrayList<DynaBean>());
				}
				treeMap.get(_temp_pdid).add(_dBean);
			}
			
		}
		_list.add(parent);
		//从根节点分层逐级挂接各层节点
		buildChildrenList(treeMap, parent, keyName, _list);

		return _list;
		
	}
	
	/**
	 * 分层逐级挂接各层节点
	 * 
	 * @param treeMap	各节点所属的子节点集合
	 * @param parent	构建节点
	 * @param keyName	唯一值构建点属性名称
	 * @param _list		构建出的集合
	 */
	private static void buildChildrenList(Map<String,List<DynaBean>> treeMap, DynaBean parent, String keyName,List<DynaBean> _list){
		
		List<DynaBean> children = treeMap.get((String)parent.get(keyName));
		if(children == null){
			children = new ArrayList<DynaBean>();
		}
		_list.addAll(children);
		if(children != null && children.size() > 0){
			
			for(DynaBean _dBean : children){
				
				buildChildrenList(treeMap, _dBean, keyName,_list);
			}
		}
	}
	
	
	/**
	 * url传值解码 防中文乱码
	 * @param _s	需解码的字符串
	 * @param _enc	解码
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decode (final String _s,final String _enc) throws UnsupportedEncodingException {
		String _enc_s = "";
		if(_s!=null){
			_enc_s = URLDecoder.decode(_s,_enc).trim();
		}
		return _enc_s;
		
	}
	
	/**
	 * url传值编码 防中文乱码
	 * @param _s 需编码的字符串
	 * @param _enc 编码
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encode (final String _s,final String _enc) throws UnsupportedEncodingException {
		String _enc_s = "";
		if(_s!=null){
			
			_enc_s = URLEncoder.encode(_s,_enc);
		}
		return _enc_s;
		
	}
	
	
	/**
	 * 将字符串包裹在<![CDATA[]]>中
	 * 目的是此字符串需要添加到xml格式的（比如word文件）文件中
	 * 防止导出的xml格式的（比如word文件）文件不发生解析错误
	 * 
	 * @author 陈腾跃
	 * 2014-06-05
	 */
	public static String surroundUnparsedCharacterData(String str){
		
		if(str!=null && !"".equals(str.trim())){
			return "<![CDATA["+str+"]]>";
		}
		
		return "<![CDATA[]]>";
	}
	

	public static Map<String,DynaBean> list2Map(List<DynaBean> _list,String _key){
		
		Map<String,DynaBean> _map = new HashMap<String,DynaBean>();
		if(_list!=null && !Util.isNull(_key)){
			String _temp=null;
			for(DynaBean _db : _list){
				_temp = Util.toString(_db.get(_key));
				if(!Util.isNull(_temp)){
					_map.put(_temp, _db);
				}
				
			}
			
		}
		
		return _map;
	}
	
	/**
	 * 根据生日计算年龄
	 * @param birthDay
	 * @return
	 * @throws Exception
	 */
	public static  int getAge(Date birthDay){ 
        Calendar cal = Calendar.getInstance(); 
        if (cal.before(birthDay)) { 
           return 0;
        } 
        int yearNow = cal.get(Calendar.YEAR); 
        int monthNow = cal.get(Calendar.MONTH)+1; 
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); 
        cal.setTime(birthDay); 
        int yearBirth = cal.get(Calendar.YEAR); 
        int monthBirth = cal.get(Calendar.MONTH); 
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH); 
        int age = yearNow - yearBirth; 
        if (monthNow <= monthBirth) { 
            if (monthNow == monthBirth) { 
                if (dayOfMonthNow < dayOfMonthBirth) { 
                    age--; 
                } 
            } else { 
                age--; 
            } 
        } 
        return age; 
    } 
	
	/**
	 * 十进制 转 二进制
	 * @param _val
	 * @return 
	 */
	public static String int2binary(int _val){
		return Integer.toBinaryString(_val);
	}
	/**
	 * 十进制 转 二进制 
	 * @param _val  十进制数值
	 * @param _digit 转换的位数
	 * @return
	 */
	public static String int2binary(int _val,int _digit){
		String _ret = int2binary(_val);
		
		int _i=0;
		int _count = _digit-_ret.length();
		
		String _tempStr = "";
		if(_count>0){
			while(_i<_count){
				_tempStr+="0";
				_i++;
			}
			return _tempStr+_ret;
		}
		
		return _ret;
		
	}
	/**
	 * 二进制 转 十进制
	 * @param _val
	 * @return
	 */
	public static int binary2int(String _val){
		return Integer.valueOf(_val,2);
	}
	
	/**
	 * @Title: strs2longs   
	 * @Description: string数组转long数组
	 * @param: @return
	 * @author: weizl      
	 * @return: long[]
	 * @date: 2017年5月10日 上午9:53:02      
	 * @throws
	 * @version: V1.0
	 */
	public static long[] strs2longs(String[] strings) {
		if (strings.length>0) {
			long[] ls = new long[strings.length];
			for(int i=0;i<strings.length;i++) {
				ls[i] = Long.parseLong(strings[i]);
			}
			return ls;
		}
		return null;
	}
	
	/**
	 * @Title: replaceNull   
	 * @Description: 将数据中的null替换为“-”
	 * @param: @return
	 * @author: xiaolei      
	 * @return: 
	 * @date: 2017年11月28日  
	 * @throws
	 * @version: V1.0
	 */
	public static List<Map<String, Object>> replaceNull(List<Map<String, Object>> dataList) {
		if(dataList != null){
			for(int i=0; i<dataList.size(); i++){
				Map<String, Object> mapObj = dataList.get(i);
				for (String key : mapObj.keySet()) {  
					Object value = mapObj.get(key);
					if(value != null){
						value = value.toString();
						if(value.equals("") || value.equals("NULL") || value.equals("null")){
							mapObj.replace(key, "-");
						 }
					}else{
						mapObj.replace(key, "-");
					}
				}  
			}
		}
		return dataList;
	}
	
	/**
	 * @Title: replaceNull   
	 * @Description: 将数据中的null替换为指定字符串
	 * @param dataList 要替换的数据
	 * @param replaceStr 制定要替换为的字符串
	 * @author: xiaolei      
	 * @date: 2017年11月28日  
	 * @version: V2.0
	 */
	public static List<Map<String, Object>> replaceNull(List<Map<String, Object>> dataList, String replaceStr) {
		if(dataList != null){
			for(int i=0; i<dataList.size(); i++){
				Map<String, Object> mapObj = dataList.get(i);
				for (String key : mapObj.keySet()) {  
					Object value = mapObj.get(key);
					if(value != null){
						value = value.toString();
						if(value.equals("") || value.equals("NULL") || value.equals("null")){
							mapObj.replace(key, replaceStr);
						 }
					}else{
						mapObj.replace(key, replaceStr);
					}
				}  
			}
		}
		return dataList;
	}
	
	/**
	 * 获取maplist中第一条记录，map中的值。适用于从数据库中查回了一条数据。
	 * @author: xiaolei      
	 * @date: 2020年3月28日
	 */
	public static Object getFirstValFromList(List<Map<String, Object>> dataList, String key) {
		Object value = null;
		if (dataList!=null && dataList.size()>0) {
			Map<String, Object> map = dataList.get(0);
			value = map.get(key);
		}
		return value;
	}
	
	
	
	
}
