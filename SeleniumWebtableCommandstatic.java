package com.shanpri;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWebtableCommandstatic {

 public static void main(String[] args) throws InterruptedException 
 {  
	 WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
  
  System.out.println(driver.manage().window().getSize());
  Dimension d = new Dimension(1420,800);
  driver.manage().window().setSize(d);
 
  driver.get("https://demo.guru99.com/test/web-table-element.php"); 
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  WebElement baseTable = driver.findElement(By.tagName("table"));	  
	 
	 WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[2]"));
     String rowtext = tableRow.getText();
	 System.out.println("Third row of table : "+rowtext);	    
	   
	    WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[3]"));
	    String valueIneed = cellIneed.getText();
	    System.out.println("Cell value is : " + valueIneed); 
 }
}