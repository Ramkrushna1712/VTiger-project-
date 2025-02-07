package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetchinfmultipledatafromexcel {
public static void main(String[] args) throws Exception {
	FileInputStream fis=new FileInputStream("");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("animal");
	System.out.println(sh.getLastRowNum());
	DataFormatter df=new DataFormatter();
	for(int i=1;i<=sh.getLastRowNum();i++) {
		Row row=sh.getRow(i);
		for(int j=0;j<row.getLastCellNum();j++) {
			Cell cell=row.getCell(j);
			String value=df.formatCellValue(cell);
			System.out.println(value);
		}
		
	}
}
}
