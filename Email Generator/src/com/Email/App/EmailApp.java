package com.Email.App;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        System.out.println("Generate Organization's Email ==>");

        try (Scanner sc = new Scanner(System.in)) { // Auto-close the Scanner
            System.out.println("Generate the email...");
            System.out.print("Enter First Name: ");
            String first = sc.nextLine();
            System.out.print("Enter Last Name: ");
            String last = sc.nextLine();

            Email email = new Email(first, last);

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1 : Show Information");
                System.out.println("2 : Change Email");
                System.out.println("3 : Change Password");
                System.out.println("4 : Disclose Password");
                System.out.println("5 : Exit");
                System.out.print("Enter operation code: ");

                if (!sc.hasNextInt()) { // Check for valid integer input
                    System.out.println("Invalid input. Please enter a number from 1 to 5.");
                    sc.next(); // Clear invalid input
                    continue;
                }

                int option = sc.nextInt();
                sc.nextLine(); // Clear the buffer after `nextInt`

                switch (option) {
                    case 1: // Show information
                        System.out.println(email.showInfo());
                        break;

                    case 2: // Change email
                        System.out.println("Enter alternate email prefix: ");
                        String alt = sc.nextLine();
                        email.setEmail(alt + "@gmail.com");
                        System.out.println("Email updated successfully!");
                        break;

                    case 3: // Change password
                        System.out.println("Enter the verification code: ");
                        String verificationCode = sc.nextLine();
                        if (verificationCode.equals(email.getVerificationCode())) {
                            System.out.println("Enter new password: ");
                            String newPassword = sc.nextLine();
                            email.setPassword(newPassword);
                            System.out.println("Password updated successfully!");
                        } else {
                            System.out.println("Invalid verification code!");
                        }
                        break;

                    case 4: // Disclose password
                        System.out.println("Password disclosure warning!");
                        System.out.println("Enter the verification code: ");
                        String verifyCode = sc.nextLine();
                        if (verifyCode.equals(email.getVerificationCode())) {
                            System.out.println("Your password: " + email.getPassword());
                        } else {
                            System.out.println("Invalid verification code!");
                        }
                        break;

                    case 5: // Exit
                        System.out.println("Have a great day ahead! Bye!");
                        return;

                    default: // Handle invalid options
                        System.out.println("Invalid option. Please select a number from 1 to 5.");
                        break;
                }
            }
        }
    }
}
