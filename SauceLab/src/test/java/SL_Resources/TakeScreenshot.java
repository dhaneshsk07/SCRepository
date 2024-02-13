package SL_Resources;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot extends BaseConnectionSetUp {
	
   
    
    public void screenshotcapture(){
      

        // Capture the screenshot
        File screenshotFile = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);

        // Save the screenshot to a file
        try {
            // Specify the destination path for the screenshot
            //String screenshotPath = "src/test/java/SL_TestData/SauceLabExcel.xlsx/screenshot.png";
            
            
            
            String screenshotPath1 = "Failure Screenshot" + System.currentTimeMillis()+ ".png";
            
           String screenshotPath=System.getProperty("user.dir") + "/test-output/" + "/Failure-Screenshot/" + screenshotPath1;
            
            // Move the screenshot file to the destination path
            org.apache.commons.io.FileUtils.moveFile(screenshotFile, new File(screenshotPath));
            System.out.println("Screenshot captured and saved to: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver1.quit();
    }
}
