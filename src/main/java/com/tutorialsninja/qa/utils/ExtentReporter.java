package com.tutorialsninja.qa.utils;

import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentReport = new ExtentReports();
		ExtentSparkReporter sparkReport = new ExtentSparkReporter("test-output/ExtentReports/sampleExtentReport.html");
		extentReport.attachReporter(sparkReport);
		
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setDocumentTitle("TN proj");
		sparkReport.config().setReportName("TutorialsNinja Automation testing");
		sparkReport.config().setTimeStampFormat("dd/MM/yy || hh:mm:ss");
		
		Properties prop = new Properties();
		try {
			FileInputStream propFile = new FileInputStream(
					"src/main/java/com/tutorialsninja/qa/config/config.properties");
			prop.load(propFile);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL: ", prop.getProperty("url"));
		extentReport.setSystemInfo("Browser name: ", prop.getProperty("browserName"));
		extentReport.setSystemInfo("User ID: ", prop.getProperty("validEmailId"));
		extentReport.setSystemInfo("Password: ", prop.getProperty("validPassword"));
		// values below property name 
		//System.getProperties().list(System.out);
		extentReport.setSystemInfo("OS name: ", System.getProperty("os.name"));
		extentReport.setSystemInfo("User name: ", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java version: ", System.getProperty("java.version"));
		
		return extentReport;
		
	}

}
