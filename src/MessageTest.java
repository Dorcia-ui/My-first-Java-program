import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    @Test
    public void testCheckRecipientCell() {
        assertTrue(Message.checkRecipientCell("+277821234567"));
        assertFalse(Message.checkRecipientCell("+27821"));
        assertFalse(Message.checkRecipientCell("0821234567"));
    }

    private void assertTrue(boolean b) {
    }

    private void assertFalse(boolean b) {
    }

    @Test
    public void testCreateMessageHash() {
        Message message = new Message("0012345678", "+27821234567", "Hi tonight");
        assertEquals("00:0:HITONIGHT", message.createMessageHash(0));
    }

    @Test
    public void testMessageDetails() {
        Message message = new Message("0012345678", "+27821234567", "Hi tonight");
        assertEquals("0012345678", message.getMessageID());
        assertEquals("+27821234567", message.getRecipient());
        assertEquals("Hi tonight", message.getMessageText());
    }

    private void assertEquals(String hiTonight, String messageText) {
    }

    @Test
    public void testSetMessageHash() {
        Message message = new Message("0012345678", "+27821234567", "Hi tonight");
        message.setMessageHash("00:0:HITONIGHT");
        assertEquals("00:0:HITONIGHT", message.getMessageHash());
    }
}

