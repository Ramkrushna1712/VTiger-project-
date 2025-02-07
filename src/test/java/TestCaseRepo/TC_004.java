package TestCaseRepo;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.excelutility;
import objectReposetory.ContactsPage;
import objectReposetory.CreatingNewContactPage;
import objectReposetory.Homepage;
public class TC_004 extends BaseClass {
@Test(groups= {""})
public void contacts_001() throws Exception {
	System.out.println("test execution started");
	 Homepage hp=new Homepage(driver);
	 hp.ClickOncontacts();
	
	 ContactsPage cp=new ContactsPage(driver);
	 cp.ClickOnCreateContacts();
	
	excelutility eutil=new excelutility();
	String firstname=eutil.getDataFromExcel("contact", 1, 1);
	String lastname=eutil.getDataFromExcel("contact", 1, 2);
	String leadsource=eutil.getDataFromExcel("contact", 1, 3);
	CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
	cncp.CreateNewContact(firstname, lastname, leadsource);
	System.out.println("test execution ended");
	
}
}
