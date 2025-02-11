package TestCaseRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.excelutility;
import objectReposetory.CreatingNewLeadpage;
import objectReposetory.Homepage;
import objectReposetory.LeadsPage;

public class TC_003 extends BaseClass{
	@Test(groups= {"smoke"})
	public void leads_003() throws Exception {
		System.out.println("test case execution started ");
		 Homepage hp=new Homepage(driver);
		 hp.ClickOnLeads();
		
		LeadsPage lp=new LeadsPage(driver);
		lp.ClickOnCreateLeads();
		
		excelutility eutil=new excelutility();
		String firstname=eutil.getDataFromExcel("leads",7 , 1);
		String lastname=eutil.getDataFromExcel("leads", 7, 2);
		String company=eutil.getDataFromExcel("leads", 7, 3);
		String phone=eutil.getDataFromExcel("leads", 7, 4);
		String website=eutil.getDataFromExcel("leads", 7, 5);
		String noOfEmp=eutil.getDataFromExcel("leads",7, 6);
		String country=eutil.getDataFromExcel("leads",7,7);
		String city=eutil.getDataFromExcel("leads",7, 8);
		String state=eutil.getDataFromExcel("leads",7, 9);
		
		CreatingNewLeadpage cnlp=new CreatingNewLeadpage(driver);
		cnlp.CreateNewLead(firstname, lastname, company, phone, website, noOfEmp, country, city, state);
		System.out.println("test execution ended");

}
}
