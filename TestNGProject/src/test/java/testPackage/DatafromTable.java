package testPackage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import baseLibrary.UtilityMethods;

public class DatafromTable extends UtilityMethods{
	@Test
public void readdatafromTable() {
		String text=null;
	int size = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td")).size(); j++) {
			text = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+(i+1)+"]/td["+(j+1)+"]")).getText();
			System.out.println("Data in row "+(i+1)+"Data in Column "+(j+1) + " is "+text);
		}		
	}
	
	verifyElementdisplayedforXpath("//tr/td/font[contains(text(),'"+text.replace("+", "").replace("-", "")+"')]");

}
}
