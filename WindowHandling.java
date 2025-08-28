package com.shanpri;



import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://demoqa.com/browser-windows");
WebElement newwindow = driver.findElement(By.id("tabButton"));
((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",newwindow);
newwindow.click();


ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
//switch to first tab

driver.switchTo().window(w.get(1));
driver.close();
	Thread.sleep(2000);
	String childWindowActualMessage = driver.findElement(By.id("sampleHeading")).getText();
	  System.out.println("childWindowMessage: " + childWindowActualMessage);
		//driver.quit();
	  //driver.close();
	  


Thread.sleep(2000);


	}

}