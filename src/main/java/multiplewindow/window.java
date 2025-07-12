package multiplewindow;

import java.util.Set; 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor; 
import org.openqa.selenium.Keys; 
import org.openqa.selenium.Point; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.interactions.Actions; 

public class window {

	public static void main(String[] args) throws Exception {

		// Step 1: Open LinkedIn login page
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.linkedin.com/login");

		// Step 2: Store the parent window handle
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window Handle: " + parentWindow);

		// Step 3: Click on the "Sign in with Google" button
		driver.findElement(By.xpath("//button[text()='Sign in with Google']")).click();

		// Step 4: Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("All Window Handles: " + allWindowHandles);
         		// Step 5: Iterate through the window handles and switch to the child window (Google login window)
		for (String windowHandle : allWindowHandles) {
			if (!windowHandle.equals(parentWindow)) {
				// Switch to Google login window
				driver.switchTo().window(windowHandle);
				System.out.println("Switched to Google Login Window");

				// Step 6: Perform actions in the Google login window (e.g., enter email and password)
				driver.findElement(By.id("identifierId")).sendKeys("rahulraftaar885@gmail.com");
				driver.findElement(By.xpath("//span[text()='Next']")).click();

				// Assuming you have a wait to handle loading and next steps, you would perform further login steps here
				break;
			}
		}

		// Step 7: After completing the Google login, switch back to the LinkedIn window
		driver.switchTo().window(parentWindow);
		System.out.println("Switched back to Parent Window");
	}
}