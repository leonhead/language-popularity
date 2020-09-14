package com.qubit.languagepopularity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qubit.languagepopularity.entity.Language;
import com.qubit.languagepopularity.entity.Repository;

@Service
public class RepositoryServiceImpl implements RepositoryService {

	@Override
	public List<Repository> findAll() {
		List<Repository> repositories = List.of(new Repository("test", "html_test", 200, new Language("Java")), new Repository("test2", "html_test2", 209, new Language("C")));
		return repositories;
	}

}
