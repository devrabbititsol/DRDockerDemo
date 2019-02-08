package web.drdockerdemo.dockermodule.webpageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.BaseClass;import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@SuppressWarnings("unused")
public class Screen2 extends BaseClass {
	
	public static String primaryInfo  = "{\"user_id\":7,\"is_generate\":false,\"is_execute\":false,\"is_web\":true,\"project_url\":\"http://devrabbit.com/\",\"report_upload_url\":\"https://192.168.1.142:8080/TAF_Automation_DR/UploadReportFile\",\"project_name\":\"DRDockerDemo\",\"project_description\":\"desc\",\"project_id\":0,\"module_name\":\"DockerModule\",\"module_description\":\"desc\",\"sub_module_id\":0,\"module_id\":362,\"testcase_name\":\"TC1\",\"testcase_id\":433,\"testset_name\":\"TC_TestDocker\",\"testset_id\":61,\"executed_timestamp\":-865352424,\"browser_type\":\"chrome\"}";

	public static String projectName = "drdockerdemo";
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;
	public static final int datasetsLength = 1;

	public Screen2(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//HTML/BODY[1]/SECTION[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[1]/DIV[2]/UL[1]/LI[6]/A[1]")	
	private WebElement	Automotive_298518A;
	public String clkAAutomotive_298518() {
		waitForExpectedElement(driver, Automotive_298518A);		
		String text = Automotive_298518A.getText();
		Automotive_298518A.click();
		return text;
	}

}