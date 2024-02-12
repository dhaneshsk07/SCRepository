package SL_Suite;

import static org.testng.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import SL_Config.TestConfig;
import SL_PageObjects.MethodsOnly;
import SL_Resources.BaseConnectionSetUp;
import SL_Resources.ExtentReportUtil;
import SL_Utils.ExcelReader;

public class LoginPageTest extends BaseConnectionSetUp {

	//public static WebDriver driver;
	String usr="ddd";
	String pwd="1234";

	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeMethod
	public void basicUrlRun() throws InterruptedException {
		BaseConnectionSetUp aa = new BaseConnectionSetUp();
		aa.connection();

	} 

	//TestConfig sc=new TestConfig();


//	@DataProvider(name = "passwords")
//	public Object[][] getPasswords() {
//		// Specify the column index or name of the password column in the Excel file
//		int passwordColumnIndex = 1; // Assuming password is in the second column (index 1)
//
//		// Read the passwords from the Excel file
//		ExcelReader excelReader = new ExcelReader(sc.TEST_DATA_EXCEL_PATH);
//		Object[][] passwords = excelReader.getColumnData(passwordColumnIndex);
//
//		return passwords;
//	}

	@Test(priority = 1,description="Test_01 Verify login page elements")
	public void verifyLoginPageElements() {
		// Verify the presence of username and password fields

		extent = ExtentReportUtil.getInstance();
		test = ExtentReportUtil.createTest("DD-TEST01");
		//		test.pass("PASSED - Login page element verified");
		//		test.fail("FAILED - unable to verify");


		a1=driver1.findElement(By.xpath("//input[@id='user-name']"));
		Assert.assertTrue(a1.isDisplayed(), "Username field is not displayed");

		a2=driver1.findElement(By.xpath("//input[@id='password']"));
		Assert.assertTrue(a2.isDisplayed(), "Password field is not displayed");

		a3=driver1.findElement(By.xpath("//input[@id='login-button']"));
		Assert.assertTrue(a3.isDisplayed(), "Login Button is not displayed");

		a4=driver1.findElement(By.xpath("//div[@class='login_logo']"));
		Assert.assertTrue(a4.isDisplayed(), "Logo Sauce Labs  is not displayed");

	}


	@Test(description="Test_02 Invalid credential")
	public void invalidCredentialCheck() throws InterruptedException {
		extent = ExtentReportUtil.getInstance();
		test = ExtentReportUtil.createTest("DD-TEST02");
		//		test.pass("PASSED - Test_01 Invalid credential");
		//		test.fail("FAILED - Test_01 Invalid credential");

		MethodsOnly tt=new MethodsOnly(driver1);
		tt.setuppf();  


		//a1=driver1.findElement(By.xpath("//input[@id='user-name']"));
		//a1.sendKeys(usr);	
		//Thread.sleep(2000);
		//a2=driver1.findElement(By.xpath("//input[@id='password']"));
		//a2.sendKeys(pwd);
		//Thread.sleep(2000);
		//a3=driver1.findElement(By.xpath("//input[@id='login-button']"));
		//a3.click();
		//Thread.sleep(2000);


	}


	@Test(description="Test_03 valid credential")
	public void validCheck() throws InterruptedException {

		extent = ExtentReportUtil.getInstance();
		test = ExtentReportUtil.createTest("DD-TEST03");

		//		test.pass("PASSED - Test_02 Valid credential");
		//		test.fail("FAILED - Test_02 Valid credential");


		a1=driver1.findElement(By.xpath("//input[@id='user-name']"));
		a1.sendKeys("standard_user");	
		Thread.sleep(2000);
		a2=driver1.findElement(By.xpath("//input[@id='password']"));
		a2.sendKeys("secret_sauce1");
		Thread.sleep(2000);
		a3=driver1.findElement(By.xpath("//input[@id='login-button']"));
		a3.click();

	}

	@AfterMethod
	public void clickLoginButton() throws InterruptedException {

		extent.flush(); // Flush the report after all tests are done
		driver1.quit();

	}

}
