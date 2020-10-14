package dropdownDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectFacebookDropDown1 {

	@Test
	public void SelectDDValues() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		Select sec1 = new Select(driver.findElement(By.id("month")));
		sec1.selectByIndex(4);
		WebElement first = sec1.getFirstSelectedOption();
		System.out.println("First Selection:" + first.getText());
		Thread.sleep(3000);
		sec1.selectByValue("5");
		WebElement second = sec1.getFirstSelectedOption();
		System.out.println("Second Selection:" + second.getText());
		Thread.sleep(3000);
		sec1.selectByVisibleText("Mar");
		WebElement third = sec1.getFirstSelectedOption();
		System.out.println("Third Selection:" + third.getText());
	}

}
