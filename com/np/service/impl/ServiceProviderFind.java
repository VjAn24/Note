package com.np.service.impl;

import com.np.service.NotesFindService;
import com.np.service.exception.ServiceException;

public class ServiceProviderFind {
	
	private static final ServiceProviderFind instance = new ServiceProviderFind();
	
	private NotesFindService findService = new NoteFindServiceImpl();
	
	public NotesFindService getFindService() {
			return findService;
		
	}
	
	public static ServiceProviderFind getInstance() {
		return instance;
	}

	@Override
	public String toString() {
		return "ServiceProviderFind [findService=" + findService + "]";
	}
	
	

}
