package TestCaseRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.excelutility;
import objectReposetory.ContactsPage;
import objectReposetory.CreatingNewContactPage;
import objectReposetory.Homepage;

public class TC_006 extends BaseClass {
	@Test(groups= {"somke","regratation"})
	public void contacts_001() throws Exception {
		System.out.println("test execution started");
		 Homepage hp=new Homepage(driver);
		 hp.ClickOncontacts();
		
		 ContactsPage cp=new ContactsPage(driver);
		 cp.ClickOnCreateContacts();
		
		excelutility eutil=new excelutility();
		String firstname=eutil.getDataFromExcel("contact", 7, 1);
		String lastname=eutil.getDataFromExcel("contact", 7, 2);
		String title=eutil.getDataFromExcel("contact", 7, 3);
		String email=eutil.getDataFromExcel("contact", 7,4);
		String mc=eutil.getDataFromExcel("contact", 7,5);
		String ms=eutil.getDataFromExcel("contact", 7,6);
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.CreateNewContact(firstname, lastname,title,email,mc,ms);
		System.out.println("test execution ended");
		
	}

}
