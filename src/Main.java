import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // PART 1: REGISTRATION AND LOGIN

        String firstName;
        String lastName;
        String Username;
        String password;

        System.out.print("Enter your first Name: ");
        firstName = sc.nextLine();

        System.out.print("Enter your last Name: ");
        lastName = sc.nextLine();

        System.out.print("Enter the username: ");
        Username = sc.nextLine();

        while (true) {
            if (Username.contains("_") && Username.length() <= 5) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println(
                        "Username is not correctly formatted. Please ensure "
                                + "that your username contains an underscore and is "
                                + "not more than five characters in length. Please try again:"
                );
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

            if (password.length() >= 8
                    && hasCapital && hasNumber && hasSpecial) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println(
                        "Password is not correctly formatted. Please ensure "
                                + "that it contains at least eight characters, a capital "
                                + "letter, a number and a special character."
                );
            }
        }

        while (true) {
            System.out.print("Enter the cellphone: ");
            String cellphone = sc.nextLine();

            if (cellphone.startsWith("+27") && cellphone.length() <= 13) {
                System.out.println("Cellphone number successfully added.");
                break;
            } else {
                System.out.println(
                        "Cellphone number incorrectly formatted or does not "
                                + "contain international code."
                );
            }
        }

        // LOGIN

        System.out.println("\nPlease enter your login details.");

        while (true) {
            System.out.print("Enter your username: ");
            String storedUsername = sc.nextLine().trim();

            System.out.print("Enter your password: ");
            String storedPassword = sc.nextLine().trim();

            if (storedUsername.equals(Username)
                    && storedPassword.equals(password)) {
                System.out.println("Login successful.");
                System.out.println(
                        "Welcome " + firstName + " " + lastName
                                + ", it is great to see you again."
                );
                break;
            } else {
                System.out.println(
                        "Password or username incorrect. Please try again."
                );
            }
        }

        // PART 2: QUICKCHAT

        Random random = new Random();
        ArrayList<Message> messages = new ArrayList<>();

        System.out.println("\nWelcome to QuickChat.");

        int option = 0;

        while (option != 3) {
            System.out.println("\n1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");

            option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
                System.out.print("How many messages would you like to send? ");
                int numberOfMessages = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < numberOfMessages; i++) {
                    System.out.println("\nMessage " + (i + 1));

                    System.out.print("Enter recipient cellphone number: ");
                    String recipient = sc.nextLine();

                    while (!Message.checkRecipientCell(recipient)) {
                        System.out.println(
                                "Cell phone number is incorrectly formatted or "
                                        + "does not contain an international code."
                        );
                        System.out.print("Enter recipient cellphone number: ");
                        recipient = sc.nextLine();
                    }

                    System.out.println("Cell phone number successfully captured.");

                    System.out.print("Enter your message: ");
                    String messageText = sc.nextLine();

                    if (messageText.length() > 250) {
                        System.out.println(
                                "Please enter a message of less than 250 characters."
                        );
                        continue;
                    }

                    String messageID = String.format(
                            "%010d", random.nextLong(10_000_000_000L)
                    );

                    System.out.println("Message ID generated: " + messageID);

                    Message message = new Message(
                            messageID, recipient, messageText
                    );

                    String messageHash = message.createMessageHash(i);
                    message.setMessageHash(messageHash);

                    System.out.println("Message Hash: " + messageHash);

                    System.out.println("\nChoose what to do with this message:");
                    System.out.println("1 - Send Message");
                    System.out.println("0 - Disregard Message");
                    System.out.println("2 - Store Message to send later");
                    System.out.print("Enter your choice: ");

                    int messageChoice = sc.nextInt();
                    sc.nextLine();

                    if (messageChoice == 1) {
                        messages.add(message);

                        System.out.println("\nMessage successfully sent.");
                        System.out.println("Message ID: " + message.getMessageID());
                        System.out.println("Message Hash: " + messageHash);
                        System.out.println("Recipient: " + message.getRecipient());
                        System.out.println(
                                "Message " + (i + 1) + ": "
                                        + message.getMessageText()
                        );

                    } else if (messageChoice == 0) {
                        System.out.println("Message disregarded.");

                    } else if (messageChoice == 2) {
                        String result = message.storeMessage();
                        System.out.println(result);

                    } else {
                        System.out.println("Invalid choice.");
                    }
                }
                break;

            } else if (option == 2) {
                System.out.println("Coming soon.");

            } else if (option == 3) {
                System.out.println("Goodbye.");

            } else {
                System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
