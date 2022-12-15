package com.TutorialNinja.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.TutorialNinja.PropertyFiles.FilePaths;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	public static String email;
	public static String pass ;
	public static String baseURL ;
	
     /**
	 * used BaseClass constructor to intilize the property file 
	 */
	public BaseClass() {
		FileInputStream file = null;
		prop=new Properties();
		try {
			file=new FileInputStream(FilePaths.propertyPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void intilizeBrowser() {
		String browserName = prop.getProperty("browser");
		email = prop.getProperty("username");
		pass = prop.getProperty("password");
		baseURL = prop.getProperty("url");

		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","E://softwares//chromedriver.exe");
			driver=new ChromeDriver();

		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","E://softwares//geckodriver.exe");
			driver=new FirefoxDriver();

		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.navigate().to(baseURL);
	}

	
	@AfterTest
	public void endreport() {
	
		driver.quit();
	}

	public static String getScreenshotAs(String screenshotName) {

		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dis = System.getProperty("user.dir")+"/screenshots/"+screenshotName+dateName+".png";
		File finalDIS=new File(dis);
		try {
			FileUtils.copyFile(src, finalDIS);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dis;
	}
	{











	}

}
