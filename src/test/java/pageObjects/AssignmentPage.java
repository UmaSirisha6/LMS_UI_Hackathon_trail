package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import actionsinterface.Action;

public class AssignmentPage {

	WebDriver driver;
	Action action = new Action();
	LogInPage loginpageObj = new LogInPage(driver);
	
	
	public AssignmentPage(WebDriver d){
		this.driver = d;
	}
	
	private By AssignHeading = By.xpath("//div[@class='box']");
	
	
	public String getHeading() {
		//return driver.findElement(AssignHeading).getText();
		return action.getText(AssignHeading);
	}
	
}
