package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.authentication.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
}
