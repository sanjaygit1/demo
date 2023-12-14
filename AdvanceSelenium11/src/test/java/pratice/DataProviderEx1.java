package pratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {

	@Test(dataProvider="dataProviderExecute")
	public void bookTickets(String src,String dest)
	{
		System.out.println("book tickets from "+src+"to"+dest);
	}
	@DataProvider
	public Object[][] dataProviderExecute()
	{
		Object[][] objarr = new Object[3][2];
		
		objarr[0][0]="Bangalore";
		objarr[0][1]="mumbai";
		
		objarr[1][0]="Bangalore";
		objarr[1][1]="Goa";
		
		objarr[2][0]="Bangalore";
		objarr[2][1]="mysore";
		
		return objarr;
		
	}
}
