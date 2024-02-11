package SL_Resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseConnectionSetUp {
	//public WebDriver driver;
	public static WebDriver driver1;
	public WebElement a1,a2,a3,a4;
	
	
	

	public void connection() throws InterruptedException {
		WebDriverManager.edgedriver().setup();

		driver1 = new EdgeDriver();
		// driver1.get("https://www.orangehrm.com/en/30-day-free-trial/success");  
		driver1.get("https://www.saucedemo.com"); 
		driver1.manage().window().maximize();
		Thread.sleep(2000);    

	}
	





}
