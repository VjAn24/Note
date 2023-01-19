package com.np.service.exception;

import com.np.dal.exception.DAOException;

public class ServiceException extends Exception{
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Exception e) {
		super(e);
	}
	
	public ServiceException(String message, Exception e) {
		super(message, e);
	}
	
	public ServiceException(String message, DAOException e) {
		super(message, e);
	}

}
