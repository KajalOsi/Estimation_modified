package com.osi.estimationmodule.services.impl;

import java.io.IOException;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.osi.estimationmodule.exceptions.InvalidFileFormatException;
import com.osi.estimationmodule.services.IFileValidator;

@Service
public class ExcelFileValidator implements IFileValidator {

	@Autowired
	private Tika tika;

	@Override
	public boolean validateFile(MultipartFile file) {

		boolean isValidFileFormat = false;
		byte[] fileData;
		if (!file.isEmpty()) {
			try {
				fileData = file.getBytes();
				String contentType = tika.detect(fileData);
				System.out.println(contentType);
				if (!(contentType.equals("application/zip") || contentType.equals("application/x-tika-ooxml")))
					throw new InvalidFileFormatException("Invalid File!. Please upload the correct EXCEL file format");
				isValidFileFormat = true;
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
		return isValidFileFormat;
	}
}
