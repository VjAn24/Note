package com.np.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import com.np.entity.Note;

public class NoteFormater {
	
	public static String format(List<Note> note) {
		
		StringBuilder build = new StringBuilder();
		build.append(((Note) note).getHeader());
		build.append(";");
		build.append(((Note) note).getDate());
		build.append(";");
		build.append(((Note) note).getTextRecord());
		build.append(";\n");
				
		return build.toString();
		
	}

}
