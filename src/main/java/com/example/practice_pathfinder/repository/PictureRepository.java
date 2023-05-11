package com.example.practice_pathfinder.repository;

import com.example.practice_pathfinder.model.entity.PicturesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<PicturesEntity, Long> {

    @Query("SELECT p.url FROM PicturesEntity AS p")
    List<String> findAllUrls();
}
