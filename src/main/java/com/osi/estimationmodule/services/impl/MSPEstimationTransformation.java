package com.osi.estimationmodule.services.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.osi.estimationmodule.services.IObjectTransformation;
@Component
public class MSPEstimationTransformation implements IObjectTransformation {

	@Override
	public Object transformObject(MultipartFile file) {
		return null;
	}

}
