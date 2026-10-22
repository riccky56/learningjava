package action;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// Class declaration that groups the related example logic in one place.
public class Svgelement {
	static WebDriver driver;

	@Test 
	public void method1() throws Exception
	{	

		driver= new ChromeDriver();

		driver.get("https://www.tutorialspoint.com/selenium/practice/login.php");
		
		
			Thread.sleep(2000);
		

		driver.findElement(By.xpath("//a[normalize-space()='Practice Form']//*[name()='svg']")).click();



		
	}

}
