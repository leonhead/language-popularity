package com.qubit.languagepopularity.entity;

public class ProgramLanguage {

	private Long id;
	private String name;

	public ProgramLanguage(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
