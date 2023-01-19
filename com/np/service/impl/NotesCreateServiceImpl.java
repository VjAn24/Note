package com.np.service.impl;

import com.np.dal.DAOProvider;
import com.np.dal.NotesDAO;
import com.np.dal.exception.DAOException;
import com.np.dal.impl.FileNotesDAO;
import com.np.entity.Note;
import com.np.service.NotesCreateService;
import com.np.service.exception.ServiceException;

public class NotesCreateServiceImpl implements NotesCreateService{
	

	@Override
	public void add (Note note) throws ServiceException {
		NotesValidationServiceImpl validation = new NotesValidationServiceImpl();
		if (validation.titleValidation(note.getHeader()) & validation.dateValidation(note.getDate()) & validation.contentValidation(note.getTextRecord())) {
			DAOProvider provider = DAOProvider.getInstance();
			NotesDAO notesDAO = provider.getNotesDAO();

			try {
				if (note != null) {
					notesDAO.save(note);
				} 
			} catch (DAOException e) {
				throw new ServiceException("Level error", e);
			}
		}else {
			throw new ServiceException("Data entered incorectly!");
		}

	}

}
