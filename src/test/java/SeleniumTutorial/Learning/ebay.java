package SeleniumTutorial.Learning;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

// Class declaration that groups the related example logic in one place.
public class ebay {
	public static WebDriver driver;

	@Test
	// Helper method used to perform a specific part of the program logic.
	public static void start() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");

		List<WebElement> allopt = driver.findElements(By.xpath("//ul[@class='_1sFryS _2x2Mmc']/li/div"));

		ArrayList suggestionscreen = new ArrayList(); // store the webelements in the arraylist

		for (WebElement option : allopt) // iterate for every element get the text and add in the list
		{
			// Add the current value into the collection.
			suggestionscreen.add(option.getText());

			// Check the condition before deciding whether this block should run.
			if (option.getText().equalsIgnoreCase("mobile homes for sale")) {
				option.click();
				break;
			}
		}
		// Display information to the console for the user.
		System.out.println(suggestionscreen);
		// Display information to the console for the user.
		System.out.println(allopt);
		driver.close();

	}

	// Helper method used to perform a specific part of the program logic.
	public static void close() {
		driver.close();
	}

}
