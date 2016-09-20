package com.schibsted.testing.servicetest.framework.repositories;

import com.schibsted.testing.servicetest.domain.repositories.IIdGenerator;

import java.util.UUID;

public class UUIDGenerator implements IIdGenerator<UUID> {

    public UUIDGenerator() {
    }

    public UUID generateId() {
        return UUID.randomUUID();
    }
}
