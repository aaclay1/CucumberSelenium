package toolbox.JSON;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import Simple.Se.GlobalVars;

public class JSONTools extends GlobalVars {
	public String curJSON;
	public String curFile;
	public ObjectNode rootNode;
	public JsonNode curNode;

	/**
	 * copyJSON : create a copy of another JSON
	 * @param templateJSONName : JSON to be copied
	 * @param newJSONName : name of the new JSON
	 */
	public void copyJSON(String templateJSONName, String newJSONName) {
		//		String templateJSON = GlobalVars.templatesFolder + File.separator + templateJSONName + ".json";
		//		try {
		//			File templateFile = new File(templateJSON);
		//			if(templateFile.exists()) {
		//				curJSON = newJSONName +"_"+ et.getSheetName() + ".json";
		//				curFile = GlobalVars.outputFolder + File.separator + curJSON;
		//				FileUtils.copyFile(new File(templateJSON),new File(curFile));
		//
		//				ft.writeToLog("creating: " + et.getCellValue() + "_" + et.getSheetName() + ".json" , true);
		//			}
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//			ft.writeToLog("Failed Creation: " + et.getCellValue() + "_" + et.getSheetName() + ".json : " + e , true);
		//		}
	}
	
	public void setCurFile(String value) {
		curFile = value;
	}
	
	public String getCurFile() {
		return curFile;
	}
	
	public ObjectNode getRoot() {
		System.out.println(rootNode);
		return rootNode;
	}
	/**
	 * @return
	 */
	public JsonNode getJSONValue(String attrPath) {
		ObjectNode container = getChildAttr(attrPath);
		String[] attrTree = attrPath.split(":");
		if(container != null) {
			return container.findValue(attrTree[attrTree.length-1]);
		}else {
			return null;
		}
	}

	/**
	 * getChildAttr : returns the last object listed in a header
	 * @param attrPath
	 * @return
	 */
	public ObjectNode getChildAttr(String attrPath) {
		//Split the header into individual values 
		String[] attrTree = attrPath.split(":");
		JsonNode path = rootNode;
		String lastAtt = null;
		for(int i=0;i<attrTree.length-1;i++) {
			lastAtt = attrTree[i];
			if(path != null) {
				path =  path.findValue(lastAtt);
			}	
		}
		if(path != null) {
			if(path.findValue(attrTree[attrTree.length-1]) != null) {
				if(path != null) {
					if(path.isArray()) {
						path = path.get(0);
					}
				}
			}else {
				path = null;
			}
		}
		return (ObjectNode) path;
	}

