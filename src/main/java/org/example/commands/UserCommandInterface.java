package org.example.commands;

import java.util.Set;
import org.example.model.User;

public interface UserCommandInterface {
  void execute(Set<User> users);
}
