package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
		
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/a/span[2]")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement signBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	@FindBy(xpath="//*[@id='top-header-menu']/div[2]/span[1]")
	WebElement usrNameverified;
	
	//Initializing the Page Objects:

	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		loginBtn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		signBtn.click();
		
//		    	JavascriptExecutor js = (JavascriptExecutor)driver;
//		    	js.executeScript("arguments[0].click();", loginBtn);
		
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("javascript:window.scrollBy(250,350)");
		
		
		    	
		return new HomePage();
	}
	
	public String verifyName() {
		return usrNameverified.getText();
		
	}
	
}

