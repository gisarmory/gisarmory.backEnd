package com.gisarmory.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.beanutils.DynaBean;

/**
 * 常量类
 * @author 
 *
 */
public class ConstantUtil {

	/**
	 * 日期格式 yyyy-MM-dd
	 */
	public static final String DATE_FORMAT_YMD = "yyyy-MM-dd";
	
	/**
	 * 日期格式 yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATE_FORMAT_YMD_HMS = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 日期格式 yyyy-MM-dd HH:mm
	 */
	public static final String DATE_FORMAT_YMD_HM = "yyyy-MM-dd HH:mm";
	
	/**
	 * default输出日期格式为yyyy-mm-dd
	 */
	public static final int PRINT_DATE_FORMAT_DEFAULT = 0;
	/**
	 * 输出日期格式为yyyy年mm月dd日
	 */
	public static final int PRINT_DATE_FORMAT1 = 1;
	/**
	 * 输出日期格式为yyyy/mm/dd日
	 */
	public static final int PRINT_DATE_FORMAT2 = 2;
	
	
	/**
	 * 输出日期格式为自定义
	 */
	public static final int PRINT_DATE_FORMAT3 = 3;
	
	/**
	 * 时间24小时制
	 */
	public static final int DATE_FORMAT_24H = 0;
	
	/**
	 * 时间12小时制
	 */
	public static final int DATE_FORMAT_12H = 1;
	
	
	/**
	 * 第一页
	 */
	public static  final String PAGE_FIRST_HANDER = "first";
	/**
	 * 最后一页
	 */
	public static  final String PAGE_LAST_HANDER = "last";
	/**
	 * 上一页
	 */
	public static  final String PAGE_PRE_HANDER = "pre";
	/**
	 * 下一页
	 */
	public static  final String PAGE_NEXT_HANDER = "next";
	/**
	 * go 页
	 */
	public static  final String PAGE_GO_HANDER = "go";
	
	/**
	 * 刷新本页
	 */
	public static  final String PAGE_REFRESH_HANDER = "refresh";
	
	/**
	 *不分页
	 */
	public static  final String PAGE_NO_PAGE = "nopage";
	

	/**
	 * 删除标记（0：未删除；1：删除）
	 */
	public static final int DELETEFLAG = 1;
	
	/**
	 * 新建
	 */
	public static  final int ORDER_0 = 0;
	
	/**
	 * 未执行
	 */
	public static  final int ORDER_1 = 1;
	
	/**
	 * 执行中
	 */
	public static  final int ORDER_2 = 2;
	
	
	/**
	 * 挂起
	 */
	public static  final int ORDER_3 = 3;
	/**
	 * 退单
	 */
	public static  final int ORDER_4 = 4;
	
	/**
	 * 完成回单
	 */
	public static  final int ORDER_5 = 5;
	/**
	 * 已审核
	 */
	public static  final int ORDER_6 = 6;
	
	/**
	 * 完成
	 */
	public static  final int ORDER_7 = 7;
	/**
	 * 审核未通过
	 */
	public static  final int ORDER_8 = 8;
	/**
	 * 验收未通过
	 */
	public static  final int ORDER_9 = 9;
	
	/**
	 * 外部特殊退单
	 */
	public static  final int ORDER_10 = 10;
	
	/**
	 * 关系表 过河管 提交状态 0未提交 
	 */
	public static  final int WORK_RELATION_0 = 0;
	
	/**
	 * 关系表 过河管 提交状态  1 已提交
	 */
	public static  final int WORK_RELATION_1 = 1;
	
	/**
	 * elementType:过河管传21
	 */
	public static  final String ELEMENTTYPE = "21";
	
	/**
	 * 下载servlet访问路径
	 */
	public static  final String DOWNLOAD_SERVLET = "servlet/download/DownloadServlet";
	
	/**
	 * 数据常量 树根节点的pdid的数据值
	 */
	public static final String DATA_TREEROOTVALUE = "-1";
	
	
	/*
	 * 设备信息台账管理
	 */
	/**
	 * 特殊：设备台账信息--设备信息管理
	 * 用户需要查看当前权限下所有设备
	 * 查询时idType仍然为1，但是id为一个特殊值
	 * 	如果为此特殊值，查询所有设备
	 */
	public static final String ALLEQUIPMENTINFOID = "-2";
	
	/**
	 * 临时设备
	 */
	public static final int EQUIPMENT_TYPE_TEMPORARYEQUIPMENT = 1;

	/**
	 * 正常设备
	 */
	public static final int EQUIPMENT_TYPE_NORMALEQUIPMENT = 0;
	
	/**
	 * 验证通过  通用
	 */
	public static final int CHECKPASS = 1;
	/**
	 * 验证不通过  通用
	 */
	public static final int CHECKNOPASS = -1;
	/**
	 * 数据库服务异常  通用
	 */
	public static final int DATABASESERVICEEXCEPITON = -10;
	/**
	 * 参数错误  通用
	 */
	public static final int PARAMERROR = -11;
	/**
	 * 值为空  通用
	 */
	public static final int VALUEISNULL = -21;
	/**
	 * 违反唯一性约束条件  通用
	 */
	public static final int ISNOTONLY = -22;
	/**
	 * 有相关数据绑定
	 */
	public static final int HAVERELEVANTDATA = -23;
	
