package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base {

	public SearchTest() {
		super();
	}

	public WebDriver driver;
	SearchPage searchPage ;
	HomePage homePage ;

	@BeforeMethod
	public void initializeBrowserAndSearchLocation() {
		driver = initializeBrowser(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		
		searchPage = homePage.ProductSearch(dataProp.getProperty("validProduct"));
		Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(), "Search not found with valid HP product");
	}

	@Test(priority = 2)
	public void verifySearchWithNonExistProduct() {
		searchPage = homePage.ProductSearch(dataProp.getProperty("invalidProduct"));
		
		Assert.assertEquals(searchPage.retrieveNoProductMessageText(),"abcd");

		//Assert.assertEquals(searchPage.retrieveNoProductMessageText(),dataProp.getProperty("NoProductTextInSearchResults"));
	}

	@Test(priority = 3, dependsOnMethods={"verifySearchWithNonExistProduct","verifySearchWithValidProduct"})
	public void verifySearchWithoutProductName() {
		searchPage = homePage.clickSearchButton();
		Assert.assertEquals(searchPage.retrieveNoProductMessageText(),
				dataProp.getProperty("NoProductTextInSearchResults"));
	}
}
