package pratice;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDatatoExcelSheet {

	public static void main(String[] args) throws Throwable {
		
		//Step1:-set the path
				FileInputStream fis=new FileInputStream("./src/test/resources/ExcelData10to12.xlsx");
				//FileInputStream fis=new FileInputStream("C:\\Users\\Shobha\\Desktop\\ExcelData10to12.xlsx");
				//Step2:-open workbook in read mode
				Workbook book = WorkbookFactory.create(fis);
				
				//step:-3 get the control to the sheet
				Sheet sh = book.getSheet("Sheet1");
				
				//step:-4 get the control on the row
				Row row = sh.getRow(0);
				
				Cell cel = row.createCell(0);
				cel.setCellValue("iphone");
				
				//To write data into ExcelSheet
				FileOutputStream fos=new FileOutputStream("./src/test/resources/ExcelData10to12.xlsx");
				book.write(fos);
				book.close();
	}

}
