package action;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowhandling {
     static WebDriver driver;
	public static void main(String[] args) {
			 driver = new ChromeDriver();

			driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

			driver.findElement(By.cssSelector(".blinkingText")).click();

			Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

			Iterator<String>it = windows.iterator();

			String parentId = it.next();

			String childId = it.next();

			driver.switchTo().window(childId);

			System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

			driver.findElement(By.cssSelector(".im-para.red")).getText();

			String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

			driver.switchTo().window(parentId);

			driver.findElement(By.id("username")).sendKeys(emailId);
	}

}
