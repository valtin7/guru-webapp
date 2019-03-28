package com.loveval.guru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.loveval.guru.repository.AuthorRepository;

@Controller
public class AuthorController {

	private AuthorRepository authorRepository;
	
	@Autowired
	public AuthorController(AuthorRepository authorRepository) {
		
		this.authorRepository = authorRepository;
		
	}
	
	@GetMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors", this.authorRepository.findAll());
		return "authors";
		
	}
}
