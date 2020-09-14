package com.qubit.languagepopularity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qubit.languagepopularity.entity.Language;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Override
	public List<Language> findAll() {
		List<Language> languages = List.of(new Language("C"), new Language("Java"), new Language("Python"));
		return languages;
	}

}
