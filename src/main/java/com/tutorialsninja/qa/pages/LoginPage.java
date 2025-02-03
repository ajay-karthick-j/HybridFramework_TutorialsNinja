package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy (id="input-email")
	private WebElement emailInputBox;
	
	@FindBy (id="input-password")
	private WebElement passwordInputBox;
	
	@FindBy (xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement loginDeniedWarningMsg;
	
	// Constructor initialization
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String emailText) {
		emailInputBox.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		passwordInputBox.sendKeys(passwordText);
	}
	
	public AccountPage clickLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public String getLoginDeniedWarningMsg() {
		String msg = loginDeniedWarningMsg.getText();
		return msg;
	}
	
	public AccountPage login(String emailText,String passwordText) {
		emailInputBox.sendKeys(emailText);
		passwordInputBox.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
	}

}
