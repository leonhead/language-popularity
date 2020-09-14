package com.qubit.languagepopularity.service;

import java.util.List;

import com.qubit.languagepopularity.entity.GithubRepository;

public interface GithubRepositoryService {
	
	public List<GithubRepository> findAll();

}
