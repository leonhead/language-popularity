package com.qubit.languagepopularity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
