package com.example.practice_pathfinder.service.impl;

import com.example.practice_pathfinder.model.entity.CategoriesEntity;
import com.example.practice_pathfinder.model.entity.enums.CategoryEnum;
import com.example.practice_pathfinder.repository.CategoryRepository;
import com.example.practice_pathfinder.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoriesEntity findCategoryByName(CategoryEnum categoryEnum) {

        return categoryRepository.findByName(categoryEnum).orElse(null);
    }
}
