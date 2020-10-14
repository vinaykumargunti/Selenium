package pom;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PageObjectModel {
	
	
	@Test
	public void pageObjectModelwithoutpageFactory() {
	Logger logger = Logger.getLogger("Maintainig Pages and Menthods following a design pattern");
	PropertyConfigurator.configure("log4j.properties");
	 System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
     
     WebDriver driver=new ChromeDriver();
	logger.info("Driver intialized");
	driver.manage().window().maximize();
	driver.get("http://demosite.center/wordpress/wp-login.php");
	LoginPage login=new LoginPage(driver);
	
	login.loginToWordpress("admin","demo123");
	//login.username();
	//login.password();
	//login.button();
	

}
}