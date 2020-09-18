package com.qubit.languagepopularity.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

		return programLanguageRepository.findAll(PageRequest.of(page, size, Sort.by("currency").descending()));
	}

	@Override
	public void save(ProgramLanguage programmLanguage) {
		Optional<ProgramLanguage> language = programLanguageRepository.findOneByNameEquals(programmLanguage.getName());
		if (!language.isPresent()) {
			programLanguageRepository.save(programmLanguage);
		}
	}

	@Override
	public void update(ProgramLanguage programmLanguage) {
		programLanguageRepository.save(programmLanguage);
	}

	@Override
	public Optional<ProgramLanguage> findByName(String name) {
		Optional<ProgramLanguage> programmLanguage = programLanguageRepository.findOneByNameEquals(name);
		return programmLanguage;
	}

	@Override
	public Long countProgramLanguage(ProgramLanguage programmLanguage, Date start, Date end) {
		return githubRepository.countByLanguage_NameAndCreatedAfterAndCreatedBefore(programmLanguage.getName(), start,
				end);
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

	@Override
	public Optional<ProgramLanguage> findById(Integer id) {
		return programLanguageRepository.findById(id);
	}

}
