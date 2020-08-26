package testPackage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import baseLibrary.UtilityMethods;
import homePageObjects.HomePageObjects;

public class Test2 extends UtilityMethods{
@Test
	public void readdatafromExcel() throws IOException {
		
		/*
		 * XSSFWorkbook wb =new XSSFWorkbook(System.getProperty("user.dir")+
		 * "//src//testdata//java//Passwords.xlsx"); XSSFSheet sheet = wb.getSheetAt(0);
		 * String username= null ; String password = null; Map<String, String> passwords
		 * = new HashMap<String, String>(); System.out.println(sheet.getLastRowNum());
		 * for (int i = 1; i <=sheet.getLastRowNum(); i++) { username =
		 * sheet.getRow(i).getCell(0).getStringCellValue(); password =
		 * sheet.getRow(i).getCell(1).getStringCellValue();
		 * System.out.println(username); System.out.println(password);
		 * passwords.put(username, password); } System.out.println(passwords);
		 * System.out.println(passwords.get("Suresh")); // Keys set // value set //
		 * Excel // Web Table
		 * 
		 * System.out.println(passwords.keySet());
		 * System.out.println(passwords.entrySet());
		 */
		HomePageObjects hm = new HomePageObjects(driver);
//		hm.getWomen().click();
		hm.setAccount("25648");
		System.out.println(hm.getAccount());
		
	}

}
