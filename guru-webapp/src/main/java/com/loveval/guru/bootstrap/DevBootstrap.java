package com.loveval.guru.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.loveval.guru.model.Author;
import com.loveval.guru.model.Book;
import com.loveval.guru.repository.AuthorRepository;
import com.loveval.guru.repository.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	@Autowired
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}
	
	private void initData() {
		
		// Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		this.authorRepository.save(eric);
		this.bookRepository.save(ddd);
		
		//
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "23444", "Worx");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		this.authorRepository.save(rod);
		this.bookRepository.save(noEJB);
		
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		this.initData();
		
	}

}
