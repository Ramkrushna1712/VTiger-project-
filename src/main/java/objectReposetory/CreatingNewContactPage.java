package objectReposetory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewContactPage {
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstname ;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname ;
	
	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement leadsource ;
	
	@FindBy(xpath="//input[@name='title']")
	private WebElement title ;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email ;
	
	@FindBy(xpath="//input[@name='mailingcity']")
	private WebElement mailinhcity ;
	
	@FindBy(xpath="//input[@name='mailingstate']")
	private WebElement mailingstate ;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement save ;
	

	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}


	public WebElement getFirstname() {
		return firstname;
	}


	public WebElement getLastname() {
		return lastname;
	}


	public WebElement getLeadsource() {
		return leadsource;
	}


	public WebElement getTitle() {
		return title;
	}


	public WebElement getEmail() {
		return email;
	}


	public WebElement getMailinhcity() {
		return mailinhcity;
	}


	public WebElement getMailingstate() {
		return mailingstate;
	}
	
	
	public WebElement getSave() {
		return save;
	}
	


	public void CreateNewContact(String firstname,String lastname,String leadsourcee) {
		getFirstname().sendKeys(firstname);
		getLastname().sendKeys(lastname);
		Select s=new Select(getLeadsource());
		s.selectByValue(leadsourcee);
		getSave().click();
	}
	public void CreateNewContact(String firstname,String lastname,String title,String email) {
		getFirstname().sendKeys(firstname);
		getLastname().sendKeys(lastname);
		getTitle().sendKeys(title);
		getEmail().sendKeys(email);
		getSave().click();
	}
	public void CreateNewContact(String firstname,String lastname,String title,String email,String mailingcity,String mailingstate) {
		getFirstname().sendKeys(firstname);
		getLastname().sendKeys(lastname);
		getTitle().sendKeys(title);
		getEmail().sendKeys(email);
		getMailinhcity().sendKeys(mailingcity);
		getMailingstate().sendKeys(mailingstate);
		getSave().click();
	}	
		
}
