package com.osi.estimationmodule.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.osi.estimationmodule.entities.Attachment;
import com.osi.estimationmodule.repositories.AttachmentRepository;
import com.osi.estimationmodule.services.IAttachmentService;

@Service
public class AttachmentServiceImpl implements IAttachmentService {

	@Autowired
	private AttachmentRepository attachmentRepository;

	@Override
	public Attachment persistData(MultipartFile file) {

		Attachment attachment = new Attachment();
		attachment.setAttachmentName(LocalDocumentManagementService.NEW_FILENAME);
		attachment.setPath(LocalDocumentManagementService.UPLOAD_DIR);
		Attachment savedAttachment = attachmentRepository.save(attachment);
		return savedAttachment;
	}

}
