package com.osi.estimationmodule.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.osi.estimationmodule.exceptions.TemplateNotFoundException;

@Component
public class TemplateValidatorFactory {
	
	@Autowired
	private GlobalEstimationTemplateValidator globalEstimationTemplateValidator;
	
	@Autowired
	private MSPEstimationTemplateValidator mspEstimationTemplateValidator;

	public ITemplateValidator getTemplateValidator(String template) {
		String globalEstimationTemplate = "GLOBAL_ESTIMATION";
		String mspEstimationTemplate = "MSP_ESTIMATION";
		if (globalEstimationTemplate.equals(template)) {
			return globalEstimationTemplateValidator;
		} else if (mspEstimationTemplate.equals(template)) {
			return mspEstimationTemplateValidator;
		} else
			throw new TemplateNotFoundException("The Template requested is not found");
	}

}
