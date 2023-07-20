package com.osi.estimationmodule.utils;

import org.springframework.web.multipart.MultipartFile;

public interface ITemplateValidator {

	boolean validateTemplate(MultipartFile file);
}
