package com.example.practice_pathfinder.service;

import com.example.practice_pathfinder.model.service.UserServiceModel;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);
}
