package com.f.mockitoexamples;

import com.schibsted.testing.servicetest.domain.model.users.User;
import com.schibsted.testing.servicetest.domain.model.users.UserAccount;
import com.schibsted.testing.servicetest.domain.repositories.IdGenerator;
import com.schibsted.testing.servicetest.domain.repositories.UserAccountRepository;
import com.schibsted.testing.servicetest.domain.services.impl.DefaultUserAccountService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoUserAccountServiceTest {

  private final String USER_TEST_1 = "Pep Guardiola";

  @Mock
  private IdGenerator<UUID> idGeneratorMock;

  @Mock
  private UserAccountRepository userAccountRepositoryMock;

  private DefaultUserAccountService userAccountService;
  private UUID uuid;


  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);

    userAccountService = new DefaultUserAccountService(idGeneratorMock, userAccountRepositoryMock);
    uuid = UUID.randomUUID();
    when(idGeneratorMock.generateId()).thenReturn(uuid);
  }

  @Test
  public void givenAUserWhenSavingItThenSucceeds() {
    // Given
    User user = new User(USER_TEST_1);
    when(userAccountRepositoryMock.save(any(UserAccount.class))).thenReturn(new UserAccount(uuid, USER_TEST_1));

    // When
    UserAccount savedUser = userAccountService.save(user);

    // Then
    assertThat(savedUser.getUsername()).isEqualTo(USER_TEST_1);
  }

  @Test
  public void givenAUserUuidWhenSearchingAUserThenSucceeds() {
    // Given
    UUID userUuid = UUID.randomUUID();
    Optional<UserAccount> optionalUserAccount = Optional.of(new UserAccount(userUuid, USER_TEST_1));
    when(userAccountRepositoryMock.find(userUuid)).thenReturn(optionalUserAccount);

    // When
    Optional<UserAccount> foundUser = userAccountService.search(userUuid);

    // Then
    assertThat(foundUser.map(UserAccount::getUsername)).isEqualTo(Optional.of(USER_TEST_1));
  }


  @Test
  public void givenAUserUuidWhenSearchingAUserThenFails() {
    // Given
    UUID userUuid = UUID.randomUUID();
    when(userAccountRepositoryMock.find(userUuid)).thenReturn(Optional.empty());

    // When
    Optional<UserAccount> foundUser = userAccountService.search(uuid);

    // Then
    assertThat(foundUser).isEqualTo(Optional.empty());
  }
}
