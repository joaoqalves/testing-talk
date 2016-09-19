package com.schibsted.testing.domain.model.users;

import java.util.UUID;

public class UserAccount {
    private UUID id;
    private String username;

    public UserAccount(UUID id, String username) {
        this.id = id;
        this.username = username;
    }

    public UUID getId() {
        return this.id;
    }

    public String getUsername() {
        return username;
    }
}
