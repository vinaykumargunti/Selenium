package actionclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ToolTipExampleTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver_85_0_4183_38\\chromedriver.exe");
	     
	      WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://jqueryui.com/tooltip");
	    System.out.println("Title: "+driver.getTitle());
	    Thread.sleep(3000);
	    WebElement iFrame=driver.findElement(By.className("demo-frame"));
	    System.out.println(iFrame.getSize());
	    driver.switchTo().frame(iFrame);
	    Thread.sleep(3000);
	 
	    WebElement ageElement=driver.findElement(By.id("age"));
	    System.out.println(ageElement.getLocation());
	    Actions act=new Actions(driver);
	   // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //JavascriptExecutor js = (JavascriptExecutor) driver;  
	   // js.executeScript("arguments[0].click();",ageElement);
	    //act.moveToElement(ageElement, 88, 190).build();
	   // act.moveToElement(ageElement).clickAndHold().moveByOffset(503,230).release().perform();
	   act.moveToElement(ageElement).build();
	   // act.moveToElement(new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(ageElement))).perform();
	    //Thread.sleep(3000);
	    WebElement tooltip=driver.findElement(By.className("ui-tooltip-content"));
	    System.out.println("value:"+tooltip.getText());
	    driver.quit();
	}
}
