package Testng;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	protected WebDriver driver;
	protected static final String BASE_URL = "https://www.saucelabs.com";

	@BeforeClass
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-dev-shm-usage");

		// Capture detailed ChromeDriver startup logs for SessionNotCreated debugging.
		ChromeDriverService service = new ChromeDriverService.Builder()
				.withLogFile(new File("target/chromedriver.log"))
				.withVerbose(true)
				.build();

		driver = new ChromeDriver(service, options);
		driver.get(BASE_URL);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}