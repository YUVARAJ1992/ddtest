package com.Vcentry.tnstc.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vcentry.tnstc.initializer.Initializer;
import com.Vcentry.tnstc.inputreader.inputReader;
import com.Vcentry.tnstc.pages.RegPage;
import com.Vcentry.tnstc.reportGenerator.ScreenshotGenerator;
import com.relevantcodes.extentreports.LogStatus;

public class RegPageTest extends Initializer{

	@Test(dataProvider="RegPageTest")
	public void validateRegpage(String TestcaseName,String Username,String Password,String ConfirmPassword,String SQ, String ASQ) throws IOException{
		initialize();
		log=reports.startTest(TestcaseName+" Initiated");
		wd.get(envprop.getProperty("URL"));
		/*wd.findElement(By.name("txtUserLoginID")).sendKeys("Yuvick");
		wd.findElement(By.name("txtPassword")).sendKeys("Yuvi123");
		wd.findElement(By.name("txtConfirmPassword")).sendKeys("Yuvi123");
		wd.findElement(By.name("txtSecretAnswer")).sendKeys("Idiot");
		WebElement dropdown= wd.findElement(By.name("txtSecretQuestion"));
		Select s=new Select(dropdown);
		s.selectByValue("petname");*/
		
		/*
		 * wd.findElement(By.name(locprop.getProperty("REGPAGE_TYPE_USERNAME_NAME"))).sendKeys("Yuvick");
		wd.findElement(By.name(locprop.getProperty("REGPAGE_TYPE_PASSWORD_NAME"))).sendKeys("Yuvi123");
		wd.findElement(By.name(locprop.getProperty("REGPAGE_TYPE_CONFIRMPASSWORD_NAME"))).sendKeys("Yuvi123");
		wd.findElement(By.name(locprop.getProperty("REGPAGE_TYPE_ANSWERSECRETQUESTION_NAME"))).sendKeys("Idiot");
		WebElement dropdown= wd.findElement(By.name(locprop.getProperty("REGPAGE_SELECT_SECRETQUESTION_NAME")));
		Select s=new Select(dropdown);
		s.selectByValue("petname");
		*/
		/*
		 * getElementByName("REGPAGE_TYPE_USERNAME_NAME").sendKeys("Yuvick");
		getElementByName("REGPAGE_TYPE_PASSWORD_NAME").sendKeys("yuvi123");
		getElementByName("REGPAGE_TYPE_CONFIRMPASSWORD_NAME").sendKeys("yuvi123");
		getElementByName("REGPAGE_TYPE_ANSWERSECRETQUESTION_NAME").sendKeys("Idiot");
		WebElement dropdown= getElementByName("REGPAGE_SELECT_SECRETQUESTION_NAME");
		Select s=new Select(dropdown);
		s.selectByValue("petname");
		*/
		RegPage.enterUsername(Username);
		RegPage.enterPassword(Password);
		RegPage.enterConfirmPassword(ConfirmPassword);
		RegPage.enterSecretQuestion(SQ);
		RegPage.enterAnswerSecretQuestion(ASQ);
		
		
	}
	@DataProvider(name="RegPageTest")
	public static Object[][] getData() throws Exception{
		if(inputReader.RunModeVerification("RegPageTest")){
		Object[][] data=inputReader.selectSingleDataOrMulitiData("RegPageTest");
					return data;
		}
		return null;
	}
	 @AfterMethod
     public void teardown(ITestResult it) throws IOException{
		 ScreenshotGenerator.generateScreenshot(it);
    	      }
		}


