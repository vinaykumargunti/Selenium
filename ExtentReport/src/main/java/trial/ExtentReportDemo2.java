package trial;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import screenshot.Utility;

public class ExtentReportDemo2 {
	// Create global variable which will be used in all method
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;

	// This code will run before executing any testcase
	@BeforeMethod
	public void setup() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Report/report.html");

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		logger = extent.createTest("LoginTest");
	}

	// Actual Test which will start the application and verify the title
	@Test
	public void loginTest() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		extent.createTest("Testing Started");
		logger.log(Status.PASS, "Succesfully Accepting url");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("fb");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class='jKWzZXdEJWi__suggestions-inner-container']/div[2]/div//span[text()='fb']")))
				.click();
		// driver.findElement(By.xpath("//div[@class='jKWzZXdEJWi__suggestions-inner-container']/div[2]/div//span[text()='fb']")).click();
		logger.log(Status.PASS, "Succesfully  url");
		driver.findElement(By.xpath("//h3[contains(text(),'Facebook - Log In or Sign Up')]")).click();
		Assert.assertEquals(driver.getTitle(), "Facebook");
		System.out.println("title :" + driver.getTitle());
		logger.log(Status.INFO, "Trying to Get Title");

	}

	// This will run after testcase and it will capture screenshot and add in report
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			String temp = Utility.getScreenshot(driver);

			logger.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}

		extent.flush();
		driver.quit();

	}
}