	/**
	 * 设备状态
	 */
	/**
	 * 在用
	 */
	public static final int EQUIPMENT_STATE_USE = 1;

	/**
	 * 闲置可用
	 */
	public static final int EQUIPMENT_STATE_IDLEAVAILABEL = 2;

	/**
	 * 闲置故障
	 */
	public static final int EQUIPMENT_STATE_IDLEFAULT = 3;

	/**
	 * 故障
	 */
	public static final int EQUIPMENT_STATE_FAULT = 4;

	/**
	 * 报废
	 */
	public static final int EQUIPMENT_STATE_SCRAPPED = 5;
	
	/**
	 * 设备变更申请类型——启用
	 */
	public static final int EQUIPMENTCHANGE_TYPE_QY = 1;
	/**
	 * 设备变更申请类型——闲置
	 */
	public static final int EQUIPMENTCHANGE_TYPE_XZ = 2;
	/**
	 * 设备变更申请类型——转移
	 */
	public static final int EQUIPMENTCHANGE_TYPE_ZY = 4;
	/**
	 * 设备变更申请类型——报废
	 */
	public static final int EQUIPMENTCHANGE_TYPE_BF = 5;
	
	/**
	 * 设备变更级别——所属部门负责人审批
	 */
	public static final int EQUIPMENTCHANGE_LEVE_BMLDSP = 0;
	/**
	 * 设备变更级别——设备科审批
	 */
	public static final int EQUIPMENTCHANGE_LEVE_SBKSP = 1;
	/**
	 * 设备变更级别——资产管理领导审批 
	 */
	public static final int EQUIPMENTCHANGE_LEVE_ZCGLLDSP = 2;
	/**
	 * 设备变更级别——财务总监
	 */
	public static final int EQUIPMENTCHANGE_LEVE_CWZJSP = 3;
	/**
	 * 设备变更级别——总经理审批
	 */
	public static final int EQUIPMENTCHANGE_LEVE_ZJLSP = 4;
	/**
	 * 设备变更级别——财务部确认
	 */
	public static final int EQUIPMENTCHANGE_LEVE_CWBQR = 5;
	/**
	 * 设备变更级别——转入部门负责人审批
	 */
	public static final int EQUIPMENTCHANGE_LEVE_ZUBMLDSP = 6;
	
	/**
	 * 设备变更状态——未提交
	 */
	public static final int EQUIPMENTCHANGE_state_wtj = 0;
	/**
	 * 设备变更状态——待所属部门负责人审核
	 */
	public static final int EQUIPMENTCHANGE_state_dssbmfzrsh = 1;
	/**
	 * 设备变更状态——待设备科审核
	 */
	public static final int EQUIPMENTCHANGE_state_dsbksh = 2;
	/**
	 * 设备变更状态——待资产分管领导审核
	 */
	public static final int EQUIPMENTCHANGE_state_dzcfgldsh = 3;
	/**
	 * 设备变更状态——待财务领导审核
	 */
	public static final int EQUIPMENTCHANGE_state_dcwldsh = 4;
	/**
	 * 设备变更状态——待总经理审核
	 */
	public static final int EQUIPMENTCHANGE_state_dzjlsh = 5;
	/**
	 * 设备变更状态——审核通过
	 */
	public static final int EQUIPMENTCHANGE_state_shtg = 6;
	/**
	 * 设备变更状态——审核不通过
	 */
	public static final int EQUIPMENTCHANGE_state_shbtg = 7;
	/**
	 * 设备变更状态——财务部已确认
	 */
	public static final int EQUIPMENTCHANGE_state_cwbyqr = 8;
	/**
	 * 设备变更状态——待转入部门负责人审核
	 */
	public static final int EQUIPMENTCHANGE_state_dzrbmfzrsh = 9;
	
	
	
