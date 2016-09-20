package com.schibsted.testing.servicetest.domain.repositories;

import com.schibsted.testing.servicetest.domain.model.users.UserAccount;

import java.util.UUID;

public interface IUserAccountRepository extends IRepository<UUID, UserAccount> {
}