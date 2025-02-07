package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import objectReposetory.Homepage;
import objectReposetory.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;//use only for listener
	public propertiesUtility putil=new propertiesUtility();
	public SeleniumUtility sutil=new SeleniumUtility();
	@BeforeSuite (alwaysRun = true)
	public void DBconnection() {
		System.out.println("database connection is sucessful");
	}
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome") String BROWSER) throws Exception {
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("safari")) {
			driver=new SafariDriver();
		}
		
		else {
			driver=new ChromeDriver();
		}
		sdriver=driver;
		sutil.maximizeWindow(driver);
		sutil.implicitWait(driver,10);
		String url=putil.getDataFromProperties("url");
		sutil.accessToApplication(driver, url);
	}
	@BeforeMethod(alwaysRun = true)
	public void LoginOperation() throws Exception {
		String UN=putil.getDataFromProperties("username");
		String PWD=putil.getDataFromProperties("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(UN, PWD);
	}
	@AfterMethod(alwaysRun = true)
	public void LogoutOperation() {
		 Homepage hp=new Homepage(driver);
		hp.SignOut(driver);
	}
	@AfterClass(alwaysRun = true)
	public void ClosingBrowser() {
		driver.quit();
	}
	@AfterSuite(alwaysRun = true)
	public void DBconnectionClosed() {
		System.out.println("database connection is closed");
	}
}
