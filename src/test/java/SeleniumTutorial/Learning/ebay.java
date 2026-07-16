package SeleniumTutorial.Learning;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ebay {
	public static WebDriver driver;

	@Test
	public static void start() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");

		List<WebElement> allopt = driver.findElements(By.xpath("//ul[@class='_1sFryS _2x2Mmc']/li/div"));

		ArrayList suggestionscreen = new ArrayList(); // store the webelements in the arraylist

		for (WebElement option : allopt) // iterate for every element get the text and add in the list
		{
			suggestionscreen.add(option.getText());

			if (option.getText().equalsIgnoreCase("mobile homes for sale")) {
				option.click();
				break;
			}
		}
		System.out.println(suggestionscreen);
		System.out.println(allopt);
		driver.close();

	}

	public static void close() {
		driver.close();
	}

}
