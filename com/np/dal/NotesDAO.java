package com.np.dal;

import java.util.List;

import com.np.dal.exception.DAOException;
import com.np.entity.Note;

public interface NotesDAO {
	
	List<Note> load() throws DAOException;
	
	void save(Note note) throws DAOException;
	

}
