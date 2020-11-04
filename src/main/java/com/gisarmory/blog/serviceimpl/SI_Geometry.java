package com.gisarmory.blog.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gisarmory.blog.service.S_Geometry;
import com.gisarmory.common.utils.JsonPluginsUtil;
import com.gisarmory.common.utils.Util;
import com.gisarmory.blog.dao.D_Geometry;


/**
 * 地图几何计算相关功能，如缓冲分析、叠加分析等。
 * @author xiaolei
 * @date 2018年11月26日
 */
@Service
public class SI_Geometry implements S_Geometry {
	
	
	@Autowired
	private D_Geometry D_Geometry;
	
	
	/**
	 * 图形缓冲,geojson格式
	 * @author xiaolei
	 * @date 2020年8月31日
	 */
	@Override
	public List<Map<String, Object>> buffer_geojson(String json) throws Exception {
		Map<String, Object> paramMap = JsonPluginsUtil.json2Map(json);
		List<Map<String, Object>> list = D_Geometry.buffer_geojson(paramMap);
		if (list!=null && list.size()>0) {
			Util.replaceNull(list, "-");
		}
		return list;
	}

	//此注释不要删除，用于自动生成代码

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
