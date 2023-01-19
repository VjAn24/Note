package com.np.controller;

import java.util.HashMap;
import java.util.Map;

import com.np.controller.command.Command;
import com.np.controller.command.impl.AddANote;
import com.np.controller.command.impl.DataSearch;
import com.np.controller.command.impl.RecordSearch;
import com.np.controller.command.impl.View;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider(){
		repository.put(CommandName.ADD_NOTE, new AddANote());
		repository.put(CommandName.CONTENT_SEARCH, new RecordSearch());
		repository.put(CommandName.DATA_SEARCH, new DataSearch());
		repository.put(CommandName.VIEW, (Command) new View());
	}
	
	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;
		
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		}catch(IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}

}