	/**
	 * setValue : places a value to a given attribute based on the node type
	 * @param container
	 * @param attrTree
	 * @param value
	 */
	public void setValue(ObjectNode container, String lastAttr, String value) {

		if(container != null) {
			JsonNodeType nodeType = container.get(lastAttr).getNodeType();
			switch(nodeType.toString()){
			case "STRING":
				container.put(lastAttr, value);
				break;
			case "NUMBER":
				try {
					if(value.contains("/.")) {
						container.put(lastAttr, Double.valueOf(value));
					}else if (value.contentEquals("")) {
						container.put(lastAttr, 10);
					}else {
						container.put(lastAttr, Integer.parseInt(value));
					}
					break;
				}catch(NumberFormatException e) {
					utility.writeToLog(e.getMessage());
				}
			case "BOOLEAN":
				try {
					if(value.toUpperCase().equals("TRUE")) {
						container.put(lastAttr, true);
					}else {
						container.put(lastAttr, false);
					}
					break;
				}catch(Exception e) {
					utility.writeToLog(e.getMessage());
				}
			}
		}
	}
	public void newRootNode() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			rootNode = (ObjectNode) objectMapper.readTree("{}");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			utility.writeToLog(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			utility.writeToLog(e.getMessage());
		}
	}


	/**
	 * setValue : places a value to a given attribute based on the node type
	 * @param container
	 * @param attrTree
	 * @param value
	 */
	public void createNode(ObjectNode container, String lastAttr, String value) {
		container.put(lastAttr, value);
	}
	/**
	 * setValue : places a value to a given attribute based on the node type
	 * @param container
	 * @param attrTree
	 * @param value
	 */
	public void createNode(ObjectNode container, String lastAttr, int value) {
		container.put(lastAttr, value);
	}
	/**
	 * setValue : places a value to a given attribute based on the node type
	 * @param container
	 * @param attrTree
	 * @param value
	 */
	public void createNode(ObjectNode container, String lastAttr, double value) {
		container.put(lastAttr, value);
	}
	/**
	 * setValue : places a value to a given attribute based on the node type
	 * @param container
	 * @param attrTree
	 * @param value
	 */
	public void createNode(ObjectNode container, String lastAttr, boolean value) {
		container.put(lastAttr, value);
	}
	/**
	 * setValue : places a value to a given attribute based on the node type
	 * @param container
	 * @param attrTree
	 * @param value
	 */
	public void createNode(ObjectNode container, String lastAttr, ObjectNode value) {
		container.putObject(lastAttr);
	}
	/**
	 * setValue : places a value to a given attribute based on the node type
	 * @param container
	 * @param attrTree
	 * @param value
	 */
	public void createNode(ObjectNode container, String lastAttr, ArrayNode value, boolean subObject) {
		if(subObject) {
			container.putArray(lastAttr).addObject();
		}else {
			container.putArray(lastAttr);
		}
	}
	/**
	 * setValue : places a value to a given attribute based on the node type
	 * @param container
	 * @param attrTree
	 * @param value
	 */
	public void setValue(ObjectNode container, String lastAttr, JsonNode value) {
		if(container != null) {
			container.get(lastAttr).getNodeType();
			container.put(lastAttr, value);
		}
	}

	/**
	 * getAttributeType: opens the schema file with the same name as the current Sheet
	 * 	Navigates to the attribute listed in the header of the current column
	 *  returns the attribute type
	 */
	public void getAttributeType() {
		//curFile = GlobalVars.schemasFolder + File.separator + GlobalVars.curSchema + ".json";
		loadJSON();

	}
	/**
	 * loadJSON : Loads JSON as a rootNode
	 * @param filePath Path of the file to be loaded
	 * @return
	 */
	public boolean loadJSON() {
		ObjectMapper objectMapper = new ObjectMapper();
		byte[] jsonData;
		boolean fileExists = false;
		File tempFile=null;
		System.out.println(curFile);
		if(curFile != null) {
			tempFile = new File(curFile);
			fileExists = tempFile.exists();
		}else {
			fileExists = false;
		}

		try {
			if(fileExists) {
				jsonData = Files.readAllBytes(Paths.get(curFile));
				rootNode = (ObjectNode) objectMapper.readTree(jsonData);
			}
		} catch (IOException e) {
			utility.writeToLog(e.getMessage());
			e.printStackTrace();
		} catch (ClassCastException e) {
			utility.writeToLog(e.getMessage());
			fileExists = false;
		}
		return fileExists;
	}

	public void setToLowerCamelCase(boolean set) {
		//		ObjectMapper objectMapper = new ObjectMapper();
		//		String newRoot = "";
		//		String firstLetter ="";
		//		FileTools ft = new FileTools();
		//		List<String> lineByLine = ft.readInFile(curFile);
		//		for(int i =0; i<lineByLine.size();i++) {
		//			String curLine = lineByLine.get(i).trim();
		//			if(curLine.startsWith("\"")) {
		//				if(set) {
		//					firstLetter = curLine.substring(1, 2).toLowerCase();
		//				}else {
		//					firstLetter = curLine.substring(1, 2).toUpperCase();
		//				}
		//
		//				newRoot = newRoot + " \"" + firstLetter + curLine.substring(2);
		//			}else {
		//				newRoot = newRoot + " " + curLine;
		//			}
		//		}
		//		try {
		//			rootNode = (ObjectNode) objectMapper.readTree(newRoot);
		//		} catch (JsonProcessingException e) {
		//			e.printStackTrace();
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}catch (ClassCastException e) {
		//			rootNode = null;
		//		}
	}

	/**
	 * saveJSON: Saves the rootNode to a JSON file
	 */
	public void saveJSON() {
		ObjectMapper jSONObjectMapper = new ObjectMapper();
		try {
			if(curFile !=null) {
				String filePath = "";
				if(curFile.lastIndexOf(File.separator) > 0) {
					filePath = curFile.substring(0, curFile.lastIndexOf(File.separator));
				}else {
					filePath = curFile;
				}
				File directory = new File(filePath);
				if (! directory.exists()){
					directory.mkdir();
				}
				jSONObjectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(curFile), rootNode);
			}
		} catch (IOException e) {
			utility.writeToLog(e.getMessage());
			e.printStackTrace();
		}
	}
}
