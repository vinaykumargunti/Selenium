package com.MMT.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.MMT.qa.browser.BrowserFactory;
import com.MMT.qa.pages.FlightsHomePageMMT;

public class FlightsHomePageMMTTest  {
	FlightsHomePageMMT homePageMMT;
	////div[@class='DayPicker-Day' and @aria-label = 'Wed Sep 02 2020']
    public String dateVal = "Wed Sep 02 2020";
   WebDriver driver=BrowserFactory.browserSelection("chrome", "https://www.makemytrip.com/");
   
   
    @Test(priority = 1)
    public void validateCitySelection() {
    	homePageMMT=PageFactory.initElements(driver, FlightsHomePageMMT.class);
    	
    	WebElement element = driver.findElement(By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser']"));
    	if (element.isDisplayed() && element.isEnabled()) {
    	    element.click();
    	}
        homePageMMT.enterValueOfFromCity();
        homePageMMT.enterValueOfToCity();
        System.out.println("city selection successfull");
    }

    @Test(priority = 2)
    public void validateDateSelection() {
        homePageMMT=PageFactory.initElements(driver, FlightsHomePageMMT.class);
        homePageMMT.selectDepartureDate(dateVal);
        System.out.println("Date selection successful");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}