package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class SeleniumUtility {
	/**
	* this is a generic method to open an application in the browser
	*/
	public void accessToApplication(WebDriver driver,String url) {
		driver.get(url);
	}
	/**
	 * this is a generic method to perform browser maximization
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this ia a generic method to apply implicit wait to the script
	 * @param driver
	 * @param maxTime
	 */
	public void implicitWait(WebDriver driver, int maxTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(maxTime));
	}
				/////////////////*********Handling Dropdown**********\\\\\\\\\\\\\\\\\\\\
	/**
	 * this is a generic method to select an option in a drop down using the index
	 * @param dropdownElement
	 * @param index
	 */
	public void slectOptionsUsingIndex(WebElement dropdownElement, int index) {
		Select sc=new Select(dropdownElement);
		sc.selectByIndex(index);
	}
	
	/**
	 * this is a generic method to select an option in a drop down using the value attribute
	 * @param dropdownElement
	 * @param index
	 */
	public void slectOptionsUsingValueAtribute(WebElement dropdownElement, String value) {
		Select sc=new Select(dropdownElement);
		sc.selectByValue(value);
	}
	
	/**
	 * this is a generic method to select an option in a drop down using the visible text
	 * @param dropdownElement
	 * @param index
	 */
	public void slectOptionsUsingVisibleText(WebElement dropdownElement, String visibleText) {
		Select sc=new Select(dropdownElement);
		sc.selectByVisibleText(visibleText);
	}
	
				/////////////////*********Handling Alert popup**********\\\\\\\\\\\\\\\\\\\\
	/**
	 * this is a generic method to accept the alert popup
	 * @param driver
	 */
	public void accpetAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * this is a generic method to dismiss the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this is a generic method to fetch alert message from the  alert popup
	 * @param driver
	 * @return 
	 */
	public String getTextAlert(WebDriver driver) {
		String alertMessage=driver.switchTo().alert().getText();
		return alertMessage;
	}
	/**
	 * this is a generic method to pass value to  the alert popup
	 * @param driver
	 */
	public void sendValueToAlert(WebDriver driver,String value) {
		driver.switchTo().alert().sendKeys(value);
	}
	
				/////////////////*********Handling Mouse Actions**********\\\\\\\\\\\\\\\\\\\\
	/**
	 * this is a generic method to perform mouse hovering action on a webelement
	 * @param driver
	 * @param element
	 */
	public void mouseHoveringAction(WebDriver driver,WebElement element ) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		}
	
				/////////////////*********Handling frames**********\\\\\\\\\\\\\\\\\\\\
	/**
	 * this is  a generic method  to switch the driver control to a frame using index
	 * @param driver
	 * @param index
	 */
	public void switchToAFrameUsingIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * this is  a generic method  to switch the driver control to a frame using name or id attribute
	 * @param driver
	 * @param index
	 */
	public void switchToAFrameUsingNmaeOrId(WebDriver driver,String nameOrIdAttribute) {
		driver.switchTo().frame(nameOrIdAttribute);
	}
	/**
	 * this is  a generic method  to switch the driver control to a frame using frameElement
	 * @param driver
	 * @param index
	 */
	public void switchToAFrameUsingFrameElement(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
				/////////////////*********Take Screenshot**********\\\\\\\\\\\\\\\\\\\\
	/**
	 * this is a generic method to take the screenshot of a webpage
	 * @param driver
	 * @param dateTimeStamp
	 * @return
	 * @throws Exception
	 */
	public String getWebpageScreenshot(WebDriver driver,String dateTimeStamp) throws Exception {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\Screenshot\\image-"+dateTimeStamp+".png");
		Files.copy(src,dest);
		return dest.getAbsolutePath();      // used in Listeners
		
	}
	
	
	
	
	
	
	
	
	
	

	
}
