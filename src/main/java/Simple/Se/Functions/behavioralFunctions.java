package Simple.Se.Functions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import Simple.Se.GlobalVars;
import io.restassured.response.Response;
import toolbox.JSON.JSONTool_ObjectElements;

/**
 * Parent Class for behavioralFunctions
 */
public class behavioralFunctions extends GlobalVars{

	/**
	 * Engage the select browser and load the given web application.
	 * @param AppName
	 */
	public void launchApplication(String AppName){
		curApplication = utility.getValue(AppName).toUpperCase();
		driverUtils.setDriver();
		driverUtils.driver.manage().window().maximize();
		driverUtils.driver.get(properties.getValue(curApplication));
		level=0;
		frames = new ArrayList<String>();
	}
	
	/**
	 * Engage the select browser and load the given web application.
	 * @param AppName
	 */
	public void launchURL(String url){
		driverUtils.setDriver();
		driverUtils.driver.manage().window().maximize();
		driverUtils.driver.get(utility.getValue(url));
		level=0;
		frames = new ArrayList<String>();
		curApplication = "General";
		element = new JSONTool_ObjectElements();
		element.init();
	}
	
	/**
	 * Log into set application with given user.
	 * @param user
	 */
	public void login(String user){}
	/**
	 * Log into set application with given user.
	 * @param user
	 */
	public void getIGNITE(){
		gui.click(By.xpath("//a[text()='re-login here!']"));
		gui.setText(By.xpath("//input[@type='email']"), utility.getValue("Login.Email"));
		gui.setText(By.xpath("//input[@type='password']"), utility.getValue("Login.Password"));
		gui.click(By.xpath("//button[@type='submit']"));
		gui.click(By.xpath("//button[@href='#/q_apps']"));
		gui.setText(By.xpath("//input[@placeholder='Keyword Search']"), utility.getValue("Search.App"));
		gui.click(By.xpath("//div[text()='" + utility.getValue("Search.App") + "']"));
	}

	public void api_GET() {
		String baseURL = "https://services1.arcgis.com/oOUgp466Coyjcu6V/arcgis/rest/services/HotSpots_Union_Dissolve/FeatureServer/0/query";
		//?f={f}&geometry={geometry}&outFields={outFields}&spatialRel={spatialRel}&where={where}&geometryType={geometryType}&inSR={inSR}&outSR={outSR}
		HashMap<String,String> hm = new HashMap<String, String>();
		hm.put("f", "json");
		hm.put("geometry", "{\"spatialReference\":{\"wkid\":102718},\"x\":989978,\"y\":\" 176108\"}");
		hm.put("outFields", "*");
		hm.put("spatialRel", "esriSpatialRelIntersects");
		hm.put("where", "1=1");
		hm.put("geometryType", "esriGeometryPoint");
		hm.put("inSR", "102718");
		hm.put("outSR", "102718");
		@SuppressWarnings("deprecation")
		Response response = given().baseUri(baseURL).queryParameters(hm).get();
		System.out.println("Response:" + response.asString());
	}
	
	/**
	 * Validation if a given object exists on the page
	 * @param string
	 * @throws Throwable
	 */
	public void doesNotExist(String string) throws Throwable {}

	/**
	 * Run SignOut procedure for current application.
	 * @throws Throwable
	 */
	public void signOut() throws Throwable{}
	public void submitSR() throws Throwable {}
	public void navigateToSRArea() throws Throwable {}
	public void startNewSR() throws Throwable {}

	public void selectForm(String string) throws Throwable {
		gui.click(element.getField("NYC311SR.FormSelector"),500);
		gui.click(element.replaceTagValue("NYC311SR.FormSelector","OptionsList", utility.getValue(string)),500);
		gui.clickIfExists(element.getField("NYC311SR.DiscardChanges"),500);
		wait(500);
	}

	public void enterAzureTestSteps() throws Throwable {
		gui.waitForPageToLoad();
		List<String> steps = utility.readFile("");
		for(String step:steps) {
			gui.setText(element.getField("TestCase.Step"), step);
		}
	}

	public void validateSRCreation() throws Throwable {
		gui.waitForPageToLoad();
		gui.hasText(element.getField("NYC311Submit.SubmitText"),"SR#");
		gui.click(element.getField("Submit.Ok"));
	}

