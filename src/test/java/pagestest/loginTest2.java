package pagestest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagesfortest.Browsersetup;
import pagesfortest.loginpage;

// Class declaration that groups the related example logic in one place.
public class loginTest2 extends Browsersetup{

	//static WebDriver driver;



    @BeforeClass
	public  void setup(){
		//driver = new ChromeDriver(); if no driver is assigned from browser2 or any other class
		Browsersetup.startBrowser();
		//driver.get("https://www.saucedemo.com/");
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();

	}


	@Test(
			retryAnalyzer = pagesfortest.Retry1.class,
			description = "This test case is to verify login functionality with valid credentials"
	)
	public void first() {
        
		loginpage log = new loginpage(driver);
		
		//log.loginAs("standard_user", "secret_sauce"); //calling all method in one method in POM
		
		log.enterusername("standard_user");
		log.enterpassword("secret_sauce");
		
		log.loginbutton();

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			try {
				driver.quit();
			} finally {
				driver = null;
			}
		}
	}

}
