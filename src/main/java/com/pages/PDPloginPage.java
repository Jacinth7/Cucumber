/*package com.pages;


import com.qa.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PDPloginPage extends ElementUtil {

	public PDPloginPage(WebDriver driver) {
		super(driver);

	}


	private By email= By.xpath("//input[@type='email']");
	private By login= By.xpath("//input[@title='Logon']");
	private By next = By.xpath("//input[@type='submit']");
	private By password = By.xpath("//input[@type='password']");
	private By signin = By.xpath("//input[@type='submit']");



	public void EnterEmail1(String useremail) throws Throwable {

		explicitWait(email);
		elementSendKeys(email, useremail);

	}

	public void ClickNext() throws Throwable {

		explicitWait(next);
		elementClick(next);
	}

	public void EnterPassword(String pwd) throws Throwable {

		explicitWait(password);
		elementSendKeys(password, pwd);
	}

	public void clickSignin() throws Throwable {

		explicitWait(password);
		elementClick(signin);
	}



	
	
	
} */