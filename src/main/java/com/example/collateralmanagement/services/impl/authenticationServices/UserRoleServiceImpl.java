package com.example.collateralmanagement.services.impl.authenticationServices;

import com.example.collateralmanagement.models.entities.authentication.UserRoleEntity;
import com.example.collateralmanagement.models.enums.UserRole;
import com.example.collateralmanagement.repositories.UserRoleRepository;
import com.example.collateralmanagement.services.UserRoleService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void seedUserRoles() {

        UserRole[] rolesEnums = UserRole.values();
        List<UserRoleEntity> roles = new ArrayList<>();
        for (UserRole roleEnum: rolesEnums) {
            UserRoleEntity role = new UserRoleEntity(roleEnum);
            roles.add(role);
        }
        this.userRoleRepository.saveAll(roles);

    }

    @Override
    public boolean isEmpty() {
        return this.userRoleRepository.count()==0;
    }

    @Override
    @PostConstruct
    public void init () {
        if (isEmpty()) seedUserRoles();
    }
}
