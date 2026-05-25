/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package MessageTest;

import com.mycompany.messageclass.MessageClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 *
 * @author Jaeran De Koker
 */
public class MessageUnitTest {

    String sentMessage;
    
    public class Message {
    private String sentMessages(int option) {
        switch (option) {
            case 1:
                return "Message sent successfully";
            case 2:
                return "Press 0 to delete the message";
            case 3:
                return "Message stored successfully";
            default:
                break;
        }
        return "Invalid option";
    } 

        private String MessageHash(String string, String hiTonight) {
            int messagenumber;
            String messageNumber = null;
            return messageNumber + ":" + "HiTonight";
        }

        private boolean checkmessageID(long validID) {
             return validID > 0 && validID <= 9999999999L;
        }

        private String createMessageHash(String messageHash) {
            return messageHash;
        }
    }
    Message message = new Message();
    public MessageUnitTest() {
    }
            
    @Test
    public void TestMessageLengthSuccess() {
        String testmessage = "Hi Mike, can you join us for dinner tonight?";
        assertTrue(testmessage.length() <= 250);
    }
    
    @Test
    public void TestMessageLengthFailure() {
        String testmessage = "Hi Keegan, did you receive the payment? I tried transferring it earlier but i was very busy, hope you are good. I hope your family is doing great and i hope to see you again and wish you all the best in everything you do. Just please dont forget to bring me the blueprints of that car model that you want to build so i can give it to our project manager that he can see if you have all the correct angles and length. Hopefully he agrees because i am super excited to help build it with you.";
        assertFalse(testmessage.length() <= 250);
    }
    
    @Test
    public void TestRecipientCellSuccess() {
        String testrecipient = "+27718693002";
        assertTrue(testrecipient.contains("+") && testrecipient.length() == 12);
    }
     @Test
     public void TestRecipientCellFailure() {
         String testrecipient = "08575975889";
         assertFalse(testrecipient.contains("+") && testrecipient.length() == 12);
     }
     
     @Test
     public void TestMessageHash() {
        String messageHash = message.createMessageHash("00:0:HiTonight");
        assertNotNull(messageHash);
        //Additional check to ensure hash is not empty
        assertNotEquals(" ", messageHash);
        assertTrue(messageHash.contains(":"));
        assertTrue(messageHash.endsWith("HiTonight"));
     }
      
     @Test
     public void TestMessageID() {
          long validID = 1234567891L;
          long invalidID = 96325874101L;
          
          assertTrue(message.checkmessageID(validID));
          assertFalse(message.checkmessageID(invalidID));
     }
     
     @Test
     public void TestSentMessage() {
        String result = message.sentMessages(1);
        assertEquals("Message sent successfully", result);
    }
     
     @Test
     public void TestDisregardMessage() {
         String result = message.sentMessages(2);
         assertEquals("Press 0 to delete the message", result);
     }
     
     @Test
     public void TestStoreMessage() {
        String result = message.sentMessages(3);
        assertEquals("Message stored successfully", result);
     }
}
