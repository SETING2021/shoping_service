package mx.com.seting.shopiing.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class ErrorResponse implements Serializable{
	
	private static final Long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Error Code", name = "code", value ="200")
	private int code;
	@ApiModelProperty(notes = "Status Code", name = "code", value ="SUCCESS")
	private String status;
	@ApiModelProperty(notes = "message", name = "code", value ="Invalid field")
	private String message;

	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getCode() {
		return code;
	}
	
	
	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
