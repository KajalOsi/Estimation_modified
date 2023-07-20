package com.osi.estimationmodule.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstimationDetail {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String role;	
	private int noOfResources;
	private String empName;
	private String projectLocation;
	private String practice;
	private String subPractice;
	private String jobCode;
	private String preminum;
	
	private int totalDays;
	private int totalHours;
	private int suggestedHourlyRate;
	private int hourlyRate;
	private int dailyRate;
	private int totalFees;
	private int hourlyCost;
	private int standardTotalCost;
	private int overheadCost;
	private int newHourlyCost;
	private int totalCost;
	private int grossMargin;
	private int grossMarginPercentage;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id", referencedColumnName = "id")
	private Project project;
}
