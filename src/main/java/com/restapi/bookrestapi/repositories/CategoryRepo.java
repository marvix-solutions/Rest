package com.restapi.bookrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.bookrestapi.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
