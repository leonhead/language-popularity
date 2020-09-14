package com.qubit.languagepopularity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qubit.languagepopularity.entity.ProgramLanguage;
import com.qubit.languagepopularity.entity.GithubRepository;

@Service
public class GithubRepositoryServiceImpl implements GithubRepositoryService {

	@Override
	public List<GithubRepository> findAll() {
		List<GithubRepository> repositories = List.of(new GithubRepository("test", "html_test", 200, new ProgramLanguage("Java")), new GithubRepository("test2", "html_test2", 209, new ProgramLanguage("C")));
		return repositories;
	}

}
