package com.np.controller.command.impl;

import com.np.controller.command.Command;

public class View implements Command{
	private final char paramDelimeter = ' ';

	@Override
	public String execute(String request) {
		
		String message = request.substring(request.indexOf(paramDelimeter));
		
		if(message!=null) {
			System.out.println(message);
		}else {
			System.out.println("No data");
		}
		return null;
	}
	
	

}
