package com.example.collateralmanagement.domain.entities.business;

import com.example.collateralmanagement.domain.entities.enums.DepartmentEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DepartmentEnum name;

    public Department() {}

    public Department(DepartmentEnum name){
        this.name = name;
    }

    public DepartmentEnum getName() {
        return name;
    }

    public void setName(DepartmentEnum name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
