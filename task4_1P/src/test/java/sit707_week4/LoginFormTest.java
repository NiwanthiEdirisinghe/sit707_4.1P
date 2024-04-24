package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "223558537";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Niwanthi";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	/*
	 * Write more test functions below.
	 */
    @Test
    public void testEmptyUsernameAndPassword() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse("Login should fail with empty username and password", status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameAndWrongPassword() {
        LoginStatus status = LoginForm.login(null, "wrong_password");
        Assert.assertFalse("Login should fail with empty username", status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameAndCorrectPassword() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse("Login should fail with empty username", status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testWrongUsernameAndCorrectPassword() {
        LoginStatus status = LoginForm.login("wrong_username", "ahsan_pass");
        Assert.assertFalse("Login should fail with wrong username", status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameAndCorrectPassword() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue("Login should succeed with correct username and password", status.isLoginSuccess());
    }

    @Test
    public void testCorrectUsernameAndCorrectPasswordAndWrongValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue("Login should succeed with correct username and password", status.isLoginSuccess());

        boolean validationResult = LoginForm.validateCode("wrong_code");
        Assert.assertFalse("Validation code should fail", validationResult);
    }

    @Test
    public void testCorrectUsernameAndCorrectPasswordAndCorrectValidationCode() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue("Login should succeed with correct username and password", status.isLoginSuccess());

        boolean validationResult = LoginForm.validateCode("123456");
        Assert.assertTrue("Validation code should pass", validationResult);
    }

    @Test
    public void testEmptyUsernameAndDontCarePasswordAndDontCareValidationCode() {
        LoginStatus status = LoginForm.login(null, null);
        Assert.assertFalse("Login should fail with empty username", status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameAndWrongPasswordAndDontCareValidationCode() {
        LoginStatus status = LoginForm.login(null, "wrong_password");
        Assert.assertFalse("Login should fail with empty username", status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameAndCorrectPasswordAndDontCareValidationCode() {
        LoginStatus status = LoginForm.login(null, "ahsan_pass");
        Assert.assertFalse("Login should fail with empty username", status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testWrongUsernameAndDontCarePasswordAndDontCareValidationCode() {
        LoginStatus status = LoginForm.login("wrong_username", "dont_care_password");
        Assert.assertFalse("Login should fail with wrong username", status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }
}
