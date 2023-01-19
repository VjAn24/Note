package com.np.service.impl;

import com.np.service.NotesCreateService;

public class ServiceProviderCreate {
	
	private static final ServiceProviderCreate instance = new ServiceProviderCreate();
	
	private NotesCreateService createService = new NotesCreateServiceImpl();
	
	public NotesCreateService getCreateService() {
		return createService;
	}
	
	public static ServiceProviderCreate geInstance() {
		return instance;
	}

	@Override
	public String toString() {
		return "ServiceProviderCreate [createService=" + createService + "]";
	}

}
