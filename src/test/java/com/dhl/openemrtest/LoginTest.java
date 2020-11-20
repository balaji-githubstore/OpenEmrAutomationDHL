package com.dhl.openemrtest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dhl.base.WebDriverWrapper;
import com.dhl.openemrpages.DashboardPage;
import com.dhl.openemrpages.LoginPage;
import com.dhl.utilities.ExcelUtils;

public class LoginTest extends WebDriverWrapper {

	// dataprovider
	// admin,pass,English (Indian),OpenEMR
	// physician,physician,English (Indian),OpenEMR
	// accountant,accountant,English (Indian),OpenEMR
	@DataProvider
	public Object[][] validCredentialData() {
		Object[][] main = new Object[3][4];

		main[0][0] = "admin";
		main[0][1] = "pass";
		main[0][2] = "English (Indian)";
		main[0][3] = "OpenEMR";

		main[1][0] = "physician";
		main[1][1] = "physician";
		main[1][2] = "English (Indian)";
		main[1][3] = "OpenEMR";

		main[2][0] = "accountant";
		main[2][1] = "accountant";
		main[2][2] = "Dutch";
		main[2][3] = "OpenEMR";

		return main;
	}

	@Test(dataProvider = "validCredentialData")
	public void validCredentialTest(String username, String password, String language, String expectedValue) {
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.selectLanguage(driver, language);
		LoginPage.clickOnLogin(driver);

		DashboardPage.WaitForPresenceOfCalendar(driver);
		String actualValue = DashboardPage.getCurrentTitle(driver);

		// Assertion
		Assert.assertEquals(actualValue, expectedValue);
	}

	// excel and dataprovider
	@DataProvider
	public Object[][] invalidCredentialData() throws IOException {
		// convert excel to object[][]
		Object[][] main = ExcelUtils.getSheetIntoObjectArray("testdata/openemrdata.xlsx", "invalidCredentialData");
		return main;
	}
	

	@Test(dataProvider = "invalidCredentialData")
	public void invalidCredentialTest(String username, String password, String language, String expectedValue) {
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.selectLanguage(driver, language);
		LoginPage.clickOnLogin(driver);
		String actualValue = LoginPage.getErrorMessage(driver);
		Assert.assertEquals(actualValue, expectedValue);
	}
}
