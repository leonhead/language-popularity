package com.qubit.languagepopularity.entity;

import java.sql.Timestamp;

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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "github_repository_id")
	private Integer id;

	@Column(name = "github_id")
	private Long githubId;

	@Column(name = "created")
	private Timestamp created;

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

	public GithubRepo(Long githubId, Timestamp created, String fullName, String htmlUrl, int stargazersCount,
			ProgramLanguage language) {
		this.githubId = githubId;
		this.created = created;
		this.fullName = fullName;
		this.htmlUrl = htmlUrl;
		this.stargazersCount = stargazersCount;
		this.language = language;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Long getGithubId() {
		return githubId;
	}

	public void setGithubId(Long githubId) {
		this.githubId = githubId;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

}
