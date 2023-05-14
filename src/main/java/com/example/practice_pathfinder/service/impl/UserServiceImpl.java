package com.example.practice_pathfinder.service.impl;

import com.example.practice_pathfinder.model.entity.UserEntity;
import com.example.practice_pathfinder.model.entity.enums.LevelEnum;
import com.example.practice_pathfinder.model.service.UserServiceModel;
import com.example.practice_pathfinder.repository.UserRepository;
import com.example.practice_pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        UserEntity userEntity = modelMapper.map(userServiceModel, UserEntity.class);

        userEntity.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));

        userEntity.setLevel(LevelEnum.BEGINNER);

        userRepository.save(userEntity);
    }

    @Override
    public UserServiceModel findByUsername(String username) {

        return userRepository
                .findByUsername(username)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

}
