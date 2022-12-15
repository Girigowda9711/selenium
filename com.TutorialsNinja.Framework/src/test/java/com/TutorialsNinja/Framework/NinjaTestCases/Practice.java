package com.TutorialsNinja.Framework.NinjaTestCases;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://omayo.blogspot.com/");
		String parentId = driver.getWindowHandle();
		System.out.println(parentId);
		driver.findElement(By.xpath("//a[@id='selenium143']")).click();
		Set<String> childId = driver.getWindowHandles();
		Iterator<String> it = childId.iterator();
		for(WebElement ir:it) {
			
		}
		






	}

}
