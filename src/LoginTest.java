import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.junit.Test;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testCheckUserName_Correct() {
        // Test Data: kyl_1 (Contains underscore and <= 5 characters)
        boolean result = login.checkUserName("kyl_1");
        assertTrue(result, "Username should be correctly formatted.");
    }

    @Test
    public void testCheckUserName_Incorrect() {
        // Test Data: kyle!!!!!!! (No underscore and too long)
        boolean result = login.checkUserName("kyle!!!!!!!");
        assertFalse(result, "Username should be incorrectly formatted.");
    }

    @Test
    public void testPasswordComplexity_Success() {
        // Test Data: Ch&&sec@ke99! (Meets all requirements)
        boolean result = login.checkPasswordComplexity("Ch&&sec@ke99!");
        assertTrue(result, "Password should meet complexity requirements.");
    }

    @Test
    public void testPasswordComplexity_Failure() {
        // Test Data: password (Too short, no caps, no special chars)
        boolean result = login.checkPasswordComplexity("password");
        assertFalse(result, "Password should not meet complexity requirements.");
    }

    @Test
    public void testCellPhoneNumber_Correct() {
        // Test Data: +27838968976 (Correct international format)
        boolean result = login.checkCellPhoneNumber("+27838968976");
        assertTrue(result, "Cell phone number should be correctly formatted.");
    }

    @Test
    public void testCellPhoneNumber_Incorrect() {
        // Test Data: 08966553 (Missing international code)
        boolean result = login.checkCellPhoneNumber("08966553");
        assertFalse(result, "Cell phone number should be incorrectly formatted.");
    }
}

