package com.osi.estimationmodule.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.osi.estimationmodule.config.AppConfig;
import com.osi.estimationmodule.services.IDocumentManagementService;

@Service
public class LocalDocumentManagementService implements IDocumentManagementService {

	public static String UPLOAD_DIR = null;
	public static String NEW_FILENAME;
	@Override
	public String uploadFile(MultipartFile file, int projectId, String templateName) {
		String fileName = file.getOriginalFilename();
		NEW_FILENAME = fileName.substring(0, fileName.lastIndexOf(".")) + "-"
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS"))
				+ fileName.substring(fileName.lastIndexOf("."));
		UPLOAD_DIR = AppConfig.BASE_PATH + projectId+"\\" + templateName;
		Path completePath = Paths.get(UPLOAD_DIR, NEW_FILENAME);
		try {
			Files.createDirectories(completePath.getParent());
			
			Files.copy(file.getInputStream(),
					Paths.get(UPLOAD_DIR,NEW_FILENAME));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "File uploaded sucessfully!";
	}

	@Override
	public byte[] downloadFile(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteFile(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean searchFile(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

}
