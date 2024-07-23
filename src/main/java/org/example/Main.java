package org.example;

import org.example.discstorage.UserInfoDiscStorageHandler;
import org.example.services.AddUserDetailsService;
import org.example.services.AddUserDetailsServiceInterface;
import org.example.services.DeleteUserDetailsService;
import org.example.services.DeleteUserDetailsServiceInterface;
import org.example.services.SortUserDetailsService;
import org.example.services.SortUserDetailsServiceInterface;
import org.example.services.UserInputChoiceService;
import org.example.services.UserInputOrderChoiceService;
import org.example.services.UserInteractionService;
import org.example.services.UserInteractionServiceInterface;
import org.example.services.UserManager;
import org.example.validators.UserInteractionServiceValidator;

public class Main {
  public static void main(String[] args) {
    try {
      UserInteractionServiceValidator userInteractionServiceValidator =
          new UserInteractionServiceValidator();
      UserInteractionServiceInterface userInteractionService = new UserInteractionService(
          userInteractionServiceValidator);
      AddUserDetailsServiceInterface addUserDetailsService = new AddUserDetailsService();
      UserInputChoiceService userInputChoiceService = new UserInputChoiceService();
      UserInputOrderChoiceService userInputOrderPrompt = new UserInputOrderChoiceService();
      DeleteUserDetailsServiceInterface deleteUserDetails = new DeleteUserDetailsService();
      UserInfoDiscStorageHandler userInfoDiscStorageHandler = new UserInfoDiscStorageHandler();
      SortUserDetailsServiceInterface sortUserDetailsService =
          new SortUserDetailsService(userInputChoiceService, userInputOrderPrompt);

      UserManager userManager = new UserManager(userInteractionService,
          addUserDetailsService, sortUserDetailsService, deleteUserDetails,
          userInfoDiscStorageHandler);

      userManager.startManager();
    } catch (Exception e) {
      System.out.println("Error : " + e.getMessage());
    }
  }
}