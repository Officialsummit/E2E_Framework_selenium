package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
		//Email Field
		@FindBy(xpath = "//input[@id='input-email']")
		WebElement inputEmail;
		public WebElement inputEmail() {
			return inputEmail;
		}
		
		//Password Field
		@FindBy(id = "input-password")
		WebElement inputPassword;
		public WebElement inputPassword() {
			return inputPassword;
		}
		
		@FindBy(xpath = "//input[@type='submit']")
		WebElement submitButton;
		public WebElement submitButton() {
			return submitButton;
		}
		
		@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
		WebElement invalidWarning;
		public WebElement invalidLogin() {
			return invalidWarning;
			
		}

}
