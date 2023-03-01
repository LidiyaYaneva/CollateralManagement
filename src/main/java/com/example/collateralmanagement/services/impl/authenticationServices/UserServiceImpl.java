package com.example.collateralmanagement.services.impl.authenticationServices;

import com.example.collateralmanagement.models.dtos.user.LoginUserDTO;
import com.example.collateralmanagement.models.dtos.user.RegisterUserDTO;
import com.example.collateralmanagement.models.entities.business.Department;
import com.example.collateralmanagement.models.enums.DepartmentEnum;
import com.example.collateralmanagement.models.entities.authentication.UserEntity;
import com.example.collateralmanagement.repositories.DepartmentRepository;
import com.example.collateralmanagement.repositories.UserRepository;
import com.example.collateralmanagement.services.UserService;
import com.example.collateralmanagement.utils.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private CurrentUser currentUser;

    private  final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, DepartmentRepository departmentRepository, CurrentUser currentUser, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(RegisterUserDTO registerUserDTO) {

        String email= registerUserDTO.getEmail();

        Optional<UserEntity> optUser =this.userRepository.findByEmail(email);

        if (optUser.isPresent()){
            LOGGER.info("User with email [{}] already exists", email);
        }
        else {

            Optional<Department> optDepartment = this.departmentRepository
                    .findByName(DepartmentEnum.valueOf(registerUserDTO.getDepartment()));

            if (optDepartment.isEmpty()) {
                LOGGER.info("Department [{}] not found", registerUserDTO.getDepartment());
            } else {
                UserEntity userEntity = this.modelMapper.map(registerUserDTO, UserEntity.class);
                userEntity.setDepartment(optDepartment.get());
                userEntity.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
                this.userRepository.save(userEntity);
            }
        }

    }

    @Override
    public boolean login(LoginUserDTO loginUserDTO) {

        Optional<UserEntity> optUser = this.userRepository
                .findByUsername(loginUserDTO.getUsername());

        if (optUser.isEmpty()) {
            LOGGER.info("User [{}] not found", loginUserDTO.getUsername());
            return false;
        }
        // TODO use validation and change this login method after Spring Security Lecture
        String encodedPassword = optUser.get().getPassword();
        String rawPassword = loginUserDTO.getPassword();
        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            login(optUser.get());
        }
        else {
            logout();
        }

        return success;

    }

    @Override
    public void logout() {
        this.currentUser.clear();
    }

    @Override
    public boolean deleteUser(String username) {
        Optional<UserEntity> userEntityOpt = this.userRepository.findByUsername(username);
        if (userEntityOpt.isEmpty()){
            LOGGER.info("User [{}]not found", username);
            return false;
        }
        else {
            this.userRepository.delete(userEntityOpt.get());
            return true;
        }
    }

    private void login (UserEntity userEntity){
        currentUser.setLoggedIn(true);
        currentUser.setFullName(userEntity.getFirstName()+ " " + userEntity.getLastName());

    }
}
