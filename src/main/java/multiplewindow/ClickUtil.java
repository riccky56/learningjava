package multiplewindow;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickUtil {

	    private static final int TIMEOUT_SECONDS = 15;
	    private static final int MAX_RETRIES = 3;

	    // Add your app's spinners/overlays here
	    private static final By[] OVERLAYS = {
	        By.cssSelector(".loader"),
	        By.cssSelector(".spinner"),
	        By.cssSelector(".modal-backdrop")
	    };

	    private final WebDriver driver;
	    private final WebDriverWait wait;

	    public ClickUtil(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
	        this.wait.ignoring(StaleElementReferenceException.class);
	    }

	    public void click(By locator) {
	        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
	            try {
	                waitForOverlaysToDisappear();

	                // Re-locates on every attempt, so staleness is avoided
	                WebElement element = wait.until(
	                        ExpectedConditions.elementToBeClickable(locator));
	                element.click();
	                return;                                   // success

	            } catch (StaleElementReferenceException e) {
	                log("Stale element, retry " + attempt + " for " + locator);

	            } catch (ElementClickInterceptedException e) {
	                log("Click intercepted, retry " + attempt + " for " + locator);
	                scrollToCenter(locator);
	                if (attempt == MAX_RETRIES) {
	                    log("Falling back to JS click for " + locator);
	                    jsClick(locator);
	                    return;
	                }

	            } catch (ElementNotInteractableException e) {
	                log("Not interactable, retry " + attempt + " for " + locator);
	                scrollToCenter(locator);

	            } catch (TimeoutException e) {
	                // Element never became clickable within the timeout. Don't retry.
	                throw new NoSuchElementException(
	                        "Element not clickable within " + TIMEOUT_SECONDS
	                        + "s: " + locator, e);
	            }
	        }
	        throw new RuntimeException(
	                "Could not click " + locator + " after " + MAX_RETRIES + " attempts");
	    }

	    private void waitForOverlaysToDisappear() {
	        // Short wait: if no overlay exists we don't want to slow every click
	        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
	        for (By overlay : OVERLAYS) {
	            try {
	                shortWait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
	            } catch (TimeoutException ignored) {
	                // Overlay still visible, the click retry logic will deal with it
	            }
	        }
	    }

	    private void scrollToCenter(By locator) {
	        try {
	            WebElement el = driver.findElement(locator);
	            ((JavascriptExecutor) driver).executeScript(
	                    "arguments[0].scrollIntoView({block:'center', inline:'center'});", el);
	        } catch (WebDriverException ignored) { }
	    }

	    private void jsClick(By locator) {
	        WebElement el = driver.findElement(locator);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
	    }

	    private void log(String msg) {
	        System.out.println("[ClickUtil] " + msg);   // swap for Log4j/SLF4J
	    }
	}
}
