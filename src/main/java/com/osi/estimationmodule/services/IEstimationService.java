package com.osi.estimationmodule.services;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

public interface IEstimationService {
	void importFile(MultipartFile file, int projectId, int sowId, int userId, String templateName, LocalDate startDate) throws IOException;
}
