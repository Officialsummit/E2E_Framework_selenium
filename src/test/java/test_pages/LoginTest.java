package test_pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base_configs.BaseConfigs;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginTest extends BaseConfigs {
	WebDriver driver;
	
	@Test
	public void goTologin() throws IOException {
		driver = initializeDriver();
		driver.get(properties.getProperty("baseUrl"));
		HomePage homepage = new HomePage(this.driver);
		homepage.myAccountDropdown().click();
		homepage.goToLoginLink().click();
		
		
	}
	
	@Test
	public void validateLogin() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.inputEmail().sendKeys(properties.getProperty("email"));
		loginPage.inputPassword().sendKeys(properties.getProperty("password"));
		loginPage.submitButton().click();
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.editAccountLink().isDisplayed());		
		
	}
	
	@AfterClass
	private void tearDown() {
		driver.quit();

	}

}
