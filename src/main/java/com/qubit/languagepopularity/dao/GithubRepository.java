package com.qubit.languagepopularity.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.qubit.languagepopularity.entity.GithubRepo;

public interface GithubRepository extends JpaRepository<GithubRepo, Integer> {

	public List<GithubRepo> findByGithubIdEquals(Long id);

	public Long countByLanguage_Name(String languageName);

	public Page<GithubRepo> findByCreatedAfterAndCreatedBefore(Date start, Date end, Pageable pageable);

	public Page<GithubRepo> findByLanguage_NameOrderByStargazersCountDesc(String languageName, Pageable pageable);
}
