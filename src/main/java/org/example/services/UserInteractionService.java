package org.example.services;

import java.util.Scanner;
import org.example.exceptions.InvalidArgument;
import org.example.prompt.MenuPrompt;
import org.example.validators.UserInteractionServiceValidator;

public class UserInteractionService implements UserInteractionServiceInterface {
  private int userChoice;

  Scanner scanner = new Scanner(System.in);
  UserInteractionServiceValidator userInteractionServiceValidator;

  public UserInteractionService(UserInteractionServiceValidator userInteractionServiceValidator) {
    this.userInteractionServiceValidator = userInteractionServiceValidator;
  }

  MenuPrompt menuPrompt = new MenuPrompt();

  @Override
  public int displayMenuAndGetUserChoice() {
    menuPrompt.showMenu();
    try {
      userChoice = scanner.nextInt();
    } catch (Exception e) {
      throw new InvalidArgument("Input should be an integer number");
    }
    userInteractionServiceValidator.validate(userChoice);
    return userChoice;
  }
}
