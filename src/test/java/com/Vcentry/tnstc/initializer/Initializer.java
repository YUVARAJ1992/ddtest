package com.Vcentry.tnstc.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vcentry.tnstc.reportGenerator.ReportOptimizer;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Initializer {
	/**
	 * Report variables
	 */
	public static ExtentReports reports;// Report generator
	public static ExtentTest log;
	/**
	 * @author 91866 Declare webdriver variables
	 */
	public static WebDriver wd = null;
	/**
	 * @author 91866 declare environment variables
	 */
	public static FileInputStream envfis = null;
	public static Properties envprop = null;
	/**
	 * @author 91866 Declare locator variables
	 * @throws IOException
	 */
	public static FileInputStream locfis = null;
	public static Properties locprop = null;

	public static boolean isReportExist = true;

	public static void initialize() throws IOException {
		if (isReportExist) {
			ReportOptimizer.optimizedReport();
			reports = new ExtentReports("C:\\Users\\91866\\workspace\\DataDrivenTest\\reports\\report.html");
			isReportExist = false;
		}
		// File f=new
		// File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"Vcentry"+File.separator+"tnstc"+File.separator+"config"+File.separator+"env.properties");
		envfis = new FileInputStream(new File(System.getProperty("user.dir") + File.separator + "src" + File.separator
				+ "test" + File.separator + "resources" + File.separator + "com" + File.separator + "Vcentry"
				+ File.separator + "tnstc" + File.separator + "config" + File.separator + "env.properties"));
		envprop = new Properties();
		envprop.load(envfis);

		locfis = new FileInputStream(new File(System.getProperty("user.dir") + File.separator + "src" + File.separator
				+ "test" + File.separator + "resources" + File.separator + "com" + File.separator + "Vcentry"
				+ File.separator + "tnstc" + File.separator + "config" + File.separator + "locator.properties"));

		locprop = new Properties();
		locprop.load(locfis);

		if (wd == null) {
			if (envprop.getProperty("BROWSER").equals("FIREFOX")) {
				wd = new FirefoxDriver();
			}
		}
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// wd.manage().deleteAllCookies();
	}

	public static WebElement getElementByName(String Name) {
		return wd.findElement(By.name(locprop.getProperty(Name)));
	}
}
