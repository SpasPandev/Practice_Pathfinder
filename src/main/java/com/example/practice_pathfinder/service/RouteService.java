package com.example.practice_pathfinder.service;

import com.example.practice_pathfinder.model.service.RouteServiceModel;
import com.example.practice_pathfinder.model.view.RouteDetailsViewModel;
import com.example.practice_pathfinder.model.view.RouteViewModel;

import java.util.List;

public interface RouteService {

    List<RouteViewModel> findAllRoutesViews();

    RouteDetailsViewModel findById(Long id);

    void addNewRoute(RouteServiceModel routeServiceModel, Long ownerId);
}
