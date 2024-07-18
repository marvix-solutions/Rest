package com.restapi.bookrestapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.bookrestapi.payloads.ApiResponse;
import com.restapi.bookrestapi.payloads.CategoryDto;
import com.restapi.bookrestapi.services.CategoryServices;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable("id") Integer id) {
        CategoryDto category = this.categoryServices.getSingleCategory(id);
        return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategory() {
        List<CategoryDto> categories = this.categoryServices.getAllCategory();
        return new ResponseEntity<List<CategoryDto>>(categories, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto category = this.categoryServices.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(category, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
            @PathVariable("id") Integer id) {
        CategoryDto category = this.categoryServices.updateCategory(categoryDto, id);
        return new ResponseEntity<CategoryDto>(category, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("id") Integer id) {
        this.categoryServices.deleteCategory(id);
        return new ResponseEntity(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
    }

}
