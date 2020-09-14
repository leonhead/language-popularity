package com.qubit.languagepopularity.service;

import java.util.List;

import com.qubit.languagepopularity.entity.GithubRepo;

public interface GithubRepositoryService {
	
	public List<GithubRepo> findAll();

}
