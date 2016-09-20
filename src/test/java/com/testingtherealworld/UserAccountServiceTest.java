package com.testingtherealworld;

import com.schibsted.testing.servicetest.domain.model.users.User;
import com.schibsted.testing.servicetest.domain.model.users.UserAccount;
import com.schibsted.testing.servicetest.domain.repositories.IUserAccountRepository;
import com.schibsted.testing.servicetest.domain.repositories.IIdGenerator;
import com.schibsted.testing.servicetest.domain.services.impl.UserAccountService;
import com.schibsted.testing.servicetest.framework.repositories.InMemoryUserAccountRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;

public class UserAccountServiceTest {

    private UserAccountService userAccountService;

    private final String USER_TEST_1 = "Pep Guardiola";
    private final String USER_TEST_1_UUID = "ceb76be0-dc4d-40b7-8de1-0c22a8b4e464";

    @Before
    public void before() {
        IUserAccountRepository userAccountRepository = new InMemoryUserAccountRepository();
        IIdGenerator<UUID> idGenerator = new MockIdGenerator();
        userAccountService = new UserAccountService(idGenerator, userAccountRepository);
    }

    @Test
    public void saveUser() {
        // Given a new user
        User user = new User(USER_TEST_1);

        // When saving it
        UserAccount savedUser = userAccountService.save(user);

        // Then we should get the user saved in the database
        assertEquals(USER_TEST_1, savedUser.getUsername());
    }

    @Test
    public void findUser() {
        // We won't test this since it's tested above :)
        userAccountService.save(new User(USER_TEST_1));

        // Given a user ID
        String id = USER_TEST_1_UUID;

        // When searching for it
        Optional<UserAccount> foundUser = userAccountService.find(UUID.fromString(id));

        // Then we should get the respective UserAccount
        assertEquals(Optional.of(USER_TEST_1), foundUser.map(UserAccount::getUsername));
    }
}