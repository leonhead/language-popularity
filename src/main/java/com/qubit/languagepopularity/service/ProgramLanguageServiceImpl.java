package com.qubit.languagepopularity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.qubit.languagepopularity.dao.GithubRepository;
import com.qubit.languagepopularity.dao.ProgramLanguageRepository;
import com.qubit.languagepopularity.entity.Popularity;
import com.qubit.languagepopularity.entity.ProgramLanguage;

@Service
@Primary
public class ProgramLanguageServiceImpl implements ProgramLanguageService {

	@Autowired
	private ProgramLanguageRepository programLanguageRepository;

	@Autowired
	private GithubRepository githubRepository;

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
	public Long countProgramLanguage(ProgramLanguage programmLanguage) {
		return githubRepository.countByLanguage_Name(programmLanguage.getName());
	}

	@Override
	public Double calculateTrend(ProgramLanguage programmLanguage) {
		programmLanguage = programLanguageRepository.getOne(programmLanguage.getId());
		List<Popularity> popularities = programmLanguage.getPopularities();
		if (popularities.size() < 2) {
			return 0.0;
		}

		Popularity currentPopularity = popularities.get(popularities.size() - 1);
		Popularity lastPopularity = popularities.get(popularities.size() - 2);

		return currentPopularity.getCurrency() - lastPopularity.getCurrency();
	}

}
