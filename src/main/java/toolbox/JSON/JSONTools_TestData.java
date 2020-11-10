package toolbox.JSON;

import java.io.File;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSONTools_TestData extends JSONTools{
	String testSuite;
	String testCase;
	String testSet;
	ObjectNode root;

	public void init() {
		setCurFile(dataFiles + File.separator + curFeature +".json");
		loadJSON();
		root = getRoot();
	}

	public void setTestSuite(String ts) {
		testSuite = ts;
	}

	public void setTestCase(String tc) {
		testCase = tc;
	}

	public void setTestSet(String tSet) {
		testSet = tSet;
	}

	public String getTestSuite() {
		return testSuite;
	}

	public String getTestCase() {
		return testCase;
	}

	public String getTestSet() {
		return testSet;
	}

	public String getValue(String attribute) {
		try {
			JsonNode object = root.get(testSuite);
			object = object.get(0);
			object = object.get(testCase);
			object = object.get(0);
			object = object.get(testSet);
			object = object.get(0);
			object = object.get(attribute);
			return object.textValue();
		}catch(Exception e) {
			utility.writeToLog(e.getMessage());
			return attribute;
		}
		
	}
}
