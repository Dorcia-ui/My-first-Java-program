import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Message {
    // private controls who are allowed to access these variables directly.
    private String messageID;
    private String recipient;
    private String messageText;
    private String messageHash;
    // put the value we received into this "object" such as messageID variable.
    public Message(String messageID, String recipient, String messageText) {
        this.messageID = messageID;
        this.recipient = recipient;
        this.messageText = messageText;
    }
    //the getters allow another class to retrieve information from the Message object.
    public String getMessageID() {
        return messageID;
    }
    public String getRecipient() {

        return recipient;
    }
    public String getMessageText() {

        return messageText;
    }
    public String getMessageHash() {
        return messageHash;
    }
    public void setMessageHash (String messageHash) {
        this.messageHash= messageHash;
    }
    public static boolean checkRecipientCell(String recipient ) {
        return recipient.startsWith("+27") && recipient.length() <= 12;
    }
    public String createMessageHash (int messageNumber) {
        String firstTwoDigits = messageID. substring(0, 2);
        String[] words = messageText . trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        return firstTwoDigits + ":" + messageNumber  + ":" + firstWord + lastWord. toUpperCase();
    }
    public String storeMessage() {
        Gson gson = new Gson ();
        try{
            Path path = Path.of("message.json");
            ArrayList<Message> storedMessages = new ArrayList<> ();
            if(Files.exists(path)) {
                String json = Files.readString(path);
                if (! json.trim().isEmpty() && json.trim().equals("[]")) {
                    Message[] existingMessages = gson.fromJson(json, Message[].class);
                    if(existingMessages != null) {
                        storedMessages.addAll(Arrays.asList(existingMessages));
                    }
                }
            }
            storedMessages.add(this);
            try(FileWriter writer  = new FileWriter("messages.json")) {
                gson.toJson(storedMessages, writer);
            }
            return "Message successfully stored.";
        } catch(IOException e) {
            return "Error storing message. ";
        }
    }

}

















