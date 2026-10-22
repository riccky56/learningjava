package action;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class shadow {
	static WebDriver driver;

	// Main method where program execution starts.
	public static void main(String[] args) throws IOException, InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://google.com");
		driver.manage().window().maximize();

		SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();

		shadow.findElement(By.cssSelector("#shadow-element"));

		// multiple shadow dom

		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		
			Thread.sleep(2000);
		
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		
		Thread.sleep(2000);
		shadow1.findElement(By.cssSelector("#nested-shadow-element"));

		
	}

}
