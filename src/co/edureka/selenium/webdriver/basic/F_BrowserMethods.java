package co.edureka.selenium.webdriver.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class F_BrowserMethods {
	
	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ash\\Selenium JARs and Bindings\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get("http://www.yatra.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	F_BrowserMethods obj = new F_BrowserMethods();
	obj.invokeBrowser();
	//Browser method to close the CURRENT PAGE (and the browser if only a single page is open, as in this case)
	obj.driver.close(); 
	//Browser method to close the ENTIRE BROWSER
	//or obj.driver.quit();
	}

}
