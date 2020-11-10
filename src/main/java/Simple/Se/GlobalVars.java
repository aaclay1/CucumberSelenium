package Simple.Se;

import java.util.List;

import com.aventstack.extentreports.ExtentTest;

import Simple.Se.Functions.behavioralFunctions;
import Simple.Se.Functions.guiFunctions;
import Simple.Se.Functions.utilityFunctions;
import Simple.Se.Reporting.Reporting;
import io.cucumber.java.Scenario;
import toolbox.JSON.JSONTool_ObjectElements;
import toolbox.JSON.JSONTools_Credentials;
import toolbox.JSON.JSONTools_ObjectMap;
import toolbox.JSON.JSONTools_Properties;
import toolbox.JSON.JSONTools_TestData;


public class GlobalVars {
	public static int shortWait = 5;
	public static int medWait = 60;
	public static int longWait = 120;
	
	public static DriverUtils driverUtils;
	public static JSONTools_Properties properties;
	public static JSONTools_ObjectMap objectMap;
	public static JSONTools_TestData testData;
	public static JSONTool_ObjectElements element;
	public static JSONTools_Credentials credentials;
	public static Reporting extentReportUtil;
	public static guiFunctions gui;
	public static utilityFunctions utility;
	public static behavioralFunctions behavioral;
	public static Object func;
	public static String objectMapFile;
	public static String credentialsFile;
	public static boolean featureParsed;
	public static boolean fullReport;
	public static boolean takeScreenCapture;
	public static boolean lastPassed;
	public static String curFeature;
	public static String preScenario;
	public static String dataFiles;
	public static String[] xpaths;
	public static String previousXpath;
	public static String automationFolder;
	public String tfeatureFiles;
	public String featureFiles;
	public static Scenario scenario1;
	public static int currentStepDefIndex;
	public static int firstError;
	public static int dataCount;
	public static int level;
	public static String currentStepDescr;
	public static String testStatusDesc;
	public static String curScenario;
	public static String screenShotFile;
	public static String preFeature;
	public static ExtentTest scenarioDef;
	public static ExtentTest features;
	public static String errorDesc;
	public static List<String> frames;
	public static String objMapFile;
	public static String searchOption;
	public static String errorXpath;
	public static String objectLabel;
	public static String curApplication;

}
