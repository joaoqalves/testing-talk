package com.mockitoexamples;

import com.schibsted.testing.servicetest.domain.model.users.User;
import com.schibsted.testing.servicetest.domain.model.users.UserAccount;
import com.schibsted.testing.servicetest.domain.repositories.IIdGenerator;
import com.schibsted.testing.servicetest.domain.repositories.IUserAccountRepository;
import com.schibsted.testing.servicetest.domain.services.impl.UserAccountService;
import com.schibsted.testing.servicetest.framework.repositories.InMemoryUserAccountRepository;
import com.testingtherealworld.MockIdGenerator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
  private final String USER_TEST_1_UUID = "ceb76be0-dc4d-40b7-8de1-0c22a8b4e464";

  @Mock
  private IIdGenerator<UUID> idGeneratorMock;

  @Mock
  private IUserAccountRepository userAccountRepositoryMock;

  private UserAccountService userAccountService;
  private UUID uuid;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
    userAccountService = new UserAccountService(idGeneratorMock, userAccountRepositoryMock);
    uuid = UUID.randomUUID();
    when(idGeneratorMock.generateId()).thenReturn(uuid);
  }

  @Test
  public void saveUser() {
    // Given a new user
    User user = new User(USER_TEST_1);

    // When saving it
    when(userAccountRepositoryMock.save(any(UserAccount.class))).thenReturn(new UserAccount(uuid, USER_TEST_1));
    UserAccount savedUser = userAccountService.save(user);

    // Then we should get the user saved in the database
    assertThat(savedUser.getUsername()).isEqualTo(USER_TEST_1);
  }

  @Test
  public void findUser() {
    // Given a user ID
    Optional<UserAccount> optionalUserAccount = Optional.of(new UserAccount(uuid, USER_TEST_1));

    // When searching for it
    when(userAccountRepositoryMock.find(uuid)).thenReturn(optionalUserAccount);
    Optional<UserAccount> foundUser = userAccountService.find(uuid);

    // Then we should get the respective UserAccount
    assertThat(foundUser.map(UserAccount::getUsername)).isEqualTo(Optional.of(USER_TEST_1));
  }


  @Test
  public void findUserNotFound() {
    // Given a user ID

    // When searching for it
    when(userAccountRepositoryMock.find(uuid)).thenReturn(Optional.empty());
    Optional<UserAccount> foundUser = userAccountService.find(uuid);

    // Then we should get the respective UserAccount
    assertThat(foundUser).isEqualTo(Optional.empty());
  }
}
