/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

/**
 *
 * @author Jaeran De Koker
 */
import java.util.Scanner;
public class ChatApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Declaration of variables
        String username = null;
        String password = null;
        int length;
        int messageNumber = 0;
        String cellphonenumber;
        String firstName = null;
        String lastName = null;
        String recipient;
        int messageCount = 0;
        int messageLimit = 0;
        String message;
        
        boolean Registered = false;
        
        //Part 1 of the ChatApp
        System.out.println("Hello user. Today you wil be registering for a chat app. PLease follow the instructions below.");
        
        boolean running = true;
        while(running) {
            System.out.println("\nOptions: ");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            
            System.out.println("Choose option: ");
            int choice = input.nextInt();
            input.nextLine();
        
        
        //Entering a username
        if (choice == 1) {
            System.out.println("\n----Registration----");
            
            System.out.print("Enter first name: ");
            firstName = input.nextLine();
            
            System.out.print("Enter last name: ");
            lastName = input.nextLine();
        
         while(true) {
        System.out.println("\nUsername Conditions: ");
        System.out.println("-Must contain an underscore(_)");
        System.out.println("-Must not be more than 5 characters long.");
        
        System.out.print("Enter a username: ");
        username = input.nextLine();
        
        length = username.length();
        if (username.length() == 5 && username.contains ("_")) {
            System.out.println("Username successfully captured.");
            break;
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        }
        }
        
        //Creating a password for user's login details
        System.out.println("\nPassword Conditions: ");
        System.out.println("-Must contain a captal letter.");
        System.out.println("-Must contain a number.");
        System.out.println("-Must contain a special character.");
        System.out.println("-Must contain at least 8 characters.");
        
        while(true) {
        boolean hasUppercase = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        System.out.print("Enter a password: ");
        password = input.nextLine();
        
        for (char c : password.toCharArray()) {
         if (Character.isUpperCase(c)) hasUppercase = true;
               if (Character.isDigit(c)) hasNumber = true;
               if (Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        
        //Checking all the requirements
        length = password.length();
        if (password.length() >= 8 && hasUppercase && hasNumber && hasSpecial) {
            System.out.println("Password successfully captured.");
            break;
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character.");
        }
        }
        //Entering a cell phone number
        while(true) {
            System.out.println("/nCellphone number conditions: ");
            System.out.println("-Must start with (+27)");
            System.out.println("-Must at least be 12 characters long.");
            
            System.out.print("Enter cell phone number: ");
            cellphonenumber = input.nextLine();
            
            length = cellphonenumber.length();
            if (cellphonenumber.startsWith("+27") && cellphonenumber.length() == 12) {
                System.out.println("Cellphone number successfully added.");
                break;
            } else {
                System.out.println("Cellphone number incorrectly formatted or does not contain the international country code.");
            }
        }
        Registered = true;
        } else if (choice == 2) {
                if (!Registered) {
                    System.out.println("You have not registered!");
                }
        //User Login Authentictor
        System.out.println("\n----Login System----");
        while (true) {
        System.out.print("\nEnter username: ");
        username = input.nextLine();
        
        System.out.print("Enter password: ");
        password = input.nextLine();
        
        if (username.equals(username) && password.equals(password)) {
            System.out.println("Login Successful. Welcome " + firstName + " " + lastName + ", " + "it is great to see you again.");
            
            //Part 2 of the ChatApp
            System.out.println("WELCOME TO QUICK CHAT");
          
            while(true) {
            System.out.println("\nMenu options");
            System.out.println("1. Send messages");
            System.out.println("2. Show recently send messages");
            System.out.println("3. Quit");
        
            System.out.print("Select an option: ");
            choice = input.nextInt();
            input.nextLine();
        
            if (choice == 1) {
                System.out.println("-Send messages-");
                
                while (true) {
                //Entering the recipient of the message's number
                System.out.print("Enter recipient cell number: ");
                recipient = input.nextLine();
                
                //Checking whether the recipients cell number meets the requirements
                length = recipient.length();
                if (recipient.startsWith("+27") && recipient.length() == 12) {
                    System.out.println("Cell number successfully saved");
                    break;
                } else {
                    System.out.println("Cell number must contain an international code and should be no more than 12 characters");
                }
                }
                
                //Entering the number of message that they would like to send
                System.out.print("How many messages would you like to send?: ");
                messageNumber = input.nextInt();
                
                System.out.print("\nEnter message (MAX 250 characters): ");
                message = input.nextLine();
                
                while (true) {
                length = message.length();
                if (message.length() <= 250) {
                    System.out.println("Message sent");
                    break;
                } else {
                    System.out.println("Please enter a message of less than 250 characters");
                }
                }
                //Auto generating the messageID
                long messageID = 10000000000L + (long)(Math.random() * 9000000000L);
                
                //Auto generating the messageHash
                 //Generating the first and last word of the sentence
                 String[] words = message.trim().split("\\s+");
                 String FirstWord = words[0].toUpperCase();
                 String LastWord = words[words.length - 1].toUpperCase();
                 
                 //Generating the first two numbers of the messageID
                 String firstTwo = String.valueOf(messageID).substring(0, 2);
                 String messageHash = firstTwo + ":" + messageNumber + ":" + FirstWord + LastWord;
                
                 //Message information
                System.out.println("Message ID: " + messageID);
                System.out.println("Message hash: " + messageHash);
                System.out.println("Recipient: " + recipient);
                System.out.println("Message: " + message);
                
                //Message system that the user decides what to do with the message that they have typed.
                System.out.println("\n-Message system:-");
                System.out.println("1. Send message");
                System.out.println("2. Disregard message (to delete a message)");
                System.out.println("3. Store message to send later");
        
                System.out.print("Select an option: ");
                int messageOption = input.nextInt();
                input.nextLine();
                
                if (messageOption == 1) {
                    System.out.println("Message successfully sent");
                    break;
                } else if (messageOption == 2) {
                    System.out.print("Press 0 to delete the message: ");
                    int pressed = 0;
                    if (pressed == 0) {
                        System.out.println("Message successfully deleted");
                        messageNumber--;
                    } else {
                        System.out.println("Message not successfully deleted");
                    }
                    break;
                } else if (messageOption == 3) {
                    System.out.println("Message successfully stored");
                    break;
                }
                
                //Storing the information that the user wants to store in a JSON file
                
            } else if (choice == 2) {
                System.out.println("Coming Soon.");
            } else if (choice == 3) {
                System.out.println("Goodbye.");
            } else {
                System.out.println("Invalid option. Try again.");
            }
            }
            } else {
                System.out.println("Username or password incorrect, please try again.");
            } 
            } 
        } else if (choice == 3) {
            System.out.println("Goodbye");
            break;
        } else {
            System.out.println("Invalid option!");
        }
        }
    }
}