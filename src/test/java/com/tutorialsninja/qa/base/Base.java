package com.tutorialsninja.qa.base;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsninja.qa.utils.TestUtilities;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	public Base() {
		prop = new Properties();
		dataProp = new Properties();
		InputStream propFile = null;
		InputStream dataPropFile = null;
		try {
			propFile = new FileInputStream("src/main/java/com/tutorialsninja/qa/config/config.properties");
			prop.load(propFile);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		try {
			dataPropFile = new FileInputStream("src/main/java/com/tutorialsninja/qa/testdata/testdata.properties");
			dataProp.load(dataPropFile);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public WebDriver initializeBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));

		return driver;
	}

}
