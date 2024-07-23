// Not Working tests need to figure out how to give inputs through tests in integer


package org.example.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.example.exceptions.InvalidArgument;
import org.example.prompt.MenuPrompt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserInputChoiceServiceTest {

  private UserInputChoiceService userInputChoiceService;
  private MenuPrompt menuPrompt;

  @BeforeEach
  public void setUp() {
    menuPrompt = mock(MenuPrompt.class); // Mock MenuPrompt
    userInputChoiceService = new UserInputChoiceService();
    userInputChoiceService.menuPrompt = menuPrompt; // Inject mock
  }

  @Test
  public void testUserInputChoiceValid() {
    String simulatedInput = "2";
    InputStream originalSystemIn = System.in;
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

    int choice = userInputChoiceService.userInputChoice();
    assertEquals(2, choice);
    System.setIn(originalSystemIn);
  }

  @Test
  public void testUserInputChoiceNull() {
    String simulatedInput = null;
    InputStream originalSystemIn = System.in;
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

    assertThrows(NumberFormatException.class, () -> userInputChoiceService.userInputChoice());
    System.setIn(originalSystemIn);
  }

  @Test
  public void testUserInputChoiceInvalid() {
    String simulatedInput = "8";
    InputStream originalSystemIn = System.in;
    System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

    assertThrows(
        InvalidArgument.class,
        () -> userInputChoiceService.userInputChoice()
    );
    System.setIn(originalSystemIn);
  }
}
