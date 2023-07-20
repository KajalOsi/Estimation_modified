package com.osi.estimationmodule.exceptions;

public class InvalidFileFormatException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public InvalidFileFormatException(String message) {
		super(message);
		this.message = message;
	}
	
	
	

}
