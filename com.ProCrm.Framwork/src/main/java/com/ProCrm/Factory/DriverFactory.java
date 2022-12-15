package com.ProCrm.Factory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	private static ThreadLocal<> driver=new ThreadLocal<>();
	
	public static BrowserFactory getDriver() {
		return driver.get();
	}
	
	public static void setDriver(WebDriver driverpro) {
		driver=driverpro;
	}
	
	
	
	
	
	
	
	
	
	

}
