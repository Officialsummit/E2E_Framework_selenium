package base_configs;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseConfigs {
	
	protected  WebDriver driver;
	protected Properties properties;
	
	
	public WebDriver initializeDriver() throws IOException {
		
		properties = new Properties();
		
		FileInputStream propFile = new FileInputStream("C:\\Users\\Sumit Chhetri\\git\\E2E_Framework_selenium\\src\\main\\java\\base_configs\\propertyfile");
		
		properties.load(propFile);		
		
		String browserName = properties.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
			
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		return driver;
	}
	@AfterMethod
	private void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();

	}
	

}
