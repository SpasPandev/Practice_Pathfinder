package com.example.practice_pathfinder.model.entity;

import com.example.practice_pathfinder.model.entity.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoriesEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CategoryEnum name;
    @Lob
    private String description;

    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoriesEntity() {
    }
}
