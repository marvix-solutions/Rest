package com.restapi.bookrestapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.restapi.bookrestapi.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findById(int id);
}
