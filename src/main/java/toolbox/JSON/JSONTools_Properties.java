package toolbox.JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSONTools_Properties extends JSONTools{
	ObjectNode root;
	
	public void init() {
		setCurFile("Properties.json");
		loadJSON();
		root = getRoot();
	}
	
	public void setAttribute(String attribute, String value) {
		root.put(attribute, value);
		saveJSON();
	}
	
	public String getValue(String attribute) {
		JsonNode object = root.get(attribute);
		return object.textValue();
	}
}
