package com.example.collateralmanagement.repositories;

import com.example.collateralmanagement.models.entities.authentication.UserEntity;
import com.example.collateralmanagement.models.enums.DepartmentEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByUsername(String username);

    List<UserEntity> findAllByDepartmentName(DepartmentEnum departmentEnum);

}
