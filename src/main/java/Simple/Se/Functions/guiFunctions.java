package Simple.Se.Functions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Simple.Se.GlobalVars;

public class guiFunctions extends GlobalVars {

	public void oneCharAtATime(By locator, String value) throws IOException {
		String[] array = value.split("");
		waitForElement(locator);
		for(int i=0; i<array.length;i++) {
			GlobalVars.driverUtils.driver.findElement(locator).sendKeys(array[i].toString());
		}
	}

	public void waitForElement(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(GlobalVars.driverUtils.driver, GlobalVars.shortWait);
			waitForPageToLoad();
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			if(!elementExists(locator)){
				GlobalVars.utility.FailTest(locator + " object not found.");
			}
		}catch(Exception e) {
			GlobalVars.utility.FailTest(locator + " object not found.");
			GlobalVars.utility.writeToLog(e.getMessage());
		}
	}
	public void waitForPageToLoad() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) GlobalVars.driverUtils.driver;
		String jsCommand = "return document.readyState";
		for (int i = 0; i < 60; i++) {

			if (js.executeScript(jsCommand).toString().equals("complete")) {
				break;
			}else {
				Thread.sleep(1000);
			}
		}
	}

	public boolean elementExists(By location) {
		return !GlobalVars.driverUtils.driver.findElements(location).isEmpty();
	}



	public void hover(WebElement we) {
		Actions actions = new Actions(GlobalVars.driverUtils.driver);
		actions.clickAndHold(we);
	}
	public boolean elementExist(By locator) throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(GlobalVars.driverUtils.driver, 1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(Exception e) {
			GlobalVars.utility.writeToLog(e.getMessage());
			return false;
		}
		return true;
	}

	public String[] getIFrame(String rawIframe) {
		if(rawIframe.contains(";")) {
			return rawIframe.split(";");
		}
		return null;
	}

	public void setFrame(String iframe) {
		String[] iframes = getIFrame(iframe);
		GlobalVars.driverUtils.driver.switchTo().defaultContent();
		if(iframes != null) {
			for(int i=1;i<iframes.length;i++) {
				GlobalVars.driverUtils.driver.switchTo().frame(iframes[i]);
			}
		}
	}

	public boolean errorExist(String curXpath) {
		try {
			Thread.sleep(100);
			String errorXpath ="//img[@alt='Error']";
			String locatorString = curXpath + errorXpath;
			if(elementExists(By.xpath("//*[@id='crmNotifications']"))) {
				if(GlobalVars.driverUtils.driver.findElement(By.xpath("//*[@id='crmNotifications']")).isDisplayed()) {

				}
			}
			if(elementExists(By.xpath(locatorString))) {
				if(GlobalVars.firstError == 0) {
					GlobalVars.firstError = GlobalVars.driverUtils.driver.findElements(By.xpath(errorXpath)).indexOf(GlobalVars.driverUtils.driver.findElement(By.xpath(locatorString)));
				}
				int lastError = GlobalVars.driverUtils.driver.findElements(By.xpath(errorXpath)).indexOf(GlobalVars.driverUtils.driver.findElement(By.xpath(locatorString)));
				if(!GlobalVars.driverUtils.driver.findElement(By.xpath(locatorString)).isDisplayed()) {
					if(GlobalVars.driverUtils.driver.findElements(By.xpath(errorXpath)).get(lastError-1).isDisplayed()) {
						GlobalVars.errorDesc = GlobalVars.driverUtils.driver.findElements(By.xpath(errorXpath)).get(lastError-1).findElement(By.xpath("ancestor::td//span[contains(@class, 'InlineEditLabelText')]")).getText();
						GlobalVars.errorDesc = GlobalVars.errorDesc +":"+ GlobalVars.driverUtils.driver.findElements(By.xpath(errorXpath)).get(lastError-1).findElement(By.xpath("following::div")).getAttribute("textContent");
						GlobalVars.lastPassed= false;
						return true;
					}
				}
			}
		} catch (InterruptedException e) {
			GlobalVars.previousXpath = curXpath;
			GlobalVars.utility.writeToLog(e.getMessage());
		}
		return false;
	}

	public void clear(By locator){
		try{
			waitForElement(locator);
			GlobalVars.driverUtils.driver.findElement(locator).clear();
		}catch(Exception e) {
			GlobalVars.lastPassed=false;
			GlobalVars.utility.writeToLog(e.getMessage());
		}
	}

	public void clearValue(By locator){
		try{
			waitForElement(locator);
			int size = GlobalVars.driverUtils.driver.findElement(locator).getAttribute("value").length();
			for(int i=1;i<=size;i++) {
				GlobalVars.driverUtils.driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
			}
		}catch(Exception e) {
			GlobalVars.lastPassed=false;
			GlobalVars.utility.writeToLog(e.getMessage());
		}
	}

	public void sendUntilFound(Keys key,By locator,By locator2,int repeat){
		try{
			waitForElement(locator);
			for(int i=0; i<repeat;i++) {
				sendKeys(locator, key);
				if(!elementExist(locator2)) {
					GlobalVars.utility.wait(1000);
				}else {
					break;
				}
			}
		}catch(Exception e) {
		}
	}

	public void click(By locator){
		click(locator ,0,true);
	}

	public void click(By locator, boolean center){
		click(locator ,0,center);
	}

	public void click(By locator, int waitBefore){
		click(locator, waitBefore, true);
	}

	public void click(By locator ,int waitBefore, boolean center){
		try{
			if(waitBefore!=0)
				utility.wait(waitBefore);
			waitForElement(locator);
			if(center) {
				WebElement element = GlobalVars.driverUtils.driver.findElement(locator);
				((JavascriptExecutor) GlobalVars.driverUtils.driver).executeScript("arguments[0].scrollIntoView(true);", element);
			}
			GlobalVars.driverUtils.driver.findElement(locator).click();
		}catch(Exception e) {
			GlobalVars.lastPassed=false;
			GlobalVars.utility.writeToLog(e.getMessage());
		}
	}

	public void clickIfExists(By locator){
		clickIfExists(locator, 0);
	}

	public void clickIfExists(By locator, int waitBefore){
		try{
			if(waitBefore!=0)
				utility.wait(waitBefore);
			if(elementExist(locator)){
				waitForElement(locator);
				GlobalVars.driverUtils.driver.findElement(locator).click();
			}
		}catch(Exception e) {
			GlobalVars.lastPassed=false;
			GlobalVars.utility.writeToLog(e.getMessage());
		}
	}

	public void waitForFieldPopulation(By locator){
		for(int i=0;i<GlobalVars.medWait;i++) {
			if(getText(locator).equals("")) {
				GlobalVars.utility.wait(1000);
			}else {
				i=GlobalVars.medWait;
			}
		}
	}

	public void sendKeys(By locator,Keys key){
		sendKeys(locator, null, key);
	}

	public void sendKeys(By locator,String value){
		sendKeys(locator, value, null);
	}
	public void sendKeys(By locator,String value, Keys key) {
		try{
			waitForElement(locator);
			if(value != null) {
				GlobalVars.driverUtils.driver.findElement(locator).clear();
				GlobalVars.driverUtils.driver.findElement(locator).sendKeys(value);
			}
			if(key != null)
				GlobalVars.driverUtils.driver.findElement(locator).sendKeys(key);
		}catch(Exception e) {
			GlobalVars.lastPassed=false;
			GlobalVars.utility.writeToLog(e.getMessage());
		}
	}
	public void sendKeysDateTime(By locator,String value) {
		try{
			GlobalVars.driverUtils.driver.findElement(locator).click();
			GlobalVars.driverUtils.driver.findElement(locator).sendKeys(value);
		}catch(Exception e) {
			GlobalVars.lastPassed=false;
			GlobalVars.utility.writeToLog(e.getMessage());
		}
	}

	public String getText(By locator) {
		try{
			waitForElement(locator);
			return GlobalVars.driverUtils.driver.findElement(locator).getText();
		}catch(Exception e) {
			GlobalVars.lastPassed=false;
			GlobalVars.utility.writeToLog(e.getMessage());
		}
		return null;
	}

	public void setText(By locator, String value) {
		try{
			GlobalVars.gui.click(locator);
			GlobalVars.gui.click(locator);
			GlobalVars.gui.clearValue(locator);
			//utility.wait(500);
			GlobalVars.gui.sendKeys(locator, GlobalVars.utility.getValue(value));
		}catch(Exception e) {
			GlobalVars.lastPassed=false;
			GlobalVars.utility.writeToLog(e.getMessage());
		}
	}

	public String getAttribute(By locator, String attribute) {
		try{
			waitForElement(locator);
			return GlobalVars.driverUtils.driver.findElement(locator).getAttribute(attribute);
		}catch(Exception e) {
			GlobalVars.lastPassed=false;
			GlobalVars.utility.writeToLog(e.getMessage());
		}
		return null;
	}

	public boolean hasText(By locator, String text) {
		try{
			waitForElement(locator);
			String txt = GlobalVars.gui.getText(locator);
			if(!txt.contains(text)) {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		return true;
	}
}
