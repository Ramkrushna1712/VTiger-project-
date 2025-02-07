package objectReposetory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	@FindBy(xpath="//a[text()='Leads']")
	private WebElement leads ;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contacts ;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement accounts ;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout ;
	

	
	public Homepage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}


	public WebElement getLeads() {
		return leads;
	}


	public WebElement getContacts() {
		return contacts;
	}


	public WebElement getAccounts() {
		return accounts;
	}


	public WebElement getSignout() {
		return signout;
	}
	
	public void ClickOncontacts() {
		getContacts().click();
	}
	
	public void ClickOnLeads() {
		getLeads().click();
		
	}
	
	public void SignOut(WebDriver driver) {
		Actions act=new Actions(driver);
		act.moveToElement(accounts).perform();
		signout.click();
		
	}
	

	}


