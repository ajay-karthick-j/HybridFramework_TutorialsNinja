package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.TestUtilities;

public class LoginTest extends Base {

	public LoginTest() {
		super();
	}

	public WebDriver driver;
	LoginPage loginPage;
	AccountPage accountPage;

	@BeforeMethod
	public void initializeBrowserAndLoginPageLoad() {

		driver = initializeBrowser(prop.getProperty("browserName"));

		// Verify title of page
		Assert.assertEquals(driver.getTitle(), dataProp.getProperty("homePageTitle"));
		// Navigate to login page and verify title
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccountDropDown();
		loginPage = homePage.clickLoginOption();

		Assert.assertEquals(driver.getTitle(), dataProp.getProperty("loginPageTitle"));

	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

	@DataProvider(name = "validCredentialsSupply")
	public Object[][] supplyTestData() {

		Object[][] data = TestUtilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 1, dataProvider = "validCredentialsSupply")
	public void verifyLoginWithValidCredentials(String email, String password) {

		// Enter credentials
		accountPage = loginPage.login(email, password);

		Assert.assertTrue(accountPage.checkEditAccountInfoIsDisplayed(),
				"Edit Your Account Information option is not displayed");
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidUseridInvalidPassword() {
		// Enter credentials
		loginPage.login(TestUtilities.generateRandomEmail(), dataProp.getProperty("invalidPassword"));

		// verify invalid login
		Assert.assertTrue(
				loginPage.getLoginDeniedWarningMsg().contains(dataProp.getProperty("invalidEmailPasswordWarning")),
				"Expected warning msg NOT FOUND");
	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidUseridValidPassword() {
		// Enter credentials
		loginPage.login(TestUtilities.generateRandomEmail(), prop.getProperty("validPassword"));

		// verify invalid login
		Assert.assertTrue(
				loginPage.getLoginDeniedWarningMsg().contains(dataProp.getProperty("invalidEmailPasswordWarning")),
				"Expected warning msg NOT FOUND");
	}

	@Test(priority = 4)
	public void verifyLoginWithValidUseridInvalidPassword() {
		// Enter credentials
		loginPage.login(prop.getProperty("validEmailId"), dataProp.getProperty("invalidPassword"));

		// verify invalid login
		Assert.assertTrue(
				loginPage.getLoginDeniedWarningMsg().contains(dataProp.getProperty("invalidEmailPasswordWarning")),
				"Expected warning msg NOT FOUND");
	}

	@Test(priority = 5)
	public void verifyLoginWithoutCredentials() {
		loginPage.clickLoginButton();

		// verify invalid login
		Assert.assertTrue(
				loginPage.getLoginDeniedWarningMsg().contains(dataProp.getProperty("invalidEmailPasswordWarning")),
				"Expected warning msg NOT FOUND");
	}

}
