package com.upoint.propertyatomic.util;

import org.springframework.stereotype.Component;

@Component
public class Message {

	private static final String PROPERTY_DELETED = "succesfull deletion with id: %1s";
	
	private static final String ENTITY_NOT_FOUND = " no content found provided for provided id: %1s";
	
	private static final String PROPERTY_UPDATED =  "property with id: %1s succesfully updated";
	
	public String getPropertyDeleted(Integer id) {
		return String.format(PROPERTY_DELETED, id);
	}
	
	public String getPropertyUpdated(Integer id) {
		return String.format(PROPERTY_UPDATED, id);
	}
	
	public String getEntityNotFound(Integer id) {
		return String.format(ENTITY_NOT_FOUND, id);
	}
}
