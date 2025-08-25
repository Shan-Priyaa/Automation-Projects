package com.shanpri;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumAlertHandling {
//https://www.tutorialspoint.com/what-are-the-differences-between-get-and-navigate-method
	// https://mindmajix.com/selenium/selenium-webdriver-commands-list
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement clickMe = driver.findElement(By.id("promtButton"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",clickMe);
		driver.findElement(By.id("alertButton")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		
		
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
		
		
		
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().sendKeys("John");
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
		
		
		
	}

}