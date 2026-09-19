
package pagesfortest;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

// Class declaration that groups the related example logic in one place.
public class Browsersetup {


	public static WebDriver driver;


	// Helper method used to perform a specific part of the program logic.
	public static void startBrowser(){
		driver = createBrowser();
	}

	// Return an independent session without changing the legacy shared driver.
	public static WebDriver createBrowser() {
		Path logFile;
		try {
			Path logDirectory = Files.createDirectories(Path.of("target", "chromedriver-logs"));
			logFile = Files.createTempFile(logDirectory, "chromedriver-", ".log").toAbsolutePath();
		} catch (IOException e) {
			throw new UncheckedIOException("Cannot create ChromeDriver log file", e);
		}

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		ChromeDriverService service = new ChromeDriverService.Builder()
				.withLogFile(logFile.toFile())
				.withVerbose(true)
				.build();

		WebDriver browser;
		try {
			browser = new ChromeDriver(service, options);
		} catch (SessionNotCreatedException e) {
			service.stop();
			throw new SessionNotCreatedException("Chrome could not start. See " + logFile
					+ ". Check chrome://policy: RemoteDebuggingAllowed=false blocks ChromeDriver"
					+ "; ask your administrator to permit automation if this policy is enforced.", e);
		}
		try {
			browser.get("https://www.saucedemo.com/");
			return browser;
		} catch (RuntimeException e) {
			try {
				browser.quit();
			} catch (RuntimeException cleanupError) {
				e.addSuppressed(cleanupError);
			}
			throw e;
		}
	}
}

