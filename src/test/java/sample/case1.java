package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import genericUtility.SeleniumUtility;
import genericUtility.excelutility;
import genericUtility.propertiesUtility;
import objectReposetory.CreatingNewLeadpage;
import objectReposetory.Homepage;
import objectReposetory.LeadsPage;
import objectReposetory.LoginPage;
@Test
public class case1 {
	public void tc_001() throws Exception {
		WebDriver driver =new EdgeDriver();
		SeleniumUtility sutil=new SeleniumUtility();
		sutil.implicitWait(driver,15);
		sutil.maximizeWindow(driver);
		
		propertiesUtility putil=new propertiesUtility();
		String URL=putil.getDataFromProperties("url");
		String username=putil.getDataFromProperties("username");
		String password=putil.getDataFromProperties("password");
		sutil.accessToApplication(driver, URL);
		
		LoginPage login=new LoginPage(driver);
		login.loginToApplication(username, password);
		
		Homepage home=new Homepage(driver);
		home.ClickOnLeads();
		
		LeadsPage lpage=new LeadsPage(driver);
		lpage.ClickOnCreateLeads();
		
		excelutility excel=new excelutility();
		String lastname=excel.getDataFromExcel("leads", 1, 1);
		String company=excel.getDataFromExcel("leads", 1, 2);
		
		CreatingNewLeadpage cnpage=new CreatingNewLeadpage(driver);
		cnpage.CreateNewLead(lastname, company);
		
		home.SignOut(driver);
		driver.quit();
		
	}	
}
