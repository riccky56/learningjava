package action;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Class declaration that groups the related example logic in one place.
public class javascriptdemo3 {

	static WebDriver driver;

	// Main method where program execution starts.
	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/");

		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.body.style.zoom='50%'");

		js.executeScript("document.body.style.zoom='80%'");

		js.executeScript("document.body.style.zoom='70%'");

		js.executeScript("document.body.style.zoom='90%'");

		// to move to end of document
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));

		WebElement ele = null;
		js.executeScript("windows.scrollIntoView(true)", ele);

		// to move till element visisble
		WebElement ele2 = driver.findElement(By.xpath("//*[normalize-space()='Community Poll']"));
		js.executeScript("arguments[0].scrollIntoView()", ele2);

	}

}
