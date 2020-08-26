package homePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.BaseLibrary;

public class HomePageObjects extends BaseLibrary {

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using ="//a[@title='Women']")
	private WebElement Women;

	public WebElement getWomen() {
		return Women;
	}

	private String Account = "123";

	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}
	
	
	
}
