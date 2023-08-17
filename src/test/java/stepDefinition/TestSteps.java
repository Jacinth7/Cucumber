/*package stepDefinition;

import com.pages.DrawdownPage;
import com.pages.PDPloginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ElementUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Properties;

public class TestSteps {

    private PDPloginPage pdplogin = new PDPloginPage(DriverFactory.getDriver());
    private DrawdownPage drawdownpage = new DrawdownPage();

//    @Given("user is on the home page")
//    public void user_is_on_the_login_screen() throws Throwable {
//    	Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream("src\\test\\resources\\config\\config.properties");
//		prop.load(fis);
//		DriverFactory.getDriver().get(prop.getProperty("url"));
//		
//		
//    	System.out.println("Pass7");
//    }

    @When("user enter email and click next button {string}")
    public void user_enter_email_and_click_next_button(String email) throws Throwable {

        pdplogin.EnterEmail1(email);
        pdplogin.ClickNext();

    }

    @When("user enter password and click signin button {string}")
    public void user_enter_password_and_click_signin_button(String pwd) throws Throwable {

        pdplogin.EnterPassword(pwd);
        pdplogin.clickSignin();
    }

    @Given("user validating the drawdown data screen")
    public void user_validating_the_drawdown_data_screen() throws SQLException, ClassNotFoundException {

        drawdownpage.drawdowncheck();
    }


    @Given("user verifying the drawdown values")
    public void user_verifying_the_drawdown_values() throws SQLException, ClassNotFoundException {

        drawdownpage.drawdownvaluescheck();
    }

    @Given("user verifying the drawdown table constraints")
    public void user_verifying_the_drawdown_table_constraints() throws SQLException, ClassNotFoundException {

        drawdownpage.drawdowntableconstraints();
    }

    @Given("user verifying the drawdown table fund proportion")
    public void user_verifying_the_drawdown_table_fund_proportion() throws SQLException, ClassNotFoundException {

        drawdownpage.drawdowntablefundproportion();
    }

}
*/