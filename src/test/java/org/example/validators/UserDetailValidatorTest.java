package org.example.validators;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.exceptions.InvalidArgument;
import org.junit.jupiter.api.Test;

class UserDetailValidatorTest {

  private static final String VALID_NAME = "Hirdesh Sharma";
  private static final int VALID_AGE = 25;
  private static final String VALID_ADDRESS = "Bhind Daboha";
  private static final String VALID_ROLL_NO = "R123";
  private static final String[] VALID_COURSES = {"A", "B", "C", "D", "E", "F"};

  @Test
  void testValidateFullNameValid() {
    UserDetailValidator validator = new UserDetailValidator(VALID_NAME, VALID_AGE, VALID_ADDRESS,
        VALID_ROLL_NO, VALID_COURSES);
    assertDoesNotThrow(validator::validate);
  }

  @Test
  void testValidateFullNameInvalidEmpty() {
    UserDetailValidator validator = new UserDetailValidator("", VALID_AGE, VALID_ADDRESS,
        VALID_ROLL_NO, VALID_COURSES);
    assertThrows(InvalidArgument.class, validator::validate);
  }

  @Test
  void testValidateFullNameInvalidFormat() {
    UserDetailValidator validator = new UserDetailValidator("invalid123", VALID_AGE, VALID_ADDRESS,
        VALID_ROLL_NO, VALID_COURSES);
    assertThrows(InvalidArgument.class, validator::validate);
  }

  @Test
  void testValidateAgeValid() {
    UserDetailValidator validator = new UserDetailValidator(VALID_NAME, VALID_AGE, VALID_ADDRESS,
        VALID_ROLL_NO, VALID_COURSES);
    assertDoesNotThrow(validator::validate);
  }

  @Test
  void testValidateAgeInvalid() {
    UserDetailValidator validator = new UserDetailValidator(VALID_NAME, 0, VALID_ADDRESS,
        VALID_ROLL_NO, VALID_COURSES);
    assertThrows(InvalidArgument.class, validator::validate);
  }

  @Test
  void testValidateAddressValid() {
    UserDetailValidator validator = new UserDetailValidator(VALID_NAME, VALID_AGE, VALID_ADDRESS,
        VALID_ROLL_NO, VALID_COURSES);
    assertDoesNotThrow(validator::validate);
  }

  @Test
  void testValidateAddressInvalidEmpty() {
    UserDetailValidator validator = new UserDetailValidator(VALID_NAME, VALID_AGE, "",
        VALID_ROLL_NO, VALID_COURSES);
    assertThrows(InvalidArgument.class, validator::validate);
  }

  @Test
  void testValidateRollNoValid() {
    UserDetailValidator validator = new UserDetailValidator(VALID_NAME, VALID_AGE, VALID_ADDRESS,
        VALID_ROLL_NO, VALID_COURSES);
    assertDoesNotThrow(validator::validate);
  }

  @Test
  void testValidateRollNoInvalidEmpty() {
    UserDetailValidator validator = new UserDetailValidator(VALID_NAME, VALID_AGE, VALID_ADDRESS,
        "", VALID_COURSES);
    assertThrows(InvalidArgument.class, validator::validate);
  }

  @Test
  void testValidateSetOfCoursesValid() {
    UserDetailValidator validator = new UserDetailValidator(VALID_NAME, VALID_AGE, VALID_ADDRESS,
        VALID_ROLL_NO, new String[]{"A", "B", "C", "D"});
    assertDoesNotThrow(validator::validate);
  }

  @Test
  void testValidateSetOfCoursesInvalidLessThanFour() {
    UserDetailValidator validator = new UserDetailValidator(VALID_NAME, VALID_AGE, VALID_ADDRESS,
        VALID_ROLL_NO, new String[]{"A", "B", "C"});
    assertThrows(InvalidArgument.class, validator::validate);
  }

  @Test
  void testValidateSetOfCoursesInvalidCourse() {
    UserDetailValidator validator = new UserDetailValidator(VALID_NAME, VALID_AGE, VALID_ADDRESS,
        VALID_ROLL_NO, new String[]{"A", "B", "C", "G"});
    assertThrows(InvalidArgument.class, validator::validate);
  }
}
