package baseLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLibrary {
	public WebDriver driver;
	public Properties prop;
	public static Date date = new Date();
	public static DateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy HHmmss");
	public static String reportLocation = System.getProperty("user.dir")+"\\Reports\\Reports_"+dateformat.format(date)+"\\";
	public ExtentReports reports = null;
	public ExtentTest logger;	
	public WebDriverWait wait;
	
	// Ctrl +Shift +F --Format
	// Ctrl + A -- Select All
	// Ctrl + o  --  remove unused Import
	// Ctrl + Space -- to popup the related items
	
	public void initialize() throws IOException {
		
		FileInputStream fis = new FileInputStream(".//config.properties");
		prop = new Properties();
		prop.load(fis);
	}

	@BeforeSuite
	public void invokeReports() {
		reports = new ExtentReports(reportLocation+"Reports_"+dateformat.format(date)+".html");	
	}
	@BeforeClass
	public void LaunchBrowser() throws IOException {
		
		initialize();
		if (prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			Map<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_setting_values.notifications", 2);
			chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
			chromePrefs.put("download.prompt_for_download", false);
			chromePrefs.put("download.directory_upgrade", true);
			chromePrefs.put("safebrowsing.enabled", true);
			ChromeOptions options = new ChromeOptions(); 
			options.setExperimentalOption("prefs", chromePrefs);
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
			options.addArguments("user-data-dir="+System.getProperty("user.home")+"\\AppData\\Local\\Google\\Chrome\\User Data\\Default"); 	
//			driver = new ChromeDriver();
//			driver.manage().getCookies();
//			driver.manage().window().maximize();
//			driver.get(prop.getProperty("URL"));	
//			StartTest("Invoke Chrome Browser");
//			logger.log(LogStatus.INFO, "Browser is launched and navigated to URL "+prop.getProperty("URL"));
//			endTest();
		} else if (prop.getProperty("browser").equalsIgnoreCase("ie")) {

		} else {
			System.out.println(" No Browser was found with the given value");
		}
	}

	public void StartTest(String TestName) {
		logger = reports.startTest(TestName);
		System.out.println(TestName);
	}
	
	public void endTest() {
		reports.endTest(logger);
	}
//	@AfterClass
	public void closeBrowser() {
		driver.quit();
		reports.flush();
	}
	
	public static String takeScreenShot(WebDriver driver) throws Throwable {
		UUID uuid = UUID.randomUUID();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile, new File(reportLocation+uuid+".png"));
		return uuid+".png";		
	}

}
