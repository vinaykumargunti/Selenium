package handlingRadioButtons;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

public class RadioButtons {
	@Test
	public void radioButton() {
		Logger logger = Logger.getLogger("RadioButtom");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		logger.info("Driver intialized");
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio' and @name='lang']"));
		for (int i = 0; i < radio.size(); i++) {
			WebElement localradio = radio.get(i);
			String radiovalue = localradio.getAttribute("Value");
			if (radiovalue.equalsIgnoreCase("Ruby"))
				localradio.click();
		}
		
		List<WebElement> checkbox=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(int i=0;i<checkbox.size();i++) {
        	
        	WebElement localvalue=checkbox.get(i);
        	String localcheckboxvalue=localvalue.getAttribute("id");
        	
        	if(localcheckboxvalue.equalsIgnoreCase("code")) {
        		
        		localvalue.click();
        	}
        }
	}

}
