package org.example.commands;

import java.util.Scanner;
import java.util.Set;
import org.example.discstorage.UserInfoDiscStorageHandler;
import org.example.model.User;
import org.example.services.UserManagerInterface;

public class ProgramTerminateCommand implements UserCommandInterface {

  UserInfoDiscStorageHandler userInfoDiscStorageHandler;
  UserManagerInterface userManager;

  public ProgramTerminateCommand(UserInfoDiscStorageHandler userInfoDiscStorageHandler,
                                 UserManagerInterface userManager) {
    this.userInfoDiscStorageHandler = userInfoDiscStorageHandler;
    this.userManager = userManager;
  }

  @Override
  public void execute(Set<User> users) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Do You Want To Save Changes Into The Disk ?\n 1 : Yes \n 2 : No");
    int userResponse = scanner.nextInt();

    if (userResponse == 1) {
      userInfoDiscStorageHandler.saveUserInfoToDiscStorage(users);
    }

    userManager.setTerminateProgram(true);
  }
}
