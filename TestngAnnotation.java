package com.shanpri;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngAnnotation {

	public WebDriver driver;
	public String url = "https://demo.guru99.com/V1/index.php";
	String dashBoardMessage = "Welcome To Manager's Page of GTPL Banks";
                            
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
 	options.addArguments("--remote-allow-origins=*");
		options.setHeadless(true);
		//options.addArguments("headless");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("BeforeSuite");
	}

	@BeforeTest
	public void profileSetup() {
		driver.manage().window().maximize();
		System.out.println("BeforeTest");
	}

	@BeforeClass
	public void appSetup() {
		driver.get(url);
		System.out.println("BeforeClass");
	}

	@BeforeMethod
	public void checkLogin() {
		driver.findElement(By.name("uid")).sendKeys("mngr47659");
		driver.findElement(By.name("password")).sendKeys("Toan123@");
		driver.findElement(By.name("btnLogin")).click();
		System.out.println("BeforeMethod");
	}

	@Test(description = "")
	public void dashBoardValidation() throws IOException, InterruptedException {
		Thread.sleep(4000);
		String dashBoard = driver.findElement(By.className("heading3")).getText();
		System.out.println("dashBoard : " + dashBoard);
		if (dashBoard.equals(dashBoardMessage)) {
			System.out.println("User able to see DashBoard pages, Test");
		} else
			System.out.println("User not able to see DashBoard page");

		Assert.assertEquals(dashBoard, dashBoardMessage);
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == (ITestResult.FAILURE | ITestResult.SUCCESS)) {
			System.out.println(testResult.getStatus());
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-" + ".jpg"));
			System.out.println(scrFile);

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("C:\\PRIYALAPTOP\\test.png"));
			System.out.println("AfterMethod");
			driver.getCurrentUrl();
			String urlname = driver.getCurrentUrl();
			System.out.println("Current URL is"+ urlname);
		}
	}

	@AfterClass
	public void closeUp() {
		// driver.close();
		System.out.println("@AfterClass");
	}

	@AfterTest
	public void reportReady() {
		System.out.println("AfterTest");
	}

	@AfterSuite
	public void cleanUp() {
		System.out.println("AfterSuite");
	}
}