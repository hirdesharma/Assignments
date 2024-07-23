package org.example.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.example.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortUserDetailsServiceTest {

  private SortUserDetailsService sortUserDetailsService;
  private UserInputChoiceService userInputChoiceService;
  private UserInputOrderChoiceService userInputOrderChoiceService;

  @BeforeEach
  public void setUp() {
    userInputChoiceService = mock(UserInputChoiceService.class);
    userInputOrderChoiceService = mock(UserInputOrderChoiceService.class);

    sortUserDetailsService = new SortUserDetailsService(userInputChoiceService,
        userInputOrderChoiceService);
  }

  @Test
  public void testSortByNameAscending() {
    Set<User> users = new HashSet<>();
    users.add(new User("Aashish", "3", 30, "Address 3", new String[]{"A"}));
    users.add(new User("Hirdesh", "1", 25, "Address 1", new String[]{"B"}));
    users.add(new User("Pradumya", "2", 28, "Address 2", new String[]{"C"}));

    when(userInputChoiceService.userInputChoice()).thenReturn(1);
    when(userInputOrderChoiceService.userInputOrder()).thenReturn(1);

    Set<String> sortedNames = users.stream()
        .sorted(Comparator.comparing(User::getName))
        .map(User::getName)
        .collect(Collectors.toSet());

    sortUserDetailsService.sortUserDetails(users);

    assertEquals(Set.of("Hirdesh", "Pradumya", "Aashish"), sortedNames);
  }

  @Test
  public void testSortByAgeDescending() {
    Set<User> users = new HashSet<>();
    users.add(new User("Aashish", "3", 30, "Address 3", new String[]{"A"}));
    users.add(new User("Hirdesh", "1", 25, "Address 1", new String[]{"B"}));
    users.add(new User("Pradumya", "2", 28, "Address 2", new String[]{"C"}));

    when(userInputChoiceService.userInputChoice()).thenReturn(3);
    when(userInputOrderChoiceService.userInputOrder()).thenReturn(2);

    Set<String> sortedNames = users.stream()
        .sorted(Comparator.comparingInt(User::getAge).reversed())
        .map(User::getName)
        .collect(Collectors.toSet());

    sortUserDetailsService.sortUserDetails(users);

    assertEquals(Set.of("Aashish", "Pradumya", "Hirdesh"), sortedNames);
  }

  @Test
  public void testSortByRollNoDescending() {
    Set<User> users = new HashSet<>();
    users.add(new User("Aashish", "3", 30, "Address 3", new String[]{"A"}));
    users.add(new User("Hirdesh", "1", 25, "Address 1", new String[]{"B"}));
    users.add(new User("Pradumya", "2", 28, "Address 2", new String[]{"C"}));

    when(userInputChoiceService.userInputChoice()).thenReturn(2);
    when(userInputOrderChoiceService.userInputOrder()).thenReturn(2);

    Set<String> sortedRollNo = users.stream()
        .sorted(Comparator.comparingInt(User::getAge).reversed())
        .map(User::getRollNumber)
        .collect(Collectors.toSet());

    sortUserDetailsService.sortUserDetails(users);

    assertEquals(Set.of("1", "2", "3"), sortedRollNo);
  }
}
