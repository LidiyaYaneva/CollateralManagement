package com.example.collateralmanagement.models.dtos.user;

import jakarta.validation.constraints.NotBlank;

public class LoginUserDTO {

    @NotBlank
    private String username;
    @NotBlank
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
