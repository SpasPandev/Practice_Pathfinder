package com.example.practice_pathfinder.repository;

import com.example.practice_pathfinder.model.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {

    @Query("SELECT r FROM RouteEntity r LEFT JOIN FETCH r.pictures")
    Set<RouteEntity> findAllRoutesByFetchPictures();

    @Query("SELECT r FROM RouteEntity r LEFT JOIN FETCH r.pictures WHERE r.id = ?1")
    Optional<RouteEntity> findByIdByFetchPictures(Long id);

    @Query("SELECT r FROM RouteEntity r LEFT JOIN FETCH r.comments WHERE r.id = ?1")
    Optional<RouteEntity> findByIdByFetchComments(Long id);
}
