package toolbox.Excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExcelTools_DataCatalog extends ExcelTools{

	List<String> allRefList;
	HashMap<String, Integer> naturalKeys;

	/**
	 * Initialize the building of the data catalog
	 */
	public void init() {
		allRefList = new ArrayList<String>();
		naturalKeys = new HashMap<String, Integer>();
	}

	/**
	 * Create Sheet in the data catalog
	 * @param sheetName : Name of the sheet to be added
	 * @param headers : Values for the columns of the first row of the new sheet
	 */
	@SuppressWarnings("rawtypes")
	public void createTemplateSheet(String sheetName, List<String> headers) {
		this.setSheet(sheetName);

		for(int i=0; i<headers.size();i++) {
			this.setRow(0);
			this.setCell(i);
			this.setCellValue(headers.get(i));
		}
		int row =1;
		for (Map.Entry mapElement : this.naturalKeys.entrySet()) { 
			String key = (String)mapElement.getKey();
			if(key.contains("_")) {
				key = key.substring(0, key.indexOf("_"));
			}
			if(key.equals(sheetName.toLowerCase())){
				this.setRow(row);
				this.setCell(0);
				this.setCellValue((String)mapElement.getKey());
				this.setCell(1);
				this.setCellValue(Integer.toString((int) (mapElement.getValue())));
				row++;
			}

		} 
	}

}