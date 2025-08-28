package com.shanpri;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumMouseAndKeyboardCommands {
//https://www.tutorialspoint.com/what-are-the-differences-between-get-and-navigate-method
	// https://mindmajix.com/selenium/selenium-webdriver-commands-list
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement des = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		//action.clickAndHold(holdObject).moveToElement(releaseHere).release().perform();
		action.dragAndDrop(src, des).perform();
		driver.close();
		Thread.sleep(2000);
		
		WebDriver driver1;
		WebDriverManager.chromedriver().setup();
		driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.get("https://jqueryui.com/draggable/");
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.switchTo().frame(0);
		WebElement holdObject = driver1.findElement(By.id("draggable"));
		Actions action1 = new Actions(driver1);
		action1.dragAndDropBy(holdObject, 200, 100).perform();
	}

}