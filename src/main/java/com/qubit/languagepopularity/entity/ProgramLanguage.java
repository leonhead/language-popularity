package com.qubit.languagepopularity.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "program_language")
public class ProgramLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "program_language_id")
	private Integer id;

	@Column(name = "program_language_name")
	private String name;

	@Column(name = "currency")
	private Double currency;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "programLanguage", cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Popularity> popularities;

	public ProgramLanguage() {
	}

	public ProgramLanguage(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Popularity> getPopularities() {
		return popularities;
	}

	public void setPopularities(List<Popularity> popularities) {
		this.popularities = popularities;
	}

	public void addPopularity(Popularity popularity) {
		if (this.popularities == null) {
			this.popularities = new ArrayList<Popularity>();
		}
		this.getPopularities().add(popularity);
		this.currency = popularity.getCurrency();
	}

	public Double getCurrency() {
		return currency;
	}

	public void setCurrency(Double currency) {
		this.currency = currency;
	}

}
