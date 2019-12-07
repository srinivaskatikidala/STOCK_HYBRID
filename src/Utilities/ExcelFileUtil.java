package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil {

	Workbook wb;

	public ExcelFileUtil() throws Exception{

	FileInputStream fi= new FileInputStream("D:\\Nivas.sri\\Automation\\Stock_Accounting\\TestInput\\InputSheet.xlsx");
	wb=new XSSFWorkbook(fi);
	}
	public int rowcount(String sheetname) {
		return wb.getSheet(sheetname).getLastRowNum();

	}

	public int ColCount(String sheetname) {
		return wb.getSheet(sheetname).getRow(0).getLastCellNum();

	}

	public String getData(String sheetname, int row, int column) {

		String data;

		if (wb.getSheet(sheetname).getRow(row).getCell(column).getCellType() == Cell.CELL_TYPE_NUMERIC) {
			int celldata = (int) wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			data = String.valueOf(celldata);

		} else {

			data = wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();

		}
		return data;
	}

	public void setData(String sheetname,int row,int column,String status) throws Exception{
		
	Sheet sh=	wb.getSheet(sheetname);
		
	Row rownum=	sh.getRow(row);
	Cell cell=rownum.createCell(column);
	cell.setCellValue(status);
	
	if (status.equalsIgnoreCase("pass")) {
		
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setColor(IndexedColors.GREEN.getIndex());
		font.setBold(true);
        style.setFont(font);
        rownum.getCell(column).setCellStyle(style);
        
        
	}else if(status.equalsIgnoreCase("fail")) {
		
		CellStyle style=wb.createCellStyle();
		Font font=wb.createFont();
		font.setColor(IndexedColors.RED.getIndex());
		font.setBold(true);
		style.setFont(font);
		rownum.getCell(column).setCellStyle(style);
	}
		else if (status.equalsIgnoreCase("not executed")) {

			CellStyle style = wb.createCellStyle();
			Font font = wb.createFont();
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			style.setFont(font);
			rownum.getCell(column).setCellStyle(style);

		}

		FileOutputStream fos = new FileOutputStream("D:\\Nivas.sri\\Automation\\Stock_Accounting\\TestOutput.xlsx");
		wb.write(fos);
		fos.close();
	

	}

}
