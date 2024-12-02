package com.tmb.SeleniumConcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tmb.driver.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandlesEx {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();

     WebDriver driver= new ChromeDriver();
  
     driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
     Thread.sleep(5000);
     driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
   Set<String> windowids= driver.getWindowHandles();
   
   List<String> windows=new ArrayList(windowids);
   
   for(String window: windows)
   {
	   System.out.println(window);
   }
   Thread.sleep(5000);
      driver.quit();
  
	}

}
