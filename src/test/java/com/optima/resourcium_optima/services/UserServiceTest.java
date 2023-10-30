package com.optima.resourcium_optima.services;

import com.optima.resourcium_optima.domain.entities.Department;
import com.optima.resourcium_optima.domain.entities.Role;
import com.optima.resourcium_optima.domain.entities.User;
import com.optima.resourcium_optima.util.AuthenticationUtil;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    @Order(1)
    void canAddUser() {
        // given
        Role role = new Role(1L, "employee");
        Department department = new Department(1L, "IT", "infos and techs");

        User newUser = new User(
                "username",
                "name",
                "surname",
                "email",
                "aD/fdbLC13eP00n0i9vOEflXryn7t7b/mp7NY6bFytk=",
                role,
                department
        );

        // do
        userService.createUser(newUser);

        User user = userService.getUserById(1L);

        // check
        assertEquals(user, newUser);
    }

    @Test
    @Order(2)
    void throwErrorWhenCreateUser() {
        // given
        Role role = new Role(2L, "employee");
        Department department = new Department(2L, "IT", "infos and techs");

        User newUser = new User(
                "username",
                "name",
                "surname",
                "email",
                "password",
                role,
                department
        );
        newUser.setId(1L);

        // check
        assertThrows(RuntimeException.class, () -> {
            userService.createUser(newUser);
        });
    }

    @Test
    @Order(3)
    void canUpdateUser() {
        // given
        User user = userService.getUserById(1L);

        // do
        String newUsername = "newUsername";
        user.setUsername(newUsername);
        userService.updateUser(user);

        User updatedUser = userService.getUserById(1L);

        // check
        assertEquals(newUsername, updatedUser.getUsername());
    }

    @Test
    @Order(4)
    void throwErrorWhenUpdateUser() {
        // given
        User user = userService.getUserById(1L);

        // do
        String newUsername = "newUsername";
        user.setUsername(newUsername);
        user.setId(9L);

        // check
        assertThrows(RuntimeException.class, () -> {
            userService.updateUser(user);
        });
    }

    @Test
    @Order(5)
    void canGetUserById() {
        // given
        User user = userService.getUserById(1L);

        String newUsername = "newUsername";

        // check
        assertEquals(newUsername, user.getUsername());
    }

    @Test
    @Order(6)
    void canGetUserByUsername() {
        // given
        String newUsername = "newUsername";
        User user = userService.getUserByUsername(newUsername);

        // check
        assertEquals("email", user.getEmail());
    }

    @Test
    @Order(7)
    void canUpdateUserPassword() {
        // given
        User user = userService.getUserById(1L);

        // do
        String newPassword = "newPassword";
        userService.updateUserPassword(user, "password", newPassword);

        User updatedUser = userService.getUserById(1L);

        assertTrue(AuthenticationUtil.verifyPassword(newPassword, updatedUser.getPassword()));
    }
}