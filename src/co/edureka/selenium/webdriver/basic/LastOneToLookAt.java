package co.edureka.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LastOneToLookAt {
	/*Goal -
	Invoke the browser
	Load the web page http://www.edureka.com
	Search for a course
	Modularizing each of the actions into methods (functions)
	*/
	
	//Create a GLOBAL variable of TYPE WebDriver (outside any function, inside the CLASS)
    WebDriver driver;
    
    public void invokeBrowser() {
    	try {
			//Point the relevant Chrome Driver property KEY to VALUE as applicable on a previously saved location on your machine
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Ash\\Selenium JARs and Bindings\\chromedriver_win32\\chromedriver.exe");
			
			//Instantiate the ChromeDriver class
			driver = new ChromeDriver();
			
			//You'll now want to MANAGE the browser in order to perform ANY ACTION on it
			//Eg: Deleting all browser cookies, Maximize the default minimized window
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			
			//Wait until the browser page loads (page synchronization)
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			//Fetch the URL
			driver.get("http://www.edureka.co/all-courses");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    	
    public void searchCourse() {
    	driver.findElement(By.id("search-inp")).sendKeys("Java");
    	driver.findElement(By.id("search-button-top")).click();
    	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LastOneToLookAt myDayObj = new LastOneToLookAt();
		myDayObj.invokeBrowser();
		myDayObj.searchCourse();
	}

}
