package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import Simple.Se.DriverUtils;
import Simple.Se.GlobalVars;
import Simple.Se.Functions.guiFunctions;
import Simple.Se.Functions.utilityFunctions;
import Simple.Se.Reporting.Reporting;
import io.cucumber.core.gherkin.FeatureParserException;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import toolbox.JSON.JSONTools_Credentials;
import toolbox.JSON.JSONTools_ObjectMap;
import toolbox.JSON.JSONTools_Properties;
import toolbox.JSON.JSONTools_TestData;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue = "stepdefinitions",
		strict = true
		)
public class RunCukesTest extends GlobalVars {
	static File featureFolder;
	static File dataFolder;

	@BeforeClass
	public static void startAll() {

		//Initiate Functions and Utilities
		if(properties==null) {
			properties = new JSONTools_Properties();
			properties.init();
		}
		utility = new utilityFunctions();
		driverUtils = new DriverUtils();
		objectMap = new JSONTools_ObjectMap();
		testData = new JSONTools_TestData();
		extentReportUtil = new Reporting();
		gui = new guiFunctions();
		
		credentials = new JSONTools_Credentials();

		try {
			objectMap.init();
			testData.init();
			credentials.init();
			extentReportUtil.ExtentReport();
			featureParsed=true;
			fullReport = Boolean.valueOf(properties.getValue("fullReport"));
			utility.writeToLog("Loaded Object Map");

		}catch(FeatureParserException a) {
			utility.writeToLog(a.getMessage());
		}
	}
	@AfterClass
	public static void endAlll() {
		utility.writeToLog("Creating Report");
		extentReportUtil.FlushReport();
	}
	

}
