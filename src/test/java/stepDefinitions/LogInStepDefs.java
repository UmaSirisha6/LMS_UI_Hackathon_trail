package stepDefinitions;

import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.ExtentManager;


public class LogInStepDefs extends TestBase {
	
//	public WebDriver driver;
	//public String browser;
//	public LogInPage loginObj = null;
	//Properties prop = new Properties();
	@Before
	public void initBrowser() throws Exception
	{
		launchBrowser();
	}
	
	@Given("User is on the LogIn Page")
	public void user_is_on_the_log_in_page() {
		String uName = prop.getProperty("userName");
		String pwd = prop.getProperty("password");
		loginObj.enterValidloginDetails(uName, pwd);

	}

	@When("user clicks on login button with username and password")
	public void user_clicks_on_login_button_with_username_and_password() {
		loginObj.clickonLogin();
	}

	@Then("should be able to log In as user")
	public void should_be_able_to_log_in_as_user() {
		
		String title = loginObj.getLoginPageTitle();
		System.out.println("Title got loaded is " + title);
		Assert.assertEquals("LMS", title, "Title matched");
	   System.out.println("User is on Manage Program Page");
	}

	@After
	public void aftermethod() {
		System.out.println("executing after method");
		getDriver().quit();
       	ExtentManager.endReport();
	}
}
