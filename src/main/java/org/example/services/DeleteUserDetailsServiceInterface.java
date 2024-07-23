package org.example.services;

import java.util.Set;
import org.example.model.User;

public interface DeleteUserDetailsServiceInterface {
  void deleteUser(Set<User> users);
}
