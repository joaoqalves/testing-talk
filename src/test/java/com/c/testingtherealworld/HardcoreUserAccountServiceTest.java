package com.c.testingtherealworld;

import com.schibsted.testing.servicetest.domain.services.impl.HardcoreUserAccountService;
import com.schibsted.testing.servicetest.framework.repositories.QuiteComplexIdGenerator;
import com.schibsted.testing.servicetest.framework.repositories.QuiteComplexUserAccountRepository;
import org.junit.Test;

import java.util.HashMap;

public class HardcoreUserAccountServiceTest {


  @Test
  public void givenAHardCoreUserAccountServiceWhenSavingThenSucceeds() {
    // Given
    QuiteComplexIdGenerator idGenerator = new QuiteComplexIdGenerator(calculateQuality(), 123, createDictionary());
    QuiteComplexUserAccountRepository userAccountRepository = new QuiteComplexUserAccountRepository(calculateDbAddress(), 987);

    HardcoreUserAccountService userAccountService = new HardcoreUserAccountService(idGenerator, userAccountRepository, "anotherHardClass");
    // When


    // Then

  }

  private String calculateQuality() {
    return "Hard to get quality string";
  }

  private String calculateDbAddress() {
    return "hard to get DB address";
  }


  private HashMap<String, String> createDictionary() {
    //Expensive operations
    return new HashMap<>();
  }

}
