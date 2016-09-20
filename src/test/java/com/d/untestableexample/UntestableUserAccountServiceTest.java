package com.d.untestableexample;

import com.schibsted.testing.UntestableUserAccountService;
import com.schibsted.testing.servicetest.domain.model.users.UserAccount;
import org.junit.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class UntestableUserAccountServiceTest {

  private UntestableUserAccountService userAccountService;

  @Test
  public void givenAnUntestableUserAccountServiceWhenSearchingByIdThenSucceeds() {
    // Given
    userAccountService = new UntestableUserAccountService();

    // When
    Optional<UserAccount> userAccount = userAccountService.searchById(UUID.randomUUID());

    // Then
    assertEquals("Pep", userAccount.map(UserAccount::getUsername).get());
  }
}
