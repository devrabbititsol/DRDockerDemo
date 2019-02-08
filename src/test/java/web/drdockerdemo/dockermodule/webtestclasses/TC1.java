package web.drdockerdemo.dockermodule.webtestclasses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.configurations.Constants;
import com.configurations.ExtentConfigurations;
import web.drdockerdemo.dockermodule.webpageclasses.Screen1;
import web.drdockerdemo.dockermodule.webpageclasses.Screen2;
import com.utilities.BaseClass;
import com.utilities.ConfigFilesUtility;
import com.utilities.Utilities;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class TC1 extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	ITestResult result;
	private Logger logger;
	private ConfigFilesUtility configFileObj;
	public boolean isElementDispalyed = false;	public static final int datasetsLength = 1;

	public TC1() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(TC1.class);
		configFileObj = new ConfigFilesUtility();
		configFileObj.loadPropertyFile("tc1.properties");
		reports = ExtentConfigurations.getExtentInstance(reportsPath, projectPath, Screen1.projectName);
		test = reports.startTest("TC1");
	}
	
	public void setUP() throws Exception {
		String primaryInfo = Screen1.primaryInfo;
		Constants.PRIMARY_INFO = primaryInfo;
		driver = launchBrowser(new JSONObject(primaryInfo).optString("browser_type"), configFileObj);
	}

	public void Screen1Test(int i) throws Exception {

	 try{
		Constants.TOTAL_TC = Constants.TOTAL_TC + 1;
		Constants.IS_TESTCASE = true; Constants.iS_WEB = true;
		int datasetScreencount = 1;
		Screen1 objScreen1 = PageFactory.initElements(driver, Screen1.class);
		testLogHeader(test, "Verify Screen1 page");
String text1 = objScreen1.clkAContact_298211();
		if(text1.equalsIgnoreCase(configFileObj.getProperty("Contact"+ i + datasetScreencount))){
			printSuccessLogAndReport(test, logger,  "Clicked on : " + configFileObj.getProperty("Contact"+ i + datasetScreencount));
			printSuccessLogAndReport(test, logger,  "Validated Link Text : " + configFileObj.getProperty("Contact"+ i + datasetScreencount));
		} else {
			printFailureLogAndReport(test, logger,  "Link Text is not displayed  : " + configFileObj.getProperty("Contact"+ i + datasetScreencount));
		}

	   } catch (Exception e) {
		  isElementDispalyed = false;
		  printFailureLogAndReport(test, logger,  "Element is not found" + e.getLocalizedMessage());
		}
	}
	

	public void Screen2Test(int i) throws Exception {

	 try{
		Constants.TOTAL_TC = Constants.TOTAL_TC + 1;
		Constants.IS_TESTCASE = true; Constants.iS_WEB = true;
		int datasetScreencount = 2;
		Screen2 objScreen2 = PageFactory.initElements(driver, Screen2.class);
		testLogHeader(test, "Verify Screen2 page");
String text1 = objScreen2.clkAAutomotive_298518();
		if(text1.equalsIgnoreCase(configFileObj.getProperty("Automotive"+ i + datasetScreencount))){
			printSuccessLogAndReport(test, logger,  "Clicked on : " + configFileObj.getProperty("Automotive"+ i + datasetScreencount));
			printSuccessLogAndReport(test, logger,  "Validated Link Text : " + configFileObj.getProperty("Automotive"+ i + datasetScreencount));
		} else {
			printFailureLogAndReport(test, logger,  "Link Text is not displayed  : " + configFileObj.getProperty("Automotive"+ i + datasetScreencount));
		}

	   } catch (Exception e) {
		  isElementDispalyed = false;
		  printFailureLogAndReport(test, logger,  "Element is not found" + e.getLocalizedMessage());
		}
	}
	
	@Test
	public void screensTest() throws Exception {
		isElementDispalyed = true;
		for(int datasets = 1; datasets <= Screen2.datasetsLength; datasets++) {
			if(!isElementDispalyed) return;			
			setUP();
			if(isElementDispalyed) { Screen1Test(datasets);}
			if(isElementDispalyed) { Screen2Test(datasets);}
			tearDown();
		}	}

	
	public void tearDown() throws Exception {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
}