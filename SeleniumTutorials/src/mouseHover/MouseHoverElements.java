package mouseHover;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHoverElements {
	@Test
	public void mouseHoverOn() throws Exception {
		Logger logger = Logger.getLogger("MouseHover");
		PropertyConfigurator.configure("log4j.properties");
		 System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
	     
	     WebDriver driver=new ChromeDriver();
		logger.info("Driver intialized");
		driver.manage().window().maximize();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-perform-mouse-hover-in-selenium.html");
		WebElement ele=driver.findElement(By.xpath("//button[@class='dropbtn']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		
		
		//driver.findElement(By.xpath("//div[@class='dropdown-content']//a[contains(text(),'Selenium')]")).click();
		
	List<WebElement> element=	driver.findElements(By.xpath("//div[@class='dropdown-content']//a"));
	for(int i=0;i<element.size();i++) {
		
		
		String value=element.get(i).getText();
		
		if(value.equals("Selenium")) {
			
			element.get(i).click();
			break;
			
			
		}
		
	}

	
	}
}