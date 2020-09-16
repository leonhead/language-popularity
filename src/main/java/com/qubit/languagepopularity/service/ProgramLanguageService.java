package com.qubit.languagepopularity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.qubit.languagepopularity.entity.ProgramLanguage;

public interface ProgramLanguageService {

	public List<ProgramLanguage> findAll();
	
	public Page<ProgramLanguage> findAll(Pageable pageable);

	public void save(ProgramLanguage programmLanguage);

	public Optional<ProgramLanguage> findByName(String name);
	
	public Double getPopularity();

	public Double getTrend();

}
