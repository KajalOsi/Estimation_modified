package com.osi.estimationmodule.services;

import org.springframework.web.multipart.MultipartFile;

public interface IDocumentManagementService {
	
	String uploadFile(MultipartFile file, int projectId, String templateName);
	byte[] downloadFile(String fileName);
	String deleteFile(String fileName);
	boolean searchFile(String fileName);
}
