package com.qubit.languagepopularity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	@Override
	public Page<ProgramLanguage> findAll(Pageable pageable) {
		int size = pageable.getPageSize();
		int page = pageable.getPageNumber();

		return programLanguageRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public void save(ProgramLanguage programmLanguage) {
		List<ProgramLanguage> programmLanguages = programLanguageRepository
				.findByNameEquals(programmLanguage.getName());
		if (programmLanguages.isEmpty()) {
			programLanguageRepository.save(programmLanguage);
		}
	}

	@Override
	public Optional<ProgramLanguage> findByName(String name) {
		List<ProgramLanguage> programmLanguages = programLanguageRepository.findByNameEquals(name);
		return programmLanguages.stream().findFirst();
	}

	@Override
	public Double getPopularity() {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public Double getTrend() {
		// TODO Auto-generated method stub
		return 0.0;
	}


}
