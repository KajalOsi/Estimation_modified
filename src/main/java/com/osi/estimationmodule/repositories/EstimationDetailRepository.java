package com.osi.estimationmodule.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osi.estimationmodule.entities.EstimationDetail;
import com.osi.estimationmodule.entities.Project;

public interface EstimationDetailRepository extends JpaRepository<EstimationDetail, Integer> {
	//List<EstimationDetail> findAllEstimationDetailsByProject(Project project);
}
