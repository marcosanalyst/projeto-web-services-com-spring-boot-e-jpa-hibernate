package com.educandoweb.course.services.execeptions;

// será um sub-classe do RuntimeException do próprio java
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resource " + id +  " not found");
	}
}
