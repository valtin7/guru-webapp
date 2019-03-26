package com.loveval.guru.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.loveval.guru.model.Author;
import com.loveval.guru.model.Book;
import com.loveval.guru.model.Publisher;
import com.loveval.guru.repository.AuthorRepository;
import com.loveval.guru.repository.BookRepository;
import com.loveval.guru.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	@Autowired
	public DevBootstrap(AuthorRepository authorRepository,
						BookRepository bookRepository,
						PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	private void initData() {
		
		// Eric
		Author eric = new Author("Eric", "Evans");
		Publisher hc = new Publisher("Harper Collins", "東京都千代田区外神田3-16-8　秋葉原三和東洋ビル");
		Book ddd = new Book("Domain Driven Design", "1234", hc);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		this.publisherRepository.save(hc);
		this.authorRepository.save(eric);
		this.bookRepository.save(ddd);
		
		//
		Author rod = new Author("Rod", "Johnson");
		Publisher wx = new Publisher("Worx", "1899 BROCK ROAD ON Canada");
		Book noEJB = new Book("J2EE Development without EJB", "23444", wx);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		this.publisherRepository.save(wx);
		this.authorRepository.save(rod);
		this.bookRepository.save(noEJB);
		
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		this.initData();
		
	}

}
