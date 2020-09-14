package com.qubit.languagepopularity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qubit.languagepopularity.entity.ProgramLanguage;

@Service
public class ProgramLanguageServiceImpl implements ProgramLanguageService {

	@Override
	public List<ProgramLanguage> findAll() {
		List<ProgramLanguage> languages = List.of(new ProgramLanguage("C"), new ProgramLanguage("Java"), new ProgramLanguage("Python"));
		return languages;
	}

}
