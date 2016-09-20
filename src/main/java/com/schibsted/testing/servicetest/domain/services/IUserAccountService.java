package com.schibsted.testing.servicetest.domain.services;

import com.schibsted.testing.servicetest.domain.model.users.User;
import com.schibsted.testing.servicetest.domain.model.users.UserAccount;

import java.util.Optional;
import java.util.UUID;

public interface IUserAccountService {
    UserAccount save(final User user);
    Optional<UserAccount> find(final UUID id);
}
