package com.qubit.languagepopularity.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.qubit.languagepopularity.entity.GithubRepo;

public interface GithubRepositoryService {

	public List<GithubRepo> findAll();

	public Page<GithubRepo> findAll(Pageable pageable);
	
	public Page<GithubRepo> findByYear(Date start, Date end, Pageable pageable);

	public Page<GithubRepo> findByLanguage(String langaugeName, Pageable pageable);
	
	public void save(GithubRepo githubRepo);

}
