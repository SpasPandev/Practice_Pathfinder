package com.example.practice_pathfinder.model.entity;

import com.example.practice_pathfinder.model.entity.enums.LevelEnum;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "routes")
public class RouteEntity extends BaseEntity {

    @Column(columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Enumerated(EnumType.STRING)
    private LevelEnum level;
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToOne
    private UserEntity author;
    @Column
    private String videoUrl;
    @ManyToMany
    private Set<CategoriesEntity> categories;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    @OneToMany(mappedBy = "route")
    private List<PicturesEntity> pictures;
    @OneToMany(mappedBy = "route")
    private List<CommentsEntity> comments;

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<CategoriesEntity> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoriesEntity> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PicturesEntity> getPictures() {
        return pictures;
    }

    public RouteEntity setPictures(List<PicturesEntity> pictures) {
        this.pictures = pictures;
        return this;
    }

    public List<CommentsEntity> getComments() {
        return comments;
    }

    public RouteEntity setComments(List<CommentsEntity> comments) {
        this.comments = comments;
        return this;
    }

    public RouteEntity() {
    }
}
