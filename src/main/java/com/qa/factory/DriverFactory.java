package com.qa.factory;


import com.qa.util.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class DriverFactory {

	//    public WebDriver driver;
	public static RemoteWebDriver driver;
	static Properties prop;
	    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//	public static ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<>();
//  @SuppressWarnings("deprecation")
		
		public static WebDriver openbrowser() throws IOException {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("src\\test\\resources\\config\\config.properties");
			
			prop.load(fis);
			String browser1 = prop.getProperty("browser");

			if(prop.getProperty("browser").equals("chrome")) {
				ChromeOptions opt=new ChromeOptions();
				opt.addArguments("--remote-allow-origins=*");
				System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
				tlDriver.set(new ChromeDriver(opt));
			}
		else if (prop.getProperty("browser").equals("firefox")) {
			FirefoxDriver f=new FirefoxDriver();
			System.setProperty("webdriver.firefox.driver", "D:/geckodriver.exe");
//			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
				
			} 
		
		else if (prop.getProperty("browser").equalsIgnoreCase("ie")) {
				
			} 
		else if (prop.getProperty("browser").equals("edge")) {
				
			} 
		else {
				System.out.println(browser1 + " is not a supported browser");

			}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}


}
