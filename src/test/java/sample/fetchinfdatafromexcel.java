package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetchinfdatafromexcel {
	public static void main(String[] args) throws Exception {
		
	FileInputStream fis=new FileInputStream("C:\\Users\\RAM\\Desktop\\exceltestdata\\module.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("animal");
	Row row = sh.getRow(1);
	Cell cell=row.getCell(0);
	DataFormatter df=new DataFormatter();
	String value=df.formatCellValue(cell);
	System.out.println(value);
	
	sh.createRow(4).createCell(0).setCellValue("buffalo");
	FileOutputStream fos=new FileOutputStream("C:\\Users\\RAM\\Desktop\\exceltestdata\\module.xlsx");
	wb.write(fos);
	

	
	
	
	
	

}
}
