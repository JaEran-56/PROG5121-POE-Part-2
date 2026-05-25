/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.messageclass;

/**
 *
 * @author Jaeran De Koker
 */
import java.util.ArrayList;
import java.util.Scanner;

public class MessageClass {
    public static void main(String[] args) {
        MessageClass mc = new MessageClass();
    }
    
    int messageNumber;
    String JSON_FILE;
    
    public boolean checkMessageID(String messageID) {
        if (messageID.length() <= 10) {
            return String.valueOf(messageID).length() <= 10;
        } else {
            return false;
        }
    }
    //Checking the cell number rrequirements
    public boolean checkRecipientCell(String recipient) {
        if (recipient.startsWith("+27") && recipient.length() == 12) {
            return recipient.startsWith("+27") && recipient.length() == 12;
        } else {
        return false;
        }
    }
    
    public String createMessagehash(String messageHash) {
        return messageHash;        
    }
    
    public String SentMessages(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println("Message option:");
        System.out.println("1. Send message");
        System.out.println("2. Disregard message (to delete a message)");
        System.out.println("3. Store message to send later");
        
        System.out.print("Select an option: ");
        int option = input.nextInt();
        if (option == 1) {
            return "Message sent successfully";
        } else if (option == 2) {
            return "Press 0 to delete the message";
        } else if (option == 3) {
            return "Message stored successfully";
        }
        return "Invalid option";
    } 
    
    public String printMessages() {
        String allMessages = "";
        Iterable<String> sentMessages = null;
        
        for (String message : sentMessages) {
            allMessages += message + "\n";
        }
        return allMessages;
    }
    
    public int returnTotalMessages() {
        return messageNumber;
    }
    
    public void storeMessages() {
        int messageID = 0;
        String MessageHash = null;
        int recipientCell = 0;
        String message = null;
         
        
        String jsonMessage = "{\n" + 
                "\"MessageID\": \"" + 
                messageID + "\",\n" +
                "\"MessageHash\": \"" +
                MessageHash +
                "\",\n" +
                "\"Recipient\": \"" +
                recipientCell + "\",\n" +
                "\"Message\": \"" +
                message + "\",\n" +
                "}";
        
        System.out.println("\nStored JSON Message: ");
        System.out.println(jsonMessage);
    }
    
}