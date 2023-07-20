package com.osi.estimationmodule.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.osi.estimationmodule.dtos.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
//	@ExceptionHandler(AttachmentNotSavedException.class)
//	public ResponseEntity<ApiResponse> AttachmentNotSavedExceptionHandler(AttachmentNotSavedException ex){
//		String msg = ex.getMessage();
//		//pass msg along with success status to the ApiResponse
//		ApiResponse apiResponse = new ApiResponse(msg, false); //send the same response with status code 
//		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler(InvalidFileFormatException.class)
	public ResponseEntity<ApiResponse> handleInvalidFileFormatException(InvalidFileFormatException ex){
		String msg = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(msg, false);  
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TemplateNotFoundException.class)
	public ResponseEntity<ApiResponse> handleTemplateNotFoundException(TemplateNotFoundException ex){
		String msg = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(msg, false); 
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<ApiResponse> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex){
		String msg = "Maximum upload size exceeded";
		ApiResponse apiResponse = new ApiResponse(msg, false); 
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.PAYLOAD_TOO_LARGE);
	}

}
