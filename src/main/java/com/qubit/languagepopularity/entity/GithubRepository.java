package com.qubit.languagepopularity.entity;

public class GithubRepository {

	private Long id;
	private String fullName;
	private String htmlUrl;
	private int stargazersCount;
	private ProgramLanguage language;

	public GithubRepository(String fullName, String htmlUrl, int stargazersCount, ProgramLanguage language) {
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
