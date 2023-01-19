package com.np.controller.command.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import com.np.controller.NoteMessage;
import com.np.controller.command.Command;
import com.np.entity.Note;
import com.np.service.NotesCreateService;
import com.np.service.exception.ServiceException;
import com.np.service.impl.ServiceProviderCreate;


public class AddANote implements Command{
	
	private final char paramDelimeter = ' ';
	
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private static final int HEADER = 0;
	
	private static final int DATE = 1;
	
	private static final int CONTENT = 2;

	@Override
	public NoteMessage execute(String request) {
		String responce = null;
		
		String madeString = request.substring(request.indexOf(paramDelimeter));
		
		ServiceProviderCreate service = ServiceProviderCreate.geInstance();
		NotesCreateService notesService = service.getCreateService();
		
		try {
			Note note = dataToNote(madeString);
			notesService.add(note);
			return new NoteMessage ("Record added succesfully");
		}catch(ServiceException | ParseException e) {
			return new NoteMessage ("Entry not added, please try again.");
		}
	
	}
	
	private  Note dataToNote (String request) throws ParseException{
		final Pattern DEVISOR = Pattern.compile("\\;");

		String[] data = DEVISOR.split(request);
		Note note = new Note(data[HEADER], simpleDateFormat.parse(data[DATE]), data[CONTENT]);

		return note;

	}

	
}
