package dropdownDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectFacebookDropDown2 {

	@Test
	public void SelectDDValues() {
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();		
		driver.get("https://www.facebook.com/");
		Select sec1=new Select(driver.findElement(By.id("month")));
		WebElement first=sec1.getFirstSelectedOption();
		System.out.println("Default Option in DropDown:"+first.getText());
	
		sec1.selectByVisibleText("Mar");
	
		WebElement second=sec1.getFirstSelectedOption();
		Assert.assertEquals(second.getText(), "Mar");
		System.out.println("After Selecting a month in DropDown:"+second.getText());
	}

}
