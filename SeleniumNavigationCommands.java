package com.shanpri;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumNavigationCommands {
//https://www.tutorialspoint.com/what-are-the-differences-between-get-and-navigate-method
	//https://mindmajix.com/selenium/selenium-webdriver-commands-list
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		Thread.sleep(5000);
		driver.navigate().to("https://mindmajix.com/selenium/selenium-webdriver-commands-list");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
	Thread.sleep(2000);
	driver.close();
	}
	

}
