package com.example.demo.service.impl;

import com.example.demo.dto.CategoryDto;
import com.example.demo.entity.Category;
import com.example.demo.repo.CategoryRepo;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category entity = Category.builder()
                .id(categoryDto.getId())
                .categoryName(categoryDto.getCategoryName())
                .description(categoryDto.getDescription())
                .build();
        entity = categoryRepo.save(entity);
        return CategoryDto.builder()
                .id(entity.getId())
                .categoryName(entity.getCategoryName())
                .description(entity.getDescription())
                .build();
    }

    @Override
    public List<CategoryDto> findAll() {
        return null;
    }

    @Override
    public CategoryDto findById(Integer id) {
         CategoryDto categoryDto = new CategoryDto();
         Category category = categoryRepo.findById(id).get();

         categoryDto.setId(category.getId());
         categoryDto.setCategoryName(category.getCategoryName());
        return categoryDto;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
