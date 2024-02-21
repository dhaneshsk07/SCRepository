package SL_Suite_All;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import SL_Resources.BaseDriverSetUp;
import SL_Resources.ExtentReportUtil;


public class UniversityLogin extends BaseDriverSetUp {

	//public static WebDriver driver;
	String usr="ddd";
	String pwd="1234";

	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeMethod
	public void basicUrlRun() throws InterruptedException {
		BaseDriverSetUp aa = new BaseDriverSetUp();
		aa.connection();

	} 

	@Test(priority = 1,description="Test_01 Verify login page elements")
	public void verifyClickPopup() {
		// Verify the presence of username and password fields

		extent = ExtentReportUtil.getInstance();
		test = ExtentReportUtil.createTest("DD-TEST01");
		a1=driver1.findElement(By.xpath("//h1[normalize-space()='POPUP & ALERTS']"));
		a1.click();
		
	}

	@Test(description="Test_02 Invalid credential")
	public void invalidCredentialCheck() throws InterruptedException {
		extent = ExtentReportUtil.getInstance();
		test = ExtentReportUtil.createTest("DD-TEST02");
		
	}
	
	@Test(description="Test_03 valid credential")
	public void validCheck() throws InterruptedException {

		extent = ExtentReportUtil.getInstance();
		test = ExtentReportUtil.createTest("DD-TEST03");

	}

	@AfterMethod
	public void clickLoginButton() throws InterruptedException {

		extent.flush(); // Flush the report after all tests are done
		driver1.quit();
	}

}
