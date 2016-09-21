package com.schibsted.testing.servicetest.domain.services.impl;


import com.schibsted.testing.StaticClassWithComplexOperations;
import com.schibsted.testing.servicetest.domain.model.users.User;
import com.schibsted.testing.servicetest.domain.model.users.UserAccount;
import com.schibsted.testing.servicetest.domain.services.UserAccountService;
import com.schibsted.testing.servicetest.framework.repositories.InMemoryUserAccountRepository;
import com.schibsted.testing.servicetest.framework.repositories.QuiteComplexIdGenerator;
import com.schibsted.testing.servicetest.framework.repositories.QuiteComplexUserAccountRepository;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.UUID;

public class HardcoreUserAccountService implements UserAccountService {

  private QuiteComplexIdGenerator idGenerator;
  private QuiteComplexUserAccountRepository userAccountRepository;

  private int type;


  public HardcoreUserAccountService(final QuiteComplexIdGenerator idGenerator,
                                    final QuiteComplexUserAccountRepository userAccountRepository, final String anotherParameters) {
    this.idGenerator = idGenerator;
    this.userAccountRepository = userAccountRepository;
    if ("NotAllowedUser".equals(StaticClassWithComplexOperations.getUser().getUsername())) {
      type = 2;
    }
  }

  public UserAccount save(User user) {
    UUID id = idGenerator.generateId();

    if(type != 2){
      return this.userAccountRepository.save(new UserAccount(id, user.getUsername()));
    }else {
      return null;
    }
  }

  public Optional<UserAccount> search(final UUID id) {
    return this.userAccountRepository.find(id);
  }
}
