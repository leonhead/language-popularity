package com.qubit.languagepopularity.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.qubit.languagepopularity.entity.GithubRepo;

public interface GithubRepositoryService {
	
	public List<GithubRepo> findAll();
	
	public void save(GithubRepo githubRepo);

	public Page<GithubRepo> findPaginated(int searchYear, Pageable pageable);
	
	public Page<GithubRepo> findByLanguage(String langaugeName, Pageable pageable);
	
	

}
