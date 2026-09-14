package Testng;

import org.testng.annotations.*;

public class LoginTest2 extends BaseTest {

	private LoginPage loginPage;

	@BeforeClass
	public void setUpTest() {
		super.setUp();
		loginPage = new LoginPage(driver);
	}

	@Test(dataProvider = "loginCredentials")
	public void testValidLogin(String email, String password) {
		loginPage.login(email, password);
		// Assert successful login
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void flakeyTest() {
		// Test that might fail occasionally
	}

	@DataProvider(name = "loginCredentials")
	public Object[][] getLoginData() {
		return new Object[][] { { "user@example.com", "password123" }, { "another@example.com", "password456" } };
	}

	@AfterClass
	public void tearDownTest() {
		super.tearDown();
	}
}