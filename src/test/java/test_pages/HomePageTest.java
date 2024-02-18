package test_pages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base_configs.BaseConfigs;

public class HomePageTest extends BaseConfigs{
	
	@Test
	public void baseNavigation() throws IOException {
		driver = initializeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		String title = driver.getTitle();
		Assert.assertEquals("The Internet", title);
	}

}
