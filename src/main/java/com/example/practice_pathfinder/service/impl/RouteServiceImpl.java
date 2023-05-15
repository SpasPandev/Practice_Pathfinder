package com.example.practice_pathfinder.service.impl;

import com.example.practice_pathfinder.model.entity.RouteEntity;
import com.example.practice_pathfinder.model.service.RouteServiceModel;
import com.example.practice_pathfinder.model.view.RouteDetailsViewModel;
import com.example.practice_pathfinder.model.view.RouteViewModel;
import com.example.practice_pathfinder.repository.RouteRepository;
import com.example.practice_pathfinder.repository.UserRepository;
import com.example.practice_pathfinder.service.CategoryService;
import com.example.practice_pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final UserRepository userRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, UserRepository userRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Transactional
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

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel, Long ownerId) {

        RouteEntity newRoute = modelMapper.map(routeServiceModel, RouteEntity.class);

        newRoute.setAuthor(userRepository.findById(ownerId).orElseThrow());

        newRoute.setCategories(routeServiceModel
                .getCategories()
                .stream()
                .map(categoryService::findCategoryByName)
                .collect(Collectors.toSet()));

        routeRepository.save(newRoute);
    }
}
