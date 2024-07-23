package org.example.commands;

import java.util.Set;
import org.example.model.User;
import org.example.services.DeleteUserDetailsServiceInterface;

public class DeleteUserCommand implements UserCommandInterface {
  private final DeleteUserDetailsServiceInterface deleteUserDetails;

  public DeleteUserCommand(DeleteUserDetailsServiceInterface deleteUserDetails) {
    this.deleteUserDetails = deleteUserDetails;
  }

  @Override
  public void execute(Set<User> users) {
    deleteUserDetails.deleteUser(users);
  }
}