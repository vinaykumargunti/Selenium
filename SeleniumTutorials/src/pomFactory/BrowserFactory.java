package pomFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
	
	static WebDriver driver;
	
	
	public static WebDriver browserSelection(String browser, String url) {
		
		
		if(browser=="firefox") {
			
			System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
			 driver = new FirefoxDriver();
			 driver.get(url);
		     
			
		}
		
		
		else if(browser=="chrome") {
			
			System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
		     
		       driver=new ChromeDriver();
		       driver.get(url);
		     
		}
		
		
		else {
			System.setProperty("webdriver.ie.driver", "D:\\Coding\\Seleniumlib\\IEDriver\\IEDriverServer.exe");
			
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability("nativeEvents", false);
			ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
			ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
			ieCapabilities.setCapability("disable-popup-blocking", true);
			ieCapabilities.setCapability("enablePersistentHover", true);
			ieCapabilities.setCapability("ignoreZoomSetting", true);
			
			
			//Creating an object of InternetExplorerDriver
			 driver=new InternetExplorerDriver(ieCapabilities);
			
		}
		return driver;
		
		
	}


	

}
