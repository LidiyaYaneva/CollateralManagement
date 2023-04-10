package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.authentication.UserRoleEntity;
import com.example.collateralmanagement.models.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    Optional<UserRoleEntity> findByRole(UserRole role);
}
