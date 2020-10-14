package RedBus;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSelection {
	
	static WebDriver driver;
	public static WebDriver travelapp() {
		Logger logger = Logger.getLogger("Switching Between Iframes");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
		 driver = new FirefoxDriver();
		logger.info("Driver intialized");
		driver.manage().window().maximize();
		return driver;

}
}
