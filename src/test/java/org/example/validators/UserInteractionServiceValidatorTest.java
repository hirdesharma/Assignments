package org.example.validators;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.exceptions.InvalidArgument;
import org.junit.jupiter.api.Test;

class UserInteractionServiceValidatorTest {

  private final UserInteractionServiceValidator validator = new UserInteractionServiceValidator();

  @Test
  void testValidateUserChoiceValid() {
    assertDoesNotThrow(() -> validator.validate(1));
    assertDoesNotThrow(() -> validator.validate(3));
    assertDoesNotThrow(() -> validator.validate(5));
  }

  @Test
  void testValidateUserChoiceTooLow() {
    assertThrows(InvalidArgument.class, () -> validator.validate(0));
  }

  @Test
  void testValidateUserChoiceTooHigh() {
    assertThrows(InvalidArgument.class, () -> validator.validate(6));
  }
}
