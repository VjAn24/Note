package com.np.controller;

import java.text.ParseException;

import com.np.controller.command.Command;

public class Controller { 
	private final CommandProvider provider = new CommandProvider();
	
	private final char paramDelimeter = ' ';
	
	public String execiteTask(String request) throws ParseException {
		String commandName;
		Command executionCommand;
		
		commandName = request.substring(0, request.indexOf(paramDelimeter));
		executionCommand = provider.getCommand(commandName);
		
		String response;
		response = executionCommand.execute(request);
		
		return response;
	}

}
