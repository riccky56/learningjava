package action;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// Class declaration that groups the related example logic in one place.
public class mouseaction {
	public static WebDriver driver;
	// Main method where program execution starts.
	public static void main(String[] args) throws Exception {
		
		 driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
        
		Actions act = new Actions(driver);
		act.moveToElement(desktop).moveToElement(mac).build().perform();
		
		act.contextClick(mac);
		act.doubleClick(desktop);
		
		//ctrl +A
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		//ctrl +C
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		//ctrl + V
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
	}

}
