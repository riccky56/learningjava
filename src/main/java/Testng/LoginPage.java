package Testng;

//LoginPage.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	// Locators using @FindBy
	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//button[contains(text(), 'Login')]")
	private WebElement loginButton;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Methods
	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(emailField));
		emailField.clear();
		emailField.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public void login(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickLogin();
	}
}
