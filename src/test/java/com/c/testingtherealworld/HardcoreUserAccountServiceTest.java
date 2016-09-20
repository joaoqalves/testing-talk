package com.c.testingtherealworld;

import com.schibsted.testing.servicetest.domain.services.impl.HardcoreUserAccountService;
import com.schibsted.testing.servicetest.framework.repositories.QuiteComplexIdGenerator;
import com.schibsted.testing.servicetest.framework.repositories.QuiteComplexUserAccountRepository;
import org.junit.Test;

import java.util.HashMap;

public class HardcoreUserAccountServiceTest {


  @Test
  public void saveUser() {
    // Given a new user
    HashMap<String, String> dictionary = createDictionary();
    QuiteComplexIdGenerator idGenerator = new QuiteComplexIdGenerator("ExtremeQuality", 123, dictionary);
    QuiteComplexUserAccountRepository userAccountRepository = new QuiteComplexUserAccountRepository("DB address", 987);

    HardcoreUserAccountService userAccountServiceTest = new HardcoreUserAccountService
        (idGenerator, userAccountRepository);
    // When saving it


    // Then we should get the user saved in the database

  }

  private HashMap<String, String> createDictionary() {
    //Expensive operations
    return new HashMap<>();
  }

}
