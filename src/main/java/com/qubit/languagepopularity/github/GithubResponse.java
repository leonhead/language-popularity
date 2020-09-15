package com.qubit.languagepopularity.github;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubResponse {

	@JsonProperty("total_count")
	private Integer totalCount;

	@JsonProperty("incomplete_results")
	private Boolean incompleteResults;

	@JsonProperty("items")
	private List<GithubRepository> repositories = new ArrayList<GithubRepository>();

	public GithubResponse() {
	}

	public GithubResponse(Integer totalCount, Boolean incompleteResults, List<GithubRepository> repositories) {
		this.totalCount = totalCount;
		this.incompleteResults = incompleteResults;
		this.repositories = repositories;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Boolean getIncompleteResults() {
		return incompleteResults;
	}

	public void setIncompleteResults(Boolean incompleteResults) {
		this.incompleteResults = incompleteResults;
	}

	public List<GithubRepository> getRepositories() {
		return repositories;
	}

	public void setRepositories(List<GithubRepository> repositories) {
		this.repositories = repositories;
	}

}
