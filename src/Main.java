import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

void main() {
    Scanner sc = new Scanner(System.in);
    String firstName;
    String lastName;
    String Username;
    String password;
        // while shows that we are going to keep asking until the input is valid.
        System.out.print("Enter your first Name: ");
         firstName = sc.nextLine();
        System.out.print("Enter your last Name: ");
         lastName = sc.nextLine();
        System.out.print("Enter the username:");
         Username = sc.nextLine();
         while  (true){
//username.length tells how many characters are in the username, username.contains("_") checks whether the username contains _.
        if (Username.contains("_") && Username.length() <= 5) {
            System.out.println("Username successfully captured.");
            break;
        } else {
            System.out.println("username is not correctly formatted please ensure that your username contains an underscore" +
                    "and it is not more than five characters in length. " +
                    "Please try again");
            Username = sc.nextLine();
        }
    }
    while (true) {
        System.out.println("Enter the password: ");
         password = sc.nextLine();
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            }
            if (Character.isDigit(ch)) {
                hasNumber = true;
            }
            if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }


        if (password.length() >= 8 && hasCapital && hasNumber && hasSpecial) {

            System.out.println("Password successfully captured");
            break;

        } else {
            System.out.println("Password is not correctly formatted please ensure that the password contains at least " +
                    " eight characters, a capital letter, a number and a special character. ");
        }
    }

//ask for the cellphone
    while (true) {
        System.out.print("Enter the cellphone: ");
        String cellphone = sc.nextLine();
        if (cellphone.startsWith("+27") && cellphone.length() <= 13) {
            System.out.print("Cellphone number successfully added");
            break;
        } else {
            System.out.println("Cellphone number incorrectly formatted or does not contain international code ");
        }
    }
    // log in part
    System.out.println("\n please enter your login details");
    String storedUsername ;
    String storedPassword ;
    System.out.print("Enter your username: ");
    storedUsername = sc.nextLine().trim();
    System.out.print("Enter your password: ");
    storedPassword = sc.nextLine().trim();
    while (true) {

        if (storedUsername.equals(Username) && storedPassword.equals(password)) {
            System.out.println("login successfully: ");
            System.out.println("welcome " + firstName + " " + lastName + " " + " it is great to see you again");
                    break;
        } else {
            System.out.println("Password or username incorrect please try again");
            storedUsername = sc.nextLine().trim();
            storedPassword = sc.nextLine().trim();
        }
    }
}












