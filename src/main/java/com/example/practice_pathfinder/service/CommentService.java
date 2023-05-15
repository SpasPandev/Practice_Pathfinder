package com.example.practice_pathfinder.service;

import com.example.practice_pathfinder.model.view.CommentViewModel;

import java.util.List;

public interface CommentService {

    List<CommentViewModel> getComments(Long routeId);
}
