package toolbox.JSON;
import org.openqa.selenium.By;

import com.fasterxml.jackson.databind.JsonNode;

import Simple.Se.GlobalVars;

public class JSONTool_ObjectElements extends JSONTools {

	private JsonNode applicationObjects;
	
	public void init() {
		setCurFile(GlobalVars.objectMapFile);
		loadJSON();
		applicationObjects = getRoot().get(curApplication).get(0);
	}
	
	public JsonNode getObjInfo(String objectName) {
		return applicationObjects.get(objectName.replace("[", "").replace("]","")).get(0);
	}
	
	public JsonNode getXpaths(String objectName) {
		return getObjInfo(objectName.replace("[", "").replace("]","")).get("xpaths").get(0);
	}
	
	public By getError(String objectName) {
		return By.xpath(setXpath(objectName.replace("[", "").replace("]",""), "error"));
	}

	public By getOptionList(String objectName) {
		return By.xpath(setXpath(objectName.replace("[", "").replace("]",""), "OptionsList"));
	}
	
	public By getField(String objectName) {
		return By.xpath(setXpath(objectName.replace("[", "").replace("]",""), "Field"));
	}

	public By getValueField(String objectName) {
		return By.xpath(setXpath(objectName.replace("[", "").replace("]",""), "Value"));
	}

	public By getLabel(String objectName) {
		return By.xpath(setXpath(objectName.replace("[", "").replace("]",""), "Label"));
	}
	
	public By getOther(String objectName, String otherAttr) {
		return By.xpath(setXpath(objectName.replace("[", "").replace("]",""), otherAttr));
	}
	
	public By getFieldType(String objectName) {
		return By.xpath(getXpath(getObjInfo(objectName.replace("[", "").replace("]","")).get("FieldType").textValue()));
	}
	
	public By replaceTagValue(String objectName, String otherAttr, String value) {
		return By.xpath(setXpath(objectName.replace("[", "").replace("]",""), otherAttr).replace("''", "'"+ value+"'").trim());
	}
	
	public JsonNode getApplicationObjects() {
		return applicationObjects;
	}
	
	public String getXpath(String rawXpath) {
		gui.setFrame(rawXpath);
		if(rawXpath.contains(";")) {
			return rawXpath.split(";")[0];
		}
		return rawXpath;
	}
	
	public void setApplicationObjects(JsonNode applicationObjects) {
		this.applicationObjects = applicationObjects;
	}
	
	public String setXpath(String objectName, String xpathName) {
		return getXpath(getXpaths(objectName.replace("[", "").replace("]","")).get(xpathName).textValue());
	}
}