package com.osi.estimationmodule.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelService {
	
	public List<String> getSheetNames(InputStream inputStream) {
        List<String> sheetNames = new ArrayList<>();

     // Create Workbook instance for XLSX file
        Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);			
			// Iterate over each sheet and add its name to the list
	        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
	            Sheet sheet = workbook.getSheetAt(i);
	            sheetNames.add(sheet.getSheetName());
	        }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}   
		return sheetNames;
    }
}
