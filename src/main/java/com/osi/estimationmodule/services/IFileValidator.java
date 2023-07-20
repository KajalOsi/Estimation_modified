package com.osi.estimationmodule.services;

import org.springframework.web.multipart.MultipartFile;

public interface IFileValidator {
	
	boolean validateFile(MultipartFile file);

}
