package org.example.services;

import java.util.Scanner;
import org.example.exceptions.InvalidArgument;
import org.example.prompt.MenuPrompt;

public class UserInputChoiceService {
  MenuPrompt menuPrompt = new MenuPrompt();
  Scanner scanner = new Scanner(System.in);

  public int userInputChoice() {

    menuPrompt.showMenu();
    System.out.print("On what field should the users be sorted on (Enter choice) :  ");
    try {
      int userInputChoice = scanner.nextInt();
      return userInputChoice;
    } catch (Exception e) {
      throw new InvalidArgument("Choice should be a number from 1 to 4  ");
    }
  }
}
