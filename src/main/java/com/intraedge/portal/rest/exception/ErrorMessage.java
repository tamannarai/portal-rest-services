package com.intraedge.portal.rest.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private Integer status;
	private String developerMessage;
	private String exceptionMessage;
	
	public ErrorMessage(){
		
	}
	public ErrorMessage(Integer status, String developerMessage,
			String exceptionMessage) {
		super();
		this.status = status;
		this.developerMessage = developerMessage;
		this.exceptionMessage = exceptionMessage;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDeveloperMessage() {
		return developerMessage;
	}
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
}
