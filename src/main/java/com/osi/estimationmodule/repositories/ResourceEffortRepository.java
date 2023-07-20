package com.osi.estimationmodule.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osi.estimationmodule.entities.EstimationDetail;
import com.osi.estimationmodule.entities.ResourceEffort;

public interface ResourceEffortRepository extends JpaRepository<ResourceEffort, Integer>  {
	//List<ResourceEffort> findAllResourceEffortsByEstimationDetail(EstimationDetail estimationDetail);
}
