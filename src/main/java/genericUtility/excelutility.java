package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelutility {
	/**
	 * this is a generic method to fetch single cell  data from excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 * @throws Exception
	 */
	public String getDataFromExcel(String sheetName, int rowIndex,int cellIndex) throws Exception {
		FileInputStream fis=new FileInputStream(ipathutility.excelpath);
		Workbook wb= WorkbookFactory.create(fis);
		Cell cell= wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex);
		DataFormatter df=new DataFormatter();
		String value=df.formatCellValue(cell);
		return value;	
	}
	
	/**
	 * this is a generic method to fetch multiple data from excel file
	 * @param sheetname
	 * @param startRowIndex
	 * @param startCellIndex
	 * @return
	 * @throws Exception
	 */
	
	public List<String>  getmultipledatafromexcel(String sheetname,int startRowIndex,int startCellIndex) throws Exception{
		
		FileInputStream fis=new FileInputStream(ipathutility.excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		DataFormatter df=new DataFormatter();
		List<String> data=new ArrayList<>();
		for(int i=startRowIndex;i<=sh.getLastRowNum();i++) {
			Row row=sh.getRow(i);
			for(int j=startCellIndex;j<row.getLastCellNum();j++) {
				Cell cell=row.getCell(j);
				String value=df.formatCellValue(cell);
				data.add(value);
		}
	}
		return data;
	}
	/**
	 * this is generic method to write a data to a cell in excel file
	 * @param sheetname
	 * @param rowindex
	 * @param cellindex
	 * @param value
	 * @throws Exception
	 */
	public void writedatatoexcel(String sheetname,int rowindex,int cellindex,String value) throws Exception {
	FileInputStream fis=new FileInputStream(ipathutility.excelpath);
	Workbook wb= WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	sh.createRow(rowindex).createCell(cellindex).setCellValue(value);
	FileOutputStream fos=new FileOutputStream(ipathutility.excelpath);
	wb.write(fos);
	
	}
}
	
	
