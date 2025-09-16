package learning_selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class autosuggestivedropdown {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		

		driver=new ChromeDriver();
	
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("autosuggest")).sendKeys("ind");

		Thread.sleep(3000);

		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); //in css   "parent space child"

		for(WebElement option :options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();

				break; // to come out of the loop once the condition is satisfied
			}
		}
		
		driver.close();
	}
}
