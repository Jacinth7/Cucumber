package stepDefinition;


import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Properties;


public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;


	@Before(order = 0)
	public void getProperty() {
		configReader=new ConfigReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() throws IOException   {

		driverFactory=new DriverFactory();
		driver = driverFactory.openbrowser();
		System.out.println("Thread: "+Thread.currentThread().getId());

	}


	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order=1)
	public void tearDown(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}
	
}