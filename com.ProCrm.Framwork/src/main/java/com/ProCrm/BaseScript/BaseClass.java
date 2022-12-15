package com.ProCrm.BaseScript;

import org.testng.annotations.BeforeMethod;

import com.ProCrm.Factory.BrowserFactory;
import com.ProCrm.FilePath.PropertyFile;

public class BaseClass {
	
	private BaseClass() {
		
	}
	BrowserFactory bf;
	PropertyFile pf;
	@BeforeMethod
	public void setUp() {
		 bf=new BrowserFactory();
		 pf=new PropertyFile();
		 bf.startBrowser(pf.getPropertiesForTest("browser"));
		 
		 
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
