package org.example.commands;

import java.util.Set;
import org.example.discstorage.UserInfoDiscStorageHandler;
import org.example.model.User;

public class SaveUserCommand implements UserCommandInterface {
  private final UserInfoDiscStorageHandler userInfoDiscStorageHandler;

  public SaveUserCommand(UserInfoDiscStorageHandler userInfoDiscStorageHandler) {
    this.userInfoDiscStorageHandler = userInfoDiscStorageHandler;
  }

  @Override
  public void execute(Set<User> users) {
    userInfoDiscStorageHandler.saveUserInfoToDiscStorage(users);
  }
}