package com.gisarmory.common.result;



import java.io.Serializable;


public class Result implements Serializable{
	
	private static final long serialVersionUID = -2253883661473010215L;

	/**
	 * 错误代码：1:表示成功，0:表示错误
	 */
	private int resCode; 
	private String msg;
	private Object data;
	
	public Result(int resCode,String msg,Object data){
		this.resCode = resCode;
		this.msg = msg;
		this.data = data;
	}
	
	
	public static Result success(Object data){
		Result result=new Result(ResultResCode.RES_CODE_SUCCESS,"success",data);
		return result;
	}
	public static Result success(){
		Result result=new Result(ResultResCode.RES_CODE_SUCCESS,"success",null);
		return result;
	}
	
	public static Result error(String msg){
		Result result=new Result(ResultResCode.RES_CODE_ERROR,msg,null);
		return result;
	}
	public static Result error(int resCode,String msg){
		Result result=new Result(resCode,msg,null);
		return result;
	}
	
	public int getResCode() {
		return resCode;
	}
	public void setResCode(int resCode) {
		this.resCode = resCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Result [resCode=" + resCode + ", msg=" + msg + ", data=" + data + "]";
	}

}
