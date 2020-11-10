package toolbox.JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSONTools_ObjectMap extends JSONTools{

	String testPage;
	ObjectNode root;

	public void init() {
		setCurFile(objMapFile);
		loadJSON();
		root = getRoot();
	}

	public void setTestPage(String tp) {
		testPage = tp;
	}

	public String getTestPage() {
		return testPage;
	}

	public String getValue(String attribute) {
		try {
			String[] attArray = attribute.split("\\.");
			JsonNode object = root;
			for(int i=0;i<attArray.length;i++) {
				object = object.get(attArray[i]);
				if(i < attArray.length-1) {
					object = object.get(0);	
				}	
			}
			return object.textValue();
		}catch(Exception e) {
			scenarioDef.fail(attribute + " not found in ObjectMap.json");
			utility.writeToLog(e.getMessage());
			return null;
		}
	}
}
