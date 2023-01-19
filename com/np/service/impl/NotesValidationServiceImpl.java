package com.np.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.np.service.NotesValidationService;
import com.np.service.exception.ServiceException;

public class NotesValidationServiceImpl implements NotesValidationService{

	@Override
	public boolean titleValidation(String title) throws ServiceException {
		if (title != null & title!= " " & title != "") {
			return true;
		}
		throw new ServiceException("Data entered incorrectly!");
	}

	@Override
	public boolean dateValidation(Date date) throws ServiceException {
		if (date != null) {
			return true;
		}
		throw new ServiceException("Data entered incorrectly!");
	}

	@Override
	public boolean contentValidation(String content) throws ServiceException {
		if (content != null & content != " " & content != "") {
			return true;
		}
		throw new ServiceException("Data entered incorrectly!");
	}

}
