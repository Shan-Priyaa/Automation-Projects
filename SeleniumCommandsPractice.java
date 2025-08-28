package com.shanpri;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCommandsPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String expectedTitle = "DEMOQA";
		String expectedUrl = "https://demoqa.com/text-box";
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		String actualTitle = driver.getTitle();
		System.out.println("Actual Title is :" + actualTitle);
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Actual Url is :" + actualUrl);
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		if (expectedUrl.equals(actualUrl)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		String pageSource = driver.getPageSource();
		System.out.println("PageSource is :" + pageSource);
		Thread.sleep(3000);
		driver.navigate().to("https://mindmajix.com/selenium/selenium-webdriver-commands-list");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.findElement(By.id("userName")).sendKeys("John");
		driver.findElement(By.id("userEmail")).sendKeys("john@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Velachery,Chennai");
		driver.findElement(By.id("permanentAddress")).sendKeys("Velachery,Chennai");
		driver.findElement(By.id("submit")).click();
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0.500)");
		WebElement submitButton =driver.findElement(By.id("submit"));
		submitButton.click();
		Dimension buttonSize=submitButton.getSize();
		System.out.println("Button Dimension is :"+buttonSize);
		String buttonBgColour=submitButton.getCssValue("vertical-align");
		String buttonBgColour1=submitButton.getCssValue("border-color");
		String buttonBgColour2=submitButton.getCssValue("font-weight");
		String buttonBgColour3=submitButton.getCssValue("vertical-align");
		System.out.println("Button Background colour is :"+buttonBgColour);
		System.out.println("Button Border colour is :"+buttonBgColour1);
		System.out.println("Button font-weight is :"+buttonBgColour2);
		System.out.println("Button vertical-align is :"+buttonBgColour3);
		boolean isDisplayed = submitButton.isDisplayed();
		System.out.println("Submit Button Is Displayed:"+isDisplayed);
		boolean isEnabled = submitButton.isEnabled();
		System.out.println("Submit Button Is Enabled :"+isEnabled);
		String data = driver.findElement(By.id("submit")).getText();
		System.out.println("Data is :"+data);
		Thread.sleep(5000);
	}

}
