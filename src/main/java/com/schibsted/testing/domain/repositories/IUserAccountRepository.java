package com.schibsted.testing.domain.repositories;

import com.schibsted.testing.domain.model.users.UserAccount;

import java.util.UUID;

public interface IUserAccountRepository extends IRepository<UUID, UserAccount> {
}