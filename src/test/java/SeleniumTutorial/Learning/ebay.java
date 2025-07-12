package SeleniumTutorial.Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class ebay {
	public static WebDriver driver;
	 
	
	public static void start() {
		
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	}
	

	public static void close() {
		driver.close();
}}
