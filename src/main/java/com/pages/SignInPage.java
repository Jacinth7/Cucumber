package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ElementUtil;

public class SignInPage extends ElementUtil {

	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	private By signIn= By.xpath("//span[text()='Sign in']");
	private By username= By.id("identifierId");
	
	public void sign() throws Throwable {
		explicitWait(signIn);
		elementClick(signIn);
	}
	
	public void enterUsername() throws Throwable {
		explicitWait(username);
		elementSendKeys(username, "testing@test.com");
		
	}
	

}
