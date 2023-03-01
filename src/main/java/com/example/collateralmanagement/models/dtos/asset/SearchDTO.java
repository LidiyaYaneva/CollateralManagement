package com.example.collateralmanagement.models.dtos.asset;

import com.example.collateralmanagement.models.enums.DepartmentEnum;

public class SearchDTO {

    String owner;

    String keyword;

    DepartmentEnum departmentEnum;

    public SearchDTO() {
    }

    public String getOwner() {
        return owner;
    }

    public SearchDTO setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public SearchDTO setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public DepartmentEnum getDepartmentEnum() {
        return departmentEnum;
    }

    public SearchDTO setDepartmentEnum(DepartmentEnum departmentEnum) {
        this.departmentEnum = departmentEnum;
        return this;
    }
}
