package pratice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFormatterEx {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/ExcelData10to12.xlsx");
		//FileInputStream fis=new FileInputStream("C:\\Users\\Shobha\\Desktop\\ExcelData10to12.xlsx");
		//Step2:-open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//step:-3 get the control to the sheet
		Sheet sh = book.getSheet("Sheet2");
    	Row row = sh.getRow(2);
	    Cell cel = row.getCell(1);

	DataFormatter format=new DataFormatter();
	String data = format.formatCellValue(cel);
	System.out.println(data);
	}

}
