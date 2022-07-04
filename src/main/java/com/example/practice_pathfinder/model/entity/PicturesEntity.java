package com.example.practice_pathfinder.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class PicturesEntity extends BaseEntity{

    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String url;
    @ManyToOne
    private UserEntity author;
    @ManyToOne
    private RouteEntity route;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }

    public PicturesEntity() {
    }
}
