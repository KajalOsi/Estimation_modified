package com.osi.estimationmodule.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.osi.estimationmodule.exceptions.TemplateNotFoundException;
import com.osi.estimationmodule.services.IObjectTransformation;
import com.osi.estimationmodule.services.impl.GlobalEstimationTransformation;
import com.osi.estimationmodule.services.impl.MSPEstimationTransformation;

@Component
public class EstimationTransformationFactory {
	
	@Autowired
	private GlobalEstimationTransformation globalEstimationTransformation;
	@Autowired
	private MSPEstimationTransformation mspEstimationTransformation;
	
	public IObjectTransformation getEstimationTransformationObject(String template) {
		String globalEstimationTemplate = "GLOBAL_ESTIMATION";
		String mspEstimationTemplate = "MSP_ESTIMATION";
		if (globalEstimationTemplate.equals(template)) {
			return globalEstimationTransformation;
		} else if (mspEstimationTemplate.equals(template)) {
			return mspEstimationTransformation;
		} else
			throw new TemplateNotFoundException("The Template requested is not found");
	}

}
