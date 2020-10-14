package dropdownDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectFacebookDropDown3 {
	@Test
	public void SelectDDValues() {
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		Select sec1 = new Select(driver.findElement(By.id("month")));
		List<WebElement> monthsList = sec1.getOptions();
//first way of arraylist
		ArrayList<String> al = new ArrayList<String>();
		al.add("Month");
		al.add("Jan");
		al.add("Feb");
		al.add("Mar");
		al.add("Apr");
		al.add("May");
		al.add("Jun");
		al.add("Jul");
		al.add("Aug");
		al.add("Sept");
		al.add("Oct");
		al.add("Nov");
		al.add("Dec");
		System.out.println(al);
		// second way of adding strings to arraylist
		List li = Arrays.asList("Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov",
				"Dec");

		List actual = new ArrayList();
		int months = monthsList.size();
		for (WebElement ele : monthsList) {
			actual.add(ele.getText());
			System.out.println("Months are=====:" + actual);

		}
		Assert.assertEquals(months, 13);
		Assert.assertEquals(actual, li);
	}

}
