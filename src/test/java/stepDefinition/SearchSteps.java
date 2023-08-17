package stepDefinition;

import java.io.FileInputStream;
import java.util.Properties;

import com.pages.HomePage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

	private HomePage home = new HomePage(DriverFactory.getDriver());

//	@Given("user is on the home page")
//	public void user_is_on_the_login_screen() throws Throwable {
//		Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream("src\\test\\resources\\config\\config.properties");
//		prop.load(fis);
//		DriverFactory.getDriver().get(prop.getProperty("url"));
//
//	}

	@When("user enters the keword to search")
	public void user_enters_the_keword_to_search() throws Throwable {
		home.enterWord("Testing");
	}

	@Then("the result is dispalyed")
	public void the_result_is_dispalyed() throws Throwable {
		home.clickSrchButton();
		System.out.println("Search Done");
	}
	
	

}
