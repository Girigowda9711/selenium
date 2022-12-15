package com.ProCrm.FilePath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	
	
	
	public  String getPropertiesForTest(String key) {
		FileInputStream fis=null;
		Properties prop=new Properties();
		try {
			 fis=new FileInputStream(IConstant.Property_Path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return prop.getProperty(key);
		
		
		
		
	}
	
	
	
	
	

}
