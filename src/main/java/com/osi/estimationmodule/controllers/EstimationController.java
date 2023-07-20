package com.osi.estimationmodule.controllers;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.osi.estimationmodule.services.IEstimationService;

@RestController
public class EstimationController {
	
	@Autowired
	private IEstimationService estimationService;
	
	@PostMapping("/estimation-sheet/import")
	public ResponseEntity<?> importFile(@RequestParam("file") MultipartFile file,
			@RequestParam("project_id") int projectId, 
			@RequestParam("sow_id") int sowId,
			@RequestParam("user_id") int userId,
			@RequestParam("template_name") String templateName,
			@RequestParam("start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate) throws IOException{
			this.estimationService.importFile(file, projectId, sowId, userId, templateName, startDate);
		
			return ResponseEntity.ok("file is uploaded and data is saved to db");
	}

}
