package com.restapi.bookrestapi.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.bookrestapi.exceptions.ResourceNotFoundException;
import com.restapi.bookrestapi.model.Category;
import com.restapi.bookrestapi.model.Post;
import com.restapi.bookrestapi.model.User;
import com.restapi.bookrestapi.payloads.PostDto;
import com.restapi.bookrestapi.repositories.CategoryRepo;
import com.restapi.bookrestapi.repositories.PostRepo;
import com.restapi.bookrestapi.repositories.UserRepo;
import com.restapi.bookrestapi.services.PostServices;

@Service
public class PostServiceImpl implements PostServices {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("defualt.png");
        post.setUser(user);
        post.setCategory(category);
        Post newPost = this.postRepo.save(post);

        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getAllPost() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Categoryid", categoryId));
        List<Post> posts = this.postRepo.findByCategory(cat);
        return posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        List<Post> posts = this.postRepo.findByUser(user);
        return posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostDto getSinglePost(Integer postId) {

        return null;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        // TODO Auto-generated method stub
        return null;
    }

}
