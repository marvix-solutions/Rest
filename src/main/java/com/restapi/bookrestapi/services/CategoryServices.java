package com.restapi.bookrestapi.services;

import java.util.List;

import com.restapi.bookrestapi.payloads.CategoryDto;

public interface CategoryServices {
    public CategoryDto createCategory(CategoryDto categoryDto);

    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    public void deleteCategory(Integer categoryId);

    public CategoryDto getSingleCategory(Integer categoryId);

    public List<CategoryDto> getAllCategory();
}
