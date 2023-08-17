package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ElementUtil;

public class HomePage extends ElementUtil {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	private By textF= By.name("q");
	private By searchButton =By.name("btnK");
	
	public void enterWord(String name) throws Throwable {
		explicitWait(textF);
		elementSendKeys(textF, name);
		
	}
	
	public void clickSrchButton() throws Throwable {
//			elementClick(searchButton);
		System.out.println("Clicked");
		
		
	}

}
