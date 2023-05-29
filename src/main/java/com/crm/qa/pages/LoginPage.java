package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(linkText="Log In")
	WebElement loginBtn;
	
	@FindBy (linkText="Sign Up")
	WebElement signup;
	
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement login;
	
	@FindBy (xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[1]/div/a/svg/image")
	WebElement crmLogo;


	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		return new HomePage();
	}
	

}
