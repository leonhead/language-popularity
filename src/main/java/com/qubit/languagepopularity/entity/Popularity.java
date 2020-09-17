package com.qubit.languagepopularity.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "popularity")
public class Popularity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "popularity_id")
	private Integer id;

	@Column(name = "date_year")
	private Integer year;

	@Column(name = "currency")
	private Double currency;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "program_language_id")
	private ProgramLanguage programLanguage;

	public Popularity() {
	}

	public Popularity(Integer year, Double currency, ProgramLanguage programLanguage) {
		this.year = year;
		this.currency = currency;
		this.programLanguage = programLanguage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCurrency() {
		return currency;
	}

	public void setCurrency(Double currency) {
		this.currency = currency;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public ProgramLanguage getProgramLanguage() {
		return programLanguage;
	}

	public void setProgramLanguage(ProgramLanguage programLanguage) {
		this.programLanguage = programLanguage;
	}

}
