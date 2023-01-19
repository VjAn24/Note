package com.np.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.np.dal.DAOProvider;
import com.np.dal.NotesDAO;
import com.np.dal.exception.DAOException;
import com.np.dal.impl.FileNotesDAO;
import com.np.entity.Note;
import com.np.service.NotesFindService;
import com.np.service.exception.ServiceException;

public class NoteFindServiceImpl implements NotesFindService{
	
	@Override
	public List<Note> findByContent(String content) throws ServiceException {

		DAOProvider provider = DAOProvider.getInstance();
		NotesDAO notesDAO = provider.getNotesDAO();
		List<Note> sourceList;
		try {
			sourceList = notesDAO.load();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		List<Note> resultSeach = new ArrayList<>();

		for (Note note : sourceList) {
			if (note.getHeader().contains(content)) {
				resultSeach.add(note);
			}
		}

		return resultSeach;

	}

	@Override
	public List<Note> findByDate(Date date) throws ServiceException {
		
		DAOProvider provider = DAOProvider.getInstance();
		NotesDAO notesDAO = provider.getNotesDAO();
		List<Note> sourceList;
		try {
			sourceList = notesDAO.load();
		}catch(DAOException e) {
			throw new ServiceException(e);
		}
		List<Note> resultSeach = new ArrayList<>();
		for(Note note: sourceList) {
			if(note.getDate().equals(date)) {
				resultSeach.add(note);
			}
		}
				
		return resultSeach;
	}

}
