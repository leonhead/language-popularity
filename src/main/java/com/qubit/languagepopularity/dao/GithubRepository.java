package com.qubit.languagepopularity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qubit.languagepopularity.entity.GithubRepo;

public interface GithubRepository extends JpaRepository<GithubRepo, Integer> {

}
