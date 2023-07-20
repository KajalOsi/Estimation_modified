package com.osi.estimationmodule.exceptions;

public class AttachmentNotSavedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	String message;

	public AttachmentNotSavedException(String message) {
		super(message);
		this.message = message;
	}

}
