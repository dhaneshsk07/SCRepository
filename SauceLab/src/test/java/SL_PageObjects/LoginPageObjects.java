package SL_PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SL_Resources.BaseConnectionSetUp;

public class LoginPageObjects extends BaseConnectionSetUp {
	//public WebDriver driver1;

	// Locators using XPath and @FindBy annotation

	@FindBy(xpath = "//input[@id='user-name']") 
	WebElement usernameField;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginButton;


	// Constructor to initialize WebDriver and elements
	public LoginPageObjects (WebDriver driver) {
		this.driver1 = driver;
		PageFactory.initElements(driver, this); 

	} 


	//**************************Method 1*******************
	// Methods to interact with elements
	public void enterUsername(String username) {
		usernameField.sendKeys(username);

	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	
	}

	//**************************Method 2*********************
	public void enterUsername1(String username) {

		a1=driver1.findElement(By.xpath("//input[@id='user-name']"));
		a1.sendKeys(username);	
	}


	public void enterPassword1(String password) {
		a2=driver1.findElement(By.xpath("//input[@id='password']"));
		a2.sendKeys(password);
	}

	public void clickLoginButton1() {

		a3=driver1.findElement(By.xpath("//input[@id='login-button']"));
		a3.click();
	}
}
