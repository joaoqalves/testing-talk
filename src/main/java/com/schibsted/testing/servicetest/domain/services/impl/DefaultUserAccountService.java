package com.schibsted.testing.servicetest.domain.services.impl;


import com.schibsted.testing.servicetest.domain.model.users.User;
import com.schibsted.testing.servicetest.domain.model.users.UserAccount;
import com.schibsted.testing.servicetest.domain.repositories.UserAccountRepository;
import com.schibsted.testing.servicetest.domain.repositories.IdGenerator;

import java.util.Optional;
import java.util.UUID;

public class DefaultUserAccountService implements com.schibsted.testing.servicetest.domain.services.UserAccountService {

    private IdGenerator<UUID> idGenerator;
    private UserAccountRepository userAccountRepository;

    public DefaultUserAccountService(final IdGenerator<UUID> idGenerator,
                                     final UserAccountRepository userAccountRepository) {
        this.idGenerator = idGenerator;
        this.userAccountRepository = userAccountRepository;
    }

    public UserAccount save(User user) {
        UUID id = idGenerator.generateId();
        return userAccountRepository.save(new UserAccount(id, user.getUsername()));
    }

    public Optional<UserAccount> search(final UUID id) {
        return userAccountRepository.find(id);
    }
}
