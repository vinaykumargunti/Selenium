package dataDrivenFramework;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data {
	WebDriver driver;

	@Test(dataProvider = "TestData")
	public void datadrivenframework(String username, String password) {
		Logger logger = Logger.getLogger("Switching Between Iframes");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.gecko.driver", "D:\\Coding\\Seleniumlib\\FireFoxDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		logger.info("Driver intialized");
		driver.manage().window().maximize();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		Assert.assertTrue(username.equals("admin") && password.equals("demo123"), "valid case");

		System.out.println("Hi, i am the true login");
		
		logger.info("Data is Valid  Details:Username:" + username + " password : " + password);
		

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="TestData")
	
	public Object[][] TestData(){
		
		ExcelDataConfigure data=new ExcelDataConfigure("D:\\Coding\\Skills.xlsx");
		
		
		
		/*obj[0][0]="Admin"; obj[0][1]="Fuckoff";
		 
		
		 obj[1][0]="admin"; obj[1][1]="demo123";
		
		
		  obj[2][0]="Admin"; obj[2][1]="Fuckofflife";
		 */
		
		
		int rowcount=data.rowcount(1);
		Object[][] obj=new Object[rowcount][2];
		
		for(int i=0;i<rowcount;i++) {
			obj[i][0]=data.getData(1, i, 0);
			obj[i][1]=data.getData(1, i, 1);
			
			
		}
		
		return obj;
		
		
	}
	
	
	
	
}
