package com.restapi.bookrestapi.controllers;

import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.restapi.bookrestapi.payloads.PostDto;
import com.restapi.bookrestapi.services.PostServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostServices postServices;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
            @PathVariable Integer categoryId) {
        PostDto createPost = this.postServices.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }

    // Get Post by UserId
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {
        List<PostDto> posts = this.postServices.getPostByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

    // Get Post By Category Id
    @GetMapping("/category/{categoryId}/post")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId) {
        List<PostDto> post = this.postServices.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(post, HttpStatus.OK);
    }
}
