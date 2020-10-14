package RedBus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RedBusLogincurrentmonthyear {
	
	
	static WebDriver driver;
	static Logger logger = null;
	@BeforeMethod
	public void openDriver() {
		driver=BrowserSelection.travelapp();
	}
	@Test(priority=1)
	public void openBrowser() throws InterruptedException {
		logger = Logger.getLogger("Switching Between Iframes");
		PropertyConfigurator.configure("log4j.properties");
		
		driver.get("https://www.redbus.com/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='src']")).click();
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Hyderabad");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='search']/div/div[1]/div/ul/li[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='dest']")).click();
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Pune");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='search']/div/div[2]/div/ul/li[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		String date="21-Aug-2020";
		String[] selectdate=date.split("-");
		String day=selectdate[0];
		String month=selectdate[1];
		String year=selectdate[2];
		Thread.sleep(1000);
		RedBusLogincurrentmonthyear.selectDate(day,month,year);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		Thread.sleep(3000);
		
	}
	public static void selectDate(String day, String month, String year) {
		
		List<WebElement> elements=driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]"));
	
		
		for(int i=0;i<elements.size();i++) {
			
			logger.info("trying to get the month from calender on redbus : "+elements.get(i).getText());
			String month1=elements.get(i).getText();
			String[] Expectedmonth=month1.split(" ");
			String monthrequired=Expectedmonth[0];
			if(monthrequired.equalsIgnoreCase(month)) {
				logger.info("Expected Month: "+monthrequired);
				List<WebElement> days=driver.findElements(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
				
				for(WebElement d:days) {
					
					if(d.getText().equals(day)) {
						logger.info("Date Expected "+d.getText());
						d.click();
						return;
						
					}
					
				}
			}
			
			
		}
		
		
		
		
	}
	
	
	@AfterMethod
	public void browserclose() {
		
		driver.quit();
	}

}
