package com.shanpri;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWebelementCommands {
//https://www.tutorialspoint.com/what-are-the-differences-between-get-and-navigate-method
	// https://mindmajix.com/selenium/selenium-webdriver-commands-list
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		driver.findElement(By.id("userName")).sendKeys("John");
		driver.findElement(By.id("userEmail")).sendKeys("john@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Velacherry,Chennai");
		driver.findElement(By.id("permanentAddress")).sendKeys("Velacherry,Chennai");
		// JavascriptExecutor jse = (JavascriptExecutor)driver;
		// jse.executeScript("window.scrollBy(0,500)");
		WebElement submitButton = driver.findElement(By.id("submit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
		submitButton.click();
		Dimension buttonSize = submitButton.getSize();
		System.out.println("Button Dimension is :" + buttonSize);
		
		String buttonBgColour = submitButton.getCssValue("text-align");
		System.out.println("Button Background colour is :" + buttonBgColour);
		
		boolean isDisplayed = submitButton.isDisplayed();
		System.out.println("Submit button is dispalyed :" + isDisplayed);
		
		boolean isEnabled = submitButton.isEnabled();
		System.out.println("Submit button is Enabled :" + isEnabled);
		
		String data = driver.findElement(By.id("submit")).getText();
		System.out.println("Data is :" + data);
		
		Point buttonLocation = submitButton.getLocation();
		System.out.println("Button Location is :" + buttonLocation);
		
		Point submitbuttonposition = driver.findElement(By.id("submit")).getLocation();
		System.out.println("submit button poistion : " + submitbuttonposition);

		String submitbuttonAttribute = driver.findElement(By.id("submit")).getAttribute("id");
		System.out.println("submit button Attribute : " + submitbuttonAttribute);

		String tagName = driver.findElement(By.id("item-0")).getTagName();
		System.out.println("tagName: " + tagName);
		Thread.sleep(2000);
		driver.close();
	}

}
