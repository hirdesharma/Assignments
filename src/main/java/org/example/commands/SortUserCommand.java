package org.example.commands;

import java.util.Set;
import org.example.model.User;
import org.example.services.SortUserDetailsServiceInterface;

public class SortUserCommand implements UserCommandInterface {
  private final SortUserDetailsServiceInterface sortUserDetails;

  public SortUserCommand(SortUserDetailsServiceInterface sortUserDetails) {
    this.sortUserDetails = sortUserDetails;
  }

  @Override
  public void execute(Set<User> users) {
    sortUserDetails.sortUserDetails(users);
  }
}