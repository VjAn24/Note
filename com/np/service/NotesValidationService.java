package com.np.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.np.service.exception.ServiceException;

public interface NotesValidationService {
	
	boolean titleValidation(String title) throws ServiceException;
	
	boolean contentValidation(String content) throws ServiceException;

	boolean dateValidation(Date date) throws ServiceException;
	

}
