package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(linkText = "Edit your account information")
	WebElement editAccountLink;
	public WebElement editAccountLink() {
		return editAccountLink;
		
	}

}
