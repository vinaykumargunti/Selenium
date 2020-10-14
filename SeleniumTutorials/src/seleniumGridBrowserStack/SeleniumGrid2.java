package seleniumGridBrowserStack;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid2 {
	
	public static final String USERNAME = "vinayvny1";
	public static final String AUTOMATE_KEY = "imYSQYgx8DPqwuW9Enfm";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
	public static void main(String[] args) throws MalformedURLException {
		
		
		
		DesiredCapabilities caps = new DesiredCapabilities().chrome();
		caps.setPlatform(Platform.MAC);
        
		
		caps.setCapability("name", "vinayvny3's Third Test");
		
		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("VINAY.GUNTI");
		System.out.println(driver.getTitle());
		driver.quit();
		
	}


}
