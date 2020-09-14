package com.qubit.languagepopularity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qubit.languagepopularity.entity.ProgramLanguage;

public interface ProgramLanguageRepository extends JpaRepository<ProgramLanguage, Integer>{

}
