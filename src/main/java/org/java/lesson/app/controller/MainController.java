package org.java.lesson.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home(Model model) {
		
		String myName = "Raffaele";
		model.addAttribute("myName", myName);
		
		return "home";
	}
	
}
