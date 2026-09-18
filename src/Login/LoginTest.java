import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginTest {
    @Test
    public void testUserNameCorrect() {
        Login l = new Login("kyl_1","Ch&&sec@ke99!","+27838888888","Kyle","Smith");
        assertTrue(l.checkUserName());
    }
    @Test
    public void testUserNameIncorrect() {
        Login l = new Login("kyle!!!!!!!","Ch&&sec@ke99!","+27838888888","Kyle","Smith");
        assertFalse(l.checkUserName());
    }
    @Test
    public void testPasswordComplexityCorrect() {
        Login l = new Login("kyl_1","Ch&&sec@ke99!","+27838888888","Kyle","Smith");
        assertTrue(l.checkPasswordComplexity());
    }
    @Test
    public void testPasswordComplexityIncorrect() {
        Login l = new Login("kyl_1","password","+27838888888","Kyle","Smith");
        assertFalse(l.checkPasswordComplexity());
    }
    @Test
    public void testCellPhoneNumberCorrect() {
        Login l = new Login("kyl_1","Ch&&sec@ke99!","+27838888888","Kyle","Smith");
        assertTrue(l.checkCellPhoneNumber("+27838888888"));
    }
    @Test
    public void testCellPhoneNumberIncorrect() {
        Login l = new Login("kyl_1","Ch&&sec@ke99!","08966553","Kyle","Smith");
        assertFalse(l.checkCellPhoneNumber("08966553"));
    }
}
