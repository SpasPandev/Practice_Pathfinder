package com.example.practice_pathfinder.model.view;

import com.example.practice_pathfinder.model.entity.PicturesEntity;
import com.example.practice_pathfinder.model.entity.UserEntity;
import com.example.practice_pathfinder.model.entity.enums.LevelEnum;

import java.util.Set;

public class RouteDetailsViewModel {

    private String gpxCoordinates;
    private String description;
    private LevelEnum level;
    private String name;
    private String videoUrl;
    private UserEntity author;
    private Set<PicturesEntity> pictures;

    public RouteDetailsViewModel() {
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteDetailsViewModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteDetailsViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteDetailsViewModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteDetailsViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteDetailsViewModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public RouteDetailsViewModel setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public Set<PicturesEntity> getPictures() {
        return pictures;
    }

    public RouteDetailsViewModel setPictures(Set<PicturesEntity> pictures) {
        this.pictures = pictures;
        return this;
    }
}
