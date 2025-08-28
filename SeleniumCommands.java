package com.shanpri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCommands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("Admin123");
		driver.findElement(By.id("Outpatient Clinic")).click();
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
		driver.findElement(By.name("givenName")).sendKeys("John");
		driver.findElement(By.name("familyName")).sendKeys("Reddy");
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.xpath("//*[@id=\"gender-field\"]/option[1]")).click();
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("birthdateYears-field")).sendKeys("21");
		driver.findElement(By.id("birthdateMonths-field")).sendKeys("6");
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("address1")).sendKeys("chennai");
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("96784");
		driver.findElement(By.id("next-button")).click();
		Select patientRelation = new Select(driver.findElement(By.id("relationship_type")));
		patientRelation.selectByIndex(1);
		Thread.sleep(2000);
		patientRelation.selectByValue("8d91a01c-c2cc-11de-8d13-0010c6dffd0f-A");
		Thread.sleep(2000);
		patientRelation.selectByVisibleText("Parent");
		Thread.sleep(2000);
		driver.findElement(null);
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		

	}

}
