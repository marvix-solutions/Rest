package com.restapi.bookrestapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.bookrestapi.exceptions.ResourceNotFoundException;
import com.restapi.bookrestapi.model.Category;
import com.restapi.bookrestapi.payloads.CategoryDto;
import com.restapi.bookrestapi.repositories.CategoryRepo;
import com.restapi.bookrestapi.services.CategoryServices;

@Service
public class CategoryServiceImpl implements CategoryServices {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        this.categoryRepo.delete(cat);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> categoriesDto = categories.stream()
                .map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
                .collect((Collectors.toList()));
        return categoriesDto;
    }

    @Override
    public CategoryDto getSingleCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        return this.modelMapper.map(cat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescripition(categoryDto.getCategoryDescripition());

        Category updatedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(updatedCat, CategoryDto.class);

    }

    // public Category dtoToCategory(CategoryDto categoryDto){

    // }
    // public CategoryDto

}
