package com.osi.estimationmodule.services;

import org.springframework.web.multipart.MultipartFile;

public interface IObjectTransformation {
	
	Object transformObject(MultipartFile file);

}
