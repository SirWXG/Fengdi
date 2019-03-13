package com.fengdi.keepsheep.util;

public class SimpleResult {
	private boolean success;
	private Object data;
	private String errCode;
	private String errMsg;
	private String message;

	
	public SimpleResult(){
		
	}
	
	public SimpleResult(boolean success){
		this.success = success;
	}
	
	public SimpleResult(Object data){
		this.success=true;
		this.data=data;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	
	public SimpleResult(String errCode, String errMsg, String message) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.message = message;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
