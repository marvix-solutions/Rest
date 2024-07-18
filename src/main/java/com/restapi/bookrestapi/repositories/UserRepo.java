package com.restapi.bookrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.bookrestapi.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
