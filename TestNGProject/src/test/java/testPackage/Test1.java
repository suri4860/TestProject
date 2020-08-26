package testPackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseLibrary.UtilityMethods;

public class Test1 extends UtilityMethods {

	/*
	 * @Test(dataProvider = "ReadDatafromExcel") public void test(String data)
	 * throws Throwable { StartTest("Verify Home Page");
	 * System.out.println("Passed Parameter is "+data); ArrayList<Double> prices =
	 * new ArrayList<Double>(); prices.add(26.5); prices.add((double) 25);
	 * prices.add(98.5); Collections.sort(prices); System.out.println(prices);
	 * System.out.println(prices.get(2).toString().replace("$", ""));
	 * Integer.parseInt(prices.get(3).toString().replace("$", "")); endTest(); }
	 * 
	 * @DataProvider(name = "ReadDatafromExcel") public Object[] ReadDatafromExcel()
	 * { Object[] obj = {1,2,2,4}; return obj; }
	 */

	/*
	 * @DataProvider (name = "data-provider") public Object[][] dpMethod() throws
	 * IOException{ Workbook wb = new XSSFWorkbook(
	 * "D:\\Personal\\SkillDrive\\TestNGProject\\src\\testdata\\java\\Passwords.xlsx"
	 * ); Sheet sheet = wb.getSheetAt(0);
	 * 
	 * for (int j = 1; j < sheet.getLastRowNum(); j++) {
	 * 
	 * } sheet.getRow(i) return new Object[][] {{"First-Value"}, {"Second-Value"}};
	 * }
	 * 
	 * @Test (dataProvider = "data-provider") public void myTest (String val) {
	 * System.out.println("Passed Parameter Is : " + val); }
	 */
	/*
	 * @Test(threadPoolSize = 5, invocationCount = 5, timeOut = 1000) public void
	 * testMethod() { System.out.println("Thread ID Is : " +
	 * Thread.currentThread().getId()); }
	 */
	@Test(dataProvider = "dp")

	public void testMethod(Object[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.println("The Thread ID for " + arr[j] + " Is :  " + Thread.currentThread().getId());
		}
	}
	@Test(dataProvider = "dp", invocationCount = 5)
	public void testMethod2(Object[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.println("The Thread ID for " + arr[j] + " Is :  " + Thread.currentThread().getId());
		}
	}
	@DataProvider(name = "dp")
	 public Object[] dp1() {
		Object[] obj = new Object[5];
		obj[0] = "123";
		obj[1] = 22;
		obj[2] = "Suresh";
		obj[3] = 'a';
		obj[4]	= true;
	   return obj;/*new Object[][] {
	       new Object[] { 1 },
	       new Object[] { 2 },
	       new Object[] { 3 },
	       new Object[] { 4 },
	       new Object[] { 5 },
	       new Object[] { 6 },
	       new Object[] { 7 },
	       new Object[] { 8 }};*/
	  
}
}
