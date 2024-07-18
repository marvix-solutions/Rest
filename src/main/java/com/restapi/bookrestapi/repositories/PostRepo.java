package com.restapi.bookrestapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.bookrestapi.model.Category;
import com.restapi.bookrestapi.model.Post;
import com.restapi.bookrestapi.model.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);
}
