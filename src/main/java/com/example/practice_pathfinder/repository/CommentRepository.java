package com.example.practice_pathfinder.repository;

import com.example.practice_pathfinder.model.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentsEntity, Long> {

}
