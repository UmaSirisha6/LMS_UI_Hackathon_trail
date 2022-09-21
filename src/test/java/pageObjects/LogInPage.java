package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import actionsinterface.Action;
import base.TestBase;

public class LogInPage extends TestBase{
	WebDriver driver;
	Action action = new Action();

	Properties prop = new Properties();
	
	public LogInPage(WebDriver d){
		this.driver = d;
	}
	/*
	 * @FindBy(xpath="//input[@id='username']") private WebElement userName;
	 * 
	 * @FindBy(xpath="//input[@id='password']") private WebElement password;
	 * 
	 * @FindBy(xpath="//button[@id='login']") private WebElement logInBtn;
	 */
	private By Username = By.id("username");
	private By Password = By.id("password");
	private By loginbtn = By.id("login");
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterValidloginDetails(String UName, String pwd) {
	
		
		//action.selectBySendkeys(UName, driver.findElement(Username));
		//action.selectBySendkeys(pwd, driver.findElement(Password));

		action.type(Username, UName);
		action.type(Password,pwd);
		//driver.findElement(Username).sendKeys(UName);
		//driver.findElement(Password).sendKeys(pwd);
	
		
		System.out.println("entered valid details");
	
	}
	
	public void clickonLogin() {
		//logInBtn.click();
		driver.findElement(loginbtn).click();
		System.out.println("clicked on login");
	}
	
	public void validLoginMethod()
	{
		action.type(Username, prop.getProperty("userName"));
	    action.type(Password,prop.getProperty("password"));
	    driver.findElement(loginbtn).click();
		
	}

}
