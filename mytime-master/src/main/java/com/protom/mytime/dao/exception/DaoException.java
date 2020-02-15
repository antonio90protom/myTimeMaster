package com.protom.mytime.dao.exception;

public class DaoException extends Exception {

	private static final long serialVersionUID = 1293380872300870249L;
	
	public DaoException() {
		super();
	}
	
	public DaoException(String message) {
		super(message);
	}
	
	public DaoException(String message, Throwable t) {
		super(message, t);
	}

}
