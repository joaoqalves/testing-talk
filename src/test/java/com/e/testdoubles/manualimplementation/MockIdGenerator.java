package com.e.testdoubles.manualimplementation;

import com.schibsted.testing.servicetest.domain.repositories.IdGenerator;

import java.util.UUID;

public class MockIdGenerator implements IdGenerator<UUID> {

    public UUID generateId() {
        String uuid = "ceb76be0-dc4d-40b7-8de1-0c22a8b4e464";
        return UUID.fromString(uuid);
    }
}
