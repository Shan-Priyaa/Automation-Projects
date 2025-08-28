package com.shanpri;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasicsCommands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String expectedTitle = "DEMOQA";
		String expectedUrl = "https://demoqa.com/text-selenium";
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		String actualTitle = driver.getTitle();
		System.out.println("Page Title is :"+actualTitle);
		if(expectedTitle.equals(actualTitle))
		{ 
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");	
		}
	String actualUrl = driver.getCurrentUrl();
	System.out.println("Page Actual Url is :"+actualUrl);
	
	if(expectedUrl.equals(actualUrl))
	{ 
		System.out.println("Test Passed");
	}
	else
	{
		System.out.println("Test Failed");	
	}
	String pageSource = driver.getPageSource();
	System.out.println("Page Source is :"+pageSource);
	
	Thread.sleep(2000);
	driver.close();
	}
	

}
