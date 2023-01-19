package com.np.controller.command.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.np.controller.NoteFormater;
import com.np.controller.NoteMessage;
import com.np.controller.command.Command;
import com.np.entity.Note;
import com.np.service.NotesFindService;
import com.np.service.exception.ServiceException;
import com.np.service.impl.ServiceProviderFind;


public class DataSearch implements Command{
	private final char paramDelimeter = ' ';
	private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static Date date = new Date();

	@Override
	public NoteMessage execute(String request) { 
		String searchDate = request.substring(request.indexOf(paramDelimeter));

		String responce = null;
		List<Note> notes = new ArrayList<Note>();
		
		ServiceProviderFind serviceProvider = ServiceProviderFind.getInstance();
		NotesFindService service = serviceProvider.getFindService();
		
		try {
			date = simpleDateFormat.parse(searchDate);
			notes = service.findByDate(date);
			return new NoteMessage("Found the following records" + NoteFormater.format(notes));
		} catch (ServiceException | ParseException e) {
			return new NoteMessage ("No Data");
		}

	}

}
