package com.loveval.guru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.loveval.guru.repository.BookRepository;

@Controller
public class BookController {
	
	private BookRepository bookRepository;
	
	@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@GetMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", this.bookRepository.findAll());
		return "books";
		
	}

}
