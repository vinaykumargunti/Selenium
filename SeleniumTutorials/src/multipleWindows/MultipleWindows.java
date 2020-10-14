package multipleWindows;

import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MultipleWindows {
	
	
	
	@Test
	public void multiplewindow() {
		
		Logger logger = Logger.getLogger("Handling Mutliple Windows");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		logger.info("Driver intialized");
		driver.get("https://www.naukri.com/");
	    String parent=driver.getWindowHandle();
		logger.info("Parent Window "+parent);
		Set<String> windows=driver.getWindowHandles();
		for(String child:windows) {
			if(!parent.equals(child)) {
				driver.switchTo().window(child);
				driver.close();
				
			}
		}
		driver.switchTo().window(parent);
		
	}

}
