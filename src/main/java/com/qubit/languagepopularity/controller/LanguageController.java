package com.qubit.languagepopularity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qubit.languagepopularity.entity.Language;
import com.qubit.languagepopularity.service.LanguageService;

@Controller
@RequestMapping("languages")
public class LanguageController {
	
	@Autowired
	private LanguageService languageService;
	
	@GetMapping()
	public String listLanguages(Model model) {
		List<Language> languages = languageService.findAll();
		model.addAttribute("languages", languages);
		
		return "list-languages";
	}

}
