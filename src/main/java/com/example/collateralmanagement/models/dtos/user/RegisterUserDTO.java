package com.example.collateralmanagement.models.dtos.user;

import com.example.collateralmanagement.models.entities.business.Department;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class RegisterUserDTO {


    @NotEmpty
    @Size(min = 2, max =20)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max =20)
    private String lastName;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 5, max =20)
    private String username;
    @NotEmpty
    @Size(min = 5)
    private String password;

    @NotEmpty
    @Size(min = 5)
    private String confirmPassword;

    private String department;

    public RegisterUserDTO() {
    }

    public RegisterUserDTO(String firstName, String lastName, String email, String username, String password, String confirmPassword, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.department = department;
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
