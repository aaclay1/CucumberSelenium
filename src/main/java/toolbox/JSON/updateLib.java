package toolbox.JSON;

import com.fasterxml.jackson.databind.node.ObjectNode;
import toolbox.Excel.ExcelTools;

public class updateLib {

	public static void main(String[] args) {
		JSONTools json = new JSONTools();
		ExcelTools excel = new ExcelTools();
		json.setCurFile("C:\\Users\\anclay\\NYC DoITT\\NYC 311 Rearchitecture - NYC311 Gherkin\\Library\\Library.json");
		json.loadJSON();
		excel.loadExcel("C:\\Users\\anclay\\NYC DoITT\\NYC 311 Rearchitecture - NYC311 Gherkin\\Library\\TestLibrary_UCI.xlsx");
		excel.setSheet("Objects");
		
		int rowCount = excel.getRowCount();
		for(int i=1;i<rowCount;i++) {
			excel.setRow(i);
			excel.getCellByHeader("Object_Name");
			String object = excel.getCellValue();
			excel.getCellByHeader("XPATH");
			String xpath = excel.getCellValue();
			ObjectNode appNode = (ObjectNode) json.getRoot().get("UCI").get(0);
			ObjectNode objectNode = (ObjectNode) appNode.get(object).get(0).get("xpaths").get(0);
			json.setValue(objectNode, "Field", xpath);
		}
		json.saveJSON();
		excel.closeExcel();
	}

}
