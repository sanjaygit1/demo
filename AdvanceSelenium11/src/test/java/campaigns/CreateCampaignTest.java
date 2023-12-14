package campaigns;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import POMRepository.CreateCampaignsPage;
import POMRepository.Home1Page;

public class CreateCampaignTest extends BaseClass {

	@Test
	public void createCampaignTest() throws Throwable {
	   Home1Page home=new Home1Page(driver);
	     home.clickMoreLink(driver);
		CreateCampaignsPage camp=new CreateCampaignsPage(driver);
		camp.clickCampPlusimg();
	    Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRandomNum();
		Excel_Utility elib=new Excel_Utility();
		String CampaginName = elib.getExcelDataUsingDataFormatter("Campaigns", 0, 0)+ranNum;
		camp.campaignsName(CampaginName);
		camp.clickSaveButton();
	     Thread.sleep(2000);
		 String Actdata = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		if(Actdata.contains(CampaginName))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("fail");
		}
		 Thread.sleep(2000);

	}
	
	}
	

