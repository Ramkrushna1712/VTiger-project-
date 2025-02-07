package TestCaseRepo;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.excelutility;
import objectReposetory.CreatingNewLeadpage;
import objectReposetory.Homepage;
import objectReposetory.LeadsPage;
@Listeners(genericUtility.ListenersImplimentation.class)
public class TC_001 extends BaseClass {
	@Test(groups= {"smoke","regression"})
	public void leads_001() throws Exception {
		System.out.println("test execution started");
		System.out.println("test case execution started ");
		 Homepage hp=new Homepage(driver);
		hp.ClickOnLeads();
		Assert.fail();
		LeadsPage lp=new LeadsPage(driver);
		lp.ClickOnCreateLeads();
		
		excelutility eutil=new excelutility();
		String lastname=eutil.getDataFromExcel("leads", 1, 1);
		String company=eutil.getDataFromExcel("leads", 1, 2);
		System.out.println(lastname);
		CreatingNewLeadpage cnlp=new CreatingNewLeadpage(driver);
		cnlp.CreateNewLead(lastname, company);
		System.out.println("test execution ended");
		
	}

}
