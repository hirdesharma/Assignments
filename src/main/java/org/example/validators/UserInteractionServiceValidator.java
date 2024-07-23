package org.example.validators;

import org.example.exceptions.InvalidArgument;

public class UserInteractionServiceValidator {
  public void validate(int userChoice) {
    if (userChoice < 1 || userChoice > 5) {
      throw new InvalidArgument("Number should be between 1 and 5 "
          + "both included");
    }
  }
}
