package com.osi.estimationmodule.services.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.osi.estimationmodule.dtos.EstimationResourceEffortDto;
import com.osi.estimationmodule.dtos.GlobalEstimationObject;
import com.osi.estimationmodule.entities.EstimationDetail;
import com.osi.estimationmodule.entities.ResourceEffort;
import com.osi.estimationmodule.exceptions.AttachmentNotSavedException;
import com.osi.estimationmodule.repositories.EstimationDetailRepository;
import com.osi.estimationmodule.repositories.ResourceEffortRepository;
import com.osi.estimationmodule.services.IAttachmentService;
import com.osi.estimationmodule.services.IDocumentManagementService;
import com.osi.estimationmodule.services.IEstimationService;
import com.osi.estimationmodule.services.IFileValidator;
import com.osi.estimationmodule.services.IObjectTransformation;
import com.osi.estimationmodule.utils.EstimationTransformationFactory;
import com.osi.estimationmodule.utils.ITemplateValidator;
import com.osi.estimationmodule.utils.TemplateValidatorFactory;

@Service
public class EstimationServiceImpl implements IEstimationService {

	@Autowired
	private IFileValidator fileValidator;

	@Autowired
	private TemplateValidatorFactory templateValidatorFactory;

	@Autowired
	private IDocumentManagementService documentManagementService;

	@Autowired
	private IAttachmentService attachmentService;

	@Autowired
	private EstimationDetailRepository estimationDetailRepository;
	
	@Autowired
	private ResourceEffortRepository resourceEffortRepository;

	@Autowired
	private EstimationTransformationFactory estimationTransformationFactory;

	@Override
	public void importFile(MultipartFile file, int projectId, int sowId, int userId, String templateName,
			LocalDate startDate) throws IOException {

		ITemplateValidator templateValidator = templateValidatorFactory.getTemplateValidator(templateName);
		IObjectTransformation objectTransformation = estimationTransformationFactory
				.getEstimationTransformationObject(templateName);

		if (fileValidator.validateFile(file) && templateValidator.validateTemplate(file)) {
			documentManagementService.uploadFile(file, projectId, templateName);
			attachmentService.persistData(file);
			GlobalEstimationObject transformedObject = (GlobalEstimationObject) objectTransformation
					.transformObject(file);

			//System.out.println(transformedObject.getEstimationDetailToResourceEffortsMap());
			persistEstimationToDb(transformedObject);

		} else
			throw new AttachmentNotSavedException("Unable to save attachment details");
	}

	private void persistEstimationToDb(GlobalEstimationObject transformedObject) {
		List<EstimationResourceEffortDto> estimationResourceEffortDtos = transformedObject.getEstimationResourceEffortDtos();
		
		for (EstimationResourceEffortDto estimationResourceEffortDto : estimationResourceEffortDtos) {
            EstimationDetail estimationDetail = estimationResourceEffortDto.getEstimationDetail();
            List<ResourceEffort> resourceEfforts = estimationResourceEffortDto.getResourceEfforts();
            EstimationDetail savedEstimationDetail = estimationDetailRepository.save(estimationDetail);

            // Iterate over the resource efforts list
            for (ResourceEffort resourceEffort : resourceEfforts) {
                resourceEffort.setEstimationDetail(savedEstimationDetail);
            }
            resourceEffortRepository.saveAll(resourceEfforts);
        }
	
	}


}
