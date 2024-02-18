package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//My Account dropdown
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myAccountDropdown;
	public WebElement myAccountDropdown() {
		return myAccountDropdown;
	}
	
	//Login link
	@FindBy(xpath = "//a[.='Login']")
	WebElement loginLink;
	public WebElement goToLoginLink() {
		return loginLink;
	}
	
	

}
