package com.qubit.languagepopularity.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.qubit.languagepopularity.dao.GithubRepository;
import com.qubit.languagepopularity.entity.GithubRepo;

@Service
public class GithubRepositoryServiceImpl implements GithubRepositoryService {

	@Autowired
	private GithubRepository githubRepository;

	@Override
	public List<GithubRepo> findAll() {
		List<GithubRepo> repositories = githubRepository.findAll();
		return repositories;
	}

	@Override
	public void save(GithubRepo githubRepo) {
		List<GithubRepo> githubRepos = githubRepository.findByGithubIdEquals(githubRepo.getGithubId());
		if (githubRepos.isEmpty()) {
			githubRepository.save(githubRepo);
		}
	}

	@Override
	public Page<GithubRepo> findPaginated(int searchYear, Pageable pageable) {
		int size = pageable.getPageSize();
		int page = pageable.getPageNumber();
		Date date = new Date(searchYear, 1, 1);
		Page<GithubRepo> repositories = githubRepository.findByCreatedBefore(date, PageRequest.of(page, size));
		return repositories;
	}

	@Override
	public Page<GithubRepo> findByLanguage(String languageName, Pageable pageable) {
		int size = pageable.getPageSize();
		int page = pageable.getPageNumber();
		Page<GithubRepo> repositories = githubRepository.findByLanguage_NameOrderByStargazersCountDesc(languageName, PageRequest.of(page, size));
		return repositories;
	}


}
