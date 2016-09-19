package com.schibsted.testing.framework.repositories;

import com.schibsted.testing.domain.model.users.UserAccount;
import com.schibsted.testing.domain.repositories.IUserAccountRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserAccountRepository implements IUserAccountRepository {

    private ConcurrentHashMap<UUID, UserAccount> database;

    public InMemoryUserAccountRepository() {
        this.database = new ConcurrentHashMap<>();
    }

    public UserAccount save(final UserAccount entity) {
        this.database.put(entity.getId(), entity);
        return entity;
    }

    public Optional<UserAccount> find(final UUID id) {
        return Optional.ofNullable(database.get(id));
    }
}
