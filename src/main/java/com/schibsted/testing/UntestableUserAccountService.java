package com.schibsted.testing;

import com.schibsted.testing.servicetest.domain.model.users.UserAccount;
import com.schibsted.testing.servicetest.framework.repositories.InMemoryUserAccountRepository;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.UUID;

public class UntestableUserAccountService {

  @Resource
  private InMemoryUserAccountRepository inMemoryUserAccountRepository;

  public Optional<UserAccount> searchById(UUID uuid) {
    return inMemoryUserAccountRepository.find(uuid);
  }
}
