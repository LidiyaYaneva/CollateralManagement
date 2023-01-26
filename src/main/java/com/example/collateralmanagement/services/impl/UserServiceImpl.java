package com.example.collateralmanagement.services.impl;

import com.example.collateralmanagement.models.dtos.RegisterUserDTO;
import com.example.collateralmanagement.repositories.UserRepository;
import com.example.collateralmanagement.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(RegisterUserDTO registerUserDTO) {

    }
}