	public void lookupSelect(String objectString, String value) throws Throwable {
		gui.click(element.getField(objectString));
		gui.sendKeys(element.getField(objectString), utility.getValue(value));
		gui.click(element.replaceTagValue(objectString,"OptionsList", utility.getValue(value)),1800);
	}

	public void searchSelect(String objectString, String value) {
		gui.sendKeys(element.getField(objectString), utility.getValue(value));
		gui.sendUntilFound(Keys.ENTER, element.getField(objectString), element.getOptionList(objectString), 4);
		gui.click(element.getOptionList(objectString), false);
	}

	public void optionSetSelect(String string, String string2) throws Throwable {
		gui.click(element.getField(string));
		gui.click(element.replaceTagValue(string,"OptionsList", utility.getValue(string2)),500);
		utility.wait(500);
		gui.sendKeys(element.getField(string), Keys.ENTER);
	}

	public void toggleRadioButton(String string, String string2) throws Throwable {
		gui.clickIfExists(element.getOther(string, "emptyRadio"));
		String fieldText = gui.getAttribute(element.getOther(string, "populatedRadio"),"aria-label");
		if(!utility.compareText(utility.getValue(string2), fieldText)) {
			gui.click(element.getOther(string, "populatedRadio"));
			utility.wait(1000);
			fieldText = gui.getAttribute(element.getOther(string, "populatedRadio"),"aria-label");
			if(!utility.compareText(utility.getValue(string2), fieldText)) {
				lastPassed=false;
			}
		}
	}

	public void objectExists(String string) throws Throwable {
		gui.waitForPageToLoad();
		int waitTime=0;
		while(!gui.elementExists(element.getField(string)) && waitTime<60){
			utility.wait(1000);
			waitTime++;
		}
		if(!gui.elementExists(element.getField(string))){
			lastPassed=false;
		}
	}

	public void setText(String string, String string2) throws Throwable {
		gui.setText(element.getField(string), utility.getValue(string2));
	}

	public void clickButton(String string) throws Throwable {
		gui.click(element.getField(string));
	}

	public void containsText(String string, String string2) throws Throwable {
		String txt = gui.getText(element.getField(string));
		if(!txt.contains(utility.getValue(string2))) {
			errorDesc = "\"" + utility.getValue(string2) +"\" was not found in Object text";
			lastPassed = false;
		}
	}

	public void hasError(String string) {
		fullReport=true;
		gui.waitForElement(element.getField(string));
		gui.click(element.getField("SR_Options.Save"));
		utility.wait(500);
		if(gui.elementExists(element.getError(string))){
			String isHidden = driverUtils.driver.findElement(element.getError(string)).getAttribute("aria-hidden");
			if(isHidden.equals("true")) {
				errorDesc = element.getError(string) + " is not visible \"";
				lastPassed= false;
			}
		}else {
			errorDesc = element.getError(string) + " does not Exist \"";
			lastPassed= false;
		}
	}

	public void validateErrorMsg(String string,String string2) {
		fullReport=true;
		gui.waitForElement(element.getField(string));
		utility.wait(500);
		gui.click(element.getField(("[SR_Options.Save]")));
		if(gui.elementExists(element.getError(string))){
			String isHidden = driverUtils.driver.findElement(element.getError(string)).getAttribute("aria-hidden");
			if(isHidden.equals("true")) {
				errorDesc = element.getError(string) + " is not visible \"";
				lastPassed= false;
			}else {
				if(!gui.getText(element.getError(string)).contains(string2.replace("(", "").replace(")", ""))) {
					errorDesc = string2.replace("(", "").replace(")", "") + " does not equal " + gui.getText(element.getError(string)) ;
					lastPassed= false;
				}
			}
		}else {
			errorDesc = element.getError(string) + " does not Exist \"";
			lastPassed= false;
		}
	}

	public void validateLabel(String string, String string2) throws IOException{
		if(!gui.elementExist(element.replaceTagValue(string ,"OptionsList", utility.getValue(string2.substring(1, string2.length()-1))))) {
			errorDesc = utility.getValue(string2) + " label does not Exist \"";
			lastPassed= false;
		}
	}

}

