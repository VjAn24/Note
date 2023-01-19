package com.np.controller.command.impl;

import com.np.controller.command.Command;
import com.np.dal.exception.DAOException;
import com.np.service.exception.ServiceException;

public class WrongRequest implements Command{

	@Override
	public String execute(String request) {
		System.out.println("Wrong command, please try again");
		return null;
	}

}
