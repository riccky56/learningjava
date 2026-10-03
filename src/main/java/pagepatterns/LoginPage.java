package pagepatterns;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//fluent page or fluent interface patter same can be explained in fluent builder patterns
	public class LoginPage {
	    private final WebDriver driver;
	    private final WebDriverWait wait;
	    private final By username = By.id("username");
	    private final By password = By.id("password");
	    private final By loginBtn = By.id("login");
	    private final By error    = By.cssSelector(".error-msg");

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    public LoginPage enterUsername(String user) {          // same page → this
	        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
	        return this;
	    }

	    public LoginPage enterPassword(String pass) {          // same page → this
	        driver.findElement(password).sendKeys(pass);
	        return this;
	    }

	    public DashboardPage clickLogin() {                    // navigates → new page
	        driver.findElement(loginBtn).click();
	        return new DashboardPage(driver);
	    }

	    public LoginPage clickLoginExpectingFailure() {        // stays on login page
	        driver.findElement(loginBtn).click();
	        return this;
	    }

	    public String getErrorMessage() {                      // returns data, ends the chain
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(error)).getText();
	    }
	}
}
