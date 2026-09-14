package Testng;

import org.testng.annotations.*;

public class TestNGBasics {

	    @BeforeSuite
	    public void setupSuite() {
	        System.out.println("Suite setup - runs once before all tests");
	    }

	    @BeforeTest
	    public void setupTest() {
	        System.out.println("Test setup - before all methods in this class");
	    }

	    @BeforeClass
	    public void setupClass() {
	        System.out.println("Class setup - before all methods");
	    }

	    @BeforeMethod
	    public void setupMethod() {
	        System.out.println("Method setup - before each test");
	    }

	    @Test
	    public void testOne() {
	        System.out.println("Test 1 executing");
	    }

	    @Test
	    public void testTwo() {
	        System.out.println("Test 2 executing");
	    }

	    @AfterMethod
	    public void teardownMethod() {
	        System.out.println("Method teardown - after each test");
	    }

	    @AfterClass
	    public void teardownClass() {
	        System.out.println("Class teardown");
	    }

	    @AfterTest
	    public void teardownTest() {
	        System.out.println("Test teardown");
	    }

	    @AfterSuite
	    public void teardownSuite() {
	        System.out.println("Suite teardown - runs once after all tests");
	    }

	 // Apply to test
	    public class RetryableTests {
	        @Test(retryAnalyzer = RetryAnalyzer.class)
	        public void flakeyTest() {
	            // Test that might fail occasionally
	        }
	    }
	}
