package Simple.Se.Reporting;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Timestamp;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Simple.Se.GlobalVars;

public class Reporting extends GlobalVars{

	String reportName = utility.timestamp()+ "ExtentsReport.html";
	public ExtentReports extent;
	public ExtentHtmlReporter htmlReporter;
	String finalReport;
	String finalReport2;
	String reportLocation ="Reports";
	String screenShotFile2;
	
	public void ExtentReport() {
		finalReport = reportLocation + File.separator + reportName;
		finalReport2 = automationFolder + File.separator + "Reports" + File.separator + reportName;
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(finalReport);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Test Report For Selenium Simple");
		htmlReporter.config().setEncoding("utf=8");
	}
	
	public void ExtentReportScreenshot() throws IOException{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		utility.createNewFolder(reportLocation);
		utility.createNewFolder(reportLocation + File.separator + "ScreenShots");
		utility.createNewFolder(reportLocation + File.separator + "ScreenShots" + File.separator + reportName.replace(".html", ""));
		screenShotFile = reportLocation + File.separator + "ScreenShots" + File.separator + reportName.replace(".html", "") + File.separator + curFeature +"_"+ curScenario +"_"+ timestamp.getTime()+".png";
		File des = new File(screenShotFile);
		File scr = ((TakesScreenshot)driverUtils.driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scr.toPath(), des.toPath());
		screenShotFile = des.getAbsolutePath();
		utility.createNewFolder(automationFolder + File.separator + "Reports");
		utility.createNewFolder(automationFolder + File.separator + "Reports" + File.separator + "ScreenShots");
		utility.createNewFolder(automationFolder + File.separator + "Reports" + File.separator + "ScreenShots" + File.separator + reportName.replace(".html", ""));
		screenShotFile2 = automationFolder + File.separator + "Reports" + File.separator + "ScreenShots" + File.separator + reportName.replace(".html", "") + File.separator + curFeature +"_"+ curScenario +"_"+ timestamp.getTime()+".png";
		des = new File(screenShotFile2);
		scr = ((TakesScreenshot)driverUtils.driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scr.toPath(), des.toPath());
		screenShotFile2 = des.getAbsolutePath();
		utility.writeToLog(screenShotFile);
	}

	public void FlushReport() {
		extent.flush();
	}
}
