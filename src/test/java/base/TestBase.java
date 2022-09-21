package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AssignmentPage;
import pageObjects.LogInPage;
import utility.ExtentManager;

public class TestBase {
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	public String browser;
	public LogInPage loginObj ;
	public AssignmentPage assignmentObj;
	public Properties prop = new Properties();
	
	@BeforeSuite
	public void LoadProperties() {
		ExtentManager.setExtent();
		System.out.println("executing LoadProperties.....");
		try {
			prop = new Properties();
			System.out.println(System.getProperty("user.dir") + "/src/test/resources/Configuration/config.properties");

			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/configuration/Config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void launchBrowser() throws Exception  {
		
		LoadProperties();
		browser = prop.getProperty("Browser");
		
		System.out.println("browser is... "+ browser);
		//WebDriverManager.chromedriver().setup();
		//WebDriverManager.edgedriver().setup();
			
		System.out.println("In Launch brower method");
		
		if(browser.equalsIgnoreCase("Edge")){
			//driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
		else {
			// driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
			
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(10000);
		getDriver().manage().window().maximize();
	
		//driver.get(loginObj.getURL());
		//getDriver().get("https://lms-frontend-phase2.herokuapp.com/login");
		getDriver().get(prop.getProperty("Base_Url"));
		loginObj = new LogInPage(getDriver());
		assignmentObj = new AssignmentPage(getDriver());
		System.out.println("login page object got created");
			
	}
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	@AfterSuite
	public void afterSuite() {
       	ExtentManager.endReport();
	}
}
