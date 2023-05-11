package com.example.practice_pathfinder.service.impl;

import com.example.practice_pathfinder.model.view.RouteDetailsViewModel;
import com.example.practice_pathfinder.model.view.RouteViewModel;
import com.example.practice_pathfinder.repository.RouteRepository;
import com.example.practice_pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RouteViewModel> findAllRoutesViews() {

        return routeRepository
                .findAllRoutesByFetchPictures()
                .stream()
                .map(route -> {
                            RouteViewModel routeViewModel =
                                    modelMapper.map(route, RouteViewModel.class);

                            if (route.getPictures().isEmpty()) {
                                routeViewModel.setPictureUrl("/images/pic4.jpg");
                            } else {
                                routeViewModel.setPictureUrl(route.getPictures().stream().findFirst().get().getUrl());
                            }

                            return routeViewModel;
                        }
                )
                .collect(Collectors.toList());
    }

    @Override
    public RouteDetailsViewModel findById(Long id) {

        return routeRepository
                .findByIdByFetchPictures(id)
                .map(route -> modelMapper.map(route, RouteDetailsViewModel.class))
                .get();
    }
}
