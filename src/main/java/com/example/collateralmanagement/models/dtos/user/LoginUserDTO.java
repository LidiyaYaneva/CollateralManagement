package com.example.collateralmanagement.models.dtos.user;

import jakarta.validation.constraints.NotEmpty;

public class LoginUserDTO {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    public LoginUserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
