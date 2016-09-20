package com.schibsted.testing.servicetest.domain.services.impl;


import com.schibsted.testing.servicetest.domain.model.users.User;
import com.schibsted.testing.servicetest.domain.model.users.UserAccount;
import com.schibsted.testing.servicetest.domain.repositories.IIdGenerator;
import com.schibsted.testing.servicetest.domain.repositories.IUserAccountRepository;
import com.schibsted.testing.servicetest.domain.services.IUserAccountService;
import com.schibsted.testing.servicetest.framework.repositories.QuiteComplexIdGenerator;
import com.schibsted.testing.servicetest.framework.repositories.QuiteComplexUserAccountRepository;

import java.util.Optional;
import java.util.UUID;

public class HardcoreUserAccountService implements IUserAccountService {

    private QuiteComplexIdGenerator idGenerator;
    private QuiteComplexUserAccountRepository userAccountRepository;

    public HardcoreUserAccountService(final QuiteComplexIdGenerator idGenerator,
                                      final QuiteComplexUserAccountRepository userAccountRepository) {
        this.idGenerator = idGenerator;
        this.userAccountRepository = userAccountRepository;
    }

    public UserAccount save(User user) {
        UUID id = idGenerator.generateId();
        return this.userAccountRepository.save(new UserAccount(id, user.getUsername()));
    }

    public Optional<UserAccount> find(final UUID id) {
        return this.userAccountRepository.find(id);
    }
}