package com.Email.App;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department; // Corrected spelling
    private String email;
    private int defaultPasswordLength = 8;
    private int codeLength = 5; // Renamed for clarity
    private String verificationCode;
    private String company = "gmail.com";
    private String name;

    // Constructor
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Kindly enter the department for email creation, dear " + this.firstName + " " + this.lastName);
        
        // Set department
        this.department = setDepartment();
        System.out.println("Department: " + department);
        
        // Generate random password
        this.password = generateRandomPassword(defaultPasswordLength);
        System.out.println("New Password: " + password);
        
        // Combine first and last name
        this.name = firstName + lastName;
        
        // Generate verification code
        this.verificationCode = generateVerificationCode(codeLength);
        System.out.println("Your verification code: " + verificationCode);
        
        // Create email
        this.email = name.toLowerCase() + "." + department + "@" + company;
        System.out.println("Official mail: " + email);
    }

    // Method to set department
    private String setDepartment() {
        System.out.println("Enter the department ID:\n1: Sales\n2: Development\n3: Accounting");
        Scanner input = new Scanner(System.in);
        int dep = input.nextInt();

        switch (dep) {
            case 1:
                return "sales";
            case 2:
                return "dev";
            case 3:
                return "acc";
            default:
                System.out.println("Invalid department ID. Setting to 'general'.");
                return "general";
        }
    }

    // Method to generate random password
    private String generateRandomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(index);
        }
        return new String(password);
    }

    // Method to generate verification code
    private String generateVerificationCode(int length) {
        String codeSet = "1234567890";
        char[] code = new char[length];
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * codeSet.length());
            code[i] = codeSet.charAt(index);
        }
        return new String(code);
    }

    // Getter and setter methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    // Get full department name based on code
    public String getDepartmentName(String dep) {
        switch (dep) {
            case "dev":
                return "Developers";
            case "acc":
                return "Accounts";
            case "sales":
                return "Sales";
            default:
                return "General";
        }
    }

    // Show user information
    public String showInfo() {
        return "Name: " + name + "\nOfficial email: " + email + "\nDepartment: " + getDepartmentName(department);
    }
}
