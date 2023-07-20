package com.osi.estimationmodule.exceptions;

public class TemplateNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public TemplateNotFoundException(String message) {
		super(message);
		this.message = message;
	}

}