	/**
	 * 设备基本信息
	 */
	//	数据库服务发生异常
	public static final int EQUIPMENT_STANDINGBOOK_BASEINFO_DBEXCEPTION = -1110; 
	//	参数错误
	public static final int EQUIPMENT_STANDINGBOOK_BASEINFO_PARAERROR = -1111;
	//	设备名称为空
	public static final int EQUIPMENT_STANDINGBOOK_BASEINFO_NAMEISNULL = -1121;
	//	资产编号不唯一
	public static final int EQUIPMENT_STANDINGBOOK_BASEINFO_FINANCIALNOTONLY = -1131;
	//	设备大类必须选择
	public static final int EQUIPMENT_STANDINGBOOK_BASEINFO_CLASSNOTCHOICE = -1141;
	//	设备编号非空的情况下全局不唯一
	public static final int EQUIPMENT_STANDINGBOOK_BASEINFO_EQUIPMENTCODENOTONLY = -1151;
	//	查询时id为空、0或负数
	public static final int EQUIPMENT_STANDINGBOOK_BASEINFO_IDERROR = -1112;
	/**
	 * 设备基本信息EXCEL导出
	 */
	//	模板目录路径
	public static final String EQUIPMENTEXCELRESOURCEDIR = "\\resource\\excel\\";
	//	模板名称 
	public static final String EQUIPMENTTEMPLATEFILENAME = "Equipment_basic_information_template.xls";
	//	导出失败（流错误 或 输入输出异常 或 模板丢失）
	public static final int EQUIPMENT_STANDINGBOOK_EXPORTEXCEL_EXPORTFAIL = -1112;
	//	没有数据，不予导出
	public static final int EQUIPMENT_STANDINGBOOK_EXPORTEXCEL_NODATA = -1113;
	/**
	 * 配件信息
	 */
	//	数据库服务异常
	public static final int EQUIPMENT_STANDINGBOOK_FITTING_DBEXCEPTION = -2210;
	//	参数错误
	public static final int EQUIPMENT_STANDINGBOOK_FITTING_PARAERROR = -2211;
	//	名称为空
	public static final int EQUIPMENT_STANDINGBOOK_FITTING_NAMEISNULL = -2221;
	//	规格型号为空
	public static final int EQUIPMENT_STANDINGBOOK_FITTING_MODELISNULL = -2231;
	/**
	 * 技术参数
	 */
	//	数据库服务异常
	public static final int EQUIPMENT_STANDINGBOOK_PARAM_DBEXCEPTION = -3310;
	//	参数错误
	public static final int EQUIPMENT_STANDINGBOOK_PARAM_PARAERROR = -3311;
	//	参数名为空
	public static final int EQUIPMENT_STANDINGBOOK_PARAM_NAMEISNULL = -3321;
	//	参数值为空
	public static final int EQUIPMENT_STANDINGBOOK_PARAM_VALUEISNULL = -3331;
	/**
	 * 技术资料
	 */
	//	数据库服务异常
	public static final int EQUIPMENT_STANDINGBOOK_MATERIAL_DBEXCEPTION = -4410;
	//	参数错误
	public static final int EQUIPMENT_STANDINGBOOK_MATERIAL_PARAERROR = -4411;
	//	文件名为空
	public static final int EQUIPMENT_STANDINGBOOK_MATERIAL_FILENAMEISNULL = -4421;
	//	文件路径为空
	public static final int EQUIPMENT_STANDINGBOOK_MATERIAL_FILEPATHISNULL = -4431;
	/**
	 * 文件上传大小
	 */
	public static final int FILESIZE = 10*1024*1024;
	/**
	 * 文件上传路径
	 */
	public static final String FILEPATH = "\\upload\\equipment_Tech_Meterial\\";
	/**
	 * 临时存放路径
	 */
	public static final String TEMPFILEPATH = "\\upload\\temp\\";
	
	/*
	 * 位置配置
	 */
	//	-21：位置名称（name）为空
	public static final int EQUIPMENT_LOCATION_NAMEISNULL = -21;
	//	-22：位置名称（name）已经存在
	public static final int EQUIPMENT_LOCATION_NAMENOTONLY = -22;
	//	-31：位置编号（code）全公司不唯一
	public static final int EQUIPMENT_LOCATION_CODENOTNOLY = -31;
	//	-21：当期位置已经关联设备不能删除
	public static final int EQUIPMENT_LOCATION_CANNOTDELETETHIS = -21;
	//	-22：当前位置的子位置已经关联设备不能删除
	public static final int EQUIPMENT_LOCATION_CANNOTDELETETHISANDCHILD = -22;
	
	/*
	 * 设备大小类
	 */
	//	-21：名称（name）为空
	public static final int EQUIPMENT_CLASS_NAMEISNULL = -21;
	//	-22：名称（name）重复
	public static final int EQUIPMENT_CLASS_NAMENOTONLY = -22;
	//	-31：代号（code）为空
	public static final int EQUIPMENT_CLASS_CODEISNULL = -31;
	//	-32：代号（code）重复
	public static final int EQUIPMENT_CLASS_CODENOTONLY = -32;
	//	-21：此类型已经关联设备，无法删除
	public static final int EQUIPMENT_CLASS_CANNOTDELETE = -21;
	
	/*
	 * 设备资料类型
	 */
	//	-21：名称为空
	public static final int EQUIPMENT_MATERIAL_TYPE_NAMEISNULL = -21;
	//	-22：名称重复
	public static final int EQUIPMENT_MATERIAL_TYPE_NAMEONONLY = -22;

	/*
	 * 构筑物 
	 */
	//	-21：构筑物名称不能为空
	public static final int STRUCTURE_NAMEISNULL = -21;
	//	-22：构筑物名称在部门下不唯一
	public static final int STRUCTURE_NAMENOTONLY = -22;
	//	-31：编号在全局不唯一
	public static final int STRUCTURE_CODENOTONLY = -31;

	/*
	 * 设备部件养护类型配置
	 */
	//	-21：名称为空
	public static final int EQUIPMENT_ITEM_MAINTAIN_TYPE_NAMEISNULL = -21;
	//	-22：名称重复
	public static final int EQUIPMENT_ITEM_MAINTAIN_TYPE_NAMEONONLY = -22;
	//  -31：类别有关联的  养护任务记录  不能删除
	public static final int EQUIPMENT_ITEM_MAINTAIN_TYPE_CANNOTDELETE = -31;
	
	
	
	/*
	 * 设备变更审批
	 */
	//	设备已有其他已提交申请
	public static final int APPROVALSTATUS = -31;
	
