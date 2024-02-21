package SL_Suite_All;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import SL_Resources.BaseDriverSetUp;
import SL_Resources.ExtentReportUtil;



public class herokuappTest extends BaseDriverSetUp {

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


	@Test(description="Test_01 Verify File Upload",enabled=false)
	public void verifyFileUpload() throws InterruptedException {
		// Verify the presence of username and password fields

		extent = ExtentReportUtil.getInstance();
		test = ExtentReportUtil.createTest("DD-TEST01");

		WebElement upload1,upload2,upload3,upload4;

		
		// ------------upload documents--------------------
		upload1=driver1.findElement(By.xpath("//input[@id='file-upload']"));//upload
		upload2=driver1.findElement(By.xpath("//input[@id='file-submit']")); //Submit

		upload2.sendKeys("C:\\Users\\panasa142user.P-142\\Downloads\\01.jpg");
		Thread.sleep(2000);
//		upload3.click();
//		Thread.sleep(2000);

		upload4=driver1.findElement(By.xpath("//h3[normalize-space()='File Uploaded!']"));

	}

	@Test(description="Test_02 Verify Drop down menu",enabled=false)
	public void verifyDropdown() throws InterruptedException {
		extent = ExtentReportUtil.getInstance();
		test = ExtentReportUtil.createTest("DD-TEST02");

		//SQA- DROPDOWN
		//https://www.globalsqa.com/demo-site/select-dropdown-menu");

		a2=driver1.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//p//select"));
		Thread.sleep(3000);

		// Instantiate the Select class
		Select dropdown = new Select(a2); 

		// Click to open the dropdown menu
		a2.click();
		Thread.sleep(2000); 

		//*** Select option by visible text ***
		//dropdown.selectByVisibleText("Buttons");

		//*** Select option by value ***
		// dropdown.selectByValue("value1");

		//*** Select option by index ***
		dropdown.selectByIndex(2); // Index starts from 0

		// Get the selected option  -- code only for print the value
		WebElement selectedOption = dropdown.getFirstSelectedOption();
		System.out.println("Selected option: " + selectedOption.getText());

	}

	@Test(description="Test_03 verify Drag and Drop",enabled=true)
	public void verifyDragAndDrop() throws InterruptedException {

		extent = ExtentReportUtil.getInstance();
		test = ExtentReportUtil.createTest("DD-TEST03");
		
		WebElement photomanager =driver1.findElement(By.xpath("//*[@id='Photo Manager']"));
		photomanager.click();
		
		Thread.sleep(4000);
		WebElement draggableElement =driver1.findElement(By.xpath("//img[@alt='Planning the ascent']"));
		WebElement droppableElement =driver1.findElement(By.xpath("//div[@id='droppable']"));

		 Thread.sleep(5000); 
		 
		 // Create Actions object
        Actions actions = new Actions(driver1);

        // Perform drag and drop
        //actions.dragAndDrop(a1, a2).perform();
        
        actions.clickAndHold(draggableElement).pause(2000)
        .moveToElement(droppableElement)
        .release()
        .build()
        .perform();
        
        
        // Wait for a while to observe the effect
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	@Test(description="Test_04 Verify File Upload",enabled=false)
	public void AlertBox() throws InterruptedException {
		// Verify the presence of username and password fields

		extent = ExtentReportUtil.getInstance();
		test = ExtentReportUtil.createTest("DD-TEST04");

		WebElement upload1,upload2,upload3,upload4;

		
		// ------------upload documents--------------------
		upload1=driver1.findElement(By.xpath("//input[@id='file-upload']"));//upload
		upload2=driver1.findElement(By.xpath("//input[@id='file-submit']")); //Submit

		upload2.sendKeys("C:\\Users\\panasa142user.P-142\\Downloads\\01.jpg");
		Thread.sleep(2000);
//		upload3.click();
//		Thread.sleep(2000);

		upload4=driver1.findElement(By.xpath("//h3[normalize-space()='File Uploaded!']"));

	}

	@AfterMethod
	public void clickLoginButton() throws InterruptedException {

		extent.flush(); // Flush the report after all tests are done
		driver1.quit();
	}

}
