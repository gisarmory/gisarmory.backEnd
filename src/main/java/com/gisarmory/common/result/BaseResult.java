package com.gisarmory.common.result;



/**
 * 接口格式
 * 
 *
 */
public class BaseResult {

	private int errorCode;
	private String errorMsg;
	private Object data;

	public BaseResult() {

	}

	public BaseResult(ResultCode result) {

		this.errorCode = result.getResultCode();
		this.errorMsg = result.getResultDes();

	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
