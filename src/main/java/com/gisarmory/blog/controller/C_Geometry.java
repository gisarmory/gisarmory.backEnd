package com.gisarmory.blog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gisarmory.common.result.Result;
import com.gisarmory.blog.service.S_Geometry;;
/**
 * 智水地图API，地图服务能力扩展，几何服务。
 * 地图几何计算相关功能，如缓冲分析、叠加分析等。
 * @author xiaolei
 * @date 2018年11月26日
 */
@RestController
@RequestMapping(value="/geometry")
public class C_Geometry {
	
	@Autowired
	private S_Geometry S_Geometry;
	
	
	/**
	 * 图形缓冲,geojson格式
	 * @author xiaolei
	 * @date 2020年8月31日
	 */
	@RequestMapping(value="/buffer_geojson")
	public Result buffer_geojson(@RequestBody String json) {
		try {
			List<Map<String, Object>> result = S_Geometry.buffer_geojson(json);
			return Result.success(result);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("failed."+e.getMessage());
		}
	};

	//此注释不要删除，用于自动生成代码
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
