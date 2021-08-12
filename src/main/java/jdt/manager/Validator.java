package jdt.manager;

import java.util.Arrays;
import java.util.Date;
import java.util.regex.*;

public class Validator {

  private final String firstname;
  private final String surname;
  private final String username;
  private final String email;
  private final Date dob;
  private final char[] password;
  private final char[] repeatPassword;
  private final int passScore;

  public Validator(String firstname, String surname, String username, String email, Date dob, char[] password,
      char[] repeatPassword, int passScore) {
    this.firstname = firstname;
    this.surname = surname;
    this.username = username;
    this.email = email;
    this.dob = dob;
    this.password = password;
    this.repeatPassword = repeatPassword;
    this.passScore = passScore;
  }

  public boolean validateFirstname() {
    boolean valid = true;

    if (firstname.equals("")) {
      valid = false;
    }

    return valid;
  }

  public boolean validateFirstnameLength() {
    boolean valid = true;

    if (firstname.length() > 100) {
      valid = false;
    }

    return valid;
  }

  public boolean validateSurname() {
    boolean valid = true;

    if (surname.equals("")) {
      valid = false;
    }

    return valid;
  }

  public boolean validateSurnameLength() {
    boolean valid = true;

    if (surname.length() > 100) {
      valid = false;
    }

    return valid;
  }

  public boolean validateUsername() {
    boolean valid = true;

    Pattern usernamePatten = Pattern.compile("^(?!.*\\.\\.)(?!.*\\.$)[^\\W][\\w.]{0,25}$",
        Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
    Matcher usernameMatcher = usernamePatten.matcher(username);

    if (!usernameMatcher.find()) {
      valid = false;
    }

    return valid;
  }

  public boolean validateUsernameLength() {
    boolean valid = true;

    if (username.length() > 25) {
      valid = false;
    }

    return valid;
  }

  public boolean validateEmail() {
    boolean valid = true;

    Pattern emailPatten = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    Matcher emailMatcher = emailPatten.matcher(email);

    if (!emailMatcher.find()) {
      valid = false;
    }

    return valid;
  }

  public boolean validateEmailLength() {
    boolean valid = true;

    if (email.length() > 255) {
      valid = false;
    }

    return valid;
  }

  public boolean validateDOB() {
    boolean valid = true;

    if (dob == null) {
      valid = false;
    }

    return valid;
  }

  public boolean validateDOBLogic() {
    boolean valid = true;

    if (dob.after(new Date())) {
      valid = false;
    }

    return valid;
  }

  public boolean validatePasswordMatch() {
    boolean valid = true;

    if (!Arrays.equals(password, repeatPassword)) {
      valid = false;
    }

    return valid;
  }

  public boolean validatePasswordLength() {
    boolean valid = true;

    if (password.length < 8) {
      valid = false;
    }
    return valid;
  }

  public boolean validatePasswordStrength() {
    boolean valid = true;

    if (passScore < 3) {
      valid = false;
    }

    return valid;
  }
}
