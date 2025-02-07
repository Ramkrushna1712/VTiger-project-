package TestCaseRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.excelutility;
import objectReposetory.CreatingNewLeadpage;
import objectReposetory.Homepage;
import objectReposetory.LeadsPage;

public class TC_002 extends BaseClass {
	@Test	
	public void leads_002() throws Exception {
		System.out.println("test case execution started ");
		 Homepage hp=new Homepage(driver);
		 hp.ClickOnLeads();
		
		LeadsPage lp=new LeadsPage(driver);
		lp.ClickOnCreateLeads();
		
		excelutility eutil=new excelutility();
		String firstname=eutil.getDataFromExcel("leads", 4, 1);
		String lastname=eutil.getDataFromExcel("leads", 4, 2);
		String company=eutil.getDataFromExcel("leads", 4, 3);
		String phone=eutil.getDataFromExcel("leads", 4, 4);
		String website=eutil.getDataFromExcel("leads", 4, 5);
		
		CreatingNewLeadpage cnlp=new CreatingNewLeadpage(driver);
		cnlp.CreateNewLead(firstname, lastname,company, phone, website);
		System.out.println("test execution ended");

}
}
