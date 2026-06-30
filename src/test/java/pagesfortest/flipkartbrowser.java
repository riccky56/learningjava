package pagesfortest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkartbrowser {

	public static WebDriver driver;


	public static void startBrowser()
	{
		
		driver = new ChromeDriver();

		//driver = new FirefoxDriver();

		//driver = new EdgeDriver();
		
	
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
}

