package com.protom.mytime.service.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 559504303518012682L;
	
	public ServiceException() {}
	
	public ServiceException( String message ) {
		super(message);
	}
	
	public ServiceException( String message, Throwable t) {
		super(message, t);
	}

}
