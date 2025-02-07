package objectReposetory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadpage {
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname ;
	
	@FindBy(xpath="//input[@name='company']")
	private WebElement company ;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phone ;
	
	@FindBy(xpath="//input[@name='website']")
	private WebElement website ;
	
	@FindBy(xpath="//input[@name='noofemployees']")
	private WebElement numofemp ;
	
	@FindBy(xpath="//input[@name='country']")
	private WebElement country ;
	
	@FindBy(xpath="//input[@name='state']")
	private WebElement state ;
	
	@FindBy(xpath="//input[@name='city']")
	private WebElement city ;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement save ;
	
	public CreatingNewLeadpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getNumofemp() {
		return numofemp;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getCity() {
		return city;
	}
	
	public WebElement getSave() {
		return save;
	}

	public void CreateNewLead(String lastname,String company) {
		getLastname().sendKeys(lastname);
		getCompany().sendKeys(company);
		getSave().click();
	}
	
	public void CreateNewLead(String firstname,String lastname,String company,String phone,String website) {
		getFirstname().sendKeys(firstname);
		getLastname().sendKeys(lastname);
		getCompany().sendKeys(company);
		getPhone().sendKeys(phone);
		getWebsite().sendKeys(website);
		getSave().click();
	}
	
	public void CreateNewLead(String firstname,String lastname,String company,String phone,String website,String numofemp,String country,String city,String state) {
		getFirstname().sendKeys(firstname);
		getLastname().sendKeys(lastname);
		getCompany().sendKeys(company);
		getPhone().sendKeys(phone);
		getWebsite().sendKeys(website);
		getNumofemp().sendKeys(numofemp);
		getCountry().sendKeys(country);
		getCity().sendKeys(city);
		getState().sendKeys(state);
		getSave().click();
	}

}