	/**
	 * 设备系统——养护计划状态——已保存
	 */
	public static final int EQUIPMENT_MAINTAINPLAN_STATE_YBC = 1;
	/**
	 * 设备系统——养护计划状态——待水厂审批
	 */
	public static final int EQUIPMENT_MAINTAINPLAN_STATE_DSCSP = 2;
	/**
	 * 设备系统——养护计划状态——待制水部领导审批
	 */
	public static final int EQUIPMENT_MAINTAINPLAN_STATE_DZSBLDSP = 3;
	/**
	 * 设备系统——养护计划状态——待设备科领导审批
	 */
	public static final int EQUIPMENT_MAINTAINPLAN_STATE_DSBKLDSP = 4;
	/**
	 * 设备系统——养护计划状态——审批不通过
	 */
	public static final int EQUIPMENT_MAINTAINPLAN_STATE_SPBTG = 5;
	/**
	 * 设备系统——养护计划状态——审批通过
	 */
	public static final int EQUIPMENT_MAINTAINPLAN_STATE_SPTG = 6;
	/**
	 * 设备系统——养护计划状态——执行中
	 */
	public static final int EQUIPMENT_MAINTAINPLAN_STATE_ZXZ = 7;
	
	/**
	 * 设备系统——养护计划状态——已停止
	 */
	public static final int EQUIPMENT_MAINTAINPLAN_STATE_YTZ = 8;
	/**
	 * 设备系统——养护计划状态——已完成
	 */
	public static final int EQUIPMENT_MAINTAINPLAN_STATE_YWC = 9;
	/**
	 * 设备变更待办事项类型——待审批
	 */
	public static final String DBSX_TYPE_EQUIPMENTCHANGE_DSP = "dsp";

	/**
	 * 设备变更待办事项类型——待确认
	 */
	public static final String DBSX_TYPE_EQUIPMENTCHANGE_DQR = "dqr";

	/**
	 * 维修任务待办事项类型——待执行
	 */
	public static final String DBSX_TYPE_REPAIRTASK_DZX = "dzx";

	/**
	 * 维修任务待办事项类型——待审批
	 */
	public static final String DBSX_TYPE_REPAIRTASK_DSP = "dsp";

	/**
	 * 维修任务待办事项类型——待验收
	 */
	public static final String DBSX_TYPE_REPAIRTASK_DYS = "dys";

	/**
	 * 养护任务待办事项类型——待指派
	 */
	public static final String DBSX_TYPE_MAINTAINTASK_DZP = "dzp";

	/**
	 * 养护任务待办事项类型——待执行
	 */
	public static final String DBSX_TYPE_MAINTAINTASK_DZX = "dzx";

	/**
	 * 养护任务待办事项类型——待审批
	 */
	public static final String DBSX_TYPE_MAINTAINTASK_DSP = "dsp";

	/**
	 * 养护任务待办事项类型——待验收
	 */
	public static final String DBSX_TYPE_MAINTAINTASK_DYS = "dys";
	
	/*
	 * 设备管理系统——系统配置模块
	 */

	/**
	 * 名称不唯一
	 */
	public static final int EQUIPMENT_SYSTEMTCONFIG_NAME_NOTUNIQUE = -12;

	/**
	 * 名称为空
	 */
	public static final int EQUIPMENT_SYSTEMTCONFIG_NAME_ISNULL = -13;
	
	
	/*
	 * 维修模块	
	 */
	
	/**
	 * 该状态下的设备无法上报异常
	 */
	public static final int REPAIR_EQUIPMENT_STATE_ERROR = -12;
	
	/**
	 * 设备异常状态异常
	 */
	public static final int REPAIR_FAULT_STATE_ERROR = -13;
	
	
	/*
	 * 养护模块
	 */
	/**
	 * 养护计划类型——可自控。
	 */
	public static final int CANAUTOMATICMONITORING = 1;
	/**
	 * 养护计划类型——不可自控。
	 */
	public static final int UNAUTOMATICMONITORING = 2;
	/**
	 * 养护计划类型——年度。
	 */
	public static final int ANNUALPLAN = 3;
	/**
	 * 养护计划类型——临时。
	 */
	public static final int TEMPPLAN = 4;
	
	/**
	 * 计划状态
	 */
	public static final int SAVED = 1;
	public static final int WATTINGFACTORYEMPLOYEEAPPROVAL = 2;
	public static final int WATTINGEQUIPMENTDEPARTMENTAPPROVAL = 3;
	public static final int WATTINGEQUIPMENTDEPARTMENTLEADERAPPROVAL = 4;
	public static final int APPROVALNOPASS = 5;
	public static final int APPROVALPASS = 6;
	public static final int PLANLAUNCH = 7;
	public static final int PLANSTOP = 8;
	public static final int HASCOMPLETE = 9;
	
	public static final String MIANTAINTASK_EXPORTDOC_CONFIGPATHTYPE = "upload.config";
	public static final String MIANTAINTASK_EXPORTDOC_PATH = "maintainTaskExportDoc//";
	
	
	/*
	 * 镇江应急及安全子系统
	 * 系统配置模块  常量
	 */
	/**
	 * 配置项名称为空
	 */
	public static final int ZHENJIANG_SYSCONFIG_NAMEISNULL = -12;
	/**
	 * 配置项名称不唯一
	 */
	public static final int ZHENJIANG_SYSCONFIG_NAMENOTONLY = -13;
	
	/**
	 * 编号不唯一
	 */
	public static final int ZHENJIANG_CODE_NOTONLY = -14;
	/**
	 * 编号为空
	 */
	public static final int ZHENJIANG_CODE_ISNULL = -15;
	

