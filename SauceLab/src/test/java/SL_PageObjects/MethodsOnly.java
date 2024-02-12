package SL_PageObjects;

import org.openqa.selenium.WebDriver;

import SL_Utils.ExcelReader;

public class MethodsOnly extends LoginPageObjects {
	
	
	public MethodsOnly(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void setuppf() throws InterruptedException {
	LoginPageObjects pf=new LoginPageObjects(driver1);
	ExcelReader er=new ExcelReader();
	
	
	pf.enterUsername("pagefactory");
	Thread.sleep(2000);
	pf.enterPassword("111111");
	Thread.sleep(2000);
	pf.clickLoginButton();
	Thread.sleep(2000); 
	
	
	}
}
