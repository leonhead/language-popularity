package com.qubit.languagepopularity.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.qubit.languagepopularity.entity.ProgramLanguage;

public interface ProgramLanguageService {

	public List<ProgramLanguage> findAll();

	public Page<ProgramLanguage> findAll(Pageable pageable);

	public Optional<ProgramLanguage> findById(Integer id);

	public void save(ProgramLanguage programmLanguage);
	
	public void update(ProgramLanguage programmLanguage);
	
	public Optional<ProgramLanguage> findByName(String name);

	public Long countProgramLanguage(ProgramLanguage programmLanguage, Date start, Date end);

	public Double calculateTrend(ProgramLanguage programmLanguage);

}
