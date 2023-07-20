package com.osi.estimationmodule;

import org.apache.tika.Tika;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EstimationModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstimationModuleApplication.class, args);
	}
	
	@Bean
	Tika getTika() {
		return new Tika();
	}
	
	@Bean
	ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
