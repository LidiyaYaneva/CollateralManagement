package com.example.collateralmanagement.services;

import com.example.collateralmanagement.models.dtos.user.LoginUserDTO;
import com.example.collateralmanagement.models.dtos.user.RegisterUserDTO;

public interface UserService {

    void registerUser (RegisterUserDTO registerUserDTO);

    boolean login (LoginUserDTO loginUserDTO);

    void logout();

    boolean deleteUser(String username);
}
