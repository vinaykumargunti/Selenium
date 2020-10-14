package brokenLinks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty9.http.HttpStatus;
import org.testng.annotations.Test;

public class BrokenLinksTest {
	
	@Test
	public void brokenLink() throws Exception {
		Logger logger = Logger.getLogger("Broken Links");
		PropertyConfigurator.configure("log4j.properties");
		 System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
	     
	     WebDriver driver=new ChromeDriver();
		logger.info("Driver intialized");
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		
		for(int i=0;i<links.size();i++) {
			
			
			String urllink=links.get(i).getAttribute("href");
			
			VerifyValidLink(urllink);
			
			
		}
		
		
		
	}

	public void VerifyValidLink(String urllink) throws Exception {
		URL link=new URL(urllink);
		HttpsURLConnection con=(HttpsURLConnection)link.openConnection();
		con.setConnectTimeout(2000);
		con.connect();
		if(con.getResponseCode()==HttpStatus.OK_200) {
			
			
			System.out.println(urllink+" - "+con.getResponseMessage()+" - "+con.getResponseCode());
		}
		
		if(con.getResponseCode()==HttpStatus.NOT_FOUND_404) {
			
			System.out.println(urllink+" - "+con.getResponseMessage()+" - "+con.getResponseCode());
		}
	}

}
