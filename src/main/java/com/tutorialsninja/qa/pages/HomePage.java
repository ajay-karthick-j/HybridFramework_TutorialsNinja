package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	// Constructor initialization
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//span[text()='My Account']")
	private WebElement myAccountDropdown;
	
	@FindBy (linkText="Login")
	private WebElement loginOption;
	
	@FindBy (linkText="Register")
	private WebElement registerOption;
	
	@FindBy (name="search")
	private WebElement searchInputBox;
	
	public void enterProductInSearchBox(String productName) {
		searchInputBox.sendKeys(productName);
	}
	
	@FindBy (xpath="//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	public SearchPage clickSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public void clickMyAccountDropDown() {
		myAccountDropdown.click();
	}
	
	public LoginPage clickLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clickRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public SearchPage ProductSearch(String productName) {
		searchInputBox.sendKeys(productName);
		searchButton.click();
		return new SearchPage(driver);
	}

}
