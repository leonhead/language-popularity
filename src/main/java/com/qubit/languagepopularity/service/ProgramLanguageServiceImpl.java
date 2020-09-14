package com.qubit.languagepopularity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qubit.languagepopularity.dao.ProgramLanguageRepository;
import com.qubit.languagepopularity.entity.ProgramLanguage;

@Service
public class ProgramLanguageServiceImpl implements ProgramLanguageService {

	@Autowired
	private ProgramLanguageRepository programLanguageRepository;

	@Override
	public List<ProgramLanguage> findAll() {
		List<ProgramLanguage> languages = programLanguageRepository.findAll();
		return languages;
	}

}
