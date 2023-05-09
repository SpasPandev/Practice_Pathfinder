package com.example.practice_pathfinder.service.impl;

import com.example.practice_pathfinder.model.entity.UserEntity;
import com.example.practice_pathfinder.model.entity.enums.LevelEnum;
import com.example.practice_pathfinder.model.service.UserServiceModel;
import com.example.practice_pathfinder.repository.UserRepository;
import com.example.practice_pathfinder.service.UserService;
import com.example.practice_pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        UserEntity userEntity = modelMapper.map(userServiceModel, UserEntity.class);

        userEntity.setLevel(LevelEnum.BEGINNER);

        userRepository.save(userEntity);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {

        currentUser.setUsername(username);
        currentUser.setId(id);
    }

    @Override
    public void logout() {

        currentUser.setId(null);
        currentUser.setUsername(null);
    }

}
