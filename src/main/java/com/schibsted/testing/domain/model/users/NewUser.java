package com.schibsted.testing.domain.model.users;

public class NewUser {
    private String username;

    public NewUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}
