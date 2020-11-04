package com.gisarmory.blog.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 几何服务
 * @author xiaolei
 * @date 2020年8月31日
 */
@Mapper
public interface D_Geometry {

	
	/**
	 * 图形缓冲,geojson格式
	 * @author xiaolei
	 * @date 2020年8月31日
	 */
	public List<Map<String, Object>> buffer_geojson(
			@Param("param") Map<String, Object> param
			);

	//此注释不要删除，用于自动生成代码
    
    
    
    
}
