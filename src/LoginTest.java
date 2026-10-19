import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LoginTest {

    // 1. Username tests

    @Test
    public void testUserNameCorrect() {
        Login l = new Login("kyl_1", "Ch&&sec@ke99!",
                "+27838888888", "Kyle", "Smith");

        assertEquals(true, l.checkUserName());
    }

    @Test
    public void testUserNameIncorrect() {
        Login l = new Login("kyle!!!!!!!", "Ch&&sec@ke99!",
                "+27838888888", "Kyle", "Smith");

        assertEquals(false, l.checkUserName());
    }

    // 2. Password tests

    @Test
    public void testPasswordComplexityCorrect() {
        Login l = new Login("kyl_1", "Ch&&sec@ke99!",
                "+27838888888", "Kyle", "Smith");

        assertEquals(true, l.checkPasswordComplexity());
    }

    @Test
    public void testPasswordComplexityIncorrect() {
        Login l = new Login("kyl_1", "password",
                "+27838888888", "Kyle", "Smith");

        assertEquals(false, l.checkPasswordComplexity());
    }

    // 3. Cellphone number tests

    @Test
    public void testCellPhoneNumberCorrect() {
        Login l = new Login("kyl_1", "Ch&&sec@ke99!",
                "+27838888888", "Kyle", "Smith");

        assertEquals(true, l.checkCellPhoneNumber("+27838888888"));
    }

    @Test
    public void testCellPhoneNumberIncorrect() {
        Login l = new Login("kyl_1", "Ch&&sec@ke99!",
                "08966553", "Kyle", "Smith");

        assertEquals(false, l.checkCellPhoneNumber("08966553"));
    }

    // 4. Registration tests

    @Test
    public void testRegisterUserSuccess() {
        Login l = new Login("kyl_1", "Ch&&sec@ke99!",
                "+27838888888", "Kyle", "Smith");

        assertEquals("User has been registered successfully.",
                l.registerUser());
    }

    @Test
    public void testRegisterUserInvalidUsername() {
        Login l = new Login("kyle!!!!!!!", "Ch&&sec@ke99!",
                "+27838888888", "Kyle", "Smith");

        assertEquals(
                "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.",
                l.registerUser());
    }

    @Test
    public void testRegisterUserInvalidPassword() {
        Login l = new Login("kyl_1", "password",
                "+27838888888", "Kyle", "Smith");

        assertEquals(
                "Password is not correctly formatted, please ensure that your password contains at least 8 characters, a capital letter, a number and a special character.",
                l.registerUser());
    }

    @Test
    public void testRegisterUserInvalidCellPhone() {
        Login l = new Login("kyl_1", "Ch&&sec@ke99!",
                "08966553", "Kyle", "Smith");

        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain an international code.",
                l.registerUser());
    }

    // 5. Login tests

    @Test
    public void testLoginUserSuccess() {
        Login l = new Login("kyl_1", "Ch&&sec@ke99!",
                "+27838888888", "Kyle", "Smith");

        assertEquals(true, l.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginUserFailure() {
        Login l = new Login("kyl_1", "Ch&&sec@ke99!",
                "+27838888888", "Kyle", "Smith");

        assertEquals(false, l.loginUser("kyl_1", "wrongPassword"));
    }

    // 6. Login status tests

    @Test
    public void testReturnLoginStatusSuccess() {
        Login l = new Login("kyl_1", "Ch&&sec@ke99!",
                "+27838888888", "Kyle", "Smith");

        assertEquals(
                "Welcome Kyle Smith it is great to see you again.",
                l.returnLoginStatus("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testReturnLoginStatusFailure() {
        Login l = new Login("kyl_1", "Ch&&sec@ke99!",
                "+27838888888", "Kyle", "Smith");

        assertEquals(
                "Username or password incorrect, please try again.",
                l.returnLoginStatus("kyl_1", "wrongPassword"));
    }
}