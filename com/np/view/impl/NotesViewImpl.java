package com.np.view.impl;

import java.util.List;

import com.np.entity.Note;
import com.np.view.NoteView;

public class NotesViewImpl implements NoteView{

	@Override
	public void view(List<Note> note) {
		if(note!=null) {
			for (int i=0; i<note.size(); i++) {
				
				System.out.println(note.get(i).getHeader());
				System.out.println(note.get(i).getDate());
				System.out.println(note.get(i).getTextRecord());
				
			}
		}else {
			
			System.out.println("Records missing");
		}
		
	}

}
