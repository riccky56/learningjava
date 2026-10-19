package reporting;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;

	public static synchronized ExtentReports getInstance() {
		if (extent == null) {
			String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(0));
			ExtentSparkReporter spark = new ExtentSparkReporter("reports/Report_" + ts + ".html");
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Regression");
			spark.config().setTheme(Theme.STANDARD);
			extent = new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Java", System.getProperty("java.version"));
		}
		return extent;
	}
}
