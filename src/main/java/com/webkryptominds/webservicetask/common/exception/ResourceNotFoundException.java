package com.webkryptominds.webservicetask.common.exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	 public ResourceNotFoundException( String message) {
		 super (message);
	 }

}