package com.qubit.languagepopularity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.qubit.languagepopularity.entity.ProgramLanguage;

public interface ProgramLanguageService {

	public List<ProgramLanguage> findAll();

	public void save(ProgramLanguage programmLanguage);

	public Optional<ProgramLanguage> findByName(String name);

	public Page<ProgramLanguage> findPaginated(Pageable pageable);

}
