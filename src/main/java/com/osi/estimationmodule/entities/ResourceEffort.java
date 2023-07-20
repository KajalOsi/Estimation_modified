package com.osi.estimationmodule.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResourceEffort {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String monthName;
	private int year;
	private int manDays;
	private int version;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "estimationDetail_id", referencedColumnName = "id")
	private EstimationDetail estimationDetail;

}
