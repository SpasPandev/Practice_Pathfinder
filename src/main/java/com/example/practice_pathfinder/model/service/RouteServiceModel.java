package com.example.practice_pathfinder.model.service;

import com.example.practice_pathfinder.model.entity.PicturesEntity;
import com.example.practice_pathfinder.model.entity.enums.CategoryEnum;
import com.example.practice_pathfinder.model.entity.enums.LevelEnum;
import org.apache.catalina.User;

import java.util.Set;

public class RouteServiceModel {

    private Long id;
    private String name;
    private String description;
    private String gpxCoordinates;
    private LevelEnum level;
    private String videoUrl;
    private Set<CategoryEnum> categories;
    private User author;
    private Set<PicturesEntity> pictures;

    public RouteServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public RouteServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteServiceModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteServiceModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<CategoryEnum> getCategories() {
        return categories;
    }

    public RouteServiceModel setCategories(Set<CategoryEnum> categories) {
        this.categories = categories;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public RouteServiceModel setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Set<PicturesEntity> getPictures() {
        return pictures;
    }

    public RouteServiceModel setPictures(Set<PicturesEntity> pictures) {
        this.pictures = pictures;
        return this;
    }
}
