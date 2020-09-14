package com.qubit.languagepopularity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("visualize")
public class VisualizeController {

	@GetMapping()
	public String visualize(Model model) {
		
		return "visualize.html";
	}
}
