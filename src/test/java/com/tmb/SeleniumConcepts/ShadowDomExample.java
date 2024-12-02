package com.tmb.SeleniumConcepts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomExample {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://watir.com/examples/shadow_dom.html");
		
		WebElement rootStart=driver.findElement(By.xpath(""));
	
		

	}

}
