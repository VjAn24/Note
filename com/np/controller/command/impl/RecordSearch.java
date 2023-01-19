package com.np.controller.command.impl;

import java.util.ArrayList;
import java.util.List;

import com.np.controller.NoteFormater;
import com.np.controller.NoteMessage;
import com.np.controller.command.Command;
import com.np.entity.Note;
import com.np.service.NotesFindService;
import com.np.service.exception.ServiceException;
import com.np.service.impl.ServiceProviderFind;

public class RecordSearch implements Command{
	private final char paramDelimeter = ' ';

	@Override
	public NoteMessage execute(String request) { 
		String seachWord = request.substring(request.indexOf(paramDelimeter));
		String responce = null;
		List<Note> notes = new ArrayList<Note>();

		ServiceProviderFind serviceProvider = ServiceProviderFind.getInstance();
		NotesFindService service = serviceProvider.getFindService();
		
		try {
			notes = service.findByContent(seachWord);
			return new NoteMessage("Found the following records" + NoteFormater.format(notes));
		} catch (ServiceException e) {
			return new NoteMessage ("No Data");
		}

	}

}
