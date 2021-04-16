package co.edureka.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class G_ElementLocatorTechniques {
	
	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ash\\Selenium JARs and Bindings\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			elementLocatorTechniquesUsingAmazon();
			//driver.quit();
			//elementLocatorTechniqueUsingFacebook();
			//driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void elementLocatorTechniquesUsingAmazon() {
		try {
			driver.get("http://www.amazon.in");
			
			//Finding a web element ByLinkText
			driver.findElement(By.linkText("Your Amazon.in")).click();
			
			//Go back to home page
			driver.navigate().back();
			
			//Finding a web element ByID
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Lenovo Laptops");
			
			//Finding a web element ByClassName
			driver.findElement(By.className("nav-input")).submit();
			
			//Go back to home page
			driver.navigate().back();
			
			//Finding a web element ByPartialLinkText
			driver.findElement(By.partialLinkText("Customer Service")).click();
			
			/*Finding web element ByXPATH
			 * --Absolute Path: Means the reference node HAS to be with an "html" TAG (typically extensive because html is at the 
			 * very beginning of the html document and has way too many cascading nodes like div, before hitting
			 * the node we are targeting. Suitable for small documents. The path separator is a single slash '/')
			 * --Relative Path: Means the reference node CAN be ANY TAG that can act as a reference. The path
			 * separator is a double slash '//')
			 */
			
			/*In this example, we try clicking on the "Hello, Sign in" link that does not have a unique ID or a CLASS.
			 * So, we go two levels up the document hierarchy at a node that has a unique id 
			 * (div id = "nav-tools") to be able to write a RELATIVE XPATH EXPRESSION using the reference.
			 * The tutorial asks to CREATE the PATH from scratch in FIREPATH to be able to test it. But with Developer Tools in
			 * Firefox, you can simply right-click the LOC and copy the XPATH. You can do this at each node 
			 * down the hiererchy until the target node:
			 * --At LOC <div id="nav-tools">, you get this on copying the XPATH:
			 * //*[@id="nav-tools"]
			 * --At LOC <a id="nav-link-yourAccount" class="...., you get this on copying the XPATH:
			 * //*[@id="nav-link-yourAccount"]
			 * nav-link-accountList (different in chrome!realised when run session failed every other time on chrome!!
			 * But reverted to original values later on.WTF?)
			 * --At LOC <span class="nav-line-1">Hello. Sign in</span>, you get this on copying the XPATH:
			 * (This looks different! Perhaps, this is an absolute path?)
			 *--/html/body/div[1]/header/div/div[2]/div[2]/div/a[1]/span[1]
			 *String the first two together and then add tag name prefixes yourself. IGNORE XPATH of the last/target node and
			 *include only span[1] to construct the XPATH expression :
			 *--//div[@id="nav-tools"]/a[@id="nav-link-yourAccount"]/span[1]
			 */
			
			driver.navigate().back();
			
			driver.findElement(By.xpath("//div[@id=\"nav-tools\"]/a[@id=\"nav-link-yourAccount\"]/span[1]")).click();
			
			//OR using absolute path, use this (direct XPATH as provided by Developer Tools!)
		    //driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/div/a[1]/span[1]")).click();	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void elementLocatorTechniqueUsingFacebook() {
		try {
			driver.get("http://www.facebook.com");
			
			//Finding web element ByName
			driver.findElement(By.name("firstname")).sendKeys("Achuk");
			
			/*Finding web element ByCSS:
			 *Format: 
			 *If specifying using ID:
			 *----By.cssSelector(<tagName>#<ValueOfID>)
			 *If specifying using CLASS:
			 *----By.cssSelector(<tagName>.<ValueOfClass>)
			 */
			driver.findElement(By.cssSelector("input#email")).sendKeys("achuk@gmail.com");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		G_ElementLocatorTechniques obj = new G_ElementLocatorTechniques();
		obj.invokeBrowser();
		

	}

}
