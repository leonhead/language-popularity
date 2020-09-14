package com.qubit.languagepopularity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "github_repository")
public class GithubRepo {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "github_repository_id")
	private Long id;
	
	@Column(name="github_id")
	private Long githubId;
	
	@Column(name="created")
	private Long created;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "html_url")
	private String htmlUrl;

	@Column(name = "stargazers_count")
	private int stargazersCount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "program_language_id")
	private ProgramLanguage language;

	public GithubRepo() {
	}

	public GithubRepo(String fullName, String htmlUrl, int stargazersCount, ProgramLanguage language) {
		this.fullName = fullName;
		this.htmlUrl = htmlUrl;
		this.stargazersCount = stargazersCount;
		this.language = language;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public int getStargazersCount() {
		return stargazersCount;
	}

	public void setStargazersCount(int stargazersCount) {
		this.stargazersCount = stargazersCount;
	}

	public ProgramLanguage getLanguage() {
		return language;
	}

	public void setLanguage(ProgramLanguage language) {
		this.language = language;
	}

}
