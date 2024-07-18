package com.restapi.bookrestapi.services;

import java.util.List;

import com.restapi.bookrestapi.payloads.PostDto;

public interface PostServices {

    // Create post
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // Update Post
    PostDto updatePost(PostDto postDto, Integer postId);

    // Delete Post
    void deletePost(Integer postId);

    // getAllPost
    List<PostDto> getAllPost();

    // getSinglePost
    PostDto getSinglePost(Integer postId);

    // Get All Post By Category
    List<PostDto> getPostByCategory(Integer categoryId);

    // get all post by User

    List<PostDto> getPostByUser(Integer userId);

}
