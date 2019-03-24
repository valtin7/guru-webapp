package com.loveval.guru.repository;

import org.springframework.data.repository.CrudRepository;

import com.loveval.guru.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
