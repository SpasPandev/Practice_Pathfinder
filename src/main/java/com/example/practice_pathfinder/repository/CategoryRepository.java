package com.example.practice_pathfinder.repository;

import com.example.practice_pathfinder.model.entity.CategoriesEntity;
import com.example.practice_pathfinder.model.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoriesEntity, Long> {

    Optional<CategoriesEntity> findByName(CategoryEnum categoryEnum);
}
