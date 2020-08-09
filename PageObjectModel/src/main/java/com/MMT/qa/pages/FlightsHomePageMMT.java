package com.MMT.qa.pages;

import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.datatype.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlightsHomePageMMT {

	// Page Factory - OR for Home page
	WebDriver driver;

	@FindBy(xpath = "//input[@id = 'fromCity']")
	WebElement FromCity;

	@FindBy(xpath = "//input[@placeholder = 'From']")
	WebElement FromTextFromCity;

	@FindBy(xpath = "//input[@id = 'toCity']")
	WebElement ToCity;

	@FindBy(xpath = "//input[@placeholder = 'To']")
	WebElement FromTextToCity;

	@FindBy(xpath = "//a[contains(text(),'Search')]")
	WebElement SrchBtn;

	@FindBy(xpath = "//div[contains(@class,'fsw_inputBox dates inactiveWidget')]")
	WebElement DepDateSelect;

	@FindBy(xpath = "//div[@class='DayPicker-Day' and @aria-label = '\"+dateVal+\"']")
	WebElement dateElement;

	public FlightsHomePageMMT(WebDriver driver) {
		this.driver = driver;
	}

	// Actions

	public void enterValueOfFromCity() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(FromCity)).click();
		FromTextFromCity.sendKeys("Mumbai");
		List<WebElement> listFrom = driver.findElements(By.xpath(
				"//ul[@role ='listbox']//li/descendant::div[@class = 'calc60']//p[contains(text(),'Mumbai, India')]"));
		System.out.println(listFrom.size());

		for (int i = 0; i < listFrom.size(); i++) {
			System.out.println(listFrom.get(i).getText());
			if (listFrom.get(i).getText().contains("Mumbai, India")) {
				
				wait.until(ExpectedConditions.elementToBeClickable(listFrom.get(i))).click();
				break;
			}
		}
	}

	public void enterValueOfToCity() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ToCity);

		driver.findElement(By.xpath("//input[@placeholder = 'To']")).sendKeys("tirupati");

		List<WebElement> listTo = driver.findElements(By.xpath(
				"//ul[@role ='listbox']//li/descendant::div[@class = 'calc60']//p[contains(text(),'Tirupati, India')]"));
		System.out.println(listTo.size());

		for (int i = 0; i < listTo.size(); i++) {
			System.out.println(listTo.get(i).getText());
			if (listTo.get(i).getText().contains("Tirupati, India")) {
				listTo.get(i).click();
				break;
			}
		}
	}

	public void selectDepartureDate(String dateVal) {
       DepDateSelect.click();
         
        try {
         WebElement element = driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label = '"+dateVal+"']"));
         selectDateByJS(driver,element);
        }catch(NoSuchElementException e) {
            System.out.println("Date selected by JS");
        }

        }
     public static void selectDateByJS(WebDriver driver,WebElement element) {

            JavascriptExecutor js = ((JavascriptExecutor)driver);
            js.executeScript("arguments[0].click();", element);
           //System.out.println(element.getText());
            
        }
}