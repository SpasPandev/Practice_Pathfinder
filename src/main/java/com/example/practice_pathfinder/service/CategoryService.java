package com.example.practice_pathfinder.service;

import com.example.practice_pathfinder.model.entity.CategoriesEntity;
import com.example.practice_pathfinder.model.entity.enums.CategoryEnum;

public interface CategoryService {

    CategoriesEntity findCategoryByName(CategoryEnum categoryEnum);
}
