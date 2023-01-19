package com.np.service;

import com.np.entity.Note;
import com.np.service.exception.ServiceException;

public interface NotesCreateService {
	void add(Note n) throws ServiceException;

}
