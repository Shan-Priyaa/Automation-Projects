package com.shanpri;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pageobject.PageObject;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTextBoxValidation {
//https://www.tutorialspoint.com/what-are-the-differences-between-get-and-navigate-method
	// https://mindmajix.com/selenium/selenium-webdriver-commands-list
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		
		PageObject po = new PageObject(driver); 
		po.userName().sendKeys("John");
		po.userEmail().sendKeys("john@gmail.com");
		po.currentAddress().sendKeys("Velacherry");
		po.permanentAddress().sendKeys("Chennai");
		po.permanentAddress().sendKeys("Chennai"); JavascriptExecutor js =
		(JavascriptExecutor) driver; js.executeScript("window.scrollBy(0,500)", "");
		po.submitButton().click();
		
		/*
		 * po.userName().sendKeys("John"); po.userEmail().sendKeys("john@gmail.com");
		 * po.currentAddress().sendKeys("velacherry");
		 * po.permanentAddress().sendKeys("Chennai"); JavascriptExecutor js =
		 * (JavascriptExecutor) driver; js.executeScript("window.scrollBy(0,500)", "");
		 * po.submitButton().click();
		 */
		
		 
			
		
	}

}