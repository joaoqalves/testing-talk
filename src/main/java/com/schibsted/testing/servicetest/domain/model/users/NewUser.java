package com.schibsted.testing.servicetest.domain.model.users;

public class NewUser {
    private String username;

    public NewUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}
