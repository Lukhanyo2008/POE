import java.util.regex.Pattern;

public class Login {
   // Stored credentials
   private String username;
   private String password;
   private String firstName;
   private String lastName;

    // 1. Check Username: Contains underscore and <= 5 chars
   public boolean checkUserName(String username) {
      return username.contains("_") && username.length() <= 5;
   }

   // 2. Check Password: Length, Capital, Number, Special Char
   public boolean checkPasswordComplexity(String password) {
      boolean hasCap = !password.equals(password.toLowerCase());
      boolean hasNum = password.matches(".*\\d.*");
      boolean hasSpec = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

      return password.length() >= 8 && hasCap && hasNum && hasSpec;
   }

   // 3. Check Cell Phone: International code and length
   public boolean checkCellPhoneNumber(String cellNumber) {
      // Regex for +27 followed by 9 digits (total 11 chars with +)
      String regex = "^\\+27[0-9]{9}$";
      return Pattern.matches(regex, cellNumber);
   }

   // 4. Register User Messaging
   public String registerUser(String username, String password, String firstName, String lastName, String cellNumber) {
      if (!checkUserName(username)) {
         return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
      }

      if (!checkPasswordComplexity(password)) {
         return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
      }

      // Store data if formatting is correct
      this.username = username;
      this.password = password;
      this.firstName = firstName;
      this.lastName = lastName;

       return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
   }

   // 5. Login Verification
   public boolean loginUser(String enteredUser, String enteredPass) {
      return enteredUser.equals(this.username) && enteredPass.equals(this.password);
   }

   // 6. Return Login Status Message
   public String returnLoginStatus(boolean isLoggedIn) {
      if (isLoggedIn) {
         return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
      } else {
         return "Username or password incorrect, please try again.";
      }
   }
}