	/* 
	 * 管网应急模块  常量
	 */
	/**
	 * 工单状态不正确，无法进行当前操作
	 */
	public static final int ZHENJIANG_NETWORKEMERGENCY_STATUSERROR = -12;
	

	/**
	 * 应急事件等级:EmergencyEventLevel,
	 */
	public static final String SYSCODE_NUM_EMERGENCYEVENTLEVEL = "EmergencyEventLevel";
	
	/**
	 * 应急事件来源EmergencyEventSource,
	 */
	public static final String SYSCODE_NUM_EMERGENCYEVENTSOURCE = "EmergencyEventSource";
	
	/**
	 * 应急事件类型EmergencyEventType,
	 */
	public static final String SYSCODE_NUM_EMERGENCYEVENTTYPE = "EmergencyEventType";
	
	/**
	 * 安全工作类型SecurityWorkType,
	 */
	public static final String SYSCODE_NUM_SECURITYWORKTYPE = "SecurityWorkType";
	
	/**
	 * 安全文件来源SecurityFileSource,
	 */
	public static final String SYSCODE_NUM_SECURITYFILESOURCE = "SecurityFileSource";
	
	/**
	 * 安全文件类型SecurityFileType,
	 */
	public static final String SYSCODE_NUM_SECURITYFILETYPE = "SecurityFileType";
	
	/**
	 * 安全预案类别SecurityPlanType,
	 */
	public static final String SYSCODE_NUM_SECURITYPLANTYPE = "SecurityPlanType";

	/**
	 * 应急预案类型EmergencyPlanCagetory,
	 */
	public static final String SYSCODE_NUM_EMERGENCYPLANCATEGORY = "EmergencyPlanCagetory";
	
	/**
	 * 安全检查类别SecurityCheckType
	 */
	public static final String SYSCODE_NUM_SECURITYCHECKTYPE = "SecurityCheckType";
	
	/**
	 * 安全检查来源SecurityCheckSource
	 */
	public static final String SYSCODE_NUM_SECURITYCHECKSOURCE = "SecurityCheckSource";
	
	/**
	 * 培训任务来源TrainingTaskSource
	 */
	public static final String SYSOCODE_NUM_TRAININGTASKSOURCE = "TrainingTaskSource"; 
	
	/**
	 * 安全活动类别SecurityActivityType
	 */
	public static final String SYSCODE_NUM_SECURITYACTIVITYTYPE = "SecurityActivityType";
	
	/**
	 * 特种作业类别SpecialWorkType
	 */
	public static final String SYSCODE_NUM_SPECIALWORKTYPE = "SpecialWorkType";
	
	/**
	 * 应急事故类型
	 */
	public static final String SYSCODE_NUM_TROUBLE_TYPE = "TroubleType";
	
	/**
	 * 应急事故等级
	 */
	public static final String SYSCODE_NUM_TROUBLE_LEVEL = "TroubleLevel";
	
	/**
	 * 应急事故来源
	 */
	public static final String SYSCODE_NUM_TROUBLE_SOURCE = "TroubleSource";

	/**
	 * 应急物资类型
	 */
	public static final String SYSCODE_NUM_MATERIAL_TYPE = "MaterialType";
	
	/**
	 * 应急专家类型
	 */
	public static final String SYSCODE_NUM_EXPERTS_TYPE = "ExpertsType";
	
	/**
	 * 应急变更原因
	 */
	public static final String SYSCODE_NUM_EXPERTS_TYPE_EMERGENCYEVENTCONFIG_CHANGEREASON = "EmergencyEventConfig_ChangeReason";
	
	/**
	 * 应急事件发生地点
	 */
	public static final String SYSCODE_NUM_EXPERTS_TYPE_EMERGENCYEVENTCONFIG_LOCATION = "EmergencyEventConfig_Location";
	
	/**
	 * 应急事件描述
	 */
	public static final String SYSCODE_NUM_EXPERTS_TYPE_EMERGENCYEVENTCONFIG_EVENTDES = "EmergencyEventConfig_EventDes";
	
	
	/**
	 * 制度文件发布单位
	 */
	public static final String SYSCODE_NUM_RELEASE_UNIT= "ReleaseUnit";

	/**
	 * 制度文件类型
	 */
	public static final String SYSCODE_NUM_FILE_TYPE= "FileType";
	
	/**
	 * 安全工作计划
	 */
	public static final String SYSCODE_NUM_WORKPLAN= "SecurityWorkPlan";
	

	/**
	 * 应急预案演练方案
	 */
	public static final String SYSCODE_NUM_PLANDRILLSCHEME= "EmergencyPlanDrillScheme";
	

	/**
	 * 应急预案演练执行——评估
	 */
	public static final String SYSCODE_NUM_PLANDRILLEXECUTION_ASSESS= "EmergencyPlanDrillExecutionAssess";

	/**
	 * 应急预案演练执行——总结
	 */
	public static final String SYSCODE_NUM_PLANDRILLEXECUTION_SUMMARY= "EmergencyPlanDrillExecutionSummary";
	

	//应急事件相关配置枚举 
	/**
	 * 事件地点
	 */
	public static final String EMERGENCYEVENT_CONFIG_LOCATION = "EmergencyEventConfig_Location";
	
