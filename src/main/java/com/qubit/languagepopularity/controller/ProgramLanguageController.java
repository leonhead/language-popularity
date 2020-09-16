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

import com.qubit.languagepopularity.entity.ProgramLanguage;
import com.qubit.languagepopularity.service.ProgramLanguageService;

@Controller
@RequestMapping("programlanguage")
public class ProgramLanguageController {

	@Autowired
	private ProgramLanguageService programLanguageService;

	@GetMapping("/languages")
	public String listLanguages(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(20);

		Page<ProgramLanguage> languages = programLanguageService.findAll(PageRequest.of(currentPage - 1, pageSize));

		model.addAttribute("languages", languages);
		model.addAttribute("pageNumbers", currentPage);
		model.addAttribute("programLanguageService", programLanguageService);

		return "list-languages";
	}

}
