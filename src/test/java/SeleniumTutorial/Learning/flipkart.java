package SeleniumTutorial.Learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagesfortest.flipkartbrowser;

public class flipkart extends flipkartbrowser{

	
	@BeforeClass
	public void start() {
		flipkartbrowser.startBrowser();
	}
	
	
	@Test
	
	public void teststart() throws Exception {
		
		driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
		
		driver.findElement(By.xpath("//div[@class='I-qZ4M vLRlQb']/input")).sendKeys("9131042507");
		driver.findElement(By.xpath("(//*[normalize-space()='Request OTP'])[1]")).click();
		
		Thread.sleep(9000);
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")); 
		Thread.sleep(2000);
		search.sendKeys("Samsung s22");
		Thread.sleep(2000);
		search.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
//		List<WebElement> allopt= driver.findElements(By.xpath("//ul[@class='_1sFryS _2x2Mmc']/li/div"));
//	
//		ArrayList suggestionscreen = new ArrayList();             //store the webelements in the arraylist 

//		for( WebElement option : allopt)               //iterate for every element get the text and add in the list
//		{
//			suggestionscreen.add(option.getText());	
//		/*   
//			if(option.getText().equalsIgnoreCase("mobile homes for sale")) {
//				option.click();
//				break;
//			}  */	
//		}
//		System.out.println(suggestionscreen);
//		System.out.println(allopt);
//		driver.close();
		
		driver.findElement(By.xpath("//div[text()='Samsung Galaxy S22 5G (Phantom Black, 128 GB)']")).click();
		String parentid  = driver.getWindowHandle();
		
		Set<String> childid  = driver.getWindowHandles();
		
		System.out.println(parentid);
		
		System.out.println(childid);
		
		for(String handle:childid) {
		if(!handle.equalsIgnoreCase(parentid))
			{
			driver.switchTo().window(handle);
		}}
		
		driver.findElement(By.id("pincodeInputId")).sendKeys("411057");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='QqFHMw zA2EfJ _7Pd1Fp']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//*[@type='radio'])[3]")).click();
		
		
		
		 
	}

}
