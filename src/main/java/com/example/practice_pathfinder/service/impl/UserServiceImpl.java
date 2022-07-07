package com.example.practice_pathfinder.service.impl;

import com.example.practice_pathfinder.model.entity.UserEntity;
import com.example.practice_pathfinder.model.entity.enums.LevelEnum;
import com.example.practice_pathfinder.model.service.UserServiceModel;
import com.example.practice_pathfinder.repository.UserRepository;
import com.example.practice_pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel)
    {
        UserEntity userEntity = modelMapper.map(userServiceModel, UserEntity.class);

        userEntity.setLevel(LevelEnum.BEGINNER);

        userRepository.save(userEntity);
    }

}
