package Testng;

import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HardandSoftAsserts {

	@Test(enabled = true, // Enable/disable test
			priority = 1, // Execution priority (lower runs first)
			timeOut = 5000, // Timeout in milliseconds
			groups = { "smoke", "regression" }, // Test groups
			dependsOnMethods = { "testLogin" }, // Dependency on other methods
			description = "Login test" // Test description
	)
	public void testLoginWithCredentials() {
		// test code
	}

	@Test
	public void hardAssertions() {
		String actualTitle = "Welcome to Automation";
		String expectedTitle = "Welcome to Automation";

		// Assert equals
		Assert.assertEquals(actualTitle, expectedTitle);

		// Assert not equals
		Assert.assertNotEquals(actualTitle, "Login Page");

		// Assert true/false
		Assert.assertTrue(true);
		Assert.assertFalse(false);

		// Assert null/not null
		Assert.assertNull(null);
		Assert.assertNotNull("value");

		// Assert with message (shown if assertion fails)
		Assert.assertEquals(actualTitle, expectedTitle,
				"Title mismatch: expected '" + expectedTitle + "' but got '" + actualTitle + "'");
	}

	@Test
	public void softAssertions() {
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals("John", "John"); // Pass
		softAssert.assertEquals("Age 30", "Age 25"); // Fail (test continues)
		softAssert.assertTrue(true); // Pass
		softAssert.assertFalse(true); // Fail (test continues)

		// IMPORTANT: Call assertAll() at the end to report all failures
		softAssert.assertAll(); // Now test fails if any assertion failed

		// Interview Tip: "Hard assertions fail immediately and stop execution.
		// Soft assertions collect all failures and report them at the end using
		// assertAll().
		// Use hard assertions for critical checks, soft for validating multiple UI
		// elements."
	}
}
