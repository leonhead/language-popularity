package com.qubit.languagepopularity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qubit.languagepopularity.service.ProgramLanguageService;
import com.qubit.languagepopularity.service.ProgramLanguageServiceImpl;

@Configuration
public class Config {

	@Bean(name = "programLanguageService")
	public ProgramLanguageService programLanguageService() {
		return new ProgramLanguageServiceImpl();
	}

}