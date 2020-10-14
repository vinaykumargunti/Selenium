package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	By username=By.xpath("//input[@id='user_login']");
	
	By password=By.xpath("//input[@id='user_pass']");
	
	By clickbutton=By.xpath("//input[@id='wp-submit']");

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void loginToWordpress(String user,String pass) {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(clickbutton).click();
	}
	
	
	public void username() {
		
		driver.findElement(username).sendKeys("admin");
	}
	
	public void password() {
		
		
		driver.findElement(password).sendKeys("demo123");
	}
	
	
	public void button() {
		
		driver.findElement(clickbutton).click();
	}
	

}
