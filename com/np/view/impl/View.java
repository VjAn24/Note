package com.np.view.impl;

public class View {
	
	public void view(String message) {
		if(message == null) {
			System.out.println("Record not found");
		}else {
			System.out.println(message);
		}
	}

}
