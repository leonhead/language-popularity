package com.qubit.languagepopularity.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepository {

	@JsonProperty("id")
	private Long githubId;

	@JsonProperty("created_at")
	private String created;

	@JsonProperty("full_name")
	private String fullName;

	@JsonProperty("html_url")
	private String htmlUrl;

	@JsonProperty("stargazers_count")
	private int stargazersCount;

	@JsonProperty("language")
	private String language;

	public GithubRepository() {
	}

	public GithubRepository(Long githubId, String created, String fullName, String htmlUrl, int stargazersCount,
			String language) {
		this.githubId = githubId;
		this.created = created;
		this.fullName = fullName;
		this.htmlUrl = htmlUrl;
		this.stargazersCount = stargazersCount;
		this.language = language;
	}

	public Long getGithubId() {
		return githubId;
	}

	public void setGithubId(Long githubId) {
		this.githubId = githubId;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
