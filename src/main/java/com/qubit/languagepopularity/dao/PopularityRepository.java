package com.qubit.languagepopularity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qubit.languagepopularity.entity.Popularity;

public interface PopularityRepository extends JpaRepository<Popularity, Integer> {

}
