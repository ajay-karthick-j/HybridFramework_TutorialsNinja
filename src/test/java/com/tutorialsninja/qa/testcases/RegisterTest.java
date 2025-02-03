package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.TestUtilities;

public class RegisterTest extends Base {

	public RegisterTest() {
		super();
	}

	public WebDriver driver;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;

	@BeforeMethod
	public void initializeBrowserAndRegisterPageLoad() {

		driver = initializeBrowser(prop.getProperty("browserName"));

		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccountDropDown();
		registerPage = homePage.clickRegisterOption();

	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegisterWIthMandateFields() {

		// Register account
		AccountSuccessPage accountSuccessPage = registerPage.registerWithMandatoryFields(
				dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				TestUtilities.generateRandomEmail(), dataProp.getProperty("telephoneNumber"),
				dataProp.getProperty("registerationPassword"));

		Assert.assertTrue(
				accountSuccessPage.getAccountSuccessText().equals(dataProp.getProperty("accountCreatedSuccessMessage")),
				"NOT created account");

	}

	@Test(priority = 2)
	public void verifyRegisterWIthOptionalRadioButton() {

		// Register account
		AccountSuccessPage accountSuccessPage = registerPage.registerWithAllFields(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), TestUtilities.generateRandomEmail(),
				dataProp.getProperty("telephoneNumber"), dataProp.getProperty("registerationPassword"));

		Assert.assertTrue(
				accountSuccessPage.getAccountSuccessText().equals(dataProp.getProperty("accountCreatedSuccessMessage")),
				"NOT created account");

	}

	@Test(priority = 3)
	public void verifyRegisterWIthRegisteredEmailid() {
		// Register account
		registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				prop.getProperty("validEmailId"), dataProp.getProperty("telephoneNumber"),
				dataProp.getProperty("registerationPassword"));

		Assert.assertTrue(registerPage.retrieveDuplicateEmailAddressWarning()
				.contains(dataProp.getProperty("duplicateEmailWarning")));

	}

	@Test(priority = 4)
	public void verifyRegisterWIthoutAnyFields() {

		// Clicking continue without filling details
		registerPage.clickContinueButton();

		// verify error messages

		Assert.assertTrue(registerPage.displayStatusOfWarningMessages(dataProp.getProperty("privacyPolicyWarning"),
				dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"),
				dataProp.getProperty("emailWarning"), dataProp.getProperty("telephoneWarning"),
				dataProp.getProperty("passwordWarning")));

	}

}
