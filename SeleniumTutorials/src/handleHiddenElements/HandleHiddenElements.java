package handleHiddenElements;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleHiddenElements {
	@Test
	public void mouseHoverOn() throws Exception {
		Logger logger = Logger.getLogger("Handle Hidden Elements");
		PropertyConfigurator.configure("log4j.properties");
		 System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
	     
	     WebDriver driver=new ChromeDriver();
		logger.info("Driver intialized");
		driver.manage().window().maximize();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
	
		
		
	
		
	List<WebElement> element=	driver.findElements(By.xpath("//input[@id='male']"));
	for(int i=0;i<element.size();i++) {
		
		
		int x=element.get(i).getLocation().getX();
		
		if(x!=0) {
			
			element.get(i).click();
			break;
			
			
		}
		
	
	}
	}
}

