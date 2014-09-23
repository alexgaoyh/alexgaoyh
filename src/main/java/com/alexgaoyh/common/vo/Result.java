package com.alexgaoyh.common.vo;

public class Result {
	
	public static Result  ok(){
		Result result = new Result();
		result.setSuccess(true);
		return result ;
	}
	
	public static Result  ok(String msg){
		Result result = new Result();
		result.setSuccess(true);
		result.setMsg(msg);
		return result ;
	}
	
	public static Result  ok(Object data){
		Result result = new Result();
		result.setSuccess(true);
		result.setData(data);
		return result ;
	}
	
	public static Result fail(){
		Result result = new Result();
		result.setSuccess(false);
		return result ;
	}
	
	public static Result fail(String msg ){
		Result result = new Result();
		result.setSuccess(false);
		result.setMsg(msg);
		return result ;
	}
	
	//常用操作码
	public static final  int  OPERATE_CODE_LOGIN = 100 ; //未
	
	private boolean success;
	private String msg ;
	private Object data;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Result(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}
	public Result() {
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	private int operateCode ;  //操作码 
	
	public int getOperateCode() {
		return operateCode;
	}
	public void setOperateCode(int operateCode) {
		this.operateCode = operateCode;
	}
	

}
