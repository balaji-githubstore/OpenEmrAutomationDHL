package com.dhl.openemrpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	private static By calendarLocator=By.xpath("//div[text()='Calendar']");
	private static By patientClientLocator=By.xpath("//div[text()='Patient/Client']");
	private static By patientLocator=By.xpath("//div[text()='Patients']");
	
	public static void WaitForPresenceOfCalendar(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.presenceOfElementLocated(calendarLocator));
	}
	
	public static String getCurrentTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public static void moveToPatientClientMenu(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(patientClientLocator)).build().perform();
	}
	
	public static void clickOnPatientMenu(WebDriver driver)
	{
		driver.findElement(patientLocator).click();
	}

}
