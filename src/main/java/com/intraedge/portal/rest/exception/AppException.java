package com.intraedge.portal.rest.exception;

public class AppException extends Exception {

	private static final long serialVersionUID = -8999932578270387947L;

	/**
	 * contains redundantly the HTTP status of the response sent back to the
	 * client in case of error, so that the developer does not have to look into
	 * the response headers. If null a default
	 */
	public Integer status;

	/** detailed error description for developers */
	public String developerMessage;
	
	/** */
	public String exceptionMessage;

	/**
	 * 
	 * @param status
	 * @param message
	 * @param developerMessage
	 */
	public AppException(int status, String exceptionMessage,
			String developerMessage) {
		super(exceptionMessage);
		this.status = status;
		this.developerMessage = developerMessage;
		this.exceptionMessage = exceptionMessage;
	}

	public AppException() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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

	public void setStatus(Integer status) {
		this.status = status;
	}

}
