package calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class mmt {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();
        driver.manage().window().maximize();
		//Is displayed is used when particular object is in code base but it is in visible mode or not

		driver.get("http://www.makemytrip.com/");
		Thread.sleep(3000);
		//driver.findElement(By.className("commonModal__close")).click();

		System.out.println(" Before clikcing on Multi city Radio button");

		System.out.println(driver.findElement(By.xpath("[//*[@id='return']")).isDisplayed());

		//driver.findElement(By.xpath(".//*[@id='multi_city_button']/span")).click();

		//driver.findElement(By.xpath(".//*[@id='multi_city_button']/span")).isEnabled();

		System.out.println(" After clikcing on Multi city Radio button");

		driver.findElement(By.xpath(".//*[@id='start_date_sec']/span[3]")).click();

		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[5]/td[3]/a")).click();

		int i=0;

		while(i<5)

		{

			driver.findElement(By.xpath(".//*[@id='adult_count']/a[2]")).click();

			i++;

		}

		//System.out.println(driver.findElement(By.xpath(".//*[@id='return_date_sec']")).isDisplayed());

		//System.out.println(driver.findElement(By.xpath(".//*[@id='mui_city_button']/span")).isDisplayed());

		Thread.sleep(3000L);

		//System.out.println(driver.findElement(By.xpath(".//*[@id='responsive_bottom']/div[2]/div[1]/div/div/h3")).getText());

		//If you want to validate the object which is present in web page or code base

		int count=driver.findElements(By.xpath(".//*[@id='mui_city_button']/span")).size();

		if (count==0)

		{

			System.out.println("verified");

		}
	}
}
