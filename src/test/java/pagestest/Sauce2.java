package pagestest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pagesfortest.Browsersetup;

@Test(singleThreaded = true)
public class Sauce2 {
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeMethod(alwaysRun = true)
	public void start() {
		driver = Browsersetup.createBrowser();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test(invocationCount = 2)
	public void LoginPage() {
		login();
		String heading = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector(".title"))).getText();
		Assert.assertEquals(heading, "Products");
	}

	@Test(retryAnalyzer = pagesfortest.Retry1.class)
	public void secondtest() {
		login();
		logoutAndVerify();
	}

	@Test
	public void thirdtest() {
		login();
		logoutAndVerify();
	}

	private void login() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")))
				.sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
	}

	private void logoutAndVerify() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("login-button"))).isDisplayed(), "Login form should appear after logout");
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}

	@AfterMethod(alwaysRun = true)
	public void cleanupMethod() {
		if (driver != null) {
			try {
				driver.quit();
			} finally {
				driver = null;
				wait = null;
			}
		}
	}
}
