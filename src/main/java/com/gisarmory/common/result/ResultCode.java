package com.gisarmory.common.result;



/**
 * 结果编码
 * 
 * @author
 *
 */
public enum ResultCode {

	SUCCESS(0, "成功"),
	DB_ERR(1000, "数据库错误"), 
	PARAM_ERR(1001, "参数错误"), 
	NET_ERR(1002, "网络错误"), 
	INNER_ERR(1003, "系统内部错误"), 
	NOT_LOGIN(1004, "未登录"), 
	OTHER_LOGIN(1005, "账户已在其他地方登录"), 
	INVALID_LOGIN(1006, "登录超时，请重新登录"),
	INSECURITY_REQUEST(1007, "非法的请求"), 
	READ_XML_ERROR(1008, "读取XML数据失败"),
	WX_ENCRYP_ERROR(1009, "微信加密异常"),
	WX_WXCI_SECRET_ERROR(1010, "秘钥错误"),
	WX_USER_INFO_ERROR(1011, "无此微信用户"),
	WX_GET_PROXY_APP_ID_ERROR(1012, "获取参数失败，请重新登陆。"), 
	WX_CODE_DICT_ERROR(1013, "配置参数错误");

	private int resultCode;
	private String resultDes;

	private ResultCode(int resultCode, String resultDes) {

		this.setResultCode(resultCode);
		this.setResultDes(resultDes);
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDes() {
		return resultDes;
	}

	public void setResultDes(String resultDes) {
		this.resultDes = resultDes;
	}

}
