package pratice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMultipleDataFormExcel {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/ExcelData10to12.xlsx");
		//FileInputStream fis=new FileInputStream("C:\\Users\\Shobha\\Desktop\\ExcelData10to12.xlsx");
		//Step2:-open workbook in read mode
	/*	Workbook book = WorkbookFactory.create(fis);
		
		//step:-3 get the control to the sheet
		Sheet sh = book.getSheet("Sheet1");
		
		System.out.println(sh.getLastRowNum());
		for(int i=0;i<=sh.getLastRowNum();i++) //377
		{
			Row row = sh.getRow(i);//0
			for(int j=0;j<=row.getLastCellNum();j++)//0
			{
				Cell cel = row.getCell(j);
				DataFormatter format=new DataFormatter();
				String data = format.formatCellValue(cel);
				System.out.println(data);
			}
		}*/
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		for (int i = 0; i <=sheet.getLastRowNum(); i++) 
		{
			Row row = sheet.getRow(i);
			for (int j = 0; j <=row.getLastCellNum(); j++) 
			{
				Cell cell = row.getCell(j);
				DataFormatter dataFormatter=new DataFormatter();
				String data = dataFormatter.formatCellValue(cell);
				System.out.println(data);
			}
		}

	}

}
