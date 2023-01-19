package com.np.dal.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.np.entity.Note;
import com.np.dal.NotesDAO;
import com.np.dal.exception.DAOException;

public class FileNotesDAO implements NotesDAO{
	
	private final List<Note> notes = new ArrayList<Note>();
	
	private static final String SOURCE_PATH = "resources/text.txt";
	
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private static final int HEADER = 0;
	private static final int DATE = 1;
	private static final int CONTENT = 2;
	
	
	public FileNotesDAO() throws DAOException{
		try {
			if(notes.isEmpty()) {
				List<String> fileForReading = new ArrayList<String>();
				readingFile(fileForReading);
				parsingFile(fileForReading);
			}
		}catch(FileNotFoundException e) {
			throw new DAOException("First level, File not found", e);
		}catch(ParseException e) {
			throw new DAOException("First level, Reading id impossible", e);
		}catch(IOException e) {
			throw new DAOException("First level, Data not available", e);
		}
	}

	@Override
	public List<Note> load() throws DAOException{
				
		return notes; 
		
	}
	

	private List<String> readingFile(List<String> neuBook) throws FileNotFoundException, IOException{
		try (BufferedReader reader = new BufferedReader(new FileReader("SOURCE_PATH"))){
			String readingLine;
			while ((readingLine=reader.readLine()) !=null) {
				neuBook.add(readingLine);
			}
		} 
		return neuBook;
	}
	
	private List<Note> parsingFile(List<String> neuList) throws ParseException{
				
		final Pattern DEVISOR = Pattern.compile("\\;");
		
		for(String lineData: neuList) {
			String[] data = DEVISOR.split(lineData);
			Note note = new Note(data[HEADER], simpleDateFormat.parse(data[DATE]), data[CONTENT]);	
			
			notes.add(note);
		}
		
		return notes;
	}
	
	@Override
	public void save (Note note) throws DAOException{ 
		notes.add(note);
		File doc  =new File("SOURCE_PATH");
		try (FileWriter writer = new FileWriter(doc, true)){
			for (Note neuNote:notes) {
				writer.write(builderData(neuNote));			
			}
		}catch (IOException e) {
			throw new DAOException("First level, Data not save", e);
		}
	}
	
	private String builderData(Note note) {
		StringBuilder build = new StringBuilder();
		build.append(note.getHeader());
		build.append(";");
		build.append(simpleDateFormat.format(note.getDate()));
		build.append(";");
		build.append(note.getTextRecord());
		build.append(";\n");
				
		return build.toString();
	}

}
