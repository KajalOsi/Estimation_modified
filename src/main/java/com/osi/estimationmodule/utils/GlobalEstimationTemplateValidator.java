package com.osi.estimationmodule.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.osi.estimationmodule.exceptions.InvalidFileFormatException;
import com.osi.estimationmodule.exceptions.TemplateNotFoundException;

@Component
public class GlobalEstimationTemplateValidator implements ITemplateValidator {

	@Autowired
	private ExcelService excelService;
	
	@Override
	public boolean validateTemplate(MultipartFile file) {
		InputStream inputStream = null;
		boolean isValidtemplate = false;
		try {
			inputStream = file.getInputStream(); 
			List<String> sheetNames = excelService.getSheetNames(inputStream);
			 if(sheetNames.contains("Year 1") || sheetNames.contains("Year 2") || sheetNames.contains("Year 3")) {
				 isValidtemplate = true;
			 }else {
				 throw new TemplateNotFoundException("Please upload correct template");
			 }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return isValidtemplate;
	}
}
