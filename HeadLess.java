package com.shanpri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLess {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		options.setHeadless(true);
		//options.addArguments("headless");
		driver = new ChromeDriver(options);  
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Pharmacy")).click();
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
		driver.findElement(By.name("givenName")).sendKeys("tension");
		driver.findElement(By.name("familyName")).sendKeys("torchur");
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.xpath("//*[@id=\"gender-field\"]/option[1]")).click();
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("birthdateYears-field")).sendKeys("25");
		driver.findElement(By.id("birthdateMonths-field")).sendKeys("5");
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("address1")).sendKeys("Png");
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("987");
		driver.findElement(By.id("next-button")).click();
		WebElement relation =  driver.findElement(By.name("relationship_type"));
		Select relationType = new Select(relation);
		relationType.selectByIndex(1);
		Thread.sleep(2000);
		relationType.selectByValue("8d91a01c-c2cc-11de-8d13-0010c6dffd0f-A");
		Thread.sleep(2000);
		relationType.selectByVisibleText("Parent");
		Thread.sleep(2000);

		driver.findElement(By.id("next-button")).click();
        driver.findElement(By.id("submit")).click();



		
		Thread.sleep(5000);
		driver.close();

	}

}