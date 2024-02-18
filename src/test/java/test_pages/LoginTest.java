package test_pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base_configs.BaseConfigs;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginTest extends BaseConfigs {
	WebDriver driver;

	@BeforeMethod
	private void openBrowser() throws IOException {
		driver = initializeDriver();
		driver.get(properties.getProperty("baseUrl"));

	}

	@Test(dataProvider = "getloginData")
	public void validateLogin(String username, String password) throws IOException {
		HomePage homepage = new HomePage(this.driver);
		homepage.myAccountDropdown().click();
		homepage.goToLoginLink().click();
		Assert.assertEquals("Account Login", driver.getTitle());
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.inputEmail().sendKeys(username);
		loginPage.inputPassword().sendKeys(password);
		loginPage.submitButton().click();
		AccountPage accountPage = new AccountPage(driver);

		// login passed
		try {

			Assert.assertTrue(accountPage.editAccountLink().isDisplayed());

		}
		// login failed
		catch (Exception e) {
			Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",
					loginPage.invalidLogin().getText());

		}

	}

	@AfterMethod
	private void tearDown() {
		driver.quit();

	}

	@DataProvider
	public Object[][] getloginData() {
		Object[][] loginCredentials = { { "xetsumit@gmail.com", "Testing@12" },
				{ "wrong@gmail.com", "wrongpassword" } };
		return loginCredentials;
	}

}
