package pagepatterns;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testclass {
	WebDriver driver;

	@Test
	public void validLogin() {
		DashboardPage dashboard = new LoginPage(driver)
				.enterUsername("rahul")
				.enterPassword("secret123")
				.clickLogin(); // chain
																														// now
																														// continues
																														// on
																														// DashboardPage

		Assert.assertTrue(dashboard.isWelcomeVisible());
	}

	@Test
	public void invalidLoginShowsError() {

		String msg = new LoginPage(driver).enterUsername("rahul").enterPassword("wrong").clickLoginExpectingFailure()
				.getErrorMessage();

		Assert.assertEquals(msg, "Invalid credentials");
	}
}
