package com.shanpri;


	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class SeleniumWebtableCommands {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			String cName = "Bharat Petroleum";

			try {
				//driver.get("https://money.rediff.com/gainers/bse/dailygroupa?src=gain_lose");
				
				driver.get("https://demo.guru99.com/test/web-table-element.php");


				List<WebElement> cNames = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
				List<WebElement> entiredata = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
				
				for (int j = 0; j <= cNames.size(); j++) {
//					System.out.println("Total Company size : "+cNames.get(j).getText());
					
					
					if (cName.equals(cNames.get(j).getText())) {
						System.out.println(entiredata.get(j).getText());
						break;
						}
				}
			} finally {
				driver.quit();
			}
		}
	}

