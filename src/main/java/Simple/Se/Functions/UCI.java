package Simple.Se.Functions;

import java.io.IOException;

import org.openqa.selenium.Keys;

public class UCI extends behavioralFunctions{
	
	@Override
	public void login(String user){
			gui.setText(element.getField("Login.Email"), credentials.getUsername(user));
			gui.click(element.getField("Login.Next"));
			gui.setText(element.getField("Login.Password"), credentials.getPassword(user));
			gui.click(element.getField("Login.SignIn"));
			gui.click(element.getField("Login.StaySignedIn"));
			gui.clickIfExists(element.getField("Welcome.Continue"));
	}
	@Override
	public void doesNotExist(String string) throws Throwable {
		if(!gui.elementExists(element.getField(string))){
			lastPassed=false;
		}
	}
	@Override
	public void signOut() throws Throwable {
		gui.clickIfExists(element.getField("Submit.SaveInProgressOK"), 500);
		gui.waitForPageToLoad();
		gui.click(element.getField("CRMMenu.User"), 500);
		gui.click(element.getField("CRMUser.SignOut"));
	}
	@Override
	public void submitSR() throws Throwable {
		gui.click(element.getField("SR_Options.Submit"));
	}
	@Override
	public void navigateToSRArea() throws Throwable {
		gui.click(element.getField("Apps.CallCenterManager"));
		frames.clear();
		gui.click(element.getField("Area.Change"));
		//gui.click(element.getOptionList("Area.Change"));
		gui.click(element.replaceTagValue("Area.Change","OptionsList", "NYC311"));
		gui.click(element.getField("Extensions.ServiceRequests"));
	}
	@Override
	public void startNewSR() throws Throwable {
		gui.click(element.getField("SR_Options.New"));
		gui.waitForPageToLoad();
	}
	@Override
	public void selectForm(String string) throws Throwable {
		gui.click(element.getField("NYC311SR.FormSelector"),500);
		gui.click(element.replaceTagValue("NYC311SR.FormSelector","OptionsList", utility.getValue(string)),500);
		gui.clickIfExists(element.getField("NYC311SR.DiscardChanges"),500);
		utility.wait(500);
	}
	@Override
	public void validateSRCreation() throws InterruptedException {
		gui.waitForPageToLoad();
		gui.hasText(element.getField("NYC311Submit.SubmitText"),"SR#");
		gui.click(element.getField("Submit.Ok"));
	}
	@Override
	public void lookupSelect(String objectString, String value) throws Throwable {
		gui.click(element.getField(objectString));
		gui.sendKeys(element.getField(objectString), utility.getValue(value));
		gui.click(element.replaceTagValue(objectString,"OptionsList", utility.getValue(value)),1800);
	}
	@Override
	public void searchSelect(String objectString, String value) {
		gui.sendKeys(element.getField(objectString), utility.getValue(value));
		gui.sendUntilFound(Keys.ENTER, element.getField(objectString), element.getOptionList(objectString), 4);
		gui.click(element.getOptionList(objectString));
	}
	@Override
	public void optionSetSelect(String string, String string2) throws Throwable {
		gui.click(element.getField(string));
		gui.click(element.replaceTagValue(string,"OptionsList", utility.getValue(string2)),500);
		utility.wait(500);
	}
	@Override
	public void toggleRadioButton(String string, String string2) throws Throwable {
		gui.clickIfExists(element.getOther(string, "emptyRadio"));
		String fieldText = gui.getAttribute(element.getOther(string, "populatedRadio"),"title");
		if(!utility.compareText(utility.getValue(string2), fieldText)) {
			gui.click(element.getOther(string, "populatedRadio"));
			utility.wait(1000);
			fieldText = gui.getAttribute(element.getOther(string, "populatedRadio"),"title");
			if(!utility.compareText(utility.getValue(string2), fieldText)) {
				lastPassed=false;
			}
		}
	}
	@Override
	public void objectExists(String string) throws Throwable {
		gui.waitForPageToLoad();
		utility.wait(500);
		if(!gui.elementExists(element.getField(string))){
			lastPassed=false;
		}
	}
	@Override
	public void setText(String string, String string2) throws Throwable {
		gui.setText(element.getField(string), utility.getValue(string2));
	}
	@Override
	public void clickButton(String string) throws Throwable {
		gui.click(element.getField(string));
	}
	@Override
	public void containsText(String string, String string2) throws Throwable {
		String txt = gui.getText(element.getField(string));
		if(!txt.contains(utility.getValue(string2))) {
			errorDesc = "\"" + utility.getValue(string2) +"\" was not found in Object text";
			lastPassed = false;
		}
	}
	@Override
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
	@Override
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
@Override
	public void validateLabel(String string, String string2) throws IOException{
		if(!gui.elementExist(element.replaceTagValue(string,"OptionsList", utility.getValue(string2.substring(1, string2.length()-1))))) {
			errorDesc = utility.getValue(string2) + " label does not Exist \"";
			lastPassed= false;
		}
	}
}
