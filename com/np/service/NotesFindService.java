package com.np.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.np.entity.Note;
import com.np.service.exception.ServiceException;

public interface NotesFindService {
	
	List<Note> findByContent(String content)throws ServiceException;
	
	List<Note> findByDate(Date date) throws ServiceException;
	
	

}