	/**
	 * 事件描述 
	 */
	public static final String EMERGENCYEVENT_CONFIG_EVENTDES = "EmergencyEventConfig_EventDes";
	
	/**
	 * 变更原因
	 */
	public static final String EMERGENCYEVENT_CONFIG_CHANGEREASON = "EmergencyEventConfig_ChangeReason";
	 
	
	/**
	 * 工作流——读取配置文件信息失败
	 */
	public static final int WORK_LOADCONFIG_EOEER = -1;
	
	/**
	 * 模块类型——管网应急
	 */
	public static final int EMERGENCYEVENT_MODEL_TYPE_PIPES = 10001;

	/**
	 * 模块类型——生产应急
	 */
	public static final int EMERGENCYEVENT_MODEL_TYPE_PRODUCTION = 10002;

	/**
	 * 模块类型——水质应急
	 */
	public static final int EMERGENCYEVENT_MODEL_TYPE_WATERQUALITY = 10003;
	
	/**
	 * 模块类型--安全检查
	 */
	public static final int EMERGENCYEVENT_MODEL_TYPE_SECURITYCHECK = 10004;
	
	/**
	 * 模块类型--整改管理
	 */
	public static final int EMERGENCYEVENT_MODEL_TYPE_ABARBEITUNG = 10004;
	
	/**
	 * 模块类型--安全活动
	 */
	public static final int EMERGENCYEVENT_MODEL_TYPE_SECURITYACTIVITY = 10005;
	
	/**
	 * 模块类型--事故处理
	 */
	public static final int EMERGENCYEVENT_MODEL_TYPE_TROUBLEREMOVAL = 10006;
	
	/**
	 * 模块类型--预案培训
	 */
	public static final int EMERGENCYEVENT_MODEL_TYPE_TRAINING = 10007;
	
	/**
	 * 事件密级——公开
	 */
	public static final int EMERGENCYEVENT_SECRETLEVEL_PUBLIC = 1;
	/**
	 * 事件密级——非公开
	 */
	public static final int EMERGENCYEVENT_SECRETLEVEL_UNPUBLIC = 0;
	
	/**
	 * 状态map
	 */
	public static final Map<String, Integer> STATUS_MAP = getMap();
	
	private static Map<String, Integer> getMap(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("新建",0);
		map.put("已分配",1);
		map.put("执行中",2);
		map.put("挂单",3);
		map.put("退单",4);
		map.put("完成回单",5);
		map.put("审批完成",6);
		map.put("结束",7);
		map.put("审批不通过",8);
		map.put("验收不通过",9);
		
		return map;
	}
	
	/**
	 * 工单状态常量  全部
	 */
	public static final int ZJSSEM_ALL = -1;
	/**
	 * 工单状态常量  待派发
	 */
	public static final int ZJSSEM_WAITTINGDISTRIBUTE = 0;
	/**
	 * 工单状态常量  已派发
	 */
	public static final int ZJSSEM_HADDISTRIBUTE = 1;
	/**
	 * 工单状态常量  执行中
	 */
	public static final int ZJSSEM_LAUNCH = 2;
	/**
	 * 工单状态常量  已挂单
	 */
	public static final int ZJSSEM_HADPAUSE = 3;
	/**
	 * 工单状态常量  已退单
	 */
	public static final int ZJSSEM_HADCHARGEBACK = 4;
	/**
	 * 工单状态常量  待审批
	 */
	public static final int ZJSSEM_WAITTINGAPPROVAL = 5;
	/**
	 * 工单状态常量  已审批
	 */
	public static final int ZJSSEM_HADAPPROVAL = 6;
	/**
	 * 工单状态常量  已完成
	 */
	public static final int ZJSSEM_COMPLETE = 7;
	/**
	 * 工单状态常量  审批未通过
	 */
	public static final int ZJSSEM_APPROVALNOPASS = 8;
	/**
	 * 工单状态常量  验收未通过
	 */
	public static final int ZJSSEM_CHECKNOPASS = 9;
	/**
	 * 工单状态常量  已上报
	 */
	public static final int ZJSSEM_HADSUBMIT = 10;
	/**
	 * 工单状态常量  待完善
	 */
	public static final int ZJSSEM_WAITTINGPERFECT = 11;
	/**
	 * 工单状态常量  已完善
	 */
	public static final int ZJSSEM_HADPERFECT = 12;

	/**
	 * 工单状态常量  已回执
	 */
	public static final int ZJSSEM_RECEIPT = 13;
	
	/**
	 * 工单状态常量  复查中
	 */
	public static final int ZJSSEM_REVIEWING = 14;
	
	/**
	 * 工单状态常量  已复查
	 */
	public static final int ZJSSEM_HADREVIEW = 15;

	/**
	 * 工单状态常量  平台下发通知
	 */
	public static final int ZJSSEM_PTXFTZ = 16;
	
	/**
	 * 工单状态常量  平台已审核
	 */
	public static final int ZJSSEM_PTYSH = 17;
	
	/**
	 * 应急事件类型配置
	 * 前台模块编号和大类名称的对应关系
	 */
	public static final TreeMap<String, String> EMERGENCYEVENTTYPEANDMODEL;
	static{
		EMERGENCYEVENTTYPEANDMODEL = new TreeMap<String, String>();
		EMERGENCYEVENTTYPEANDMODEL.put("10002", "生产应急");
		EMERGENCYEVENTTYPEANDMODEL.put("10003", "水质应急");		
	};
	
