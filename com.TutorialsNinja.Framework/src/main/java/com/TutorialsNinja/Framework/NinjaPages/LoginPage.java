package com.TutorialsNinja.Framework.NinjaPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TutorialNinja.BaseTest.BaseClass;

import comm.TutorialNinja.NinjaUtilities.Utilities;

public class LoginPage extends BaseClass {
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccount;
	@FindBy(xpath="//a[contains(.,'Login')]")
	private WebElement login;
	@FindBy(id="input-email")
	private WebElement username;
	@FindBy(id="input-password")
	private WebElement password;
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginBtn;
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver,this);
		
	}
	
	public void clickOnMyAccountDropDown() {
		myAccount.click();
		login.click();
	}
	
	public HomePage VerifyUserLogin() {
		
		username.sendKeys(email);
		password.sendKeys(pass);
		loginBtn.click();
		return new HomePage();
			}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
