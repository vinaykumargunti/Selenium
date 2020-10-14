package pomFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	
	 WebDriver driver;

	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
		
	@FindBy(id="user_login") 
	
	WebElement username; 
	 
	@FindBy(how=How.ID,using="user_pass")
	
	WebElement password;
	 
	@FindBy(how=How.XPATH,using=".//*[@id='wp-submit']")

	WebElement submit_button;
	 
		
	public void wordpresslogin(String user,String passw) {
		username.sendKeys(user);
		password.sendKeys(passw);
		submit_button.click();
		
	}
	
	

}