	/**
	 * 应急事件 附件代号
	 */
	//	生产事件 上报图片
	public static final String EMERGENCYEVENT_PRODUCTION_SHANGBAOPIC = "p1";
	//	生产事件 处理图片
	public static final String EMERGENCYEVENT_PRODUCTION_CHULIPIC = "p2";
	//	生产事件 处理附件
	public static final String EMERGENCYEVENT_PRODUCTION_CHULIFILE = "p3";
	//	水质事件 上报图片
	public static final String EMERGENCYEVENT_WATER_SHANGBAOPIC = "w1";
	//	水质事件 处理图片
	public static final String EMERGENCYEVENT_WATER_CHULIPIC = "w2";
	//	水质事件 处理附件
	public static final String EMERGENCYEVENT_WATER_CHULIFILE = "w3";
	
	/**应急事故处理上报图片*/
	public static final String EMERGENCY_ADD_IMAGE = "31";
	/**应急事故处理回单图片*/
	public static final String EMERGENCY_RECEIPT_IMAGE = "32";
	/**应急事故处理回单附件*/
	public static final String EMERGENCY_RECEIPT_FILES = "33";
	
	/**
	 * 应急事件 统计模块
	 */
	//	事件大类统计  图片  存放路径
	public static final String Event_StatisticsImage_Categories = "eventStatisticsImage/Categories";
	//	事件大类等级统计  图片  存放路径
	public static final String Event_StatisticsImage_CategoriesLevel = "eventStatisticsImage/CategoriesLevel";
	//	事件小类统计  图片  存放路径
	public static final String Event_StatisticsImage_subClass = "eventStatisticsImage/subClass";
	//	事件小类等级统计  图片  存放路径
	public static final String Event_StatisticsImage_subClassLevel = "eventStatisticsImage/subClassLevel";
	//  事故处理类型统计图片存放路径
	public static final String EMERGENCY_TROUBLE_TYPE_IMAGE_PATH = "tempFile/eventStatisticsImage/troubleType";
	//  事故处理等级统计图片存放路径
	public static final String EMERGENCY_TROUBLE_LEVEL_IMAGE_PATH = "tempFile/eventStatisticsImage/troubleLevel";
	//	导出excel临时文件目录
	public static final String ZJSSEM_EVENT_STATISTICSDATATOEXCEL_FILESOURCEDIR = "resource\\excel\\";
	//	导出excel模板名称 
	public static final String ZJSSEM_EVENT_STATISTICSDATATOEXCEL_FILENAME = "template\\Event_Categories_Statistics_Template.xls";
	//  导出excel模版名称
	public static final String ZJSSEM_TROUBLE_STATISTICSDATATOEXCEL_FILENAME = "template\\trouble_Statistics_Template.xlsx";
	/**
	 * 应急安全 统计模块
	 */
	//	安全检查统计  图片  存放路径
	public static final String SECURITY_STATISTICSIMAGE_SECURITYCHECK = "securityStatisticsImage/securityCheck";
	//	安全活动统计  图片  存放路径
	public static final String SECURITY_STATISTICSIMAGE_SECURITYACTIVITY = "securityStatisticsImage/securityActivity";
	
	//	导出excel临时文件目录
	public static final String ZJSSEM_SECURITY_STATISTICSDATATOEXCEL_FILESOURCEDIR = "resource\\excel\\";
	//	导出安全检查excel模板名称 
	public static final String ZJSSEM_SECURITY_CHECK_STATISTICSDATATOEXCEL_FILENAME = "template\\Security_Check_Statistics_Template.xls";
	//	导出安全活动excel模板名称 
	public static final String ZJSSEM_SECURITY_ACTIVITY_STATISTICSDATATOEXCEL_FILENAME = "template\\Security_Acitvity_Statistics_Template.xls";
	
	
	/**
	 * 文本最大长度
	 */
	public static final int TEXT_MAX_LENGTH = 4000;

	/**
	 * 应急安全系统——安全模块回执情况状态：未回执
	 */
	public static final int ZJSSEM_SECURITY_RECEIPT_STATE_UNRECEIPT = 0;

	/**
	 * 应急安全系统——安全模块回执情况状态：已回执
	 */
	public static final int ZJSSEM_SECURITY_RECEIPT_STATE_RECEIPT = 1;

	/**
	 * 应急安全系统——安全模块回执情况状态：审批通过
	 */
	public static final int ZJSSEM_SECURITY_RECEIPT_STATE_APPROVAL = 2;

	/**
	 * 应急安全系统——安全模块回执情况状态：审批不通过
	 */
	public static final int ZJSSEM_SECURITY_RECEIPT_STATE_UNAPPROVAL = 3;
	
	/**
	 * 应急安全系统——安全工作计划状态：未提交
	 */
	public static final int ZJSSEM_SECURITY_WORKPLAN_STATE_UNSUBMIT = 1;

