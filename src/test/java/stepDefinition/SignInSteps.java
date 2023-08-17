package stepDefinition;

import java.io.FileInputStream;
import java.util.Properties;

import com.pages.SignInPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SignInSteps {
	
	private SignInPage in = new SignInPage(DriverFactory.getDriver());
	
	  @Given("user is on the home page")
	    public void user_is_on_the_login_screen() throws Throwable {
	    	Properties prop = new Properties();
			FileInputStream fis = new FileInputStream("src\\test\\resources\\config\\config.properties");
			prop.load(fis);
			DriverFactory.getDriver().get(prop.getProperty("url"));
			
			
	    	System.out.println("Pass7");
	    }
	
	@When("user enters click sign in button")
	public void user_enters_click_sign_in_button() throws Throwable {
		in.sign();
	}
	
	@When("user enters the username and clicks next")
	public void user_enters_the_username_and_clicks_next() throws Throwable {
		in.enterUsername();
		System.out.println("Sign In done");
		Thread.sleep(2000);
	}

}
