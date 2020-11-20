package com.dhl.openemrtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dhl.base.WebDriverWrapper;
import com.dhl.openemrpages.DashboardPage;
import com.dhl.openemrpages.LoginPage;
import com.dhl.utilities.ExcelUtils;

public class AddPatientTest extends WebDriverWrapper {
	
	@DataProvider
	public Object[][] createPatientData() throws IOException
	{
		Object[][] main = ExcelUtils.getSheetIntoObjectArray("testdata/openemrdata.xlsx", "createPatientData");
		return main;
	}
	
	@Test(dataProvider = "createPatientData")
	public void createPatientTest(String username,String password,String language,String firstname,String lastname,String dob,String sex,String expectedValue)
	{
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.selectLanguage(driver, language);
		LoginPage.clickOnLogin(driver);	
		
		DashboardPage.moveToPatientClientMenu(driver);
		DashboardPage.clickOnPatientMenu(driver);
		
		
		
	}

}
