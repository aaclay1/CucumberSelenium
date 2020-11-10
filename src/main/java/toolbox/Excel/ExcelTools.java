package toolbox.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Simple.Se.GlobalVars;

/**
 * @author TONYCLAY
 *
 */
public class ExcelTools extends GlobalVars{
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public String fileName;
	public int column;

	

	public void setCellBold() {
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setBold(true);
		style.setFont(font);  
		cell.setCellStyle(style);  
	}

	public void setRowBold() {
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setBold(true);
		style.setFont(font); 
		int colCount = getColumnCount();
		for(int j = 0; j<colCount; j++)
			row.getCell(j).setCellStyle(style);
	}

	public void setColMaxSize(int column) {
		sheet.autoSizeColumn(column);
	}

	/**
	 * getSheetCount : returns the number of sheets in the current workbook
	 * @return 
	 */
	public int getSheetCount() {
		return wb.getNumberOfSheets();
	}

	/**
	 * getRowCount : get the number of rows in the current sheet
	 * @return
	 */
	public int getRowCount() {
		return sheet.getLastRowNum();
	}

	/**
	 * getColumnCount : get the number of columns in the current Row
	 * @return
	 */
	public int getColumnCount() {
		return row.getLastCellNum();
	}

	/**
	 * getSheetName : get the name of the current sheet
	 * @return
	 */
	public String getSheetName() {
		return sheet.getSheetName();
	}

	/**
	 * getHeaderName : get the header value of the current column
	 * @return
	 */
	public String getHeaderName(int columnNum) {
		return sheet.getRow(0).getCell(columnNum).getRichStringCellValue().toString();
	}

	public String getColumnLetter(int columnNum) {
		return CellReference.convertNumToColString(columnNum);
	}
	/**
	 * getHeaderName : get the header value of the current column
	 * @return
	 */
	public XSSFWorkbook copyWorkbook() {
		return wb;
	}

	/**getColumnByHeader : sets the cell by name of a given header
	 * @param header : string value of a header
	 * @return
	 */
	public int getCellByHeader(String header) {
		int numOfCol = sheet.getRow(0).getLastCellNum();
		int colNum = -1;
		for(int i =0; i<numOfCol;i++) {
			if(getHeaderName(i).equalsIgnoreCase(header)) {
				colNum = i;
				break;
			}
		}
		if(colNum > -1) {
			setCell(colNum);
		}
		return colNum;
	}

	/**
	 * writeToExcel: writes all workbook changes to current excel file
	 */
	public void writeToExcel() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File(fileName));
			wb.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			utility.writeToLog(e.getMessage());
		}
	}
	/**
	 * loadExcel: load content from an existing excel file
	 * @param fileName1: Full file name including .xls or .xlsx
	 */
	public void loadExcel(String fileName1) {
		try {

			fileName = fileName1;
			FileInputStream fis = new FileInputStream(fileName);
			wb = new XSSFWorkbook(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			utility.writeToLog(e.getMessage());
		}
	}

	/**
	 * closeExcel : Close the current instance of the workbook
	 */
	public void closeExcel() {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
			utility.writeToLog(e.getMessage());
		}
	}

	/**
	 * setSheet : Set current Sheet of the current workbook
	 * @param sheetNum : the sheet number order from left to right 0 being the first
	 */
	public void setSheet(int sheetNum) {
		sheet = wb.getSheetAt(sheetNum);
		if(sheet == null) {
			wb.createSheet();
		}
	}

	/**
	 * setSheet : Set current Sheet of the current workbook
	 * @param sheetName : set the sheet by name
	 */
	public void setSheet(String sheetName) {
		try {
			sheet = wb.getSheet(sheetName);
			if(sheet == null) {
				sheet = wb.createSheet(sheetName);
			}
		}catch(Exception e) {
			utility.writeToLog(e.getMessage());
		}
	}

	/**setRow : Set current Row of the current sheet
	 * @param rownum row number where row 0 is row 1 of the sheet
	 */
	public void setRow(int rownum) {
		row = sheet.getRow(rownum);
		if(row == null) {
			row = sheet.createRow(rownum);
		}
	}

	/**
	 * setCell : Set current column of the current sheet and Row
	 * @param columnNumber column number where column 0 is column 1 of the sheet and current Row
	 */
	public void setCell(int columnNumber) {
		column = columnNumber;
		cell = row.getCell(columnNumber);
		if(cell == null) {
			cell = row.createCell(columnNumber);
		}
	}

	/**
	 * creatSheet: Add a sheet to the current workbook instance
	 * @param sheetName : Name of the sheet to be created
	 */
	public void createSheet(String sheetName) {
		wb.createSheet(sheetName);
	}

	/**
	 * getCellValue: Get cell value from current workbook
	 * @return the cell value in string format
	 */
	public String getCellValue() {
		String cellValue = null;
		if(cell !=null) {
			cell.setCellType(CellType.STRING);
			cellValue = cell.getStringCellValue();
		}
		return cellValue;
	}

	/**
	 * setCellValu: set a value in the current cell
	 * @param value
	 */
	public void setCellValue(String value) {
		cell.setCellValue(value);
	}
}
