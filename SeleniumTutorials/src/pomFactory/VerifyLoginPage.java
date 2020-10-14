package pomFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class VerifyLoginPage {
	
	@Test
	public void VerifyLogin() {
	
	WebDriver driver=BrowserFactory.browserSelection("chrome","http://demosite.center/wordpress/wp-login.php");
   LoginPage page=  PageFactory.initElements(driver,LoginPage.class);
     
   page.wordpresslogin("admin", "demo123");
	
	}
}
