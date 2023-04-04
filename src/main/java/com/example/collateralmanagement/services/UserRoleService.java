package com.example.collateralmanagement.services;

import jakarta.annotation.PostConstruct;

public interface UserRoleService {
    void seedUserRoles();

    boolean isEmpty();

    @PostConstruct
    void init();
}
