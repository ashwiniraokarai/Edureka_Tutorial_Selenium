package co.edureka.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C_GetMethodsDemoMADEMODULAR {
	
	 /* Goal - To improvise upon GetMethodsDemoLINEARCODE.java Class
     * Copied GetMethodsDemo as a NEW CLASS to improvise readability and refine it
     * Modularized the linear code into functions
     * Surrounded each function with TRY-CATCH block (select->right click->surround with try-catch)
     * Called the functions in MAIN by instantiation
     */
	
	/*Notice driver object being DECLARED (with NO instantiation) right at the beginning of the CLASS but OUTSIDE any METHOD to give it a GLOBAL
	scope inside the Class i.e. it's value is accessible from any method defined in the class, even thought instantiation
	(value assignment) is being done inside of a method (inside method invokeBrowser)
	*/
	
	WebDriver driver;

	public void invokeBrowser() {
		try {
			
			//This method is called by main() method (entry point) defined at the bottom
			
			System.out.println("Setting system properties of Selenium WebDriver to Chrome Driver");
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Ash\\Selenium JARs and Bindings\\chromedriver_win32\\chromedriver.exe");
			
			System.out.println("Launching Chrome Browser");
			
			/*Notice how you SHOULD NOT prefix 'WebDriver' when assigning value to the pre-declared. 
			That is akin to re-declaration of the same object with it's type and leads to java.lang.nullpointerexception
			Like declaring String x outside the method and INADVERTENTLY declaring it again as String x = 10 in the method 
			(when all you intended to do is assign a value simply as x = 10;) reduces the scope to local, 
			thus defeating the whole purpose of making the variable accessible globally across the class!
			*/
			
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
			
			//Call getMethodsDemo
			System.out.println("Calling getMethodsDemo");
			getMethodsDemo();
			
			//Close the browser
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void getMethodsDemo() {
		try {
			//This method is invoked by invokeBrowser method (above) which is in turn invoked by main() method (bottom)
			System.out.println("Trying to launch Amazon.com home page");
			
			//Notice a GET command
			driver.get("http://www.amazon.com");
			
			//Exploring other "GET" commands
			driver.getTitle();
			//You can either receive the returned value in a STRING variable (String title = driver.getTitle' System.Out.Println("Title of the page is : " +title")) 
			//and echo/ print it on the console OR print directly on the console by wrapping the getTitle with a System.Out.Println
			System.out.println("Title of the home page of Amazon is : " +driver.getTitle());
			
			/*Great. Now, let's say you want to CLICK on a DIFFERENT LINK on the same page - Amazons's home page and then GET the CURRENT URL.
			This is where you'll need to use one of the 8 Element Locator techniques (akin to GetProperty technique in QTP) to SPECIFY the
			link and you need some TOOL like an "Object Spy" to INSPECT the element first of all. 
			So, open Amazon page on Firefox browser and open up "Developer Tools" (Developer Tools is your Object Recognition tool)
			You have an option on the extreme left on the Developer Tools window where you can PICK the ELEMENT you want to LEARN ("spy")
			Go ahead, locate the element on the screen ("Today's deals" link) and see the Developer Tool window POINT to the PERTINENT
			LOC. You want to copy a property/ attribute value.You'll have more than one option listed as key-value pairs. 
			Which KEY"S VALUE want to USE depends on the ELEMENT LOCATOR TECHNIQUE you CHOOSE. To see all the options: 
			Right-click on LOC->Copy-> <Options listing>:
			
				Inner HTML
				Today's Deals
				
				Outer HTML
				<a href="/gp/goldbox/ref=nav_cs_gb/147-7216137-5038432" class="nav-a" tabindex="50">Today's Deals</a>
				
				CSS Selector
				#nav-xshop > a:nth-child(4)
				
				CSS Path
				html.a-ws.a-js.a-audio.a-video.a-canvas.a-svg.a-drag-drop.a-geolocation.a-history.a-webworker.a-autofocus.a-input-placeholder.a-textarea-placeholder.a-local-storage.a-touch.a-gradients.a-hires.a-transform3d.a-touch-scrolling.a-text-shadow.a-text-stroke.a-box-shadow.a-border-radius.a-border-image.a-opacity.a-transform.a-transition.a-ember body.a-m-us.a-aui_107069-c.a-aui_51744-c.a-aui_57326-c.a-aui_72554-c.a-aui_accessibility_49860-c.a-aui_attr_validations_1_51371-c.a-aui_bolt_62845-c.a-aui_ux_102912-c.a-aui_ux_59374-c.a-aui_ux_60000-c.a-aui_ux_92006-c.a-aui_ux_98513-c.a-dex_92889-c.a-meter-animate div#a-page header.nav-locale-us.nav-lang-en.nav-ssl.nav-unrec.nav-opt-sprite div#navbar.nav-sprite-v1.nav-bluebeacon div#nav-main.nav-sprite div.nav-fill div#nav-xshop-container div#nav-xshop a.nav-a
				
				X-Path
				/html/body/div[1]/header/div/div[2]/div[3]/div/div/a[3]
				 
			We choose to use the ELEMENT LOCATOR TECHNIQUE called 'linkText'. So, the VALUE of KEY 'Inner HTML' would be suitable since
			the value seems to match the text of the link as seen on the home page screen to the layman eye.
			
			findElement is the WebDriver INTERFACE METHOD and it's argument takes values of the CUSTOM TYPE "By" ("By" is a class)
			which has the ELEMENT LOCATOR TECHNIQUES (ELT) as it's CLASS METHODS. In this case we will use the linkText ELT. So, we call
			the linkText METHOD on the By CLASS and Pass "Today's deals" as the argument to linkText method. 
			driver.findElement(By.linkText("Today's Deals"));
			
			With this SPEC in place, call the METHOD suitable to the ACTION you want to perform:  click(). The very reason you went through all this trouble.
			driver.findElement(By.linkText("Today's Deals")).click();
					
			*/
			
			driver.findElement(By.linkText("Today's Deals")).click();
			
			//Time to call the getCurrentUrl method to get the current URL, of course!
			String currentURL  = driver.getCurrentUrl();
			System.out.println("After clicking on \"Today's Deals\" link, the current URL is : " +currentURL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		//Execution begins here
		C_GetMethodsDemoMADEMODULAR testObj = new C_GetMethodsDemoMADEMODULAR();
		testObj.invokeBrowser();
		//testObj.getMethodsDemo();
		
	}

}
