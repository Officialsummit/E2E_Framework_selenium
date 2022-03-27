package base_configs;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseConfigs {
	
	public  WebDriver driver;
	
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties properties = new Properties();
		
		FileInputStream propFile = new FileInputStream("D:\\eclipse ide\\eclipse projects\\E2EFramework\\src\\main\\java\\base_configs\\propertyfile");
		
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

}
