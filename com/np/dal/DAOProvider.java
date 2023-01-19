package com.np.dal;

import com.np.dal.exception.DAOException;
import com.np.dal.impl.FileNotesDAO;

public class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();
	
	private NotesDAO notesDAO;
	
	private DAOProvider() {
		try {
			notesDAO = new FileNotesDAO();
		}catch(DAOException e) {
			throw new RuntimeException("First level, DAO not created");
		}
		
	}
		
	
	public NotesDAO getNotesDAO() {
		return notesDAO;
	}
	
	public static DAOProvider getInstance() {
		return instance;
	}

}
