package com.np.dal.exception;

import java.io.IOException;

public class DAOException extends Exception{
	
	public DAOException () {
		super();
	}
	
	public DAOException (Exception e) {
		super(e);
	}
	
	public DAOException (String message) {
		super(message);
	}
	
	public DAOException (String message, Exception e) {
		super(message, e);
	}
	
	public DAOException(String message, IOException e) {
		super (message, e);
	}

}
