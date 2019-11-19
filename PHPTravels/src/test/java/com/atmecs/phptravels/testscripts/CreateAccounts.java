package com.atmecs.phptravels.testscripts;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.atmecs.phptravels.constants.LogReports;
import com.atmecs.phptravels.helpers.ReadExcelData1;
import com.atmecs.phptravels.helpers.ReadPropertiesFile;
import com.atmecs.phptravels.pageactions.PageActions;
import com.atmecs.phptravels.testbase.InvokeBrowser;



public class CreateAccounts extends InvokeBrowser {
	String Xpath;
	LogReports log = new LogReports();
	ReadPropertiesFile read = new ReadPropertiesFile();

	@Test(priority = 2)
	public void ClickOnRemoveSymbol() {
		Xpath = read.readPropertiesFile("loc.btn.clickremoveframe.xpath");
		driver.findElement(By.xpath(Xpath)).getText();
		PageActions.clickOnElement(driver, Xpath);
		log.info("Clicked on Remove symbol");
	}

	@Test(priority = 3)
	public void ClickOnMyAccount() {
		Xpath = read.readPropertiesFile("loc.field.clickonmyaccount.xpath");
		driver.findElement(By.xpath(Xpath));
		PageActions.clickOnElement(driver, Xpath);
		log.info("Clicked on my account");
	}

	@Test(priority = 4)
	public void ClickOnSignUp() {
		Xpath = read.readPropertiesFile("loc.clicksighnup.xpath");
		driver.findElement(By.xpath(Xpath));
		PageActions.clickOnElement(driver, Xpath);
		log.info("Clicked on sign up");

	}

	@Test(priority = 5, dataProvider = "data", dataProviderClass = ReadExcelData1.class)
	public void GetTestDataFromExcel(String[] in) {

// To enter first name
		Xpath = read.readPropertiesFile("loc.field.firstname.xpath");
		driver.findElement(By.xpath(Xpath)).sendKeys(in[0]);
		log.info("First name got entered");

//To enter last name
		Xpath = read.readPropertiesFile("loc.field.lastname.xpath");
		driver.findElement(By.xpath(Xpath)).sendKeys(in[1]);
		log.info("last name got enterd");

//To enter mobile number
		Xpath = read.readPropertiesFile("loc.field.mobilenumber.xpath");
		driver.findElement(By.xpath(Xpath)).sendKeys(in[2]);
		log.info("Mobile number entered");

// To enter email
		Xpath = read.readPropertiesFile("loc.field.email.xpath");
		driver.findElement(By.xpath(Xpath)).sendKeys(in[3]);
		log.info("Email typed");

// To enter password
		Xpath = read.readPropertiesFile("loc.field.password.xpath");
		driver.findElement(By.xpath(Xpath)).sendKeys(in[4]);
		log.info("Password typed");

// To enter confirm password
		Xpath = read.readPropertiesFile("loc.field.confirmpswd.xpath");
		driver.findElement(By.xpath(Xpath)).sendKeys(in[5]);
		log.info("Retyped password for confirmation");

// To click on sign up
		Xpath = read.readPropertiesFile("loc.btn.signup.xpath");
		driver.findElement(By.xpath(Xpath)).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

// To click on dropdown
		Xpath = read.readPropertiesFile("loc.field.dropdown.xpath");
		driver.findElement(By.xpath(Xpath)).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("Clicked on drop down");

// To click on logout
		Xpath = read.readPropertiesFile("loc.field.logout.xpath");
		driver.findElement(By.xpath(Xpath)).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("Logged out");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

// To click on signup
		Xpath = read.readPropertiesFile("loc.field.signup.xpath");
		driver.findElement(By.xpath(Xpath)).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("clicked on sign up");
	}

}
