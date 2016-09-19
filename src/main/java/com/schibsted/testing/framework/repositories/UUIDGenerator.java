package com.schibsted.testing.framework.repositories;

import com.schibsted.testing.domain.repositories.IIdGenerator;

import java.util.UUID;

public class UUIDGenerator implements IIdGenerator<UUID> {

    public UUID generateId() {
        return UUID.randomUUID();
    }
}
