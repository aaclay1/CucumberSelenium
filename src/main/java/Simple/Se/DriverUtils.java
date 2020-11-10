package Simple.Se;

import java.io.File;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtils{

	public WebDriver driver;
	public boolean driverClosed;
	
	
	/**
	 * Set driver to a specific browser type
	 * Add case for each additional browser type
	 */
	public void setDriver() {
		switch(GlobalVars.properties.getValue("browser")) {
		case "CHROME": StartChromeDriver();
		break;
		}  
		
		driverClosed = false;
	}
	
	/**
	 * Set driver to a closed state
	 */
	public void closeDriver() {
		driver.close();
	}
	
	/**
	 * load driver
	 */
	public  WebDriver getdriver() {
		return driver;
	}
	
	/**
	 * Establish the Chrome Driver
	 */
	public void StartChromeDriver() {
		String homeDirectory = System.getProperty("user.home");
		String chromeDriverDirectory = homeDirectory + File.separator + ".m2" + File.separator 
				+ "repository" + File.separator 
				+ "webdriver" + File.separator 
				+ "chromedriver" + File.separator 
				+ "win32" + File.separator 
				+ "77.0.3865.40";
		String chromeDriver =  chromeDriverDirectory + File.separator + "chromedriver.exe";
		try {
			System.setProperty("webdriver.chrome.driver", chromeDriver);   
			driver = new ChromeDriver();
		}catch(SessionNotCreatedException e) {
			System.out.println("Session Not Created!");
			System.out.println("Got to http://chromedriver.chromium.org/downloads");
			System.out.println("Download the latest ChromeDriver that matches your current version of Chrome");
			System.out.println("Place that version in this folder:" + chromeDriverDirectory);
			GlobalVars.utility.writeToLog(e.getMessage());
		}
	}

}
