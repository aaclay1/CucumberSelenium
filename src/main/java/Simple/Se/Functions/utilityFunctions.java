package Simple.Se.Functions;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.google.common.io.Files;

import Simple.Se.GlobalVars;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;

public class utilityFunctions extends GlobalVars {

	public static void main(String[] args) {
	}
	
	public static String[] StringToArray(String value) {
		String[] array = value.split("");
		return array;
	}
	
	public static String getTime(String value) {
		String offSet1 = value.substring(value.indexOf("Time(")+5,value.indexOf(";")).trim();
		String format = value.substring(value.indexOf(";")+1,value.indexOf(")")).trim();
		return timeNow(offSet1, format);
	}

	public static String getDate(String value) {
		String offSet1 = value.substring(value.indexOf("Today(")+6,value.indexOf(";")).trim();
		String format = value.substring(value.indexOf(";")+1,value.indexOf(")")).trim();
		return todaysDate(offSet1, format);
	}
	public long timestamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime();
	}

	@SuppressWarnings("deprecation")
	public static String timeNow(String offSet, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		int offSetInt = Integer.parseInt(offSet.trim());
		try {
			c.setTime(dateFormat.parse(dateFormat.format(date)));
			int mins = c.getTime().getMinutes();
			if(mins>16 && mins<45) {
				mins = 30;
			}else {
				mins = 0;
			}
			c.add(Calendar.HOUR_OF_DAY, offSetInt);
			c.set(Calendar.MINUTE, mins);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return dateFormat.format(c.getTime());
	}

	public static String todaysDate(String offSet, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		int offSetInt = Integer.parseInt(offSet.trim());
		try {
			c.setTime(dateFormat.parse(dateFormat.format(date)));
			c.add(Calendar.DAY_OF_MONTH, offSetInt);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return dateFormat.format(c.getTime());
	}
	
	public void wait(int milliSec) {
		try {
			Thread.sleep(milliSec);
		}catch(Exception e) {
			lastPassed=false;
			utility.writeToLog(e.getMessage());
		}
	}
	
	public boolean compareText(String string1, String string2) {
		if(string1.equalsIgnoreCase(string2)) {
			return true;
		}
		return false;
	}
	
	public void loadXpaths(String value) {
		if(value!=null)
			xpaths = getValue(value).split(";");
	}
	
	public void deleteTempFolders() {
		String homeFolder = System.getProperty("user.home");
		automationFolder = homeFolder + File.separator + "AutomationTemp";
		deleteFolder(new File(automationFolder));
	}
	
	public void createTempFolders() {
		String homeFolder = System.getProperty("user.home");
		automationFolder = homeFolder + File.separator + "AutomationTemp";
		tfeatureFiles = automationFolder + File.separator + "Features";
		String dataFolder = automationFolder + File.separator + "Data";
		createNewFolder(automationFolder);
		createNewFolder(tfeatureFiles);
		createNewFolder(dataFolder);
		copyDir(featureFiles, tfeatureFiles);
	}
	
	public void getStepText() {
		try {
			Field f = scenario1.getClass().getDeclaredField("delegate");
			f.setAccessible(true);
			TestCaseState tcs = (TestCaseState) f.get(scenario1);

			Field f2 = tcs.getClass().getDeclaredField("testCase");
			f2.setAccessible(true);
			TestCase r = (TestCase) f2.get(tcs);

			List<PickleStepTestStep> stepDefs = r.getTestSteps()
					.stream()
					.filter(x -> x instanceof PickleStepTestStep)
					.map(x -> (PickleStepTestStep) x)
					.collect(Collectors.toList());


			PickleStepTestStep currentStepDef = stepDefs
					.get(currentStepDefIndex);
			currentStepDescr = currentStepDef.getStep().getText();

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(String varName) {
		String value;
		try {
			if(varName.startsWith("(")) {
				value = testData.getValue(varName.substring(1,varName.length()-1).trim());
				if(value.contains("Today(")) {
					    String before = value.substring(0, value.indexOf("Today("));
					    String after = value.substring(value.indexOf(")")+1, value.length());
						String date = getDate(value);
						value = before + date + after;
				}
				if(value.contains("Time(")) {
					  	String before = value.substring(0, value.indexOf("Time("));
					    String after = value.substring(value.indexOf(")")+1, value.length());
						String time = getTime(value);
						value = before + time + after;
				}
			}else {
				value = varName;
			}
			if(value.startsWith("(")) {
				if(value.contains("Leave Empty")) {
					value = "";
				}
			}
			return value;
		}catch(Exception e) {
			lastPassed=false;
			utility.writeToLog(e.getMessage());
		}
		return null;
	}
	public void buildStepDescription() {
		try{
			if(currentStepDescr.contains("(")) {
				String oValue = currentStepDescr.substring(currentStepDescr.indexOf("("),currentStepDescr.lastIndexOf(")")+1);
				testStatusDesc = currentStepDescr.replaceAll("(?<=\\().*?(?=\\))", getValue(oValue)).replace("))",")");
				testStatusDesc = testStatusDesc.replace("\"(","\"").replace(")\"","\"");
			}else {
				testStatusDesc = currentStepDescr;
			}
		}catch(Exception e) {
			lastPassed=false;
			utility.writeToLog(e.getMessage());
		}
	}
	public void editStepDescription(String oName, String oValue) {
		try{
			if(oName != null)
				currentStepDescr = currentStepDescr.replaceAll("(?<=\\{).*?(?=\\})", getValue(oName));
			if(oValue != null)
				currentStepDescr = currentStepDescr.replaceAll("(?<=\\().*?(?=\\))", getValue(oValue));
			testStatusDesc = currentStepDescr;
		}catch(Exception e) {
			lastPassed=false;
			utility.writeToLog(e.getMessage());
		}
	}
	public String getObjectName() {
		String oValue =null;
		try{
			if(currentStepDescr.contains("["))
			oValue = currentStepDescr.substring(currentStepDescr.indexOf("["),currentStepDescr.indexOf("]")+1);
		}catch(Exception e) {
			lastPassed=false;
			utility.writeToLog(e.getMessage());
		}
		return oValue;
	}
	public void beforeSubStep(String curStep) {
		try {
				currentStepDescr=curStep;
				buildStepDescription();
		    	loadXpaths(getObjectName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteFolder(File folder) {
		File[] files = folder.listFiles();
		if(files!=null) { 
			for(File f: files) {
				if(f.isDirectory()) {
					deleteFolder(f);
				} else {
					f.delete();
				}
			}
		}
		folder.delete();
	}

	public void createNewFolder(String folderName) {
		File folder = new File(folderName);
		if (!folder.exists()) 
		{
			folder.mkdir();
		}
	}

	public void createMFolders() {
		String mfolder = System.getProperty("user.home");
		String[] filePath = {".m2","repository","webdriver","chromedriver","win32","77.0.3865.40"};
		for(int i=0; i<filePath.length;i++) {
			mfolder = mfolder + File.separator + filePath[i];
			createNewFolder(mfolder);
		}
		String chromedriver = mfolder + File.separator + "chromedriver.exe";
		String localChrome =  "chromedriver.exe";
		File file = new File(chromedriver);
		if (!file.exists()) 
		{
			copyFile(localChrome,chromedriver);
		}
	}

	public static void copyFile(String from, String to) {
		Path src = Paths.get(from);
		Path dest = Paths.get(to);
		try {
			Files.copy(src.toFile(), dest.toFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void copyDir(String from, String to) {
		File src = new File(from);
		File dest = new File(to);
		try {
			copyFolder(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
			utility.writeToLog(e.getMessage());
		}
	}
	private static void copyFolder(File sourceFolder, File destinationFolder) throws IOException
	{
		//Check if sourceFolder is a directory or file
		//If sourceFolder is file; then copy the file directly to new location
		if (sourceFolder.isDirectory()) 
		{
			//Verify if destinationFolder is already present; If not then create it
			if (!destinationFolder.exists()) 
			{
				destinationFolder.mkdir();
				System.out.println("Directory created :: " + destinationFolder);
			}

			//Get all files from source directory
			String files[] = sourceFolder.list();

			//Iterate over all files and copy them to destinationFolder one by one
			for (String file : files) 
			{
				File srcFile = new File(sourceFolder, file);
				File destFile = new File(destinationFolder, file);

				//Recursive function call
				copyFolder(srcFile, destFile);
			}
		}
		else
		{
			//Copy the file content from one place to another 
			Files.copy(sourceFolder.toPath().toFile(), destinationFolder.toPath().toFile());
			System.out.println("File copied :: " + destinationFolder);
		}
	}
	public void FailTest(String details) {
		try {
			extentReportUtil.ExtentReportScreenshot();
			scenarioDef.fail(details).addScreenCaptureFromPath(screenShotFile);
			assertEquals(true, false);
		}catch (IOException e) {
			e.printStackTrace();
			utility.writeToLog(e.getMessage());
		}
	}
	
	public void writeToLog(String string) {
		try {
			FileWriter myWriter = new FileWriter("logFile.txt", true);
			myWriter.append(string);
			myWriter.append("\n");
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> readFile(String string) {
		List<String> list = new ArrayList<String>();
		try {
			int i=0;
			Scanner scanner = new Scanner(new File(string));
			while (scanner.hasNextLine()) {
				list.add(i,scanner.nextLine());
				i++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void clearLog() {
		try {
			FileWriter myWriter = new FileWriter("logFile.txt");
			myWriter.write("");
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void setStatus() throws IOException, InterruptedException {
		if(!lastPassed || fullReport || takeScreenCapture) {
			extentReportUtil.ExtentReportScreenshot();
			takeScreenCapture=false;
		}

		switch(scenario1.getStatus()) {
		case FAILED: 
			lastPassed = false;
			break;
		case SKIPPED: 
			if(fullReport) {
				scenarioDef.skip(testStatusDesc).addScreenCaptureFromPath(screenShotFile);
			}else {
				scenarioDef.skip(testStatusDesc);
			}
			break;
		default: 
			break;
		}

		if(!lastPassed) {
			scenarioDef.fail(testStatusDesc +",\n"+ errorDesc).addScreenCaptureFromPath(screenShotFile);
			errorDesc="";
		}else {
			if(fullReport) {
				scenarioDef.pass(testStatusDesc).addScreenCaptureFromPath(screenShotFile);
			}else {
				scenarioDef.pass(testStatusDesc);
			}
		}
		fullReport = Boolean.valueOf(properties.getValue("fullReport"));
	}
}
