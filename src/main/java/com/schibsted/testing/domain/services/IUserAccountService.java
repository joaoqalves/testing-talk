package com.schibsted.testing.domain.services;

import com.schibsted.testing.domain.model.users.NewUser;
import com.schibsted.testing.domain.model.users.UserAccount;

import java.util.Optional;
import java.util.UUID;

public interface IUserAccountService {
    UserAccount save(final NewUser newUser);
    Optional<UserAccount> find(final UUID id);
}
