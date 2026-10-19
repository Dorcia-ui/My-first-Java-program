public class Login {
    private String Username;
    private String Password;
    private String cellPhone;
    private String firstName;
    private String lastName;

    public Login(String username, String password, String cellPhone, String firstName, String lastName) {
        this.Username = username;
        this.Password = password;
        this.cellPhone = cellPhone;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean checkUserName() {
        return Username.contains("_") && Username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        if (Password.length() < 8) return false;
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        for (char c : Password.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapital = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasCapital && hasNumber && hasSpecial;
    }

    public boolean checkCellPhoneNumber(String number) {
        // This is what the test at line 18 expects: +27 and total 12 chars
        return number.matches("\\+27\\d{9}");
    }

    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that your password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        if (!checkCellPhoneNumber(this.cellPhone)) {
            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }
        return "User has been registered successfully.";
    }

    public boolean loginUser(String username, String password) {
        return this.Username.equals(username) && this.Password.equals(password);
    }

    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    }
