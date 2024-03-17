package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShareRankerTestCase {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@Test
	public void verifyShareRanker() {

		driver.findElement(By.partialLinkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame("webform");
		driver.findElement(By.xpath("//div[@id = 'webform_preview']/div")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//i[contains(@class , 'fa fa-facebook social-icon')]")).click();
		String actualResult = driver.getTitle();
		String expectedResult = "Facebook";
		Assert.assertEquals(actualResult, expectedResult);
		
	}
}
