package com.qubit.languagepopularity.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.qubit.languagepopularity.entity.GithubRepo;

public interface GithubRepository extends JpaRepository<GithubRepo, Integer> {

	public List<GithubRepo> findByGithubIdEquals(Long id);
	
	public Page<GithubRepo> findByCreatedBefore(@Param("created") Date created, Pageable pageable);
	
	public Page<GithubRepo> findByLanguage_NameOrderByStargazersCountDesc(@Param("language") String languageName, Pageable pageable); 
}
