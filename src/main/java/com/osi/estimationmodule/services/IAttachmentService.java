package com.osi.estimationmodule.services;

import org.springframework.web.multipart.MultipartFile;

import com.osi.estimationmodule.entities.Attachment;

public interface IAttachmentService {	
	Attachment persistData(MultipartFile file);
}
