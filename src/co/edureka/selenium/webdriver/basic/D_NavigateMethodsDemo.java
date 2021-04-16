package co.edureka.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D_NavigateMethodsDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ash\\Selenium JARs and Bindings\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.navigate().to("http://www.flipkart.com");
			//Close the login pop up/ modal window
			driver.findElement(By.cssSelector("._29YdH8")).click();
			//Click on Advertise link
			driver.findElement(By.linkText("Advertise")).click();
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
			driver.navigate().forward();
			Thread.sleep(2000);
			driver.navigate().refresh();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