	/**
	 * 应急安全系统——安全工作计划状态：已提交
	 */
	public static final int ZJSSEM_SECURITY_WORKPLAN_STATE_SUBMIT = 2;
	/**
	 * 应急安全系统——安全工作计划状态：计划审批通过
	 */
	public static final int ZJSSEM_SECURITY_WORKPLAN_STATE_PLANAPPROVAL = 3;
	/**
	 * 应急安全系统——安全工作计划状态：计划审批不通过
	 */
	public static final int ZJSSEM_SECURITY_WORKPLAN_STATE_PLANUNAPPROVAL = 4;
	/**
	 * 应急安全系统——安全工作计划状态：已上报
	 */
	public static final int ZJSSEM_SECURITY_WORKPLAN_STATE_REPORT = 5;
	/**
	 * 应急安全系统——安全工作计划状态：其他审批通过
	 */
	public static final int ZJSSEM_SECURITY_WORKPLAN_STATE_APPROVAL = 6;
	/**
	 * 应急安全系统——安全工作计划状态：其他审批不通过
	 */
	public static final int ZJSSEM_SECURITY_WORKPLAN_STATE_UNAPPROVAL = 7; 
	/**
	 * 应急安全系统——安全工作计划状态：平台下发
	 */
	public static final int ZJSSEM_SECURITY_WORKPLAN_STATE_PTXF = 8;

	/**
	 * 应急安全系统——应急预案演练计划状态：未提交
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILL_STATE_UNSUBMIT = 1;

	/**
	 * 应急安全系统——应急预案演练计划状态：已提交
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILL_STATE_SUBMIT = 2;
	/**
	 * 应急安全系统——应急预案演练计划状态：计划审批通过
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILL_STATE_PLANAPPROVAL = 3;
	/**
	 * 应急安全系统——应急预案演练计划状态：计划审批不通过
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILL_STATE_PLANUNAPPROVAL = 4;
	/**
	 * 应急安全系统——应急预案演练计划状态：已上报
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILL_STATE_REPORT = 5;
	/**
	 * 应急安全系统——应急预案演练计划状态：其他审批通过
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILL_STATE_APPROVAL = 6;
	/**
	 * 应急安全系统——应急预案演练计划状态：其他审批不通过
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILL_STATE_UNAPPROVAL = 7;

	/**
	 * 应急安全系统——应急预案演练计划状态：待执行
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILL_STATE_UNEXECUTE = 8;
	/**
	 * 应急安全系统——应急预案演练计划状态：执行中
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILL_STATE_EXECUTEL = 9;
	/**
	 * 应急安全系统——应急预案演练计划状态：已完成
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILL_STATE_COMPLETE = 10;
	
	/**
	 * 应急安全系统——应急预案演练方案状态：未提交
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILLSCHEME_STATE_UNSUBMIT = 1;
	/**
	 * 应急安全系统——应急预案演练方案状态：已提交
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILLSCHEME_STATE_SUBMIT = 2;
	/**
	 * 应急安全系统——应急预案演练方案状态：方案审核通过
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILLSCHEME_STATE_SCHEMEAPPROVAL = 3;
	/**
	 * 应急安全系统——应急预案演练方案状态：方案审核不通过
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILLSCHEME_STATE_SCHEMEUNAPPROVAL = 4;
	
	/**
	 * 应急安全系统——应急预案演练执行状态：待评估
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILLEXECUTION_STATE_UNASSESS = 1;
	/**
	 * 应急安全系统——应急预案演练执行状态：待总结
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILLEXECUTION_STATE_UNSUMMARIZE = 2;
	/**
	 * 应急安全系统——应急预案演练执行状态：已完成
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILLEXECUTION_STATE_COMPLETE = 3;
	/**
	 * 应急安全系统——应急预案演练执行状态：已上报
	 */
	public static final int ZJSSEM_EMERGENCY_PLANDRILLEXECUTION_STATE_REPORT = 4;
	
	/**
	 * 应急安全系统——制度文件状态：未提交
	 */
	public static final int ZJSSEM_SYSTEMFILE_STATE_UNSUBMIT = 1;

	/**
	 * 应急安全系统——制度文件状态：已提交
	 */
	public static final int ZJSSEM_SYSTEMFILE_STATE_SUBMIT = 2;

	/**
	 * 应急安全系统——制度文件状态：已上报
	 */
	public static final int ZJSSEM_SYSTEMFILE_STATE_REPORT = 3;
	
	
	
	/**
	 * 安全检查工作 附件代号
	 */
	//	安全检查平台下发附件
	public static final String ZJSSEM_SECURITY_CHECK_PTXFFJ = "sc4";
	//	安全检查情况附件
	public static final String ZJSSEM_SECURITY_CHECK_FILE = "sc1";
	//	安全检查复查附件
	public static final String ZJSSEM_SECURITY_CHECK_REVIEWFILE = "sc2";
	//	安全检查回执附件
	public static final String ZJSSEM_SECURITY_CHECK_RECEIPTFILE = "sc3";
	


	////////////////////////////////////安全活动附件代号////////////////////////////////////////////////////////
	/**
	 * 安全活动平台下发附件
	 */
	public static final String ZJSSEM_SECURITYACTIVITY_PTXFFILE = "SecurityActivityPTFJ";

	////////////////////////////////////制度文件附件代号////////////////////////////////////////////////////////
	/**
	 * 制度文件平台下发附件
	 */
	public static final String ZJSSEM_SYSTEMFILE_PTXFFILE = "SystemFilePTFJ";
	
	public static final String CONFIG_FILE = "config.properties";
}
