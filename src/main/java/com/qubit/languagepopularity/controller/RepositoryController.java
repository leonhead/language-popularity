package com.qubit.languagepopularity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qubit.languagepopularity.entity.Repository;
import com.qubit.languagepopularity.service.RepositoryService;

@Controller
@RequestMapping("repositories")
public class RepositoryController {

	@Autowired
	private RepositoryService repositoryService;

	@GetMapping()
	public String listRepositories(Model model) {
		List<Repository> repositories = repositoryService.findAll();
		model.addAttribute("repositories", repositories);
		return "list-repositories";
	}

}
