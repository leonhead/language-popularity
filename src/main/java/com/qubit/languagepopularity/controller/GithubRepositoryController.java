package com.qubit.languagepopularity.controller;

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
@RequestMapping("repositories")
public class GithubRepositoryController {

	@Autowired
	private GithubRepositoryService repositoryService;

	@GetMapping()
	public String listRepositories(Model model,  @RequestParam("year") Optional<Integer> year, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(20);
		int searchYear = year.orElse(2040);
		
		Page<GithubRepo> repositories = repositoryService.findPaginated(searchYear, PageRequest.of(currentPage - 1, pageSize));
		model.addAttribute("repositories", repositories);
		model.addAttribute("pageNumbers", currentPage);
		return "list-repositories";
	}
	
}
