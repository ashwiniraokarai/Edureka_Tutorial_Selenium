package co.edureka.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A_BeginHere {

	public static void main(String[] args) {

		/*
		 * FUNDA1: The VERY FIRST THING you want to do is LAUNCH YOUR BROWSER. Without
		 * this you got no application to test under!(AKIN to Launch and Login component
		 * in TAO) You would certainly need to CALL a suitable METHOD from your
		 * WebDriver INTERFACE in order to do this (remember the REFERENCE LIBRARY a.k.a
		 * selenium JARs you imported to your project?)
		 * 
		 * Now, remember that the WebDriver Interface can work on different BROWSERS.
		 * So, your INTERFACE although multiple browser compatible, NEEDS TO BIND with
		 * the SPECIFIC BROWSER DRIVER compatible with the BROWSER you are going to
		 * INVOKE. In other words, the WebDriver is an INTERFACE that is IMPLEMENTED by
		 * SEVERAL CLASSES dedicated to respective browsers such as ChromeDriver,
		 * FirefoxDriver, InternetExplorerDriver, AndrioidDriver, RemoteWebDriver, etc.
		 * In order to ACCESS these classes, you MAY need to DOWNLOAD them onto your
		 * machine (depending on the version compatibility between Selenium and that of
		 * the Browser of choice.
		 * 
		 * FUNDA2: You need ACCESS to the DRIVER CLASS to BEGIN with (entry point). You
		 * will need to instantiate this Browser Class specifically (just like you would
		 * do with a CLASS) and then CALL methods using the interface object (of
		 * Webdriver interface type) WebDriver driver = new ChromeDriver();
		 * driver.get("http://www.amazon.in")
		 * 
		 * CAUTION: EXCEPT object/variable declaration (not instantiation), ALL code
		 * needs to be INSIDE a METHOD. This can be the MAIN method or ANY other class
		 * method.
		 * 
		 * FUNDA 3: You MAY need to DOWNLOAD the DRIVER and configure your system first
		 * IF there are version compatibility issues between Selenium and the Browser of
		 * choice. For example, if Firefox is your browser: If Firefox version is less
		 * than 47+, then Selenium version has to be 2.5+ but NOT 3.0 If Firefox version
		 * is more than 47+, then Selenium version has to be 3.0+ In such cases, you
		 * will need to DOWNLOAD the respective DRIVER EXECUTABLE of the BROWSER of
		 * choice and set the system property. This can be found in
		 * http://www.seleniumhq.org/download/ under section “Third Party Browser
		 * Drivers NOT DEVELOPED by seleniumhq” This will also introduce an additional
		 * step in your code requiring SETTING your SYSTEM PROPERTY in a KEY,VALUE pair
		 * format BEFORE you can instantiate.
		 * 
		 * Eg.If using chromedriver.exe: System.SetProperty(
		 * "webdriver.chrome.driver","<location on your computer>/chromedriver.exe")
		 * 
		 * You then INVOKE your browser using: WebDriver driver = new ChromeDriver();
		 * 
		 * Using the WebDriver type object, you call the suitable method to load your
		 * AUT/ Web application!Simple! driver.get("http://www.amazon.in")
		 * 
		 * A good way to test this is by running a single line of code in your newly
		 * created Java Class, like this: Webdriver driver = new Firefoxdriver();
		 * Eclipse will tell you if you have the driver missing AND where to get it.
		 * Further, it states which SYSTEM PROPERTY should the EXECUTABLE be set to:
		 * “Exception in thread "main" java.lang.IllegalStateException: The path to the
		 * driver executable must be set by the webdriver.chrome.driver system property;
		 * for more information, see
		 * https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver. The latest version
		 * can be downloaded from http://chromedriver.storage.googleapis.com/index.html”
		 * 
		 * So, you know that the “gecko” driver (executable) is missing and from where
		 * it can be downloaded onto your system. You also see that the
		 * webdriver.gecko.driver system property needs to be set to the driver
		 * executable (.exe) (see sample on directed documentation:
		 *  https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver)
		 * 
		 * FUNDA 4: There are some TYPICAL DEFAULT factors that need to be MANAGED in
		 * between - such as The browser DOES NOT OPEN in fully maximized mode (write an
		 * LOC to MAXIMIZE it either way) driver.manage().window.maximize(); Cookies
		 * stored on the browser (LOC to DELETE THEM ALL)
		 * driver.manage().deleteALLCookies(); Page synchronization a.k.a loading time
		 * (2 LOC for IMPLICIT WAIT and PAGE LOAD TIME OUT)
		 * driver.manage().timeouts.implicitlyWait(30, TimeUnit.SECONDS);
		 * driver.manage().timeouts.pageLoadTimeout(40, TimeUnit.SECONDS);
		 * 
		 * Do ALL of THESE steps and only move on doing whatever it is that you want to
		 * do next
		 * 
		 * ---Use ctrl+space for intellisense ---Use ctrl+Shift+o to include any
		 * suggested imports ---Use ctrl+Shift+f to format code
		 * 
		 * Note: Sysouts were added later on for better clarity on the output console
		 */

		System.out.println("Setting system properties of Selenium WebDriver to Chrome Driver");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ash\\Selenium JARs and Bindings\\chromedriver_win32\\chromedriver.exe");

		System.out.println("Launching Chrome Browser");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		System.out.println("Trying to launch Amazon.com home page");

		driver.get("http://www.amazon.com");

		// Go ahead with whatever it is it that you want to do on the AUT

	}

}
