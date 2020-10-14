package browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//https://sites.google.com/a/chromium.org/chromedriver/downloads-to find chrome driver : ChromeDriver 84.0.4147.30
//Chromebrowser Version 84.0.4147.89 (Official Build) (64-bit)
//https://www.selenium.dev/downloads/-Download Latest stable version 3.141.59sss
public class Seleniumfindelementbychromedriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
     
      WebDriver driver=new ChromeDriver();
      driver.get("https://sites.google.com/a/chromium.org/chromedriver/downloads");
      System.out.println(driver.getTitle());
      System.out.println(driver.getCurrentUrl());
      driver.quit();
	}

}
