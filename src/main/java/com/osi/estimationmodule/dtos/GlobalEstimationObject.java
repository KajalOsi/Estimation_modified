package com.osi.estimationmodule.dtos;

import java.util.List;
import java.util.Map;

import com.osi.estimationmodule.entities.EstimationDetail;
import com.osi.estimationmodule.entities.ResourceEffort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalEstimationObject {
	
	private List<EstimationResourceEffortDto> estimationResourceEffortDtos;

}
