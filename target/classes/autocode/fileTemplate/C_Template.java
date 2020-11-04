package com.THHSEI.{packageName}.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.THHSEI.common.result.Result;
import com.THHSEI.{packageName}.service.S_{className};


/**
 * {classComment}
 * @author {classAuthor}
 * @date {classDate}
 */
@RestController
@RequestMapping(value="/{className}")
public class C_{className} {
	
	@Autowired
	private S_{className} S_{className};

	
	//此注释不要删除，用于自动生成代码
	
	
	
}
