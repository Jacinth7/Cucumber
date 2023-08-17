package com.qa.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ElementUtil {

	private static com.qa.util.ConfigReader ConfigReader;
	private static Properties prop;
	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Some exception occured while creating webelement " + locator);
		}
		return element;
	}
	
	public int getTotalelements(By locator) {
		//WebElement element = null;
		int total = 0;
		try {
			List<WebElement> a = driver.findElements(locator);
			 total = a.size();
		} catch (Exception e) {
			System.out.println("Some exception occured while creating webelement " + locator);
		}
		
		return total;
	}

	
	public void draganddrop(By source, By target) throws Throwable {
		Actions acc = new Actions(driver);
		// acc.dragAndDrop(source, target);
		acc.dragAndDrop(getElement(source), getElement(target)).build().perform();
	}

	public void accept() {
		try {
			Alert confirm_alert = driver.switchTo().alert();
			confirm_alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getText(By locator) {
		return getElement(locator).getText();
	}

	public void dismiss() {
		try {
			Alert cancel_alert = driver.switchTo().alert();
			cancel_alert.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public void waitForElementPresent(By locator) {
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//	}
//
//	public void waitForTitlePresent(String title) {
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.titleContains(title));
//	}

	public void elementClick(By locator) {
		getElement(locator).click();
	}
	public void elementPaste() throws AWTException {

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	public void elementEnter() throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void ChooseFile() {

	//	WebElement uploadDoc = driver.findElement(By.id("upload-field"));
	//	uploadDoc.sendKeys("C:\\Users\\56889\\Downloads\\invalidAuthToken.pdf");
		WebElement uploadDoc = driver.findElement(By.xpath("//label[text()='Choose file to upload']"));
		uploadDoc.sendKeys("./document/invalidAuthToken.pdf");
	}

	public void drop_down(WebElement element, String type, String value, String index) {
		Select s = new Select(element);
		try {
			if (type.equalsIgnoreCase("index")) {
				s.selectByIndex(Integer.parseInt(index));
			} else if (type.equalsIgnoreCase("value")) {
				s.selectByValue(value);
			} else if (type.equalsIgnoreCase("text")) {
				s.selectByVisibleText(value);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public void elementSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void SendKeys(CharSequence... keysToSend) {
	}

	public String getPageTitle() {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception occurred while getting the title " + title);
		}
		return title;
	}

	public void close() {
		driver.close();
	}

	public void quit() {
		driver.quit();
	}

	public void threadwait() throws Throwable {
		Thread.sleep(3000);
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public void implicitWait() throws Throwable {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void explicitWait(By locator) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public void pageloadWait() throws Throwable {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	public void SelectVisible(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	public static String Readprop(String globalvar) {
		ConfigReader = new ConfigReader();
		prop = ConfigReader.init_prop();
		String globalvariable = prop.getProperty(globalvar);
		return globalvariable;
	}

	public void TakeScreenshot(String fileName) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		String current = System.getProperty("user.dir");
		// System.out.println(current);
		File destination = new File(current + "\\TestScreenshot\\" + fileName + ".png");
		FileUtils.copyFile(source, destination);

	}

	public List<WebElement> getElementList(By locator) {

		List<WebElement> element = null;
		try {
			element = driver.findElements(locator);
		} catch (Exception e) {
			System.out.println("Some exception occured while creating webelement " + locator);
		}
		return element;
	}

	public void waitforloadingicon(By locator) throws Throwable {

		List<WebElement> icon = getElementList(locator);
		int count = 0;
		while (icon.size() != 0 && count < 13) {
			Thread.sleep(1000);
			count++;
		}
	}

//	public void waitforinvisible(By locator) {
//
//		WebDriverWait wait = new WebDriverWait(driver, 110);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//
//	}

	public void clickSingleaction(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
		a.click(e).build().perform();

	}

	public void MoveSingleaction(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();

	}

	public void sendValueaction(WebElement e, String value) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
		a.click(e).sendKeys(value).perform();

	}
	
//	public void uploadDocuments(String fileName) throws Throwable {
//		try {
//		 String filePath = System.getProperty("user.dir") + "\\document\\" + fileName;
//		 System.out.println(filePath);
//		 
//		// C:\\Users\\70478\\Downloads\\NDA_Employee_Declaration.pdf
//		 By choosefile = By.xpath("//label[text()='Choose file to upload']");
//		 elementClick(choosefile);
//		// waitforinvisible(choosefile);
//		 explicitWait(choosefile);
//		 sendFilepath(filePath);
//		 implicitWait();
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		}	 
//		
//	}

	private void sendFilepath(String sFilePath) throws Throwable {

		try {
			StringSelection strSel = new StringSelection(sFilePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);

			Robot robot = new Robot();

			implicitWait();
			robot.delay(250);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			implicitWait();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			implicitWait();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(250);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	public WebElement getElements(By locator) {
//		WebElement element = null;
//		try {
//			waitForElementPresent(locator);
//			element = driver.findElement(locator);
//			System.out.println("Pensionwise Clicked ");
//		} catch (Exception e) {
//			System.out.println("Some exception occured while creating webelement " + locator);
//		}
//		return element;
//	}
	
	
	public void javascriptClick(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", locator);
		
	}
	

}
