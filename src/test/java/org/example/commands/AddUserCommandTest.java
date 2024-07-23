package org.example.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;
import org.example.exceptions.InvalidArgument;
import org.example.model.User;
import org.example.services.AddUserDetailsServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddUserCommandTest {

  private AddUserDetailsServiceInterface addUserDetailsService;
  private UserCommandInterface addUserCommand;
  private Set<User> users;

  @BeforeEach
  public void setUp() {
    addUserDetailsService = mock(AddUserDetailsServiceInterface.class);
    addUserCommand = new AddUserCommand(addUserDetailsService);
    users = new HashSet<>();
  }

  @Test
  public void testExecute_addsNewUser() {
    User newUser = new User("Hirdesh Sharma", "1001", 25, "Bhind Daboha", new String[]{"A"});
    when(addUserDetailsService.newUser()).thenReturn(newUser);

    addUserCommand.execute(users);
    assertTrue(users.contains(newUser), "User should be added to the set");
  }

  @Test
  public void testExecute_UserAlreadyExists() {
    User existingUser = new User("Hirdesh Sharma", "1001", 25, "Bhind Daboha", new String[]{"A"});
    users.add(existingUser);
    when(addUserDetailsService.newUser()).thenReturn(existingUser);

    InvalidArgument exception = assertThrows(InvalidArgument.class, () -> {
      addUserCommand.execute(users);
    });

    assertEquals("This User with rollNo 1001 already exists in database", exception.getMessage());
  }
}
