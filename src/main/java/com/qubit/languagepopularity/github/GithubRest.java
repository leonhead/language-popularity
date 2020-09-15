package com.qubit.languagepopularity.github;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qubit.languagepopularity.ProgramLanguagePopularityApplication;
import com.qubit.languagepopularity.entity.GithubRepo;
import com.qubit.languagepopularity.entity.ProgramLanguage;
import com.qubit.languagepopularity.service.GithubRepositoryService;
import com.qubit.languagepopularity.service.ProgramLanguageService;

@SpringBootApplication
public class GithubRest {

	public static void main(String[] args)
			throws IOException, InterruptedException, URISyntaxException, ParseException {
		ConfigurableApplicationContext context = SpringApplication.run(ProgramLanguagePopularityApplication.class,
				args);

		ProgramLanguageService programLanguageService = context.getBean(ProgramLanguageService.class);
		GithubRepositoryService githubRepositoryService = context.getBean(GithubRepositoryService.class);

		GithubRest githubRest = new GithubRest();
		HttpResponse<String> response = githubRest.getRepositoriesByStars("2019-01-01");
		String content = response.body();
		ObjectMapper objectMapper = new ObjectMapper();
		GithubResponse githubResponse = objectMapper.readValue(content, GithubResponse.class);

		for (GithubRepository repository : githubResponse.getRepositories()) {
			String languageString = repository.getLanguage();
			if (languageString != null && !languageString.isEmpty()) {
				ProgramLanguage programLanguage = new ProgramLanguage(languageString);
				programLanguageService.save(programLanguage);
			}
			Optional<ProgramLanguage> language = programLanguageService.findByName(repository.getLanguage());
			if (language.isPresent()) {
				Timestamp created = new Timestamp(formatCreatedString(repository.getCreated()));
				GithubRepo repo = new GithubRepo(repository.getGithubId(), created, repository.getFullName(),
						repository.getHtmlUrl(), repository.getStargazersCount(), language.get());
				githubRepositoryService.save(repo);
			}
		}
	}

	private HttpResponse<String> getRepositoriesByStars(String createdDate)
			throws IOException, InterruptedException, URISyntaxException {
		String query = "https://api.github.com/search/repositories?q=created:>=" + URLEncoder.encode(createdDate, "UTF-8")
				+ "&page=1&per_page=100&sort=stars&order=desc";

		HttpRequest request = HttpRequest.newBuilder().uri(new URI(query)).GET().build();
		HttpResponse<String> response = HttpClient.newBuilder().build().send(request, BodyHandlers.ofString());
		return response;
	}

	private static long formatCreatedString(String created) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
		Date date = (Date) formatter.parse(created);
		return date.getTime();
	}

}
