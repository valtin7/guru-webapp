package com.loveval.guru.repository;

import org.springframework.data.repository.CrudRepository;

import com.loveval.guru.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
