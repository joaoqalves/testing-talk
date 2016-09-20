package com.schibsted.testing.servicetest.framework.repositories;

import com.schibsted.testing.servicetest.domain.repositories.IdGenerator;

import java.util.UUID;

public class UUIDGenerator implements IdGenerator<UUID> {

    public UUIDGenerator() {
    }

    public UUID generateId() {
        return UUID.randomUUID();
    }
}
