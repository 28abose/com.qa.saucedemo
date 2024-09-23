package com.saucedemo.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverScript {
	
	public static WebDriver driver;
	static Properties prop;
	
	/*
	 * this constructor is used to read the contents from the properties file
	 */
	
	public DriverScript() {
		try
		{
			// File file = new File(".\\src\\test\\resources\\config\\config.properties");

File file = new File("./src/test/resources/config/config.properties");

			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("unable to load the properties file!");
		}
	}

	/*
	 * this method is used to initialize the driver based on the values from properties file
	 */
	public void initApplication() {
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("unsupported browser type! please check the config file");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		getAppUrl();
		}
	
	/*
	 * this method is used to navigate to the url based on the properties file
	 */
	public static void getAppUrl() {
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	/*
	 * this method is used to quit the driver instance
	 */
	public static void quitDriver() {
		driver.quit();
	}
	
	public static String getText(WebElement element) {
		return element.getText();
	}
	
}