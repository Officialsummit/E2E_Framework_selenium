package test_pages;

import java.io.IOException;

import org.testng.annotations.Test;

import base_configs.BaseConfigs;

public class HomePageTest extends BaseConfigs{
	
	@Test
	public void baseNavigation() throws IOException {
		driver = initializeDriver();
		driver.get("https://www.google.com");
	}

}
