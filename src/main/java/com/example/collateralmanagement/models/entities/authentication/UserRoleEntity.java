package com.example.collateralmanagement.models.entities.authentication;

import com.example.collateralmanagement.models.enums.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public UserRoleEntity(){}

    public UserRoleEntity(UserRole roleEnum) {
        this.role= roleEnum;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
