package com.qubit.languagepopularity.github;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class GithubRest {

	private static HttpResponse<String> getRepositoriesByStars(String createdDate)
			throws IOException, InterruptedException, URISyntaxException {
		String query = "https://api.github.com/search/repositories?q=created:"
				+ URLEncoder.encode(createdDate, "UTF-8") + "&page=1&per_page=100&sort=stars&order=desc";

		HttpRequest request = HttpRequest.newBuilder().uri(new URI(query)).GET().build();

		HttpResponse<String> response = HttpClient.newBuilder().build().send(request, BodyHandlers.ofString());
		return response;

	}

	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
		HttpResponse<String> response = GithubRest.getRepositoriesByStars("2019-01-01");
		String content = response.body();
		System.out.println(content);
	}

}
