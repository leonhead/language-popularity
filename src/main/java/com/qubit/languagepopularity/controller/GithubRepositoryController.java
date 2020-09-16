package com.qubit.languagepopularity.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qubit.languagepopularity.entity.GithubRepo;
import com.qubit.languagepopularity.service.GithubRepositoryService;

@Controller
@RequestMapping("githubrepository")
public class GithubRepositoryController {

	@Autowired
	private GithubRepositoryService repositoryService;

	@GetMapping("/repositories")
	public String listRepositories(Model model, @RequestParam("year") Optional<Integer> year,
			@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(20);
		int searchYear = year.orElse(2020);

		Calendar calendar = Calendar.getInstance();
		calendar.set(searchYear, 0, 1, 0, 0, 0);
		Date start = calendar.getTime();
		calendar.set(searchYear, 11, 31, 23, 59, 59);
		Date end = calendar.getTime();

		Page<GithubRepo> repositories = repositoryService.findByYear(start, end,
				PageRequest.of(currentPage - 1, pageSize));
		model.addAttribute("repositories", repositories);
		model.addAttribute("pageNumbers", currentPage);
		model.addAttribute("year", searchYear);

		return "list-repositories";
	}

}
