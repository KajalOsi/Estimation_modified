package com.osi.estimationmodule.dtos;

import java.util.List;

import com.osi.estimationmodule.entities.EstimationDetail;
import com.osi.estimationmodule.entities.ResourceEffort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstimationResourceEffortDto {
	
	private EstimationDetail estimationDetail;
	private List<ResourceEffort> resourceEfforts;

}
