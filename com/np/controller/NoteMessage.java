package com.np.controller;

import com.np.entity.Note;

public class NoteMessage {
	
	private String message;
	
	public NoteMessage() {
		
	}
	
	public NoteMessage(String message) {
		this.message=message;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
