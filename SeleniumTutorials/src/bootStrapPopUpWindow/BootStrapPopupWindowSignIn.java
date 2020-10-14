package bootStrapPopUpWindow;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BootStrapPopupWindowSignIn {
	@Test
	public void BootStrap() {

		Logger logger = Logger.getLogger("HandleBootStrapWindow");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		logger.info("Driver intialized");
		driver.get("https://www.goibibo.com/");
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window Title " + driver.getTitle());
		driver.findElement(By.xpath("//a[@id='get_sign_up']")).click();
		// Frame Handling begins here
		// Get All Tabs or Window handles and iterate using for each loop
		for (String handle : driver.getWindowHandles()) {
			System.out.println(handle);
			driver.switchTo().window(handle);
		}

		// switch to frame using frame name
		driver.switchTo().frame("authiframe"); // replace by your frame name
		String childtFrame = driver.getWindowHandle();
		System.out.println("Child Frame Title " + driver.getTitle());
		// now enter login credentials
		driver.findElement(By.id("authMobile")).sendKeys("8328379319");

		// now click on sign in button
		driver.findElement(By.id("mobileSubmitBtn")).click();
		driver.switchTo().window(parentWindow);

	}
	
	
	
	
}
