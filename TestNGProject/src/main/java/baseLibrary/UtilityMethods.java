package baseLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class UtilityMethods extends BaseLibrary {

	public void click(WebElement ele, String Elementname) throws Throwable {
		try {
			waitforElementtobeclickable(ele);
			ele.click();
			System.out.println("Clicked on Element " + Elementname);
			logger.log(LogStatus.PASS, "Should Click on Element " + Elementname,
					"Clicked on Element " + Elementname + logger.addScreenCapture(takeScreenShot(driver)));
		} catch (Exception e) {
			System.out.println("Not Clicked on Element " + Elementname);
			System.out.println(e);
			logger.log(LogStatus.FAIL, "Should Click on Element " + Elementname, "Not Clicked on Element " + Elementname
					+ " due to " + e + "<br>" + logger.addScreenCapture(takeScreenShot(driver)));
		}
	}

	public void verifyelementdisplayed(WebElement ele, String ElementName) throws Throwable {
		try {
			waitforElementtobeclickable(ele);
			ele.isDisplayed();
			System.out.println(ElementName + " Element is displayed");
			logger.log(LogStatus.PASS, ElementName + " Element should be available",
					ElementName + " Element is available " + logger.addScreenCapture(takeScreenShot(driver)));
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(ElementName + " Element is not displayed");
			logger.log(LogStatus.FAIL, ElementName + " Element should be available",
					ElementName + " Element is not available due to " + e + "<br>"
							+ logger.addScreenCapture(takeScreenShot(driver)));
		}

	}

	public void waitforElementtobeclickable(WebElement ele) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void verifyElementdisplayedforXpath(String xpath) {
		try {
			waitforElementtobeclickable(driver.findElement(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).isDisplayed();
			System.out.println("Element is displayed "+driver.findElement(By.xpath(xpath)).getText());
		} catch (Exception e) {
			System.out.println("element not displayed due to "+e);
		}
		
	}

}
