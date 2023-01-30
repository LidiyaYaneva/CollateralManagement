package com.example.collateralmanagement.utils.user;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private String fullName;

    private boolean isLoggedIn;

    public CurrentUser() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void clear () {
        this.isLoggedIn = false;
        this.fullName = null;
    }
}
