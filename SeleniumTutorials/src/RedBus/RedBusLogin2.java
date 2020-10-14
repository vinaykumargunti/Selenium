package RedBus;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RedBusLogin2 {

	static WebDriver driver;
	static Logger logger = null;
	static List<String> monthList = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep",
			"Oct", "Nov", "Dec");

	@BeforeMethod
	public void openDriver() {
		driver = BrowserSelection.travelapp();
	}

	@Test(priority = 1)
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
		String date = "15-09-2020";
		String[] selectdate = date.split("-");
		String day = selectdate[0];
		int month = Integer.parseInt(selectdate[1]);
		int year = Integer.parseInt(selectdate[2]);
		Thread.sleep(1000);
		RedBusLogin2.selectDate(day, month, year);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		Thread.sleep(3000);

	}
 
	public static void selectDate(String day, int month, int year) {
		boolean selection = true;
		WebElement elements = driver
				.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]"));
		logger.info("trying to get the month from calender on redbus : " + elements.getText());
		String selectedmonthyear = elements.getText();
		String[] selectedmonthyearvalue = selectedmonthyear.split(" ");
		String monthselected = selectedmonthyearvalue[0];
		int yearselected = Integer.parseInt(selectedmonthyearvalue[1]);

		while (selection) {

			if (monthList.indexOf(monthselected) + 1 == month) {

				selectdateoncurrentcalender(day, month, year);
				selection = false;
			}

			else if (monthList.indexOf(monthselected) + 1 > month && yearselected == year || yearselected > year) {
				driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//button[contains(text(),'<')]"))
						.click();
				selectdateoncurrent(day, month, year);
				selection = false;
			}

			else if (monthList.indexOf(monthselected) + 1 < month && yearselected == year || yearselected < year) {
				driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//button[contains(text(),'>')]"))
						.click();
				selectdateoncurrent(day, month, year);
				selection = false;
			}

		}

	}

	
	public static void selectdateoncurrentcalender(String day, int month, int year) {
		List<WebElement> element = driver
				.findElements(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
		for (WebElement days : element) {
			if (days.getText().equals(day)) {

				days.click();
				return;
			}

		}

	}

	public static void selectdateoncurrent(String day, int month, int year) {
		WebElement elements = driver
				.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]"));
		logger.info("trying to get the month from calender on redbus : " + elements.getText());
		String selectedmonthyear = elements.getText();
		String[] selectedmonthyearvalue = selectedmonthyear.split(" ");
		String monthselected = selectedmonthyearvalue[0];
		int yearselected = Integer.parseInt(selectedmonthyearvalue[1]);
			logger.info("Month and Year "+monthselected+" : "+yearselected);
			
				List<WebElement> element = driver
						.findElements(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
				for (WebElement days1 : element) {
					
					if (days1.getText().equals(day)) {
                            logger.info("Day Selected :" +days1);
                            
						days1.click();
						return;
					}

				}
			}
		
	
	@AfterMethod
	public void browserclose() {

		driver.quit();
	}

}
